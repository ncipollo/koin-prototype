package njc.koinprototype

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class IntervalRepository {
    fun interval() = Observable.interval(2, TimeUnit.SECONDS)
}
