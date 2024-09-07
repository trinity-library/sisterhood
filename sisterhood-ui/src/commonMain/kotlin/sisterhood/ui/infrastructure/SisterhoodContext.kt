package sisterhood.ui.infrastructure

import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import sisterhood.business.Mediate

data class SisterhoodContext(
    private val koin: Koin
) {
    val mediate: Mediate
        get() = koin.get(named("mediate"))
}

class SisterhoodContextInitialization {
    private lateinit var koin: Koin

    private fun insertKoin(koin: Koin) {
        this.koin = koin
    }

    fun insertKoin(appDeclaration: KoinAppDeclaration) =
        insertKoin(startKoin(appDeclaration).koin)

    fun initialize(): SisterhoodContext =
        SisterhoodContext(
            koin = koin
        )
}
