package sisterhood.infrastructure.hitomi

import sisterhood.domain.HentaiInfoFetchFailed
import sisterhood.domain.hentai.HentaiId
import sisterhood.domain.hentai.HentaiInfoService
import sisterhood.domain.hentai.entities.HitomiInfo
import sisterhood.domain.hentai.valueobjects.HentaiLanguage
import sisterhood.lib.HitomiClient

class HitomiInfoService(private val hitomiClient: HitomiClient) : HentaiInfoService {
    override suspend fun fetchLatest(language: HentaiLanguage, n: Int, skip: Int): Result<List<HitomiInfo>> =
        hitomiClient
            .fetchIds(language.toHitomiLanguage(), skip, n)
            .map { ids -> ids.map { id -> HitomiInfo(id = HentaiId(id = id)) } }
            .onFailure {
                return Result.failure(
                    HentaiInfoFetchFailed(
                        cause = it,
                        message = "Failed to create latest $n hentais(skipping $skip) from hitomi"
                    )
                )
            }
}
