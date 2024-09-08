package sisterhood.domain.hentai

import sisterhood.domain.Status

sealed class HentaiStatus : Status() {
    data object Created : HentaiStatus()
    data object Preparing : HentaiStatus()
    data object Fulfilled : HentaiStatus()
}

fun HentaiStatus(status: String): HentaiStatus = when (status) {
    HentaiStatus.Created::class.simpleName!! -> HentaiStatus.Created
    HentaiStatus.Preparing::class.simpleName!! -> HentaiStatus.Preparing
    HentaiStatus.Fulfilled::class.simpleName!! -> HentaiStatus.Fulfilled
    else -> throw IllegalArgumentException("Unknown status: $status")
}
