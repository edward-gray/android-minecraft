package club.appster.minecraft.ui.mods

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import club.appster.minecraft.R
import club.appster.minecraft.model.MinecraftCard
import kotlinx.android.synthetic.main.minecraft_card_item.view.*
import java.util.*

class ModsAdapter(
    private val minecraftCardList: List<MinecraftCard>,
    private val context: Context
): RecyclerView.Adapter<ModsAdapter.ModsViewHolder>() {

    class ModsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.imageView
        val title: TextView = itemView.title
        val summary: TextView = itemView.summary
        val toggleButton: ToggleButton = itemView.toggleButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
            .inflate(R.layout.minecraft_card_item, parent, false)
        return ModsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ModsViewHolder, position: Int) {
        val currentItem = minecraftCardList[position]
        val deviceLang = Locale.getDefault().language

        // setting imageView
        val imageResource: Int =
            context.resources.getIdentifier(
                "drawable/${currentItem.image}",
                null,
                context.packageName
            )
        val iconResId: Int = context.resources.getIdentifier(currentItem.image, "drawable", context.packageName)
        holder.imageView.setImageResource(iconResId)

        // handling content language
        if (deviceLang == "ru") {
            holder.title.text = currentItem.titleRu
            holder.summary.text = currentItem.descRu
        } else {
            holder.title.text = currentItem.titleEn
            holder.summary.text = currentItem.descEn
        }
    }

    override fun getItemCount() = minecraftCardList.size

}