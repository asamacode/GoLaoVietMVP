package com.asama.luong.golaovietmvp.di.builder

import com.asama.luong.golaovietmvp.ui.detail_word.DetailWordActivityModule
import com.asama.luong.golaovietmvp.ui.detail_word.view.DetailWordActivity
import com.asama.luong.golaovietmvp.ui.main.MainActivityModule
import com.asama.luong.golaovietmvp.ui.main.view.MainActivity
import com.asama.luong.golaovietmvp.ui.search_word.SearchWordActivityModule
import com.asama.luong.golaovietmvp.ui.search_word.view.SearchWordActivity
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

    @ContributesAndroidInjector(modules = [(DetailWordActivityModule::class)])
    abstract fun bindDetailWord(): DetailWordActivity

    @ContributesAndroidInjector(modules = [(SearchWordActivityModule::class)])
    abstract fun bindSearchWordActivity(): SearchWordActivity

}