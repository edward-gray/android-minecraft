package club.appster.minecraft.ui.mods

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import club.appster.minecraft.R
import kotlinx.android.synthetic.main.fragment_mods.*

class ModsFragment : Fragment(R.layout.fragment_mods) {
    private val viewModel: ModsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, {
            mods_text.text = it
        })
    }
}