package club.appster.minecraft.data

import android.content.Context
import club.appster.minecraft.model.MinecraftCard
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ModsJson(private var context: Context) {

    fun getMinecraftCardList(): MutableList<MinecraftCard>? {

        val rawData = getJsonFileAsString()
        val gson = Gson()
        val listMinecraftCardType = object : TypeToken<List<MinecraftCard>>() {}.type

        return gson.fromJson(rawData, listMinecraftCardType)
    }

    private fun getJsonFileAsString(): String? {
        try {
            return context.assets.open(FILE_MODS_JSON).bufferedReader().use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    companion object {
        const val FILE_MODS_JSON = "mods.json"
    }



}