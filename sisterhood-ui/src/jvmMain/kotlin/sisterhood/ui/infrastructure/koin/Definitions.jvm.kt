package sisterhood.ui.infrastructure.koin

import org.koin.core.definition.Definition
import sisterhood.domain.PrintFactory
import sisterhood.infrastructure.LoggingPrintFactory
import sisterhood.infrastructure.sqldelight.SqliteDriverFactory

actual val definePrintFactory: Definition<PrintFactory> = {
    LoggingPrintFactory()
}

actual val defineSqliteDriverFactory: Definition<SqliteDriverFactory> = {
    SqliteDriverFactory(path = ".tmp.db")
}
