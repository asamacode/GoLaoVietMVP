package com.asama.luong.golaovietmvp.data

import com.asama.luong.golaovietmvp.data.db.DbHelper
import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.data.preferences.PrefHelper
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val dbHelper: DbHelper,
    private val prefHelper: PrefHelper
) : DataManager {
    override fun saveListWordFull(listWord: List<WordFull>): Observable<Boolean> {
        return dbHelper.saveListWordFull(listWord)
    }

    override fun getlistWordFull(): Observable<List<WordFullEntity>> {
        return dbHelper.getlistWordFull()
    }

    override fun isLoadedData(): Boolean = prefHelper.isLoadedData()

    override fun setDataLoaded(boolean: Boolean) = prefHelper.setDataLoaded(boolean)
}