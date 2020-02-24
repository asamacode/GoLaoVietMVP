package com.asama.luong.golaovietmvp.ui.splash.presenter

import com.asama.luong.golaovietmvp.ui.base.presenter.MVPPresenter
import com.asama.luong.golaovietmvp.ui.splash.interactor.SplashMVPInteractor
import com.asama.luong.golaovietmvp.ui.splash.view.SplashMVPView

interface SplashMVPPresenter<V: SplashMVPView, I: SplashMVPInteractor>: MVPPresenter<V, I> {
}