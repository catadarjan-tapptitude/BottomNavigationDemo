package tapp.bottomnav.demo.feature.travel.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import tapp.bottomnav.demo.databinding.ItemDestinationBinding
import tapp.bottomnav.demo.util.layoutInflater

class DestinationsAdapter : ListAdapter<Destination, DestinationViewHolder>(DestinationsDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder =
        DestinationViewHolder(ItemDestinationBinding.inflate(parent.layoutInflater, parent, false))

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) =
        holder.bind(getItem(position))
}