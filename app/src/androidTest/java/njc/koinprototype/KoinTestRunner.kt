package njc.koinprototype

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

class KoinTestRunner: AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, TestKoinApplication::class.java.name, context)
    }
}
