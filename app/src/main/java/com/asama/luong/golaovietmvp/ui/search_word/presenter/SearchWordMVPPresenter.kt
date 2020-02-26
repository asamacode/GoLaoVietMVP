package com.asama.luong.golaovietmvp.ui.search_word.presenter

import com.asama.luong.golaovietmvp.ui.base.presenter.MVPPresenter
import com.asama.luong.golaovietmvp.ui.search_word.interactor.SearchWordMVPInteractor
import com.asama.luong.golaovietmvp.ui.search_word.view.SearchWordMVPView

interface SearchWordMVPPresenter<V: SearchWordMVPView, I: SearchWordMVPInteractor> : MVPPresenter<V, I> {

    fun searchWord(str: String)
}