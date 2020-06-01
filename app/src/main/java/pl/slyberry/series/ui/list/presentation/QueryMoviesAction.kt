package pl.slyberry.series.ui.list.presentation

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import org.koin.core.KoinComponent
import org.koin.core.inject
import pl.slyberry.series.common.*
import pl.slyberry.series.domain.GetMoviesUseCase
import pl.slyberry.series.ui.MoviesModel

class QueryMoviesAction(private val query: String) : Action<MoviesModel>, KoinComponent {

    private val useCase by inject<GetMoviesUseCase>()

    override fun perform(): Flow<Intention<MoviesModel>> {
        return useCase.perform(query)
            .onStart { delay(1000) }
            .map {
                when (it) {
                    is LoadingResult -> QueryInProgressIntention
                    is SuccessResult -> NewQueryResultSuccessIntention(it.data)
                    is ErrorResult -> QueryErrorIntention
                }
            }
    }
}
