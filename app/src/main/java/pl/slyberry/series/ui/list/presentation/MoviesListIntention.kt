package pl.slyberry.series.ui.list.presentation

import pl.slyberry.series.common.Intention
import pl.slyberry.series.domain.Movie
import pl.slyberry.series.ui.MoviesModel
import pl.slyberry.series.ui.Navigation
import pl.slyberry.series.ui.Status

object QueryInProgressIntention : Intention<MoviesModel> {

    override fun reduce(oldState: MoviesModel): MoviesModel {
        return oldState.copy(status = Status.SYNCING)
    }
}

class NewQueryResultSuccessIntention(private val movies: List<Movie>) : Intention<MoviesModel> {

    override fun reduce(oldState: MoviesModel): MoviesModel {
        return oldState.copy(movies = movies, status = Status.IDLE)
    }
}

object QueryErrorIntention : Intention<MoviesModel> {

    override fun reduce(oldState: MoviesModel): MoviesModel {
        return oldState.copy(status = Status.ERROR)
    }
}

object MoveToStreamIntention : Intention<MoviesModel> {

    override fun reduce(oldState: MoviesModel): MoviesModel {
        return oldState.copy(navigation = Navigation.MOVIE)
    }
}

object NavigatedToStreamIntention : Intention<MoviesModel> {

    override fun reduce(oldState: MoviesModel): MoviesModel {
        return oldState.copy(navigation = Navigation.LIST)
    }
}
