package club.appster.minecraft.ui.mods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import club.appster.minecraft.R
import kotlinx.android.synthetic.main.minecraft_card_item.view.*

class ModsAdapter: RecyclerView.Adapter<ModsAdapter.ModsViewHolder>() {

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
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}