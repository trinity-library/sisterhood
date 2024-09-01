package sisterhood.business

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import sisterhood.business.commands.Command
import sisterhood.domain.Aggregate
import sisterhood.domain.Circuit
import sisterhood.domain.Event

interface Mediate {
    operator fun invoke(command: Command): Flow<Event<out Aggregate>>
}

fun Mediate(
    circuit: Circuit,
    sink: Sink
): Mediate = object : Mediate {
    private fun mediate(
        handleEvent: (Event<out Aggregate>) -> Flow<Event<out Aggregate>>,
        produceEvents: () -> Flow<Event<out Aggregate>>
    ): Flow<Event<out Aggregate>> = channelFlow {
        produceEvents().collect {
            launch { handleEvent(it).collect { send(it) } }
        }
    }

    override fun invoke(command: Command): Flow<Event<out Aggregate>> =
        mediate(
            handleEvent = circuit,
            produceEvents = { sink(command) }
        )
}
