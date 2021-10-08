package tapp.bottomnav.demo.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.databinding.FragmentHomeBinding
import tapp.bottomnav.demo.util.navigateUp

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener { navigateUp() }

        binding.readMoreBtn.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment())
        }
    }
}