package sisterhood.domain

interface Print {
    fun debug(message: String)
    fun debug(message: String, throwable: Throwable)
    fun info(message: String)
    fun info(message: String, throwable: Throwable)
    fun warn(message: String)
    fun warn(message: String, throwable: Throwable)
    fun error(message: String)
    fun error(message: String, throwable: Throwable)
}
