package com.adrian.firebaseUI.ui.login.di

import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.firebaseUI.ui.login.model.LoginModel
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 11. 25..
 */

@Module
class LoginModule {

    @Provides
    @ActivityScope
    fun provideLoginModel() = LoginModel()

}