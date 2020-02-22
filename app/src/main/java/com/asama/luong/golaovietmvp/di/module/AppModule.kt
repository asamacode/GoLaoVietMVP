package com.asama.luong.golaovietmvp.di.module

import android.app.Application
import android.content.Context
import com.asama.luong.golaovietmvp.di.DatabaseInfo
import com.asama.luong.golaovietmvp.di.PrefInfo
import com.asama.luong.golaovietmvp.util.AppConstants
import dagger.Module
import dagger.Provides
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
}