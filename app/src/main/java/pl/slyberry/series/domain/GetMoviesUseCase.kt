package pl.slyberry.series.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import pl.slyberry.series.common.Result
import pl.slyberry.series.common.UseCase
import pl.slyberry.series.repository.MoviesRepository
import pl.slyberry.series.ui.list.presentation.QueryValidator

class GetMoviesUseCase(
    private val repository: MoviesRepository,
    private val validator: QueryValidator
) : UseCase<String, List<Movie>> {

    override fun perform(params: String): Flow<Result<List<Movie>>> {
        if (!validator.isValid(params)) return emptyFlow()
        return flow {
            emit(Result.createLoading())
            try {
                emit(Result.createSuccess(repository.getMovies(params)))
            } catch (it: Throwable) {
                it.printStackTrace()
                emit(Result.createError(it))
            }
        }
    }
}
