package sisterhood.domain

import kotlinx.coroutines.flow.Flow

abstract class Event<A : Aggregate>(
    open val aggregate: A,
    val occurredAt: Timestamp = Timestamp()
) : Entity(
    createdAt = occurredAt,
    updatedAt = occurredAt
) {
    abstract fun EventProp.apply(): Flow<Event<out Aggregate>>

    fun handle(prop: EventProp): Flow<Event<out Aggregate>> =
        prop.apply()
}
