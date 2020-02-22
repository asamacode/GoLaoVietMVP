package com.asama.luong.golaovietmvp.ui.main.interactor

import com.asama.luong.golaovietmvp.data.db.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.MVPInteractor

interface MainMVPInteractor: MVPInteractor {

    fun getRandomWord(): WordFull
}