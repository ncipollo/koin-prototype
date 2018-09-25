package njc.koinprototype

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

open class IntervalRepository {
    open fun interval() = Observable.interval(2, TimeUnit.SECONDS)
}
