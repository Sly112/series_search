package pl.slyberry.series.ui.list.presentation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pl.slyberry.series.common.Action
import pl.slyberry.series.common.Intention
import pl.slyberry.series.ui.MoviesModel

object NavigateAction : Action<MoviesModel> {

    override fun perform(): Flow<Intention<MoviesModel>> {
        return flow { emit(NavigatedToStreamIntention) }
    }
}
