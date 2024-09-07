package sisterhood.ui.infrastructure.koin

import org.koin.core.definition.Definition
import sisterhood.domain.PrintFactory
import sisterhood.infrastructure.sqldelight.SqliteDriverFactory

expect val definePrintFactory: Definition<PrintFactory>
expect val defineSqliteDriverFactory: Definition<SqliteDriverFactory>
