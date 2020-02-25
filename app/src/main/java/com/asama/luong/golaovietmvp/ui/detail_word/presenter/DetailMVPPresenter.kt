package com.asama.luong.golaovietmvp.ui.detail_word.presenter

import android.content.Intent
import com.asama.luong.golaovietmvp.ui.base.presenter.MVPPresenter
import com.asama.luong.golaovietmvp.ui.detail_word.interactor.DetailMVPInteractor
import com.asama.luong.golaovietmvp.ui.detail_word.view.DetailWordMVPView

interface DetailMVPPresenter<V: DetailWordMVPView, I: DetailMVPInteractor>: MVPPresenter<V, I> {

    fun getWordFullData(intent: Intent)
}