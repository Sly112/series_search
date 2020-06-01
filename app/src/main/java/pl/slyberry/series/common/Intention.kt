package pl.slyberry.series.common

interface Intention<T> {
    fun reduce(oldState: T): T
}
