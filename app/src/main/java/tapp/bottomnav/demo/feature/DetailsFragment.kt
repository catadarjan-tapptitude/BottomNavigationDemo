package tapp.bottomnav.demo.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import java.text.SimpleDateFormat
import java.util.Locale
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.data.articlePreviews
import tapp.bottomnav.demo.databinding.FragmentDetailsBinding
import tapp.bottomnav.demo.util.navigateUp

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val args by navArgs<DetailsFragmentArgs>()
    private val article by lazy { articlePreviews.firstOrNull { it.id == args.articleId } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backIB.setOnClickListener { navigateUp() }
        val article = article ?: return
        loadArticleImage(article.imageUrl)
        binding.articleTitleTV.text = article.title
        binding.articleDateTV.text = SimpleDateFormat("dd-mm-yyyy", Locale.getDefault()).format(article.date)
    }

    private fun loadArticleImage(imageUrl: String) {
        Glide.with(binding.bannerIV)
            .load(imageUrl)
            .centerInside()
            .into(binding.bannerIV)
    }
}