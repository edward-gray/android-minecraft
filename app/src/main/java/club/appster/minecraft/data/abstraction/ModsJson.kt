package club.appster.minecraft.data.abstraction

import club.appster.minecraft.model.MinecraftCard

interface ModsJson {

    fun getMinecraftCardList(): List<MinecraftCard>?

}