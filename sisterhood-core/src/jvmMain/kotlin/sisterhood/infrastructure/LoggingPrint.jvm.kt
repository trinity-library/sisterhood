package sisterhood.infrastructure

import org.slf4j.Logger
import sisterhood.domain.Print
import sisterhood.domain.SisterhoodException

actual class LoggingPrint(private val logger: Logger) : Print {
    override fun info(message: String) =
        logger.info(message)

    override fun info(exception: SisterhoodException, message: String) {
        logger.info(message, exception)
    }
}
