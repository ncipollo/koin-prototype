package njc.koinprototype

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object Injection {

    private val viewModelModule = module {
        viewModel { MainViewModel() }
    }

    private val modules = listOf(viewModelModule)

    fun start(application: Application) {
        application.startKoin(application, modules)
    }
}
