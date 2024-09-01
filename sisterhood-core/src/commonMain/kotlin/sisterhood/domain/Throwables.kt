package sisterhood.domain

abstract class SisterhoodException : RuntimeException() {
    abstract override val cause: Throwable?
    abstract override val message: String?
}

class HentaiInfoFetchFailed(
    override val cause: Throwable,
    override val message: String
) : SisterhoodException()
