package tapp.bottomnav.demo.feature.home.adapter

import androidx.recyclerview.widget.RecyclerView
import tapp.bottomnav.demo.databinding.ItemArticlePreviewBinding
import tapp.bottomnav.demo.util.loadUrl
import tapp.bottomnav.demo.util.setFormattedDate

class ArticlePreviewViewHolder(
    private val binding: ItemArticlePreviewBinding,
    private val onArticlePreviewClickListener: OnArticlePreviewClickListener
) : RecyclerView.ViewHolder(binding.root) {

    private var articlePreview: ArticlePreview? = null

    init {
        binding.readMoreBtn.setOnClickListener {
            articlePreview?.let { articlePreview ->
                onArticlePreviewClickListener(articlePreview.id)
            }
        }
    }

    fun bind(articlePreview: ArticlePreview) {
        this.articlePreview = articlePreview
        binding.articleTitleTV.text = articlePreview.title
        binding.articleDateTV.setFormattedDate(articlePreview.date)
        binding.articleSnippetTV.text = articlePreview.contentPreview
        binding.articleImageIV.loadUrl(articlePreview.imageUrl)
    }
}