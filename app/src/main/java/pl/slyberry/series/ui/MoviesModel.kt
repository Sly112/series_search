package pl.slyberry.series.ui

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import pl.slyberry.series.domain.Movie

@Parcelize
data class MoviesModel(
    val movies: List<Movie>,
    val status: Status,
    val navigation: Navigation
) : Parcelable {

    companion object {
        fun initial() = MoviesModel(
            emptyList(),
            Status.IDLE,
            Navigation.LIST
        )
    }
}

enum class Status {
    IDLE, SYNCING, ERROR
}

enum class Navigation {
    LIST, MOVIE
}
