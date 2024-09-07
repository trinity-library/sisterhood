package sisterhood.domain.hentai.events

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.EventProp
import sisterhood.domain.create
import sisterhood.domain.hentai.Hentai
import sisterhood.domain.hentaiinfo.HentaiInfo

data class HentaiPrepared(
    override val aggregate: Hentai,
    val hentaiInfo: HentaiInfo
) : HentaiEvent(aggregate = aggregate) {
    override fun EventProp.apply(): Flow<Event<out Aggregate>> = flow<Event<out Aggregate>> {
    }.onStart {
        val print = printFactory.create(this@HentaiPrepared)
        hentaiRepository.update(aggregate)
        print.info("Hentai(${aggregate.id}) updated.")
    }
}
