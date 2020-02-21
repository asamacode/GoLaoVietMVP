package com.asama.luong.golaovietmvp.di.component

import android.app.Application
import com.asama.luong.golaovietmvp.MvpApp
import com.asama.luong.golaovietmvp.di.builder.ActivityBuilder
import com.asama.luong.golaovietmvp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MvpApp)
}