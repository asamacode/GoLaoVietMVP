package com.asama.luong.golaovietmvp.ui.splash.presenter

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

    override fun feedInDatabase() {

        if (!interactor?.getLoadedData()!!) {
            getView()?.showProgress()

            interactor?.let {
                it.loadWordData()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe(
                        {
                            if (it) {
//                                feedMeanData()
                                getView()?.openMainActivity()
                                interactor!!.setLoadedData()
                            }
                        }, {
                            getView()?.handleError(it)
                            getView()?.hideProgress()
                        }
                    )
            }
        } else getView()?.openMainActivity()
    }

    private fun feedMeanData() {
        interactor?.let {
            it.loadMeanData()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe(
                    {
                        if (it) {
                            getView()?.openMainActivity()
                            interactor!!.setLoadedData()
                            getView()?.hideProgress()
                        }
                    }, {
                        getView()?.handleError(it)
                        getView()?.hideProgress()
                    }
                )
        }
    }

}