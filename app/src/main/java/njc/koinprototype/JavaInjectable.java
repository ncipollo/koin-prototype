package njc.koinprototype;

import android.util.Log;

import org.koin.java.standalone.KoinJavaComponent;

public class JavaInjectable {
    public JavaInjectable() {
        MainViewModel viewModel = KoinJavaComponent.get(MainViewModel.class);
        Log.e("JavaInjectable",  viewModel.toString());
    }
}
