package pl.slyberry.series.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@Suppress("EXPERIMENTAL_API_USAGE")
class ModelStore<State>(scope: CoroutineScope, initialState: State) {

    private val intents = Channel<Intention<State>>()
    private val store = ConflatedBroadcastChannel(initialState)

    init {
        scope.launch {
            while (isActive) {
                store.offer(intents.receive().reduce(store.value))
            }
        }
    }

    suspend fun process(intent: Intention<State>) {
        intents.send(intent)
    }

    fun modelState() = store.asFlow()
}
