package tapp.bottomnav.demo.feature.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Locale
import tapp.bottomnav.demo.databinding.ItemArticlePreviewBinding

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
        binding.articleDateTV.text = SimpleDateFormat("dd-mm-yyyy", Locale.getDefault()).format(articlePreview.date)
        binding.articleSnippetTV.text = articlePreview.contentPreview
        loadArticleImage(articlePreview.imageUrl)
    }

    private fun loadArticleImage(imageUrl: String) {
        Glide.with(binding.articleImageIV)
            .load(imageUrl)
            .centerInside()
            .into(binding.articleImageIV)
    }
}