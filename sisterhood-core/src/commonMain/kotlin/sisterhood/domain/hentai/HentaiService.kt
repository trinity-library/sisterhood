package sisterhood.domain.hentai

import sisterhood.domain.hentai.entities.HentaiMetadata
import sisterhood.domain.valueobjects.HentaiId
import sisterhood.domain.valueobjects.HentaiLanguage

interface HentaiService {
    suspend fun fetchLatestIds(n: Int, skip: Int): Result<List<HentaiId>>
    suspend fun fetchLatestIds(language: HentaiLanguage, n: Int, skip: Int): Result<List<HentaiId>>
    suspend fun fetchMetadata(id: HentaiId): Result<HentaiMetadata>
}
