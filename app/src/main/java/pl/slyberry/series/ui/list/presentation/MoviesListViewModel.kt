package pl.slyberry.series.ui.list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.slyberry.series.common.ModelStore
import pl.slyberry.series.common.ViewEventConsumer
import pl.slyberry.series.common.ViewEventProducer
import pl.slyberry.series.ui.MoviesModel
import pl.slyberry.series.ui.list.view.MoviesListViewEvent

class MoviesListViewModel() : ViewModel(), ViewEventConsumer<MoviesListViewEvent> {

    val state = MutableLiveData<MoviesModel>()

    private val modelStore = ModelStore(viewModelScope, MoviesModel.initial())

    init {
        modelStore.modelState()
            .onEach {
                state.value = it
            }.launchIn(viewModelScope)
    }

    override fun viewEvents(producer: ViewEventProducer<MoviesListViewEvent>) {
        producer.viewEvents()
            .flatMapLatest {
                it.toAction().perform()
            }.onEach {
                modelStore.process(it)
            }.launchIn(viewModelScope)
    }
}