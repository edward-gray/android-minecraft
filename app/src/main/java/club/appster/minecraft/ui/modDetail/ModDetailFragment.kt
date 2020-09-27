package club.appster.minecraft.ui.modDetail

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import club.appster.minecraft.R
import club.appster.minecraft.model.MinecraftCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_mod_detail.*
import java.util.*


@AndroidEntryPoint
class ModDetailFragment : Fragment(R.layout.fragment_mod_detail) {

    private lateinit var minecraftCard: MinecraftCard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        minecraftCard = arguments?.getParcelable("minecraftCard")?: throw Exception("There is no card in mod detail")
        handleUI()
        handleDownload()
//        Toast.makeText(requireActivity().applicationContext, minecraftCard.toString(), Toast.LENGTH_LONG).show()
    }

    private fun handleUI() {
        val context = requireActivity().applicationContext
        val deviceLang = Locale.getDefault().language

        // setting imageView
        val imageResource: Int =
            context.resources.getIdentifier(
                "drawable/${minecraftCard.image}",
                null,
                context.packageName
            )
        val iconResId: Int = context.resources.getIdentifier(
            minecraftCard.image,
            "drawable",
            context.packageName
        )
        modDetail_image_cover.setImageResource(iconResId)

        // handling content language
        if (deviceLang == "ru") {
            modDetail_text_title.text = minecraftCard.titleRu
            modDetail_text_summary.text = minecraftCard.descRu
        } else {
            modDetail_text_title.text = minecraftCard.titleEn
            modDetail_text_summary.text = minecraftCard.descEn
        }
    }

    private fun handleDownload() {
        modDetail_button_download.setOnClickListener {
            val file = requireActivity().applicationContext.assets.open(minecraftCard.file).use { it.readBytes() }
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "*/*"
                putExtra(Intent.EXTRA_STREAM, file)
            }
            requireActivity().startActivity(intent)
        }
    }
}