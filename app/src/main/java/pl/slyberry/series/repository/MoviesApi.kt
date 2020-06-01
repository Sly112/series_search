package pl.slyberry.series.repository

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("search/shows")
    suspend fun getMovies(@Query("q") search: String): List<MovieJson>
}
