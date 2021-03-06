package com.adrian.firebaseUI.ui.jsonplaceholder.di

import com.adrian.firebaseUI.scope.FragmentScope
import com.adrian.firebaseUI.ui.jsonplaceholder.submodules.postspage.PostsPageFragment
import com.adrian.firebaseUI.ui.jsonplaceholder.submodules.postspage.di.PostsPageModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cadri on 2017. 08. 05..
 */

@Module
abstract class JsonPlaceholderFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = arrayOf(PostsPageModule::class))
    abstract fun bindPostsPageFragment(): PostsPageFragment

}
