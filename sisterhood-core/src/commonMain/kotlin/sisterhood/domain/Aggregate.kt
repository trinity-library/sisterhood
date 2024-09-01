package sisterhood.domain

abstract class Aggregate : Entity() {
    abstract override val id: Id
    abstract val status: Status

    override fun equals(other: Any?): Boolean = when (other) {
        is Aggregate -> id == other.id && status == other.status
        else -> false
    }

    override fun hashCode(): Int =
        super.hashCode().times(31).plus(status.hashCode())
}
