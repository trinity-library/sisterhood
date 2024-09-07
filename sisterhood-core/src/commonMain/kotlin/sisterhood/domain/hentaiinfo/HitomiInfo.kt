package sisterhood.domain.hentaiinfo

import sisterhood.domain.Timestamp
import sisterhood.domain.valueobjects.HentaiId

data class HitomiInfo(
    override val id: HentaiId,
    override val updatedAt: Timestamp,
    override val status: HentaiInfoStatus
) : HentaiInfo(status = status) {
    constructor(id: HentaiId) : this(
        id = id,
        updatedAt = Timestamp(),
        status = HentaiInfoStatus.Empty
    )
}
