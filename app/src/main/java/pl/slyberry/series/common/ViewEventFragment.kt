package pl.slyberry.series.common

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow

abstract class ViewEventFragment<T>(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId),
    ViewEventProducer<T> {

    private val eventChannel = Channel<T>()
    protected abstract val viewModel: ViewEventConsumer<T> //work on it

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewEvents(this)
    }

    final override fun viewEvents(): Flow<T> {
        return eventChannel.receiveAsFlow()
    }

    fun T.emitToChannel() {
        eventChannel.offer(this)
    }

    fun Flow<T>.emitToChannel() {
        onEach { eventChannel.offer(it) }.launchIn(lifecycleScope)
    }
}
