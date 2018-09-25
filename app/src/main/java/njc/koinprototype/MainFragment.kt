package njc.koinprototype

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.text
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainFragment : Fragment() {
    companion object {
        fun withArgs(arg: String): MainFragment {
            val fragment = MainFragment()
            fragment.arguments = Bundle().also { it.putString("arg", arg) }
            return fragment
        }
    }

    private val viewModel: MainViewModel by viewModel()
    private val paramViewModel: ParameterViewModel by viewModel {
        parametersOf(
            arguments?.getString("arg") ?: ""
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(this, Observer { state ->
            state?.let {
                text.text = it.text
            }
        })
        Log.e("Parameter value", paramViewModel.parameter)

        JavaInjectable()
    }
}
