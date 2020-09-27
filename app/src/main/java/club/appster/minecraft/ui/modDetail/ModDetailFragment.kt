package club.appster.minecraft.ui.modDetail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import club.appster.minecraft.R
import club.appster.minecraft.model.MinecraftCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModDetailFragment : Fragment(R.layout.fragment_mod_detail) {

    private lateinit var minecraftCard: MinecraftCard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        minecraftCard = arguments?.getParcelable("minecraftCard")?: throw Exception("There is no card in mod detail")
        Toast.makeText(requireActivity().applicationContext, minecraftCard.toString(), Toast.LENGTH_LONG).show()
    }
}