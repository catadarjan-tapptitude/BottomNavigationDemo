package tapp.bottomnav.demo.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.data.articlePreviews
import tapp.bottomnav.demo.databinding.FragmentHomeBinding
import tapp.bottomnav.demo.feature.home.adapter.ArticlePreviewsAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val articlePreviewsAdapter by lazy { initArticlePreviewsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.articlesListRV.adapter = articlePreviewsAdapter.apply {
            submitList(articlePreviews)
        }
    }

    private fun initArticlePreviewsAdapter(): ArticlePreviewsAdapter = ArticlePreviewsAdapter(::onArticlePreviewClickListener)

    private fun onArticlePreviewClickListener(articleId: Int) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(articleId))
    }
}