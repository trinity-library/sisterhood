package sisterhood.lib.hitomi

import kotlinx.serialization.Serializable

@Serializable
data class Gallery(
    val id: Int,
    val title: String,
    val language: Language = Language.NONE,
    val files: List<File>,
    val date: String,
    val artists: List<Artist> = emptyList(),
    val characters: List<Character> = emptyList(),
    val groups: List<Group> = emptyList(),
    val parodys: List<Parody> = emptyList(),
    val related: List<Int> = emptyList(),
    val tags: List<Tag> = emptyList()
)
