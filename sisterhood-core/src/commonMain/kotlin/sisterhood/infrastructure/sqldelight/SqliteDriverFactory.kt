package sisterhood.infrastructure.sqldelight

import app.cash.sqldelight.db.SqlDriver

expect class SqliteDriverFactory {
    fun create(): SqlDriver
}
