package sisterhood.application

import sisterhood.usecase.HentaiUnitOfWork

object Dependency {
    lateinit var configuration: Configuration
    lateinit var preparation: Preparation

    fun provideHentaiUnitOfWork() = HentaiUnitOfWork(
        hentaiCache = preparation.cacheFactory.create(),
        hentaiRepository = preparation.repositoryFactory.create(),
        hentaiService = preparation.serviceFactory.create()
    )

    fun provideSettingsStore() = preparation.storeFactory.create()

    fun inject(action: Scope.() -> Unit) = Scope().action()

    class Scope {
        fun configure(action: Configuration.Scope.() -> Unit) = with(Configuration.Scope()) {
            action()
            configuration = build()
        }

        fun prepare(action: Preparation.Scope.() -> Unit) = if (::configuration.isInitialized) {
            Preparation.Scope(configuration)
        } else {
            Preparation.Scope()
        }.apply {
            action()
            preparation = build()
        }
    }
}
