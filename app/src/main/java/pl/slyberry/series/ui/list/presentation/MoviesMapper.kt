package pl.slyberry.series.ui.list.presentation

import pl.slyberry.series.common.Action
import pl.slyberry.series.ui.MoviesModel
import pl.slyberry.series.ui.list.view.MoviesListViewEvent
import pl.slyberry.series.ui.list.view.NavigatedToMovieViewEvent
import pl.slyberry.series.ui.list.view.SearchViewEvent
import pl.slyberry.series.ui.list.view.SelectMovieViewEvent

fun MoviesListViewEvent.toAction(): Action<MoviesModel> {
    return when (this) {
        is SearchViewEvent -> QueryMoviesAction(query)
        SelectMovieViewEvent -> SelectMoviesAction
        NavigatedToMovieViewEvent -> NavigateAction
    }
}
