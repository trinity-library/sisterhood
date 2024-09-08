package sisterhood.domain.hentai

import sisterhood.domain.Aggregate
import sisterhood.domain.Timestamp
import sisterhood.domain.hentai.events.HentaiInitializationStarted
import sisterhood.domain.valueobjects.HentaiId

data class Hentai(
    override val id: HentaiId,
    override val status: HentaiStatus,
    override val createdAt: Timestamp,
    override val updatedAt: Timestamp
) : Aggregate() {
    constructor(id: HentaiId) : this(
        id = id,
        createdAt = Timestamp(),
        updatedAt = Timestamp(),
        status = HentaiStatus.Created
    )

    fun isPreparing(): Boolean =
        status == HentaiStatus.Preparing

    private fun canInitialize(): Boolean =
        status == HentaiStatus.Created || status == HentaiStatus.Preparing

    fun initialize(): HentaiInitializationStarted? =
        takeIf { canInitialize() }?.let {
            HentaiInitializationStarted(
                aggregate = copy(
                    status = HentaiStatus.Fulfilled,
                    updatedAt = Timestamp()
                )
            )
        }
}
