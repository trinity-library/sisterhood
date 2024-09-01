package sisterhood.domain.hentai.entities

import sisterhood.domain.Entity
import sisterhood.domain.hentai.HentaiId

sealed class HentaiInfo(
    override val id: HentaiId
) : Entity()
