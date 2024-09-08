package sisterhood.infrastructure.sqldelight

import sisterhood.domain.Timestamp
import sisterhood.domain.hentai.Hentai
import sisterhood.domain.valueobjects.HentaiId
import sisterhood.infrastructure.sqldelight.Hentai as HentaiOrm

fun HentaiOrm.toHentai(): Hentai =
    Hentai(
        id = HentaiId(id = id),
        status = status,
        createdAt = Timestamp(epochMillisecond = created_at),
        updatedAt = Timestamp(epochMillisecond = updated_at),
    )

fun HentaiOrm(hentai: Hentai): HentaiOrm = hentai.run {
    HentaiOrm(
        id = id.toLong(),
        status = status,
        created_at = createdAt.epochMillisecond,
        updated_at = updatedAt.epochMillisecond,
    )
}
