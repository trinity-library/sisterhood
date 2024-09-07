package sisterhood.domain

import kotlinx.coroutines.flow.Flow
import sisterhood.domain.valueobjects.HentaiId

abstract class Event<A : Aggregate>(open val aggregate: A) : Entity() {
    override val id: Id = HentaiId(id = 1)  // TODO: replace with UUID after applying kotlin 2.0.20
    override val updatedAt: Timestamp = Timestamp()

    abstract fun EventProp.apply(): Flow<Event<out Aggregate>>

    fun handle(prop: EventProp): Flow<Event<out Aggregate>> =
        prop.apply()
}
