package njc.koinprototype

import android.app.Application

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Injection.start(this)
    }
}
