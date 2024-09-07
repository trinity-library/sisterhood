package sisterhood.domain

abstract class Entity(val createdAt: Timestamp = Timestamp()) {
    abstract val id: Id
    abstract val updatedAt: Timestamp

    override fun equals(other: Any?): Boolean = when (other) {
        is Entity -> id == other.id
        else -> false
    }

    override fun hashCode(): Int =
        id.hashCode()
            .times(31).plus(createdAt.hashCode())
            .times(31).plus(updatedAt.hashCode())
}
