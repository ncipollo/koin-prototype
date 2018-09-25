package njc.koinprototype

import android.app.Application
import org.koin.android.ext.android.startKoin

object Injection {
    fun start(application: Application) {
        application.startKoin(application, emptyList())
    }
}
