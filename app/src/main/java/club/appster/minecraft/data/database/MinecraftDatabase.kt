package club.appster.minecraft.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import club.appster.minecraft.data.entity.MinecraftCardEntity

@Database(entities = [MinecraftCardEntity::class], version = 1)
abstract class MinecraftDatabase: RoomDatabase() {

    abstract fun minecraftDao(): MinecraftDao

    companion object {
        const val DATABASE_NAME = "minecraft_db"
    }
}