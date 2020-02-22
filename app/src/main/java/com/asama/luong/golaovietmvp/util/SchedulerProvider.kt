package com.asama.luong.golaovietmvp.util

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider {

    private fun getIOThreadScheduler() = Schedulers.io()

    private fun getMainThreadScheduler() = AndroidSchedulers.mainThread()

}