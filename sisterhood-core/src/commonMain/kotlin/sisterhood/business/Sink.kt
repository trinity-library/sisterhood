package sisterhood.business

import kotlinx.coroutines.flow.Flow
import sisterhood.business.commands.Command
import sisterhood.business.commands.CommandProp
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.PrintFactory
import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiRepository
import sisterhood.domain.hentai.HentaiService

typealias Sink = (Command) -> Flow<Event<out Aggregate>>

fun Sink(
    hentaiFactory: HentaiFactory,
    hentaiRepository: HentaiRepository,
    hentaiService: HentaiService,
    printFactory: PrintFactory
): Sink = { command ->
    command.handle(
        CommandProp(
            hentaiFactory = hentaiFactory,
            hentaiRepository = hentaiRepository,
            hentaiService = hentaiService,
            printFactory = printFactory
        )
    )
}
