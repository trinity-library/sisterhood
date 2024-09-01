package sisterhood.domain

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

@JvmInline
value class Timestamp(private val instant: Instant) {
    constructor() : this(instant = Clock.System.now())

    operator fun compareTo(updatedAt: Timestamp): Int =
        instant.compareTo(updatedAt.instant)
}
