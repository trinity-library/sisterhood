package sisterhood.infrastructure.hitomi

import sisterhood.domain.hentai.valueobjects.HentaiLanguage
import sisterhood.lib.hitomi.Language as HitomiLanguage

fun HentaiLanguage.toHitomiLanguage(): HitomiLanguage = when (this) {
    HentaiLanguage.KOREAN -> HitomiLanguage.KOREAN
}
