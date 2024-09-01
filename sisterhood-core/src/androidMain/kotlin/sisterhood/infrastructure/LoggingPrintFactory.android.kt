package sisterhood.infrastructure

import sisterhood.domain.Print
import sisterhood.domain.PrintFactory

actual class LoggingPrintFactory : PrintFactory {
    override fun create(name: String): Print =
        LoggingPrint(tag = name)
}
