package sisterhood.domain.hentai

import sisterhood.domain.hentai.entities.HentaiInfo
import sisterhood.domain.hentai.valueobjects.HentaiLanguage

interface HentaiInfoService {
    suspend fun fetchLatest(language: HentaiLanguage, n: Int, skip: Int): Result<List<HentaiInfo>>
}
