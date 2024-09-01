package sisterhood.domain.hentai

import sisterhood.domain.Status

sealed class HentaiStatus : Status() {
    data object Empty : HentaiStatus()
    data object Prepared : HentaiStatus()
}
