package sisterhood.business

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import sisterhood.business.commands.Command
import sisterhood.domain.Aggregate
import sisterhood.domain.Circuit
import sisterhood.domain.Event

interface Mediate {
    operator suspend fun invoke(command: Command)
}

fun Mediate(
    circuit: Circuit,
    sink: Sink
): Mediate = object : Mediate {
    private suspend fun mediate(
        handleEvent: (Event<out Aggregate>) -> Flow<Event<out Aggregate>>,
        produceEvents: () -> Flow<Event<out Aggregate>>
    ) = channelFlow {
        produceEvents().collect {
            launch { handleEvent(it).collect { send(it) } }
        }
    }.collect()

    override suspend fun invoke(command: Command) =
        mediate(
            handleEvent = circuit,
            produceEvents = { sink(command) }
        )
}
