package sisterhood.domain.hentai.events

import sisterhood.domain.Event
import sisterhood.domain.hentai.Hentai
import sisterhood.domain.hentai.HentaiId

sealed class HentaiEvent(
    override val id: HentaiId = HentaiId(id = 1),
    override val aggregate: Hentai
) : Event<Hentai>(aggregate = aggregate)
