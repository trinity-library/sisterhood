package sisterhood.infrastructure

import org.slf4j.Logger
import sisterhood.domain.Print

actual class LoggingPrint(private val logger: Logger) : Print {
    override fun debug(message: String) =
        logger.debug(message)

    override fun debug(message: String, throwable: Throwable) =
        logger.debug(message, throwable)

    override fun info(message: String) =
        logger.info(message)

    override fun info(message: String, throwable: Throwable) =
        logger.info(message, throwable)

    override fun warn(message: String) =
        logger.warn(message)

    override fun warn(message: String, throwable: Throwable) =
        logger.warn(message, throwable)

    override fun error(message: String) =
        logger.error(message)

    override fun error(message: String, throwable: Throwable) =
        logger.error(message, throwable)
}
