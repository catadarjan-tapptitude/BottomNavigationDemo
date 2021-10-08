package tapp.bottomnav.demo.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.databinding.FragmentDetailsBinding
import tapp.bottomnav.demo.util.navigateUp

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backIB.setOnClickListener { navigateUp() }
    }
}