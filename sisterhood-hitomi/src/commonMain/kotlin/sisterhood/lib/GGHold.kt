package sisterhood.lib

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
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
    val gg: GG
        get() = if (alive()) store else fetchGG()
    private lateinit var store: GG
    private var lastFetchedAt: Instant = Instant.DISTANT_PAST

    constructor(httpClient: HttpClient) : this(
        httpClient = httpClient,
        lifetime = 3.minutes
    )

    private fun alive(): Boolean =
        Clock.System.now() - lastFetchedAt < lifetime

    private fun fetchGG(): GG = runBlocking {
        httpClient
            .get("https://ltn.hitomi.la/gg.js")
            .bodyAsText()
            .let { ggjs -> GGImpl(ggJs = ggjs) }
            .also {
                store = it
                lastFetchedAt = Clock.System.now()
            }
    }

    fun fetch(): Result<GG> = runCatching {
        takeIf { alive() }?.store ?: fetchGG()
    }
}
