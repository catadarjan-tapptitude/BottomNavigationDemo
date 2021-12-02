package tapp.bottomnav.demo.feature

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import tapp.bottomnav.demo.R
import tapp.bottomnav.demo.data.articlePreviews
import tapp.bottomnav.demo.databinding.FragmentHomeBinding
import tapp.bottomnav.demo.feature.adapter.ArticlePreviewsAdapter
import tapp.bottomnav.demo.util.navigateUp

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val articlePreviewsAdapter by lazy { initArticlePreviewsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initViews()
    }

    private fun initListeners() {
        binding.toolbar.setNavigationOnClickListener { navigateUp() }
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