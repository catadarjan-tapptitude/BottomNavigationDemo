package tapp.bottomnav.demo.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import org.koin.android.ext.android.inject
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.databinding.FragmentProfileBinding
import tapp.bottomnav.demo.util.InternalStorageManager

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val storageManager by inject<InternalStorageManager>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logoutBtn.setOnClickListener {
            storageManager.setIsUserLoggedIn(false)
            findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToSplashGraph())
        }
    }
}