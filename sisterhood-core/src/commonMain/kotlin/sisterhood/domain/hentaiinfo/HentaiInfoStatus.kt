package sisterhood.domain.hentaiinfo

import sisterhood.domain.Status

sealed class HentaiInfoStatus : Status() {
    data object Empty : HentaiInfoStatus()
    data object Prepared : HentaiInfoStatus()
}
