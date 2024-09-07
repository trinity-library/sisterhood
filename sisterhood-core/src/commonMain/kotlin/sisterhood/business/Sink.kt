package sisterhood.business

import kotlinx.coroutines.flow.Flow
import sisterhood.business.commands.Command
import sisterhood.business.commands.CommandProp
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.PrintFactory

typealias Sink = (Command) -> Flow<Event<out Aggregate>>

fun Sink(printFactory: PrintFactory): Sink = { command ->
    command.handle(
        CommandProp(
            printFactory = printFactory
        )
    )
}
