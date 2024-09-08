package sisterhood.domain.valueobjects

import sisterhood.domain.Id

@JvmInline
value class HentaiId(private val id: Long) : Id {
    constructor(id: Int) : this(id = id.toLong())

    fun toInt(): Int = id.toInt()
    fun toLong(): Long = id
}
