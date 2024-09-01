package sisterhood.domain.hentai

interface HentaiFactory {
    fun create(id: HentaiId): Hentai
}
