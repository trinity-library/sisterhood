package sisterhood.infrastructure.hitomi

import sisterhood.domain.valueobjects.HentaiLanguage
import sisterhood.lib.hitomi.Language as HitomiLanguage

fun HentaiLanguage.toHitomiLanguage(): HitomiLanguage = when (this) {
    HentaiLanguage.ENGLISH -> HitomiLanguage.ENGLISH
    HentaiLanguage.JAPANESE -> HitomiLanguage.JAPANESE
    HentaiLanguage.KOREAN -> HitomiLanguage.KOREAN
    HentaiLanguage.ALBANIAN -> HitomiLanguage.ALBANIAN
    HentaiLanguage.ARABIC -> HitomiLanguage.ARABIC
    HentaiLanguage.BULGARIAN -> HitomiLanguage.BULGARIAN
    HentaiLanguage.BURMESE -> HitomiLanguage.BURMESE
    HentaiLanguage.CATALAN -> HitomiLanguage.CATALAN
    HentaiLanguage.CEBUANO -> HitomiLanguage.CEBUANO
    HentaiLanguage.CHESKEY -> HitomiLanguage.CHESKEY
    HentaiLanguage.DANISH -> HitomiLanguage.DANISH
    HentaiLanguage.DUTCH -> HitomiLanguage.DUTCH
    HentaiLanguage.ESPERANTO -> HitomiLanguage.ESPERANTO
    HentaiLanguage.ESTONIAN -> HitomiLanguage.ESTONIAN
    HentaiLanguage.FINNISH -> HitomiLanguage.FINNISH
    HentaiLanguage.FRENCH -> HitomiLanguage.FRENCH
    HentaiLanguage.GERMAN -> HitomiLanguage.GERMAN
    HentaiLanguage.GREEK -> HitomiLanguage.GREEK
    HentaiLanguage.HEBREW -> HitomiLanguage.HEBREW
    HentaiLanguage.HINDI -> HitomiLanguage.HINDI
    HentaiLanguage.HUNGARIAN -> HitomiLanguage.HUNGARIAN
    HentaiLanguage.ICELANDIC -> HitomiLanguage.ICELANDIC
    HentaiLanguage.INDONESIAN -> HitomiLanguage.INDONESIAN
    HentaiLanguage.ITALIAN -> HitomiLanguage.ITALIAN
    HentaiLanguage.LATIN -> HitomiLanguage.LATIN
    HentaiLanguage.JAVANESE -> HitomiLanguage.JAVANESE
    HentaiLanguage.MONGOLIAN -> HitomiLanguage.MONGOLIAN
    HentaiLanguage.NORWEGIAN -> HitomiLanguage.NORWEGIAN
    HentaiLanguage.PERSIAN -> HitomiLanguage.PERSIAN
    HentaiLanguage.POLISH -> HitomiLanguage.POLISH
    HentaiLanguage.PORTUGUESE -> HitomiLanguage.PORTUGUESE
    HentaiLanguage.ROMANIAN -> HitomiLanguage.ROMANIAN
    HentaiLanguage.RUSSIAN -> HitomiLanguage.RUSSIAN
    HentaiLanguage.SERBIAN -> HitomiLanguage.SERBIAN
    HentaiLanguage.SLOVAK -> HitomiLanguage.SLOVAK
    HentaiLanguage.SPANISH -> HitomiLanguage.SPANISH
    HentaiLanguage.SWEDISH -> HitomiLanguage.SWEDISH
    HentaiLanguage.TAGALOG -> HitomiLanguage.TAGALOG
    HentaiLanguage.THAI -> HitomiLanguage.THAI
    HentaiLanguage.TURKISH -> HitomiLanguage.TURKISH
    HentaiLanguage.UKRAINIAN -> HitomiLanguage.UKRAINIAN
    HentaiLanguage.VIETNAMESE -> HitomiLanguage.VIETNAMESE
    HentaiLanguage.NONE -> HitomiLanguage.NONE
}
