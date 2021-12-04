package tapp.bottomnav.demo.feature.travel.adapter

import androidx.recyclerview.widget.DiffUtil

object DestinationsDiffUtil : DiffUtil.ItemCallback<Destination>() {

    override fun areItemsTheSame(oldItem: Destination, newItem: Destination): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Destination, newItem: Destination): Boolean =
        oldItem == newItem
}