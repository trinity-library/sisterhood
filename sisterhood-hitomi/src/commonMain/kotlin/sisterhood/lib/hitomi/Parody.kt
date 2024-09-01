package sisterhood.lib.hitomi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parody(
    @SerialName("parody")
    val name: String
)
