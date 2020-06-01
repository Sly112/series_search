package pl.slyberry.series.common

import kotlinx.coroutines.flow.Flow

interface ViewEventProducer<Event> {

    fun viewEvents(): Flow<Event>
}

interface ViewEventConsumer<Event> {

    fun viewEvents(producer: ViewEventProducer<Event>)
}
