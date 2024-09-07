package sisterhood.business.commands

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.onCompletion
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.create

data class FetchLatestHentais(
    val n: Int,
    val skip: Int,
) : Command() {
    override fun CommandProp.apply(): Flow<Event<out Aggregate>> =
        emptyFlow<Event<out Aggregate>>().onCompletion {
            val print = printFactory.create(this@FetchLatestHentais)
            print.info("yeah")
        }
}
