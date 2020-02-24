package com.asama.luong.golaovietmvp.ui.splash.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.asama.luong.golaovietmvp.R
import com.asama.luong.golaovietmvp.ui.base.view.BaseActivity
import com.asama.luong.golaovietmvp.ui.main.view.MainActivity
import com.asama.luong.golaovietmvp.ui.splash.interactor.SplashMVPInteractor
import com.asama.luong.golaovietmvp.ui.splash.presenter.SplashPresenter
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashMVPView {

    @Inject
    internal lateinit var mPresenter : SplashPresenter<SplashMVPView, SplashMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mPresenter.onAttach(this)
        
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun handleError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
    }
}
