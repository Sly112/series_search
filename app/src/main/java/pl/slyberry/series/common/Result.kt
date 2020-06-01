package pl.slyberry.series.common

sealed class Result<T> {

    companion object {
        fun <T> createLoading() = LoadingResult<T>()
        fun <T> createSuccess(value: T) = SuccessResult<T>(value)
        fun <T> createError(error: Throwable) = ErrorResult<T>(error)
    }
}

class LoadingResult<T> : Result<T>()
data class SuccessResult<T>(val data: T) : Result<T>()
data class ErrorResult<T>(val error: Throwable) : Result<T>()
