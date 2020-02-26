package com.asama.luong.golaovietmvp.ui.search_word.presenter

import com.asama.luong.golaovietmvp.ui.base.presenter.BasePresenter
import com.asama.luong.golaovietmvp.ui.search_word.interactor.SearchWordMVPInteractor
import com.asama.luong.golaovietmvp.ui.search_word.view.SearchWordMVPView
import com.asama.luong.golaovietmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SearchWordPresenter<V : SearchWordMVPView, I : SearchWordMVPInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), SearchWordMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
    }

    override fun searchWord(str: String) {

        getView()?.showLoadingSearch()

        interactor?.let {
            it.searchWordInDatabse(str)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({
                    getView()?.hideLoadingSearch()
                    getView()?.setWordSearchData(it)
                }, {
                    getView()?.hideLoadingSearch()
                    getView()?.handleError(it)
                })
        }
    }
}