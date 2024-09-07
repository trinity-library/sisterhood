package sisterhood.ui.infrastructure.koin

import android.content.Context
import android.content.ContextWrapper
import org.koin.core.definition.Definition
import sisterhood.domain.PrintFactory
import sisterhood.infrastructure.LoggingPrintFactory
import sisterhood.infrastructure.sqldelight.SqliteDriverFactory

actual val definePrintFactory: Definition<PrintFactory> = {
    LoggingPrintFactory()
}

actual val defineSqliteDriverFactory: Definition<SqliteDriverFactory> = {
    SqliteDriverFactory(context = get(), path = ".tmp")
}

val ContextWrapper.defineContext: Definition<Context>
    get() = { baseContext }
