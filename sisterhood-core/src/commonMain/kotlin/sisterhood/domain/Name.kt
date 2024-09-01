package sisterhood.domain

@JvmInline
value class Name(private val name: String) {
    override fun toString(): String = name
}
