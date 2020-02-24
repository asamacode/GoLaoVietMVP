package com.asama.luong.golaovietmvp.ui.main.interactor

import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface MainMVPInteractor: MVPInteractor {

    fun getRandomWord(): Observable<WordFull>
}