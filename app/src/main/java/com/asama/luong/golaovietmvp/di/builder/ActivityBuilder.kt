package com.asama.luong.golaovietmvp.di.builder

import com.asama.luong.golaovietmvp.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity
}