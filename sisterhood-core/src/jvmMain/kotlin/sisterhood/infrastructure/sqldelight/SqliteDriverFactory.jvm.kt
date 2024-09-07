package sisterhood.infrastructure.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

actual class SqliteDriverFactory(private val path: Path) {
    constructor(path: String) : this(path = Path(path = path))

    private val driver: SqlDriver by lazy {
        JdbcSqliteDriver("jdbc:sqlite:${path.name}")
    }

    actual fun create(): SqlDriver =
        driver.also {
            if (!SystemFileSystem.exists(path)) {
                Sqlite.Schema.create(it)
            }
        }

}
