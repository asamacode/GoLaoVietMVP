package com.asama.luong.golaovietmvp.ui.search_word.view

import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.ui.base.view.MVPView

interface SearchWordMVPView: MVPView {

    fun setWordSearchData(listWord: List<WordFull>)

    fun showLoadingSearch()

    fun hideLoadingSearch()
}