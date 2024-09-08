package sisterhood.domain.hentai.events

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.EventProp
import sisterhood.domain.create
import sisterhood.domain.hentai.Hentai

data class HentaiInitializationStarted(
    override val aggregate: Hentai
) : HentaiEvent(aggregate = aggregate) {
    override fun EventProp.apply(): Flow<Event<out Aggregate>> = flow<Event<out Aggregate>> {
        hentaiService.fetchMetadata(aggregate.id)
    }.onStart {
        val print = printFactory.create(this@HentaiInitializationStarted)
        print.info("Hentai (#${aggregate.id}) started to be initialized")

        hentaiRepository.save(aggregate)
        print.debug("Hentai (#${aggregate.id}) was saved successfully")
    }
}
