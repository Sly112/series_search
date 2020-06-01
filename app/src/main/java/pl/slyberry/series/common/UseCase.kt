package pl.slyberry.series.common

import kotlinx.coroutines.flow.Flow

interface UseCase<Params, Data> {

    fun perform(params: Params): Flow<Result<Data>>
}
