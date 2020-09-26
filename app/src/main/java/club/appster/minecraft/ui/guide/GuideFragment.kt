package club.appster.minecraft.ui.guide

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import club.appster.minecraft.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_guide.*

@AndroidEntryPoint
class GuideFragment : Fragment(R.layout.fragment_guide) {
    private val viewModel: GuideViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.text.observe(viewLifecycleOwner, {
            guide_text.text = it
        })
    }
}