package sisterhood.domain

interface Print {
    fun info(message: String)
    fun info(exception: SisterhoodException, message: String)
}
