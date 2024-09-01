package sisterhood.infrastructure

import android.util.Log
import sisterhood.domain.Print
import sisterhood.domain.SisterhoodException

actual class LoggingPrint(private val tag: String) : Print {
    override fun info(message: String) {
        Log.i(tag, message)
    }

    override fun info(exception: SisterhoodException, message: String) {
        Log.i(tag, message, exception)
    }
}
