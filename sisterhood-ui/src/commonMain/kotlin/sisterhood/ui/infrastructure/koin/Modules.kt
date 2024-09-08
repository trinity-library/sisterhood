package sisterhood.ui.infrastructure.koin

import io.ktor.client.*
import org.koin.core.qualifier.named
import org.koin.dsl.module
import sisterhood.business.Mediate
import sisterhood.business.Sink
import sisterhood.domain.Circuit
import sisterhood.domain.PrintFactory
import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.hentai.HentaiRepository
import sisterhood.domain.hentai.HentaiService
import sisterhood.infrastructure.ConcreteHentaiFactory
import sisterhood.infrastructure.hitomi.HitomiInfoService
import sisterhood.infrastructure.sqldelight.SqliteDriverFactory
import sisterhood.infrastructure.sqldelight.SqliteHentaiRepository
import sisterhood.lib.GGHold
import sisterhood.lib.HitomiClient
import sisterhood.lib.KtorHitomiClient

val commonModule = module {
    factory<HentaiFactory> { ConcreteHentaiFactory() }
    single { GGHold(httpClient = HttpClient()) }
    factory<HitomiClient> {
        KtorHitomiClient(
            gg = get<GGHold>().gg,
            httpClient = HttpClient()
        )
    }
    factory<HentaiFactory> { ConcreteHentaiFactory() }
    factory<SqliteDriverFactory> { defineSqliteDriverFactory(it) }
    factory<HentaiRepository> {
        SqliteHentaiRepository(
            driver = get<SqliteDriverFactory>().create(),
            printFactory = get()
        )
    }
    factory<HentaiService> { HitomiInfoService(hitomiClient = get()) }
    factory<PrintFactory> { definePrintFactory(it) }

    factory<Circuit>(named("circuit")) {
        Circuit(
            hentaiFactory = get(),
            hentaiRepository = get(),
            hentaiService = get(),
            printFactory = get()
        )
    }
    factory<Sink>(named("sink")) {
        Sink(
            hentaiFactory = get(),
            hentaiRepository = get(),
            hentaiService = get(),
            printFactory = get()
        )
    }
    factory<Mediate>(named("mediate")) {
        Mediate(
            circuit = get(named("circuit")),
            sink = get(named("sink"))
        )
    }
}
