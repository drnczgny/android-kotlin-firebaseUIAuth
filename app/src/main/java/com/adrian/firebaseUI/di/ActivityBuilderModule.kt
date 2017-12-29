package com.adrian.firebaseUI.di

import com.adrian.kotlinrecyclerviewdagger.main.di.ActivityScope
import com.adrian.firebaseUI.ui.jsonplaceholder.di.JsonPlaceholderFragmentBuilderModule
import com.adrian.firebaseUI.ui.jsonplaceholder.di.JsonPlaceholderModule
import com.adrian.firebaseUI.ui.jsonplaceholder.submodules.postspage.di.PostsPageModule
import com.adrian.firebaseUI.ui.login.di.LoginModule
import com.adrian.firebaseUI.ui.login.view.LoginActivity
import com.adrian.firebaseUI.ui.main.JsonPlaceholderActivity
import com.adrian.firebaseUI.ui.main.di.MainModule
import com.adrian.firebaseUI.ui.main.view.MainActivity
import com.adrian.firebaseUI.ui.resetpasswordactivity.di.ResetPasswordModule
import com.adrian.firebaseUI.ui.resetpasswordactivity.view.ResetPasswordActivity
import com.adrian.firebaseUI.ui.signup.di.SignupModule
import com.adrian.firebaseUI.ui.signup.view.SignupActivity
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
    @ContributesAndroidInjector(modules = arrayOf(SignupModule::class))
    abstract fun bindSignupActivity(): SignupActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(ResetPasswordModule::class))
    abstract fun bindResetPasswordActivity(): ResetPasswordActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(JsonPlaceholderModule::class, PostsPageModule::class, JsonPlaceholderFragmentBuilderModule::class))
    abstract fun bindJsonPlaceholderActivity(): JsonPlaceholderActivity

}