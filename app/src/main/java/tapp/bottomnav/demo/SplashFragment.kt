package tapp.bottomnav.demo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import tapp.bottomnav.demo.util.InternalStorageManager

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val storageManager by inject<InternalStorageManager>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (storageManager.getIsUserLoggedIn()) {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToMainGraph())
        } else {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToAuthGraph())
        }
    }
}