package pl.slyberry.series

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.slyberry.series.domain.GetMoviesUseCase
import pl.slyberry.series.repository.MoviesApi
import pl.slyberry.series.repository.MoviesRepository
import pl.slyberry.series.repository.MoviesRepositoryImpl
import pl.slyberry.series.ui.MoviesModel
import pl.slyberry.series.ui.list.presentation.MoviesListViewModel
import pl.slyberry.series.ui.list.presentation.QueryValidator
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val koinModule = module {

    viewModel { MoviesListViewModel() }

    single { provideGithubApi(get()) }
    single { provideRetrofitClient() }
    single { MoviesRepositoryImpl(get()) as MoviesRepository }
    single { QueryValidator() }
    factory { GetMoviesUseCase(get(), get()) }
}

private fun provideGithubApi(retrofit: Retrofit) = retrofit.create(MoviesApi::class.java)

private fun provideRetrofitClient(): Retrofit {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    return Retrofit.Builder()
        .baseUrl("http://api.tvmaze.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(httpClient)
        .build()
}
