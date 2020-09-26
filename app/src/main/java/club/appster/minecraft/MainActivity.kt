package club.appster.minecraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.itemIconTintList = null

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_container) as NavHostFragment? ?: return
        navController = host.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_mods, R.id.navigation_favorites, R.id.navigation_guide
            )
        )
        bottom_navigation.setupWithNavController(navController)
    }

}