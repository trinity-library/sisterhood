package sisterhood.lib

import sisterhood.lib.hitomi.FileExtension
import sisterhood.lib.hitomi.Gallery
import sisterhood.lib.hitomi.Language
import sisterhood.lib.hitomi.ThumbnailSize

interface HitomiClient {
    suspend fun fetchGallery(id: Int): Result<Gallery?>
    suspend fun fetchIds(language: Language, offset: Int, limit: Int): Result<List<Int>>
    suspend fun fetchPage(gallery: Gallery, pageNumber: Int, ext: FileExtension): Result<ByteArray>
    suspend fun fetchThumbnail(gallery: Gallery, ext: FileExtension, size: ThumbnailSize): Result<ByteArray>
}
