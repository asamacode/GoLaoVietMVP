package com.asama.luong.golaovietmvp.data

import com.asama.luong.golaovietmvp.data.db.DbHelper
import com.asama.luong.golaovietmvp.data.db.entity.ExampleEntity
import com.asama.luong.golaovietmvp.data.model.Mean
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

    override fun saveMeanList(meanList: List<Mean>): Observable<Boolean> {
        return dbHelper.saveMeanList(meanList)
    }

    override fun getRandomWordFull(): Observable<WordFull> {
        return dbHelper.getRandomWordFull()
    }

    override fun getMeanWordByWordId(word: String): Observable<List<ExampleEntity>> {
        return dbHelper.getMeanWordByWordId(word)
    }

    override fun searchWord(key: String): Observable<List<WordFull>> {
        return dbHelper.searchWord(key)
    }

    override fun isLoadedData(): Boolean = prefHelper.isLoadedData()

    override fun setDataLoaded(boolean: Boolean) = prefHelper.setDataLoaded(boolean)
}