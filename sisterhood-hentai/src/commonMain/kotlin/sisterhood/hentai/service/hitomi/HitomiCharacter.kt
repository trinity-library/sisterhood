package sisterhood.hentai.service.hitomi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HitomiCharacter(
    @SerialName("character")
    val name: String
)
