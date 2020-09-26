package club.appster.minecraft.ui.mods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import club.appster.minecraft.R
import club.appster.minecraft.data.ModsJson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_mods.*

@AndroidEntryPoint
class ModsFragment : Fragment(R.layout.fragment_mods) {
    private val viewModel: ModsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleAdapter()
    }

    private fun handleAdapter() {
        val context = requireActivity().applicationContext
        val minecraftCardList = ModsJson(context).getMinecraftCardList()
        mods_recycler_view.adapter = ModsAdapter(minecraftCardList!!, context)
        mods_recycler_view.layoutManager = LinearLayoutManager(context)
        mods_recycler_view.setHasFixedSize(true)
    }
}