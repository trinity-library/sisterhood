package sisterhood.domain.hentai

import sisterhood.domain.Aggregate
import sisterhood.domain.Timestamp
import sisterhood.domain.hentai.events.HentaiPrepared
import sisterhood.domain.hentaiinfo.HentaiInfo
import sisterhood.domain.valueobjects.HentaiId

data class Hentai(
    override val id: HentaiId,
    override val updatedAt: Timestamp,
    override val status: HentaiStatus
) : Aggregate() {
    constructor(id: HentaiId) : this(
        id = id,
        updatedAt = Timestamp(),
        status = HentaiStatus.Empty
    )

    private fun canPrepare(hentaiInfo: HentaiInfo): Boolean =
        hentaiInfo.isPrepared()

    fun prepare(hentaiInfo: HentaiInfo): HentaiPrepared? =
        takeIf { canPrepare(hentaiInfo) }?.let {
            HentaiPrepared(
                aggregate = copy(status = HentaiStatus.Prepared, updatedAt = Timestamp()),
                hentaiInfo = hentaiInfo,
            )
        }
}
