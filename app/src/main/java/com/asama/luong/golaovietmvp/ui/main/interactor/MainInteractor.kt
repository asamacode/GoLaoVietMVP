package com.asama.luong.golaovietmvp.ui.main.interactor

import com.asama.luong.golaovietmvp.data.DataManager
import com.asama.luong.golaovietmvp.data.db.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject


class MainInteractor @Inject constructor(
    private val dataManager: DataManager
) : BaseInteractor(dataManager) ,MainMVPInteractor {

    override fun getRandomWord(): WordFull {
        return WordFull()
    }
}