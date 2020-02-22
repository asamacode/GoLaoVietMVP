package com.asama.luong.golaovietmvp.ui.base.presenter

import com.asama.luong.golaovietmvp.ui.base.interactor.MVPInteractor
import com.asama.luong.golaovietmvp.ui.base.view.MVPView

interface MVPPresenter<V: MVPView, I: MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?
}