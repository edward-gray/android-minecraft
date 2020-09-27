package club.appster.minecraft.data.implementation

import club.appster.minecraft.data.abstraction.MinecraftDaoService
import club.appster.minecraft.data.database.MinecraftDao
import club.appster.minecraft.data.entity.MinecraftCardEntity

class MinecraftDaoServiceImpl(
    private val minecraftDao: MinecraftDao
): MinecraftDaoService {

    override suspend fun save(minecraftCardEntity: MinecraftCardEntity): Long {
        return minecraftDao.save(minecraftCardEntity)
    }

    override suspend fun findAll(): List<MinecraftCardEntity> {
        return minecraftDao.findAll()
    }

    override suspend fun delete(minecraftCardEntity: MinecraftCardEntity) {
        return minecraftDao.delete(minecraftCardEntity)
    }

}