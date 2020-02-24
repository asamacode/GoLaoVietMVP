package com.asama.luong.golaovietmvp.data.db

import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity
import com.asama.luong.golaovietmvp.data.model.WordFull
import io.reactivex.Observable

interface DbHelper {

    fun saveListWordFull(listWord: List<WordFull>) : Observable<Boolean>

    fun getlistWordFull(): Observable<List<WordFullEntity>>

}