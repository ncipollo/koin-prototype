package njc.koinprototype

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.Disposable

class MainViewModel(
    private val interactor: MainInteractor
) : ViewModel() {
    private var disposable: Disposable? = null

    val viewState = object : LiveData<ViewState>() {
        override fun onActive() {
            if (disposable == null) {
                disposable = interactor.create().subscribe { postValue(resultToState(it)) }
            }
        }
    }

    override fun onCleared() {
        disposable?.dispose()
    }

    fun resultToState(result: MainInteractor.Result) =
        ViewState("${result.text} seconds have passed")
}

data class ViewState(val text: String)
