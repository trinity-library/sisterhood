package sisterhood.domain.hentaiinfo

import sisterhood.domain.hentaiinfo.entities.HentaiMetadata
import sisterhood.domain.valueobjects.HentaiId
import sisterhood.domain.valueobjects.HentaiLanguage

interface HentaiInfoService {
    suspend fun fetchLatestIds(language: HentaiLanguage, n: Int, skip: Int): Result<List<HentaiId>>
    suspend fun fetchMetadata(id: HentaiId): Result<HentaiMetadata?>
}
