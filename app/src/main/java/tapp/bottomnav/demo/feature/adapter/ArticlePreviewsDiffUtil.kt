package tapp.bottomnav.demo.feature.adapter

import androidx.recyclerview.widget.DiffUtil

object ArticlePreviewsDiffUtil : DiffUtil.ItemCallback<ArticlePreview>() {

    override fun areItemsTheSame(oldItem: ArticlePreview, newItem: ArticlePreview): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ArticlePreview, newItem: ArticlePreview): Boolean =
        oldItem == newItem
}