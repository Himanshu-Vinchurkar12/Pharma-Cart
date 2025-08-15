package com.example.medicalstoreapp.di

import android.content.Context
import com.example.medicalstoreapp.api.Api_Builder
import com.example.medicalstoreapp.prefData.MyPreference
import com.example.medicalstoreapp.repo.Repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {



    @Provides
    @Singleton
    fun provideApi() : Api_Builder {
       return Api_Builder
    }

    @Provides
    @Singleton
    fun provideRepo(apiService: Api_Builder
    ) : Repo {
        return Repo(apiService)
    }

    @Provides
    @Singleton
    fun providePrefs(@ApplicationContext context : Context) : MyPreference{
        return MyPreference(context)
    }

}