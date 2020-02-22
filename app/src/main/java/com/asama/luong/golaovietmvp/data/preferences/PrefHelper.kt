package com.asama.luong.golaovietmvp.data.preferences

interface PrefHelper {

    fun isLoadedData() : Boolean

    fun setDataLoaded(boolean: Boolean)
}