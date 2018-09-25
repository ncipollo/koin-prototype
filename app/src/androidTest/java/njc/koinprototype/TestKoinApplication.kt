package njc.koinprototype

import android.app.Application
import io.reactivex.Observable
import org.koin.dsl.module.module
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

const val TEST_INTERVAL = 100L

class TestKoinApplication : Application() {
    private val mockModule = module {
        single(override = true) { _ ->
            mock(IntervalRepository::class.java)
                .also { repo ->
                    `when`(repo.interval()).then { Observable.just(TEST_INTERVAL) }
                }
        }
    }

    override fun onCreate() {
        super.onCreate()
        Injection.startTest(this, mockModule)
    }
}
