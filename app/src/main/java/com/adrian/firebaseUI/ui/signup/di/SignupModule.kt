package com.adrian.firebaseUI.ui.signup.di

import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.firebaseUI.ui.signup.model.SignupModel
import dagger.Module
import dagger.Provides

/**
 * Created by cadri on 2017. 11. 25..
 */

@Module
class SignupModule {

    @Provides
    @ActivityScope
    fun provideSignupModel() = SignupModel()

}