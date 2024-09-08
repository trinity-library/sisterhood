package sisterhood.infrastructure

import android.util.Log
import sisterhood.domain.Print

actual class LoggingPrint(private val tag: String) : Print {
    override fun debug(message: String) {
        Log.d(tag, message)
    }

    override fun debug(message: String, throwable: Throwable) {
        Log.d(tag, message, throwable)
    }

    override fun info(message: String) {
        Log.i(tag, message)
    }

    override fun info(message: String, throwable: Throwable) {
        Log.i(tag, message, throwable)
    }

    override fun warn(message: String) {
        Log.w(tag, message)
    }

    override fun warn(message: String, throwable: Throwable) {
        Log.w(tag, message, throwable)
    }

    override fun error(message: String) {
        Log.e(tag, message)
    }

    override fun error(message: String, throwable: Throwable) {
        Log.e(tag, message, throwable)
    }
}
