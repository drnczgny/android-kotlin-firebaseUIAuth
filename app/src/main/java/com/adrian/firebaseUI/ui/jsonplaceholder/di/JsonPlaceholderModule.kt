package com.adrian.firebaseUI.ui.jsonplaceholder.di

import com.adrian.firebaseUI.data.ApiService
import com.adrian.firebaseUI.ui.main.JsonPlaceholderActivity
import com.adrian.firebaseUI.ui.jsonplaceholder.submodules.postspage.JsonPlaceholderModel
import com.adrian.firebaseUI.ui.jsonplaceholder.submodules.postspage.JsonPlaceholderRouter
import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
class JsonPlaceholderModule {

    @ActivityScope
    @Provides
    fun providesJsonPlaceholderRouter(jsonPlaceholderActivity: JsonPlaceholderActivity): JsonPlaceholderRouter = jsonPlaceholderActivity

    @ActivityScope
    @Provides
    fun providesJsonPlaceholderModel(apiService: ApiService) = JsonPlaceholderModel(apiService)

}