package tapp.bottomnav.demo.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.data.articlePreviews
import tapp.bottomnav.demo.databinding.FragmentDetailsBinding
import tapp.bottomnav.demo.util.getArticleById
import tapp.bottomnav.demo.util.loadUrl
import tapp.bottomnav.demo.util.navigateUp
import tapp.bottomnav.demo.util.setFormattedDate

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private val args by navArgs<DetailsFragmentArgs>()
    private val article by lazy { articlePreviews.getArticleById(args.articleId) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backIB.setOnClickListener { navigateUp() }
        val article = article ?: return
        binding.bannerIV.loadUrl(article.imageUrl)
        binding.articleTitleTV.text = article.title
        binding.articleDateTV.setFormattedDate(article.date)
    }
}