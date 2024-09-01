package sisterhood.domain.hentai

import sisterhood.domain.Aggregate
import sisterhood.domain.hentai.entities.HentaiInfo
import sisterhood.domain.hentai.entities.HitomiInfo
import sisterhood.domain.hentai.events.HentaiInfoUpdated

data class Hentai(
    override val id: HentaiId,
    override val status: HentaiStatus,
    private val hitomiInfo: HitomiInfo?
) : Aggregate() {
    constructor(id: HentaiId) : this(
        id = id,
        status = HentaiStatus.Empty,
        hitomiInfo = null
    )

    fun updateInfo(info: HentaiInfo): HentaiInfoUpdated? =
        when (info) {
            is HitomiInfo -> takeIf { hitomiInfo == null || hitomiInfo.updatedAt <= info.updatedAt }
                ?.run {
                    HentaiInfoUpdated(
                        aggregate = copy(status = HentaiStatus.Prepared),
                        hentaiInfo = info
                    )
                }
        }
}
