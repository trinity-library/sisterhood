package sisterhood.infrastructure.sqldelight

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.runBlocking
import sisterhood.domain.PrintFactory
import sisterhood.domain.create
import sisterhood.domain.hentai.Hentai
import sisterhood.domain.hentai.HentaiRepository
import sisterhood.domain.valueobjects.HentaiId
import sisterhood.infrastructure.sqldelight.Hentai as HentaiOrm

class SqliteHentaiRepository(
    driver: SqlDriver,
    printFactory: PrintFactory
) : HentaiRepository {
    init {
        runBlocking { Sqlite.Schema.create(driver).await() }
    }

    private val database = Sqlite(
        driver = driver,
        hentaiAdapter = HentaiOrm.Adapter(statusAdapter = hentaiStatusAdapter())
    )
    private val print = printFactory.create(this)

    override suspend fun list(ids: List<HentaiId>): List<Hentai> =
        database.hentaiQueries.selectHentaisById(ids.map { it.toLong() }).awaitAsList().map { it.toHentai() }

    override suspend fun save(hentai: Hentai): Result<Unit> = runCatching {
        database.hentaiQueries.insertHentai(HentaiOrm(hentai = hentai))
    }.onSuccess {
        print.debug("Hentai (#${hentai.id}) was saved successfully")
    }.onFailure {
        print.error("Failed to save hentai (#${hentai.id})", it)
    }

    override suspend fun update(hentai: Hentai): Result<Unit> = runCatching {
        database.hentaiQueries.replaceHentai(HentaiOrm(hentai = hentai))
    }.onSuccess {
        print.debug("Hentai (#${hentai.id}) was updated successfully")
    }.onFailure {
        print.error("Failed to update hentai (#${hentai.id})", it)
    }
}
