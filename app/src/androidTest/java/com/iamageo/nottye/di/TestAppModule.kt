package com.iamageo.nottye.di

import android.app.Application
import androidx.room.Room
import com.iamageo.data.datasource.NottyeDatabase
import com.iamageo.data.repository.NottyeRepositoryImpl
import com.iamageo.domain.repository.NottyeRepository
import com.iamageo.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNottyeDatabase(app: Application): NottyeDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NottyeDatabase::class.java,
        ).build()
    }

    @Provides
    @Singleton
    fun provideNottyeRepository(db: NottyeDatabase): NottyeRepository {
        return NottyeRepositoryImpl(db.nottyeDao)
    }

    @Provides
    @Singleton
    fun provideNottyeUseCases(repository: NottyeRepository): NottyeUseCases {
        return NottyeUseCases(
            getNottyes = GetNottyes(repository),
            deleteNottye = DeleteNottye(repository),
            addNottye = AddNottye(repository),
            getNottye = GetNottye(repository)
        )
    }

}