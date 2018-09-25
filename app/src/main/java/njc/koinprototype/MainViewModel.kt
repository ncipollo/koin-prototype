package njc.koinprototype

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val viewState = object : LiveData<ViewState>() {
        override fun onActive() {
            postValue(ViewState("Testing 123"))
        }
    }
}

data class ViewState(val text: String)
