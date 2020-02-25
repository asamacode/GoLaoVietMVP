package com.asama.luong.golaovietmvp.ui.detail_word

import com.asama.luong.golaovietmvp.ui.detail_word.interactor.DetailMVPInteractor
import com.asama.luong.golaovietmvp.ui.detail_word.interactor.DetailWordInteractor
import com.asama.luong.golaovietmvp.ui.detail_word.presenter.DetailMVPPresenter
import com.asama.luong.golaovietmvp.ui.detail_word.presenter.DetailPresenter
import com.asama.luong.golaovietmvp.ui.detail_word.view.DetailWordMVPView
import dagger.Module
import dagger.Provides

@Module
class DetailWordActivityModule {

    @Provides
    internal fun provideDetailInteractor(detailWordInteractor: DetailWordInteractor): DetailMVPInteractor =
        detailWordInteractor

    @Provides
    internal fun provideDetailPresenter(detailPresenter: DetailPresenter<DetailWordMVPView, DetailMVPInteractor>):
            DetailMVPPresenter<DetailWordMVPView, DetailMVPInteractor> = detailPresenter
}