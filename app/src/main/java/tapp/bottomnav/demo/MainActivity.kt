package tapp.bottomnav.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import tapp.bottomnav.demo.databinding.ActivityMainBinding
import tapp.bottomnav.demo.util.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val navController: NavController by lazy { initNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupBottomNavigation()
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()

    private fun setupBottomNavigation() {
        binding.mainBottomNavigation.setupWithNavController(navController)
    }

    private fun initNavController(): NavController =
        (supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment).navController.apply {
            addOnDestinationChangedListener { _, destination, _ ->
                binding.mainBottomNavigation.isVisible = destination.id in BOTTOM_NAVIGATION_FRAGMENTS
            }
        }

    companion object {
        private val BOTTOM_NAVIGATION_FRAGMENTS = listOf(R.id.homeFragment, R.id.profileFragment, R.id.newsFragment)
    }
}