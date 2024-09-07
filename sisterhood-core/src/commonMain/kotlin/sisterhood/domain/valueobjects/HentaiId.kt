package sisterhood.domain.valueobjects

import sisterhood.domain.Id

@JvmInline
value class HentaiId(private val id: Int) : Id {
    fun toInt() = id
}
