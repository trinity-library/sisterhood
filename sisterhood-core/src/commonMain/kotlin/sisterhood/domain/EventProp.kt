package sisterhood.domain

import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiInfoService
import sisterhood.domain.hentai.HentaiRepository

class EventProp(
    val hentaiFactory: HentaiFactory,
    val hentaiInfoService: HentaiInfoService,
    val hentaiRepository: HentaiRepository,
    val printFactory: PrintFactory
)
