package com.plantix.names.di

import android.content.Context
import com.plantix.names.data.localdatasource.AppDatabase
import com.plantix.names.data.names.NamesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppDatabaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideNamesDao(appDatabase: AppDatabase): NamesDao {
        return appDatabase.namesDao()
    }
}