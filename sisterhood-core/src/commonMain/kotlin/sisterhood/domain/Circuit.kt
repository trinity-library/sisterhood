package sisterhood.domain

import kotlinx.coroutines.flow.Flow
import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiRepository
import sisterhood.domain.hentai.HentaiService

typealias Circuit = (Event<out Aggregate>) -> Flow<Event<out Aggregate>>

fun Circuit(
    hentaiFactory: HentaiFactory,
    hentaiRepository: HentaiRepository,
    hentaiService: HentaiService,
    printFactory: PrintFactory
): Circuit = { event ->
    event.handle(
        EventProp(
            hentaiFactory = hentaiFactory,
            hentaiRepository = hentaiRepository,
            hentaiService = hentaiService,
            printFactory = printFactory
        )
    )
}
