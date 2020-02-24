package com.asama.luong.golaovietmvp.ui.main.presenter

import com.asama.luong.golaovietmvp.ui.base.presenter.MVPPresenter
import com.asama.luong.golaovietmvp.ui.main.interactor.MainMVPInteractor
import com.asama.luong.golaovietmvp.ui.main.view.MainMVPView

interface MainMVPPresenter<V: MainMVPView, I: MainMVPInteractor>: MVPPresenter<V, I> {

    fun onDrawerTranslateClick(): Unit?

    fun onDrawerOptionAboutClick() : Unit?

    fun onDrawerOptionRateUsClick(): Unit?

    fun receiveRandomWordData()
}