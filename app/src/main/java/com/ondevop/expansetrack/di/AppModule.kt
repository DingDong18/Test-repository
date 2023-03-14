package com.ondevop.expansetrack.di

import androidx.lifecycle.ViewModelProvider
import com.ondevop.expansetrack.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {
    @Provides
    fun provideMyRepository(): MainRepository {
        return MainRepository()
    }


}