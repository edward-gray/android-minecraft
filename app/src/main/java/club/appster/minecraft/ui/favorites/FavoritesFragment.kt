package club.appster.minecraft.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import club.appster.minecraft.R
import club.appster.minecraft.model.MinecraftCard
import club.appster.minecraft.ui.mods.ModsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorites.*

@AndroidEntryPoint
class FavoritesFragment : Fragment(R.layout.fragment_favorites), ModsAdapter.OnItemClickListener {

    private val viewModel: FavoritesViewModel by viewModels()
    private lateinit var navController: NavController
    private lateinit var minecraftCardList: List<MinecraftCard>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        subscribers()
    }

    private fun subscribers() {
        viewModel.getMinecraftList()
        viewModel.minecraftCardList.observe(viewLifecycleOwner, {
            minecraftCardList = it
            handleAdapter()
        })
    }

    private fun handleAdapter() {
        val context = requireActivity().applicationContext
        favorite_recycler_view.adapter = ModsAdapter(minecraftCardList, context, this)
        favorite_recycler_view.layoutManager = LinearLayoutManager(context)
        favorite_recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val bundle = bundleOf("minecraftCard" to minecraftCardList[position])
        navController.navigate(R.id.action_navigation_favorites_to_navigation_modDetail, bundle)
    }

    override fun toggleButtonWasClicked(position: Int, isChecked: Boolean) {
        viewModel.handleFavorite(position, isChecked)
    }

}