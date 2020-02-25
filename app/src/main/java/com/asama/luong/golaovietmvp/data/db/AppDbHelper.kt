package com.asama.luong.golaovietmvp.data.db

import com.asama.luong.golaovietmvp.data.db.entity.ExampleEntity
import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity
import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.WordFull
import com.asama.luong.golaovietmvp.util.extension.toEntity
import com.asama.luong.golaovietmvp.util.extension.toWordFull
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

    override fun saveMeanList(meanList: List<Mean>): Observable<Boolean> {
        return Observable.fromCallable{

            val listExam = meanList.toEntity()
            mAppDatabase.exampleDao().insertAllExample(listExam)
            return@fromCallable true
        }
    }

    override fun getRandomWordFull(): Observable<WordFull> {
        return Observable.fromCallable {
            return@fromCallable mAppDatabase.wordFullDao().loadRandomWord().toWordFull()
        }
    }

    override fun getMeanWordByWordId(word: String): Observable<List<ExampleEntity>> {
        return Observable.fromCallable {
            return@fromCallable mAppDatabase.exampleDao().loadExampleByWord(word)
        }
    }

    override fun searchWord(key: String): Observable<List<WordFull>> {
        return Observable.fromCallable {
            val listWord = ArrayList<WordFull>()
            val listWordEntity  = mAppDatabase.wordFullDao().searchWord(key)
            for (entity in listWordEntity) {
                listWord.add(entity.toWordFull())
            }
            return@fromCallable  listWord
        }
    }
}