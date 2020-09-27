package club.appster.minecraft.data.abstraction

import club.appster.minecraft.data.entity.MinecraftCardEntity

interface MinecraftDaoService {

    suspend fun save(minecraftCardEntity: MinecraftCardEntity): Long

    suspend fun findAll(): List<MinecraftCardEntity>

    suspend fun delete(minecraftCardEntity: MinecraftCardEntity)

}