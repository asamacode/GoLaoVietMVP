package com.asama.luong.golaovietmvp

import android.app.Activity
import android.app.Application
import com.asama.luong.golaovietmvp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import javax.inject.Inject

class MvpApp : Application(), HasActivityInjector {

    @Inject
    lateinit internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        //init Realm Db
        Realm.init(this)

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

}