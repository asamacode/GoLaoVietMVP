package com.asama.luong.golaovietmvp.ui.main.view

import com.asama.luong.golaovietmvp.ui.base.view.MVPView

interface MainMVPView: MVPView {

    fun lockDrawer(): Unit?
    fun unlockDrawer(): Unit?

    fun openTranslateFragment()

    fun openAboutFragment()

    fun openRateUsFragment()
}