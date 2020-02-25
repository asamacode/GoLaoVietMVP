package com.asama.luong.golaovietmvp.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asama.luong.golaovietmvp.util.CommonUtil
import dagger.android.AndroidInjection

abstract class BaseActivity: MVPView, AppCompatActivity(), BaseFragment.Callback {

    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
    }

    override fun showProgress() {
        hideProgress()

        mProgressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun hideProgress() {
        mProgressDialog?.let {
            if (it.isShowing)
                it.cancel()
        }
    }

    override fun showDialogLoad() {
        hideDialogLoad()

        mProgressDialog = CommonUtil.showInitDataDialog(this)
    }

    override fun hideDialogLoad() {
        mProgressDialog?.let {
            if (it.isShowing)
                it.cancel()
        }
    }

    private fun performDI() {
        return AndroidInjection.inject(this)
    }
}