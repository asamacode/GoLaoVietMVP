package com.asama.luong.golaovietmvp.util.custom

import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher

class DelayTextWatcher(val ms: Long = 500, val textChanged: (String) -> Unit) : TextWatcher {

    private var timer: CountDownTimer? = null
    override fun afterTextChanged(p0: Editable) {
        timer?.cancel()
        timer = object : CountDownTimer(ms, ms) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                textChanged(p0.toString())
            }
        }.start()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    fun dispose() {
        timer?.cancel()
    }
}