package club.appster.minecraft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import club.appster.minecraft.data.implementation.ModsJsonImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


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

        AppBarConfiguration(
            setOf(
                R.id.navigation_mods, R.id.navigation_favorites, R.id.navigation_guide
            )
        )
        bottom_navigation.setupWithNavController(navController)

        test()

        println("lang: " + Locale.getDefault().language)

    }

    private fun test() {
        val minecraftCardList = ModsJsonImpl(applicationContext).getMinecraftCardList()
        minecraftCardList?.map {
            println("DEBUG: $it")
        }

    }

}