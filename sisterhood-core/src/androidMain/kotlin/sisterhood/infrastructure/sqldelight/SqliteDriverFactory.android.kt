package sisterhood.infrastructure.sqldelight

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

actual class SqliteDriverFactory(
    context: Context,
    private val path: Path
) {
    private val driver: SqlDriver by lazy {
        AndroidSqliteDriver(
            schema = Sqlite.Schema.synchronous(),
            context = context,
            name = path.name
        )
    }

    actual fun create(): SqlDriver =
        driver.also {
            if (!SystemFileSystem.exists(path)) {
                Sqlite.Schema.create(it)
            }
        }
}
