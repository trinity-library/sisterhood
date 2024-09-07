package sisterhood.infrastructure.hitomi

import sisterhood.domain.HentaiInfoFetchFailed
import sisterhood.domain.Name
import sisterhood.domain.hentaiinfo.HentaiInfoService
import sisterhood.domain.hentaiinfo.entities.HentaiMetadata
import sisterhood.domain.hentaiinfo.entities.HitomiMetadata
import sisterhood.domain.valueobjects.HentaiId
import sisterhood.domain.valueobjects.HentaiLanguage
import sisterhood.lib.HitomiClient
import sisterhood.lib.hitomi.Gallery
import sisterhood.lib.hitomi.Language

class HitomiInfoService(private val hitomiClient: HitomiClient) : HentaiInfoService {
    override suspend fun fetchLatestIds(language: HentaiLanguage, n: Int, skip: Int): Result<List<HentaiId>> =
        hitomiClient
            .fetchIds(language.toHitomiLanguage(), skip, n)
            .map { ids -> ids.map { id -> HentaiId(id = id) } }
            .onFailure {
                return Result.failure(
                    HentaiInfoFetchFailed(
                        cause = it,
                        message = "Failed to fetch latest $n ids(skipping $skip) from hitomi"
                    )
                )
            }

    override suspend fun fetchMetadata(id: HentaiId): Result<HentaiMetadata?> =
        hitomiClient
            .fetchGallery(id.toInt())
            .map { it?.toHitomiMetadata() }
}

private fun Gallery.toHitomiMetadata(): HitomiMetadata =
    HitomiMetadata(
        id = HentaiId(id = id),
        language = language.toHentaiLanguage(),
        title = Name(name = title)
    )

private fun Language.toHentaiLanguage(): HentaiLanguage = when (this) {
    Language.KOREAN -> HentaiLanguage.KOREAN
    else -> throw Exception()
}
