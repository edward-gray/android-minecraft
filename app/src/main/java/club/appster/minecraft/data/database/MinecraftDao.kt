package club.appster.minecraft.data.database

import androidx.room.*
import club.appster.minecraft.data.entity.MinecraftCardEntity

@Dao
interface MinecraftDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(minecraftCardEntity: MinecraftCardEntity): Long

    @Query("SELECT * FROM minecraft")
    suspend fun findAll(): List<MinecraftCardEntity>

    @Delete
    suspend fun delete(minecraftCardEntity: MinecraftCardEntity)

}