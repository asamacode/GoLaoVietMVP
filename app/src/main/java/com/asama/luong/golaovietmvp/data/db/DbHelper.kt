package com.asama.luong.golaovietmvp.data.db

import com.asama.luong.golaovietmvp.data.model.Mean
import com.asama.luong.golaovietmvp.data.model.WordFull
import io.reactivex.Observable

interface DbHelper {

    fun saveListWordFull(listWord: List<WordFull>) : Observable<Boolean>

    fun saveMeanList(meanList: List<Mean>) : Observable<Boolean>

    fun getRandomWordFull() : Observable<WordFull>

    fun getMeanWordByWordId(word: String) : Observable<Mean>

    fun searchWord(key: String) : Observable<List<WordFull>>
}