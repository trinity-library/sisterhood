package sisterhood.domain.hentai

interface HentaiRepository {
    suspend fun save(hentai: Hentai): Result<Unit>
    suspend fun update(hentai: Hentai): Result<Unit>
}
