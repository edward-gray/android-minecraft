package club.appster.minecraft.di

import android.content.Context
import androidx.room.Room
import club.appster.minecraft.data.abstraction.MinecraftDaoService
import club.appster.minecraft.data.abstraction.ModsJson
import club.appster.minecraft.data.database.MinecraftDao
import club.appster.minecraft.data.database.MinecraftDatabase
import club.appster.minecraft.data.implementation.MinecraftDaoServiceImpl
import club.appster.minecraft.data.implementation.ModsJsonImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideModsJson(@ApplicationContext context: Context): ModsJson {
        return ModsJsonImpl(context)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) : MinecraftDatabase {
        return Room
            .databaseBuilder(app, MinecraftDatabase::class.java , MinecraftDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMinecraftDao(database : MinecraftDatabase) : MinecraftDao {
        return database.minecraftDao()
    }

    @Singleton
    @Provides
    fun provideMinecraftDaoService(minecraftDao: MinecraftDao) : MinecraftDaoService {
        return MinecraftDaoServiceImpl(minecraftDao)
    }

}