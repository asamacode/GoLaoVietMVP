package com.asama.luong.golaovietmvp.ui.main.presenter

import com.asama.luong.golaovietmvp.ui.base.presenter.BasePresenter
import com.asama.luong.golaovietmvp.ui.main.interactor.MainMVPInteractor
import com.asama.luong.golaovietmvp.ui.main.view.MainMVPView
import com.asama.luong.golaovietmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor
    (
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) :
    BasePresenter<V, I>(
        interactor = interactor,
        schedulerProvider = schedulerProvider,
        compositeDisposable = disposable
    ), MainMVPPresenter<V, I> {

    override fun onDrawerTranslateClick(): Unit? = getView()?.openTranslateFragment()

    override fun onDrawerOptionAboutClick(): Unit? = getView()?.openAboutFragment()

    override fun onDrawerOptionRateUsClick(): Unit? = getView()?.openRateUsFragment()

    override fun receiveRandomWordData() {

        getView()?.showProgress()

        interactor?.let {
            it.getRandomWord()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({
                    getView()?.setRandomWordUI(it)
                    getView()?.hideProgress()
                }, {
                    getView()?.hideProgress()
                    getView()?.handleError(it)
                })
        }
    }
}