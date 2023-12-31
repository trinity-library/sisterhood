package sisterhood.usecase

import kotlinx.serialization.Serializable
import sisterhood.domain.Hentai
import sisterhood.domain.HentaiId

@Serializable
data class HentaiInfo(
    val id: HentaiId,
    val title: String,
    val language: String,
    val pages: List<HentaiPageInfo>
) {
    constructor(hentai: Hentai) : this(
        hentai.id,
        hentai.title,
        hentai.language.name,
        hentai.pages.map { HentaiPageInfo(it) }
    )
}
