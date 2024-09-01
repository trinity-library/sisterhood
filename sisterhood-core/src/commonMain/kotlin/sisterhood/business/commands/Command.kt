package sisterhood.business.commands

import kotlinx.coroutines.flow.Flow
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.PrintFactory

sealed class Command {
    abstract fun CommandProp.apply(): Flow<Event<out Aggregate>>

    fun handle(prop: CommandProp): Flow<Event<out Aggregate>> = prop.apply()
}
