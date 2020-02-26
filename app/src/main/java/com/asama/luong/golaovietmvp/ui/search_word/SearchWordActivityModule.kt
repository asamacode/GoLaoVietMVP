package com.asama.luong.golaovietmvp.ui.search_word

import androidx.recyclerview.widget.LinearLayoutManager
import com.asama.luong.golaovietmvp.ui.search_word.interactor.SearchWordInteractor
import com.asama.luong.golaovietmvp.ui.search_word.interactor.SearchWordMVPInteractor
import com.asama.luong.golaovietmvp.ui.search_word.presenter.SearchWordPresenter
import com.asama.luong.golaovietmvp.ui.search_word.view.SearchWordActivity
import com.asama.luong.golaovietmvp.ui.search_word.view.SearchWordAdapter
import com.asama.luong.golaovietmvp.ui.search_word.view.SearchWordMVPView
import dagger.Module
import dagger.Provides

@Module
class SearchWordActivityModule {

    @Provides
    internal fun provideSearchInteractor(searchWordInteractor: SearchWordInteractor): SearchWordMVPInteractor =
        searchWordInteractor

    @Provides
    internal fun provideSearchPresenter(
        searchWordPresenter: SearchWordPresenter<SearchWordMVPView,
                SearchWordMVPInteractor>
    ): SearchWordPresenter<SearchWordMVPView, SearchWordMVPInteractor> = searchWordPresenter

    @Provides
    internal fun provideSearchAdapter() : SearchWordAdapter = SearchWordAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(activity: SearchWordActivity) : LinearLayoutManager =
        LinearLayoutManager(activity)
}