package com.asama.luong.golaovietmvp.data.preferences

import android.content.Context
import androidx.core.content.edit
import com.asama.luong.golaovietmvp.di.PrefInfo
import javax.inject.Inject

class AppPrefHelper @Inject constructor(
    context: Context,
    @PrefInfo private val prefName: String
) : PrefHelper {

    companion object {

        internal val KEY_LOAD_DATA = "LOAD_DATA"

    }

    private val mPrefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    override fun setDataLoaded(boolean: Boolean) {
        mPrefs.edit {
            putBoolean(KEY_LOAD_DATA, true)
        }
    }

    override fun isLoadedData(): Boolean =
        mPrefs.getBoolean(KEY_LOAD_DATA, false)
}