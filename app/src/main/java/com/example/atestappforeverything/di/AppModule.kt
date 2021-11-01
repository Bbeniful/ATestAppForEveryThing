package com.example.atestappforeverything.di

import android.content.Context
import com.example.atestappforeverything.feature_data_store.data.preferences.MyDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): MyDataStore {
        return MyDataStore(context = context)
    }

}