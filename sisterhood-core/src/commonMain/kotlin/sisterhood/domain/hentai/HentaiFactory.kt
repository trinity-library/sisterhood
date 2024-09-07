package sisterhood.domain.hentai

import sisterhood.domain.valueobjects.HentaiId

interface HentaiFactory {
    fun create(id: HentaiId): Hentai
}
