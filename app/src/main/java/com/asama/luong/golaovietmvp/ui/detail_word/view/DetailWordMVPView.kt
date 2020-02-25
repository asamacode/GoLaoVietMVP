package com.asama.luong.golaovietmvp.ui.detail_word.view

import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.view.MVPView

interface DetailWordMVPView: MVPView {

    fun setWordData(wordFull: WordFull)

    fun setMeanData(mean: Mean)
}