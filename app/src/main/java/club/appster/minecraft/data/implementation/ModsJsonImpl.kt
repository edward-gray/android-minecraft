package club.appster.minecraft.data.implementation

import android.content.Context
import club.appster.minecraft.data.abstraction.ModsJson
import club.appster.minecraft.model.MinecraftCard
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ModsJsonImpl(private var context: Context): ModsJson {

    override fun getMinecraftCardList(): List<MinecraftCard>? {

        val rawData = getJsonFileAsString()
        val listMinecraftCardType = object : TypeToken<List<MinecraftCard>>() {}.type

        val gson = Gson()
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