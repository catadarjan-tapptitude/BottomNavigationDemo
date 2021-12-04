package tapp.bottomnav.demo.feature.travel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.data.destinations
import tapp.bottomnav.demo.databinding.FragmentTravelBinding
import tapp.bottomnav.demo.feature.travel.adapter.DestinationsAdapter

class TravelFragment : Fragment(R.layout.fragment_travel) {

    private val binding by viewBinding(FragmentTravelBinding::bind)
    private val destinationsAdapter by lazy { initDestinationsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.travelRV.adapter = destinationsAdapter.apply {
            submitList(destinations)
        }
    }

    private fun initDestinationsAdapter(): DestinationsAdapter = DestinationsAdapter()
}