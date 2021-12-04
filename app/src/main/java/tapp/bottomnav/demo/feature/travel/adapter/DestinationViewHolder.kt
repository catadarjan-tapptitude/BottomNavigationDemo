package tapp.bottomnav.demo.feature.travel.adapter

import androidx.recyclerview.widget.RecyclerView
import tapp.bottomnav.demo.databinding.ItemDestinationBinding
import tapp.bottomnav.demo.util.loadUrl
import tapp.bottomnav.demo.util.setFormattedDate

class DestinationViewHolder(private val binding: ItemDestinationBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(destination: Destination) {
        binding.locationIV.loadUrl(destination.imageUrl)
        binding.cityNameTV.text = destination.city
        binding.dateTV.setFormattedDate(destination.date)
    }
}