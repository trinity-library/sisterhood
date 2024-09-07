package sisterhood.domain.hentaiinfo.entities

import sisterhood.domain.Name
import sisterhood.domain.Timestamp
import sisterhood.domain.valueobjects.HentaiId
import sisterhood.domain.valueobjects.HentaiLanguage

data class HitomiMetadata(
    override val id: HentaiId,
    override val updatedAt: Timestamp,
    override val language: HentaiLanguage,
    override val title: Name,
) : HentaiMetadata() {
    constructor(
        id: HentaiId,
        language: HentaiLanguage,
        title: Name,
    ) : this(
        id = id,
        updatedAt = Timestamp(),
        language = language,
        title = title,
    )
}
