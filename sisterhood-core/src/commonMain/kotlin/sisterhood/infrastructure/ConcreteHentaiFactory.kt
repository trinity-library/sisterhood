package sisterhood.infrastructure

import sisterhood.domain.hentai.Hentai
import sisterhood.domain.hentai.HentaiFactory
import sisterhood.domain.valueobjects.HentaiId

class ConcreteHentaiFactory : HentaiFactory {
    override fun create(id: HentaiId): Hentai =
        Hentai(id = id)
}
