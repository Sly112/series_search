package pl.slyberry.series.common

import kotlinx.coroutines.flow.Flow

interface Action<T> {

    fun perform(): Flow<Intention<T>>
}
