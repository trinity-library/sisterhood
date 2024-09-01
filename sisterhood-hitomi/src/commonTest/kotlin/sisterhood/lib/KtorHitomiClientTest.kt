package sisterhood.lib

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import sisterhood.lib.hitomi.FakeGG
import sisterhood.lib.hitomi.FileExtension
import sisterhood.lib.hitomi.Gallery
import sisterhood.lib.hitomi.ThumbnailSize
import kotlin.test.Test

class KtorHitomiClientTest {
    private fun fetchGallery(): Gallery {
        val galleryId = 2726888
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(text = Resources.galleryJs),
                status = HttpStatusCode.OK,
                headers = headers {
                    HttpHeaders.run {
                        set(AcceptRanges, "bytes")
                        set(AccessControlAllowOrigin, "*")
                        set(CacheControl, "max-age=3600")
                        set(ContentType, "application/javascript; charset=UTF-8")
                        set(Date, "Sat, 31 Aug 2024 10:03:20 GMT")
                        set(Expires, "Sat, 31 Aug 2024 11:03:20 GMT")
                        set(LastModified, "Sat, 31 Aug 2024 10:00:02 GMT")
                        set(Server, "nginx/1.27.1")
                        set(Vary, "Accept-Encoding")
                    }
                    etag("65e64486-f2b")
                    set("alt-svc", "h3=\":443\"; ma=2592000")
                }
            )
        }
        val client = KtorHitomiClient(
            gg = FakeGG(),
            httpClient = HttpClient(engine = mockEngine)
        )
        return runBlocking { client.fetchGallery(galleryId) }.getOrThrow()!!
    }

    @Test
    fun canFetchGallery() {
        // Given
        val galleryId = 2726888
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(text = Resources.galleryJs),
                status = HttpStatusCode.OK,
                headers = headers {
                    HttpHeaders.run {
                        set(AcceptRanges, "bytes")
                        set(AccessControlAllowOrigin, "*")
                        set(CacheControl, "max-age=3600")
                        set(ContentType, "application/javascript; charset=UTF-8")
                        set(Date, "Sat, 31 Aug 2024 10:03:20 GMT")
                        set(Expires, "Sat, 31 Aug 2024 11:03:20 GMT")
                        set(LastModified, "Sat, 31 Aug 2024 10:00:02 GMT")
                        set(Server, "nginx/1.27.1")
                        set(Vary, "Accept-Encoding")
                    }
                    etag("65e64486-f2b")
                    set("alt-svc", "h3=\":443\"; ma=2592000")
                }
            )
        }
        val client = KtorHitomiClient(
            gg = FakeGG(),
            httpClient = HttpClient(engine = mockEngine)
        )

        // When
        val result = runBlocking { client.fetchGallery(galleryId) }

        // Then
        result.run {
            println(exceptionOrNull())
            assert(isSuccess)
            assert(getOrNull()?.id == galleryId)
        }
    }

    @Test
    fun canFetchPage() {
        // Given
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(content = ByteArray(10)),
                status = HttpStatusCode.OK,
                headers = headers {
                    HttpHeaders.run {
                        set(AcceptRanges, "bytes")
                        set(AccessControlAllowOrigin, "*")
                        set(CacheControl, "max-age=3600")
                        set(ContentLength, "10")
                        set(ContentType, "image/webp")
                        set(Date, "Sat, 31 Aug 2024 10:03:20 GMT")
                        set(Expires, "Sat, 31 Aug 2024 11:03:20 GMT")
                        set(LastModified, "Wed, 02 Jun 2021 03:41:49 GMT")
                        set(Server, "nginx/1.27.1")
                        set(Vary, "Accept-Encoding")
                    }
                    etag("60b6fdfd-83cc8")
                    set("alt-svc", "h3=\":443\"; ma=2592000")
                }
            )
        }
        val client = KtorHitomiClient(
            gg = FakeGG(),
            httpClient = HttpClient(engine = mockEngine)
        )
        val gallery = fetchGallery()

        // When
        val result = runBlocking { client.fetchPage(gallery, 1, FileExtension.WEBP) }

        // Then
        assert(result.isSuccess)
    }

    @Test
    fun canFetchThumbnail() {
        // Given
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(content = ByteArray(10)),
                status = HttpStatusCode.OK,
                headers = headers {
                    HttpHeaders.run {
                        set(AcceptRanges, "bytes")
                        set(AccessControlAllowOrigin, "*")
                        set(CacheControl, "max-age=3600")
                        set(ContentLength, "10")
                        set(ContentType, "image/webp")
                        set(Date, "Sat, 31 Aug 2024 10:03:20 GMT")
                        set(Expires, "Sat, 31 Aug 2024 11:03:20 GMT")
                        set(LastModified, "Wed, 02 Jun 2021 03:41:49 GMT")
                        set(Server, "nginx/1.27.1")
                        set(Vary, "Accept-Encoding")
                    }
                    etag("60b6fdfd-83cc8")
                    set("alt-svc", "h3=\":443\"; ma=2592000")
                }
            )
        }
        val client = KtorHitomiClient(
            gg = FakeGG(),
            httpClient = HttpClient(engine = mockEngine)
        )
        val gallery = fetchGallery()

        // When
        val result = runBlocking { client.fetchThumbnail(gallery, FileExtension.WEBP, ThumbnailSize.SMALLBIG) }

        // Then
        assert(result.isSuccess)
    }
}
