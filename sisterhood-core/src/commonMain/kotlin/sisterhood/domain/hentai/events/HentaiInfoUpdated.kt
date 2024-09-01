package sisterhood.domain.hentai.events

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.EventProp
import sisterhood.domain.create
import sisterhood.domain.hentai.Hentai
import sisterhood.domain.hentai.entities.HentaiInfo

data class HentaiInfoUpdated(
    override val aggregate: Hentai,
    val hentaiInfo: HentaiInfo
) : HentaiEvent(aggregate = aggregate) {
    override fun EventProp.apply(): Flow<Event<out Aggregate>> = flow<Event<out Aggregate>> {
    }.onStart {
        val print = printFactory.create(this@HentaiInfoUpdated)
        hentaiRepository.update(aggregate)
        print.info("Hentai.sq(${aggregate.id}) updated.")
    }
}
