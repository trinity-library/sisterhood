package sisterhood.domain.hentai.entities

import sisterhood.domain.hentai.HentaiId

data class HitomiInfo(
    override val id: HentaiId
) : HentaiInfo(id = id)
