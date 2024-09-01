package sisterhood.domain

import kotlinx.coroutines.flow.Flow
import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiInfoService
import sisterhood.domain.hentai.HentaiRepository

typealias Circuit = (Event<out Aggregate>) -> Flow<Event<out Aggregate>>

fun Circuit(
    hentaiFactory: HentaiFactory,
    hentaiInfoService: HentaiInfoService,
    hentaiRepository: HentaiRepository,
    printFactory: PrintFactory
): Circuit = { event ->
    event.handle(
        EventProp(
            hentaiFactory = hentaiFactory,
            hentaiInfoService = hentaiInfoService,
            hentaiRepository = hentaiRepository,
            printFactory = printFactory
        )
    )
}