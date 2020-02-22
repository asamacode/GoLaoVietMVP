package com.asama.luong.golaovietmvp.ui.base.presenter

import com.asama.luong.golaovietmvp.ui.base.interactor.MVPInteractor
import com.asama.luong.golaovietmvp.ui.base.view.MVPView
import com.asama.luong.golaovietmvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(
    protected var interactor: I?,
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable
): MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

    override fun getView(): V? = view
}