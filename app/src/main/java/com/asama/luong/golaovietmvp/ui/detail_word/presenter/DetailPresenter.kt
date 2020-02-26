package com.asama.luong.golaovietmvp.ui.detail_word.presenter

import android.content.Intent
import com.asama.luong.golaovietmvp.ui.base.presenter.BasePresenter
import com.asama.luong.golaovietmvp.ui.detail_word.interactor.DetailMVPInteractor
import com.asama.luong.golaovietmvp.ui.detail_word.view.DetailWordMVPView
import com.asama.luong.golaovietmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailPresenter<V : DetailWordMVPView, I : DetailMVPInteractor> @Inject constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : DetailMVPPresenter<V, I>, BasePresenter<V, I>(
    interactor = interactor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = compositeDisposable
) {

    override fun onAttach(view: V?) {
        super.onAttach(view)
    }

    override fun getWordFullData(intent: Intent) {
        val word = interactor?.getWordData(intent)
        getView()?.setWordData(word!!)
    }

    override fun getMeanData(word: String) {

        interactor?.let {
            it.getMeanByWord(word)
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({
                    getView()?.setMeanData(it)
                }, {
                    getView()?.handleError(it)
                })
        }

    }
}