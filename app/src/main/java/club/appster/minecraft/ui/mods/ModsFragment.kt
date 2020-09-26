package club.appster.minecraft.ui.mods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import club.appster.minecraft.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ModsFragment : Fragment(R.layout.fragment_mods) {
    private val viewModel: ModsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}