package sisterhood.lib.hitomi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Character(
    @SerialName("character")
    val name: String
)
