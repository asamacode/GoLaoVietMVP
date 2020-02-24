package com.asama.luong.golaovietmvp.ui.splash.presenter

import android.util.Log
import com.asama.luong.golaovietmvp.ui.base.presenter.BasePresenter
import com.asama.luong.golaovietmvp.ui.splash.interactor.SplashMVPInteractor
import com.asama.luong.golaovietmvp.ui.splash.view.SplashMVPView
import com.asama.luong.golaovietmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashPresenter<V : SplashMVPView, I : SplashMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor,
    schedulerProvider,
    compositeDisposable
), SplashMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)

        feedInDatabase()
    }

    private fun feedInDatabase() = interactor?.let {
        it.loadWordData()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe {
                if (it) {
                    getView()?.openMainActivity()
                    getListWord()
                } else Log.wtf("HICHIC", "loi")
            }
    }

    internal fun getListWord() = interactor?.let {
        it.loadWordFull()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe {
                Log.wtf("HICHIC", it.get(0).commonMean)
            }
    }
}