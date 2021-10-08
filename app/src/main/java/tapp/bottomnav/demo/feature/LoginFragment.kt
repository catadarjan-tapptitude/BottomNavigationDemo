package tapp.bottomnav.demo.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import org.koin.android.ext.android.inject
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.databinding.FragmentLoginBinding
import tapp.bottomnav.demo.util.InternalStorageManager
import tapp.bottomnav.demo.util.navigateUp

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val storageManager by inject<InternalStorageManager>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.buttonLogin.setOnClickListener {
            storageManager.setIsUserLoggedIn(true)
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToMainGraph())
        }

        binding.toolbar.setNavigationOnClickListener { navigateUp() }
    }
}