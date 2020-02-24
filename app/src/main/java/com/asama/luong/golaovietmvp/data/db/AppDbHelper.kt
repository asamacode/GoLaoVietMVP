package com.asama.luong.golaovietmvp.data.db

import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.util.extension.toEntity
import io.reactivex.Observable
import javax.inject.Inject

class AppDbHelper @Inject constructor(
    private val mAppDatabase: AppDatabase
) : DbHelper {

    override fun saveListWordFull(listWord: List<WordFull>): Observable<Boolean> {
        return Observable.fromCallable{
            val wordList = ArrayList<WordFullEntity>()
            for (word in listWord) {
                wordList.add(word.toEntity())
            }
            mAppDatabase.wordFullDao().insertAllWord(wordList)
            return@fromCallable true
        }
    }

    override fun getlistWordFull(): Observable<List<WordFullEntity>> {
        return Observable.fromCallable{
            return@fromCallable mAppDatabase.wordFullDao().loadAllWord()
        }
    }
}