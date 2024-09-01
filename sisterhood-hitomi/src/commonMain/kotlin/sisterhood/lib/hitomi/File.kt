package sisterhood.lib.hitomi

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class File(
    val name: String,
    val hash: String,
    val width: Int,
    val height: Int,
    @SerialName("hasavif")
    val hasAvif: Int,
    @SerialName("hasjxl")
    val hasJxl: Int,
    @SerialName("haswebp")
    val hasWebp: Int
)
