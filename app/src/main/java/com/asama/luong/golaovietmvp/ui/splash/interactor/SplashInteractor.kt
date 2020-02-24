package com.asama.luong.golaovietmvp.ui.splash.interactor

import android.content.Context
import android.util.Log
import com.asama.luong.golaovietmvp.data.DataManager
import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity
import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.BaseInteractor
import com.asama.luong.golaovietmvp.util.AppConstants
import com.asama.luong.golaovietmvp.util.FileUtil
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import io.reactivex.Observable
import javax.inject.Inject

class SplashInteractor @Inject internal constructor(
    private val mContext: Context,
    private val dataManager: DataManager
) : SplashMVPInteractor, BaseInteractor(dataManager) {


    override fun loadWordData(): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()

        val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, WordFull::class.java)
        val wordList = gson.fromJson<List<WordFull>>(
            FileUtil.loadJSOnFromAsset(
                mContext,
                AppConstants.SEED_DB_WORDFULL
            ), type
        )

        Log.wtf("HICHIC",  "haha $wordList")
        loadMeanData()
        return dataManager.saveListWordFull(wordList)

    }

    override fun loadWordFull(): Observable<List<WordFullEntity>> {

        return dataManager.getlistWordFull()
    }

    override fun loadMeanData(){
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()

        val type = `$Gson$Types`.newParameterizedTypeWithOwner(null, List::class.java, Mean::class.java)
        val meanList = gson.fromJson<List<Mean>>(
            FileUtil.loadJSOnFromAsset(
                mContext,
                AppConstants.SEED_DB_MEAN
            ), type
        )

        Log.wtf("HICHIC",  "haha $meanList")
    }


}