package com.asama.luong.golaovietmvp.ui.base.interactor

import com.asama.luong.golaovietmvp.data.DataManager

open class BaseInteractor() : MVPInteractor {

    protected lateinit var mDataManager: DataManager

    constructor(dataManager: DataManager) : this() {
        this.mDataManager = dataManager
    }
}