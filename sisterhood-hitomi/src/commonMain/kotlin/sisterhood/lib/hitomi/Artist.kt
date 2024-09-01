package sisterhood.lib.hitomi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    @SerialName("artist")
    val name: String
)