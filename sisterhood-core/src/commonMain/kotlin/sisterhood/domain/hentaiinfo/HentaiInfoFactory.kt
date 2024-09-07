package sisterhood.domain.hentaiinfo

import sisterhood.domain.hentaiinfo.entities.HentaiMetadata

interface HentaiInfoFactory {
    fun create(metadata: HentaiMetadata): HentaiInfo
}
