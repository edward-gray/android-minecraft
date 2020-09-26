package club.appster.minecraft.ui.splash

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import club.appster.minecraft.R
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.blurry.Blurry
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_splash.*

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var navController : NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        makeImageBlur()
        hideBottomNavigation()
        start()
    }

    private fun start() {
        Handler().postDelayed({
            // navigate and show tabBar
            navController.navigate(R.id.action_splashFragment_to_modsFragment)
            requireActivity().bottom_navigation.visibility = View.VISIBLE
            requireActivity().activity_view_shadow.visibility = View.VISIBLE
        }, 2000)
    }

    private fun makeImageBlur() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.loading_bg)
        Blurry.with(context).from(bitmap).into(splash_image_bg)
    }

    private fun hideBottomNavigation() {
        requireActivity().bottom_navigation.visibility = View.GONE
        requireActivity().activity_view_shadow.visibility = View.GONE
    }
}