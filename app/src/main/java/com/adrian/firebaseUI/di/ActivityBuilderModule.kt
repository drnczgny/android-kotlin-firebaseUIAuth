package com.adrian.firebaseUI.di

import com.adrian.firebaseUI.ui.jsonplaceholder.di.JsonPlaceholderFragmentBuilderModule
import com.adrian.firebaseUI.ui.jsonplaceholder.di.JsonPlaceholderModule
import com.adrian.firebaseUI.ui.jsonplaceholder.submodules.postspage.di.PostsPageModule
import com.adrian.firebaseUI.ui.login.di.LoginModule
import com.adrian.firebaseUI.ui.login.view.LoginActivity
import com.adrian.firebaseUI.ui.main.JsonPlaceholderActivity
import com.adrian.firebaseUI.ui.main.di.MainModule
import com.adrian.firebaseUI.ui.main.view.MainActivity
import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 03..
 */

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(JsonPlaceholderModule::class, PostsPageModule::class, JsonPlaceholderFragmentBuilderModule::class))
    abstract fun bindJsonPlaceholderActivity(): JsonPlaceholderActivity

}