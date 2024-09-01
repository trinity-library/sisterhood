package sisterhood.lib

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import sisterhood.lib.hitomi.GG
import sisterhood.lib.hitomi.GGImpl
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

class GGHold(
    private val httpClient: HttpClient,
    private val lifetime: Duration
) {
    private var gg: GG? = null
    private var lastFetchedAt: Instant = Instant.DISTANT_PAST

    constructor(httpClient: HttpClient) : this(
        httpClient = httpClient,
        lifetime = 3.minutes
    )

    private fun alive(): Boolean =
        Clock.System.now() - lastFetchedAt < lifetime

    private suspend fun fetchGG(): GG =
        httpClient
            .get("https://ltn.hitomi.la/gg.js")
            .bodyAsText()
            .let { ggjs -> GGImpl(ggJs = ggjs) }
            .also {
                gg = it
                lastFetchedAt = Clock.System.now()
            }

    suspend fun fetch(): Result<GG> = runCatching {
        takeIf { alive() }?.gg ?: fetchGG()
    }
}
