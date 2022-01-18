package tapp.bottomnav.demo.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import tapp.bottomnav.demo.feature.home.adapter.ArticlePreview

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}

fun Fragment.navigateUp() {
    if (findNavController().previousBackStackEntry == null) {
        requireActivity().onBackPressed()
    } else {
        findNavController().navigateUp()
    }
}

internal val ViewGroup.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

fun ImageView.loadUrl(imageUrl: String) {
    Glide.with(context)
        .load(imageUrl)
        .centerInside()
        .into(this)
}

fun TextView.setFormattedDate(date: Date) {
    text = SimpleDateFormat("dd-mm-yyyy", Locale.US).format(date)
}

fun List<ArticlePreview>.getArticleById(articleId: Int): ArticlePreview? = firstOrNull { article -> article.id == articleId }