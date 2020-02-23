package com.asama.luong.golaovietmvp.di.builder

import com.asama.luong.golaovietmvp.ui.main.MainActivityModule
import com.asama.luong.golaovietmvp.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

}