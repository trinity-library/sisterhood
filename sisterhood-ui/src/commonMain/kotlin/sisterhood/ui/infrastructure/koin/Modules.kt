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
import sisterhood.domain.hentaiinfo.HentaiInfoService
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
    factory<SqliteDriverFactory> { defineSqliteDriverFactory(it) }
    factory<HentaiInfoService> {
        HitomiInfoService(hitomiClient = get())
    }
    factory<HentaiFactory> { ConcreteHentaiFactory() }
    factory<HentaiRepository> { SqliteHentaiRepository(driver = get<SqliteDriverFactory>().create()) }
    factory<PrintFactory> { definePrintFactory(it) }

    factory<Circuit>(named("circuit")) {
        Circuit(
            hentaiFactory = get(),
            hentaiInfoService = get(),
            hentaiRepository = get(),
            printFactory = get()
        )
    }
    factory<Sink>(named("sink")) { Sink(printFactory = get()) }
    factory<Mediate>(named("mediate")) {
        Mediate(
            circuit = get(named("circuit")),
            sink = get(named("sink"))
        )
    }
}
