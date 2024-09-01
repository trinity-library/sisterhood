package sisterhood.domain

interface PrintFactory {
    fun create(name: Name): Print =
        create(name.toString())

    fun create(name: String): Print
}

inline fun <reified T : Any> PrintFactory.create(obj: T): Print =
    create(obj::class.simpleName ?: "Unknown")
