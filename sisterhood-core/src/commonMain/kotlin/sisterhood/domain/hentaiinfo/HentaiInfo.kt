package sisterhood.domain.hentaiinfo

import sisterhood.domain.Aggregate

sealed class HentaiInfo(
    override val status: HentaiInfoStatus
) : Aggregate() {
    fun isPrepared() =
        status == HentaiInfoStatus.Prepared
}
