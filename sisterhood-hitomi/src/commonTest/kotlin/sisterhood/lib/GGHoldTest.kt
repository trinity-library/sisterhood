package sisterhood.lib

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class GGHoldTest {
    @Test
    fun canFetchGG() {
        // Given
        val mockEngine = MockEngine {
            respond(
                content = ByteReadChannel(text = Resources.ggJs),
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
                    etag("\"66d2e9a2-13ac\"")
                    set("alt-svc", "h3=\":443\"; ma=2592000")
                }
            )
        }
        val ggHold = GGHold(httpClient = HttpClient(engine = mockEngine))

        // When
        val result = runBlocking { ggHold.fetch() }

        // Then
        assert(result.isSuccess)
    }
}
