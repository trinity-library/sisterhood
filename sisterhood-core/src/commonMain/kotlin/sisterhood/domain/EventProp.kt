package sisterhood.domain

import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiRepository
import sisterhood.domain.hentai.HentaiService

class EventProp(
    val hentaiFactory: HentaiFactory,
    val hentaiRepository: HentaiRepository,
    val hentaiService: HentaiService,
    val printFactory: PrintFactory
)
