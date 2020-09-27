package club.appster.minecraft.ui.mods

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import club.appster.minecraft.R
import club.appster.minecraft.model.MinecraftCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_mods.*

@AndroidEntryPoint
class ModsFragment : Fragment(R.layout.fragment_mods), ModsAdapter.OnItemClickListener {

    private val viewModel: ModsViewModel by viewModels()
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
        mods_recycler_view.adapter = ModsAdapter(minecraftCardList, context, this)
        mods_recycler_view.layoutManager = LinearLayoutManager(context)
        mods_recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val bundle = bundleOf("minecraftCard" to minecraftCardList[position])
        navController.navigate(R.id.action_navigation_mods_to_navigation_modDetail, bundle)
        Toast.makeText(requireActivity().applicationContext, "this is $position", Toast.LENGTH_LONG)
            .show()
    }

    override fun toggleButtonWasClicked(position: Int, isChecked: Boolean) {
        viewModel.saveFavorite(position, isChecked)

        Toast.makeText(
            requireActivity().applicationContext,
            "$position - $isChecked",
            Toast.LENGTH_SHORT
        ).show()
    }


}