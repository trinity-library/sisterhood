package sisterhood.lib

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import sisterhood.lib.hitomi.*

private const val GALLERY_PREFIX = "var galleryinfo = "

class KtorHitomiClient(
    private val gg: GG,
    private val httpClient: HttpClient
) : HitomiClient {
    private val json = Json {
        coerceInputValues = true
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    override suspend fun fetchGallery(id: Int): Result<Gallery?> = runCatching {
        httpClient
            .get("https://ltn.hitomi.la/galleries/$id.js")
            .let { response ->
                response
                    .bodyAsText()
                    .takeIf { it.startsWith(GALLERY_PREFIX) }
                    ?.let { json.decodeFromString(it.removePrefix(GALLERY_PREFIX)) }
            }
    }

    override suspend fun fetchIds(language: Language, offset: Int, limit: Int): Result<List<Int>> = runCatching {
        httpClient
            .get("https://ltn.hitomi.la/index-${language.name.lowercase()}.nozomi") {
                headers { append(HttpHeaders.Range, "bytes=${offset * 4}-${offset * 4 + limit * 4 - 1}") }
            }
            .let { response ->
                response.bodyAsChannel().let { channel ->
                    mutableListOf<Int>().apply {
                        while (!channel.isClosedForRead) add(channel.readInt())
                    }
                }
            }
    }

    private fun createPageUrl(hash: String, ext: String): String {
        val aOrB = Char(97 + gg.m(gg.s(hash)))
        val route = "${gg.b}${gg.s(hash)}"
        return "https://${aOrB}a.hitomi.la/$ext/$route/$hash.$ext"
    }

    override suspend fun fetchPage(
        gallery: Gallery,
        pageNumber: Int,
        ext: FileExtension
    ): Result<ByteArray> = runCatching {
        httpClient
            .get(createPageUrl(gallery.files.get(pageNumber).hash, ext.text)) {
                headers {
                    append(
                        HttpHeaders.Accept,
                        "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"
                    )
                    append(HttpHeaders.Referrer, "https://hitomi.la/reader/${gallery.id}.html")
                    append(
                        HttpHeaders.UserAgent,
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/109.0"
                    )
                }
            }
            .readBytes()
    }

    private fun createThumbnailUrl(hash: String, ext: String, size: String): String {
        val aOrB = Char(97 + gg.m(gg.s(hash)))
        val processedHash = "${hash.last()}/${hash.substring(hash.length - 3, hash.length - 1)}"
        return "https://${aOrB}tn.hitomi.la/${ext}${size}tn/$processedHash/$hash.$ext"
    }

    override suspend fun fetchThumbnail(
        gallery: Gallery,
        ext: FileExtension,
        size: ThumbnailSize
    ): Result<ByteArray> = runCatching {
        httpClient
            .get(createThumbnailUrl(gallery.files.first().hash, ext.text, size.text)) {
                headers { append(HttpHeaders.Referrer, "https://hitomi.la") }
            }
            .readBytes()
    }
}
