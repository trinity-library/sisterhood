package sisterhood.domain.hentaiinfo.entities

import sisterhood.domain.Entity
import sisterhood.domain.Name
import sisterhood.domain.valueobjects.HentaiLanguage

sealed class HentaiMetadata : Entity() {
    abstract val language: HentaiLanguage
    abstract val title: Name
}
