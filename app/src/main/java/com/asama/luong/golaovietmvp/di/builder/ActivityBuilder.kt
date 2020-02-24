package com.asama.luong.golaovietmvp.di.builder

import com.asama.luong.golaovietmvp.ui.main.MainActivityModule
import com.asama.luong.golaovietmvp.ui.main.view.MainActivity
import com.asama.luong.golaovietmvp.ui.splash.SplashActivityModule
import com.asama.luong.golaovietmvp.ui.splash.view.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

}