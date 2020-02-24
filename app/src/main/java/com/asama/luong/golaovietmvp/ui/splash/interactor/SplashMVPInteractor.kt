package com.asama.luong.golaovietmvp.ui.splash.interactor

import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity
import com.asama.luong.golaovietmvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface SplashMVPInteractor: MVPInteractor {

    fun loadWordData(): Observable<Boolean>

    fun loadWordFull(): Observable<List<WordFullEntity>>

    fun loadMeanData()
}