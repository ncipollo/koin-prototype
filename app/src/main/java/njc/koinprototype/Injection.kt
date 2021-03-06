package njc.koinprototype

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.log.EmptyLogger

object Injection {

    private val repoModule = module {
        single { IntervalRepository() }
    }

    private val interactorModule = module {
        single { MainInteractor(get()) }
    }

    private val viewModelModule = module {
        viewModel { MainViewModel(get()) }
        viewModel { ParameterViewModel(it[0]) }
    }

    val modules = listOf(repoModule, interactorModule, viewModelModule)

    val modulesMissingDependency = listOf(interactorModule, viewModelModule)

    fun start(application: Application) {
        application.startKoin(context = application, modules = modules, logger = EmptyLogger())
    }

    fun startTest(application: Application, mockModule: Module) {
        application.startKoin(application, modules + mockModule)
    }
}
