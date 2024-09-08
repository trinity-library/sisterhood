package sisterhood.business.commands

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import sisterhood.domain.Aggregate
import sisterhood.domain.Event
import sisterhood.domain.HentaiMetadataFetchFailed
import sisterhood.domain.create

data class FetchLatestHentais(
    val n: Int,
    val skip: Int,
) : Command() {
    override fun CommandProp.apply(): Flow<Event<out Aggregate>> = flow {
        val hentaiIds = hentaiService
            .fetchLatestIds(n, skip)
            .getOrThrow()

        val existing = hentaiRepository
            .list(hentaiIds)
            .apply { emitAll(mapNotNull { it.initialize() }.asFlow()) }

        val alreadyFetched = existing.map { it.id }.toSet()
        hentaiIds
            .filter { it !in alreadyFetched }
            .mapNotNull { hentaiFactory.create(it).initialize() }
            .apply { emitAll(asFlow()) }
    }.retry {
        val print = printFactory.create(this@FetchLatestHentais)
        when (it) {
            is HentaiMetadataFetchFailed -> {
                print.warn("Failed to fetch metadata, retrying...", it)
                delay(1000)
                true
            }

            else -> {
                print.error("Failed to fetch $n hentais (skipping $skip)", it)
                false
            }
        }
    }
}
