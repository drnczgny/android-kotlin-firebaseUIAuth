package com.adrian.firebaseUI.di

import android.content.Context
import com.adrian.firebaseUI.MyApplication
import com.adrian.firebaseUI.data.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideApplication(myApplication: MyApplication) = myApplication

    @Singleton
    @Provides
    @Named("applicationContext")
    fun provideContext(myApplication: MyApplication): Context = myApplication.applicationContext

    @Singleton
    @Provides
    fun provideApiService() = ApiService()

}