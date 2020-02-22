package com.asama.luong.golaovietmvp.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.asama.luong.golaovietmvp.R
import com.asama.luong.golaovietmvp.ui.base.view.BaseActivity
import com.asama.luong.golaovietmvp.ui.main.interactor.MainMVPInteractor
import com.asama.luong.golaovietmvp.ui.main.presenter.MainMVPPresenter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView, HasSupportFragmentInjector {

    @Inject
    internal lateinit var mPresenter : MainMVPPresenter<MainMVPView, MainMVPInteractor>

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    override fun openTranslateFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openAboutFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openRateUsFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun lockDrawer(): Unit? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unlockDrawer(): Unit? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}
