package sisterhood.infrastructure

import org.slf4j.LoggerFactory
import sisterhood.domain.Print
import sisterhood.domain.PrintFactory

actual class LoggingPrintFactory : PrintFactory {
    override fun create(name: String): Print =
        LoggingPrint(logger = LoggerFactory.getLogger(name))
}
