package tapp.bottomnav.demo.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

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