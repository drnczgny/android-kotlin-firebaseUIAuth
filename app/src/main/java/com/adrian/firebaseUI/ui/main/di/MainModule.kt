package com.adrian.firebaseUI.ui.main.di

import com.adrian.firebaseUI.data.ApiService
import com.adrian.firebaseUI.ui.main.view.MainActivity
import com.adrian.firebaseUI.ui.main.model.MainModel
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
class MainModule {

    @Provides
    fun providesMainRouter(mainActivity: MainActivity) = mainActivity

    @Provides
    fun provideMainModel(apiService: ApiService) = MainModel(apiService)
}