package sisterhood.business.commands

import sisterhood.domain.PrintFactory
import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiRepository
import sisterhood.domain.hentai.HentaiService

class CommandProp(
    val hentaiFactory: HentaiFactory,
    val hentaiRepository: HentaiRepository,
    val hentaiService: HentaiService,
    val printFactory: PrintFactory
)
