package tapp.bottomnav.demo.feature.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import tapp.bottomnav.demo.databinding.ItemArticlePreviewBinding
import tapp.bottomnav.demo.util.layoutInflater

typealias OnArticlePreviewClickListener = (Int) -> Unit

class ArticlePreviewsAdapter(
    private val onArticlePreviewClickListener: OnArticlePreviewClickListener
) : ListAdapter<ArticlePreview, ArticlePreviewViewHolder>(ArticlePreviewsDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlePreviewViewHolder =
        ArticlePreviewViewHolder(
            ItemArticlePreviewBinding.inflate(parent.layoutInflater, parent, false),
            onArticlePreviewClickListener
        )

    override fun onBindViewHolder(holder: ArticlePreviewViewHolder, position: Int) =
        holder.bind(getItem(position))
}