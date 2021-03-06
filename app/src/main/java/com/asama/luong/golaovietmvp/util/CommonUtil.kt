package com.asama.luong.golaovietmvp.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import com.asama.luong.golaovietmvp.R

object CommonUtil {

    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)

        progressDialog.let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.dialog_progress)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }

    fun showInitDataDialog(context: Context): ProgressDialog {
        val progressDialog = ProgressDialog(context)

        progressDialog.let {
            it.isIndeterminate = true
            it.setMessage(context.getString(R.string.load_data_first_time))
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            it.show()

            return it
        }
    }
}