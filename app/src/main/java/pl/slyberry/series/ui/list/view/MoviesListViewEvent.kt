package pl.slyberry.series.ui.list.view

sealed class MoviesListViewEvent

data class SearchViewEvent(val query: String) : MoviesListViewEvent()

object SelectMovieViewEvent : MoviesListViewEvent()

object NavigatedToMovieViewEvent : MoviesListViewEvent()
