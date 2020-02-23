package com.asama.luong.golaovietmvp.di.module

import android.app.Application
import android.content.Context
import com.asama.luong.golaovietmvp.data.AppDataManager
import com.asama.luong.golaovietmvp.data.DataManager
import com.asama.luong.golaovietmvp.data.db.DbHelper
import com.asama.luong.golaovietmvp.data.db.RealmDbHelper
import com.asama.luong.golaovietmvp.data.preferences.AppPrefHelper
import com.asama.luong.golaovietmvp.data.preferences.PrefHelper
import com.asama.luong.golaovietmvp.di.DatabaseInfo
import com.asama.luong.golaovietmvp.di.PrefInfo
import com.asama.luong.golaovietmvp.util.AppConstants
import com.asama.luong.golaovietmvp.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @DatabaseInfo
    internal fun provideRealmDbName(): String = AppConstants.APP_DB_NAME

    @Provides
    @Singleton
    internal fun provideDbConfiguration(@DatabaseInfo dbName: String) : RealmConfiguration =
        RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .name(dbName)
            .build()

    @Provides
    @PrefInfo
    internal fun providePrefName(): String = AppConstants.APP_PREF_NAME

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: RealmDbHelper): DbHelper = appDbHelper

    @Provides
    @Singleton
    internal fun providePrefHelper(appPrefHelper: AppPrefHelper): PrefHelper = appPrefHelper

    @Provides
    @Singleton
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    @Singleton
    internal fun provideDisposable(): CompositeDisposable = CompositeDisposable()
}