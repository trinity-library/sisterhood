package sisterhood.lib.hitomi

import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    val tag: String,
    val female: String = "",
    val male: String = "",
)
