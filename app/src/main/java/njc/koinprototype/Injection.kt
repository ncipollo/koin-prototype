package njc.koinprototype

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object Injection {

    private val repoModule = module {
        single { IntervalRepository() }
    }

    private val interactorModule = module {
        single { MainInteractor(get()) }
    }

    private val viewModelModule = module {
        viewModel { MainViewModel(get()) }
    }

    private val modules = listOf(repoModule, interactorModule, viewModelModule)

    fun start(application: Application) {
        application.startKoin(application, modules)
    }
}
