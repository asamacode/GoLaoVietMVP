package com.asama.luong.golaovietmvp.ui.base.view

interface MVPView {

    fun showProgress()

    fun hideProgress()

    fun handleError(throwable: Throwable)
}