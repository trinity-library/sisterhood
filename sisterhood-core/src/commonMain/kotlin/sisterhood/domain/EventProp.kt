package sisterhood.domain

import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiRepository
import sisterhood.domain.hentaiinfo.HentaiInfoService

class EventProp(
    val hentaiFactory: HentaiFactory,
    val hentaiInfoService: HentaiInfoService,
    val hentaiRepository: HentaiRepository,
    val printFactory: PrintFactory
)
