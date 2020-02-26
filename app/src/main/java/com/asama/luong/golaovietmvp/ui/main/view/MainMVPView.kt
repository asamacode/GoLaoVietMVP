package com.asama.luong.golaovietmvp.ui.main.view

import android.view.View
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.view.MVPView

interface MainMVPView: MVPView {

    fun lockDrawer(): Unit?
    fun unlockDrawer(): Unit?

    fun openTranslateFragment()

    fun openAboutFragment()

    fun openRateUsFragment()

    fun openSearchActivity(view: View)

    fun setRandomWordUI(wordFull: WordFull)
}