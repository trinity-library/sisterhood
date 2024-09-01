package sisterhood.infrastructure.sqldelight

import app.cash.sqldelight.db.SqlDriver
import sisterhood.domain.hentai.Hentai
import sisterhood.domain.hentai.HentaiRepository

class SqliteHentaiRepository(driver: SqlDriver) : HentaiRepository {
    private val database = Sqlite(driver = driver)

    override suspend fun save(hentai: Hentai): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun update(hentai: Hentai): Result<Unit> {
        TODO("Not yet implemented")
    }
}
