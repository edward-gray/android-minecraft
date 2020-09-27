package club.appster.minecraft.di

import android.content.Context
import club.appster.minecraft.data.abstraction.ModsJson
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


}