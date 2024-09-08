package sisterhood.domain.hentai

import sisterhood.domain.valueobjects.HentaiId

interface HentaiRepository {
    suspend fun list(ids: List<HentaiId>): List<Hentai>
    suspend fun save(hentai: Hentai): Result<Unit>
    suspend fun update(hentai: Hentai): Result<Unit>
}
