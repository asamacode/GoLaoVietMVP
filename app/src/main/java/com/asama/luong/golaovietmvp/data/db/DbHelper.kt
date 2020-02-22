package com.asama.luong.golaovietmvp.data.db

import com.asama.luong.golaovietmvp.data.db.model.Mean
import com.asama.luong.golaovietmvp.data.db.model.Word
import com.asama.luong.golaovietmvp.data.db.model.WordFull

interface DbHelper {

    fun getListSaveWord() : List<Word>

    fun searchWord(word: String) : List<WordFull>

    fun getMeanWord(word: String) : Mean

    fun insertWord(word: Word)

    fun deleteWord(word: Word)
}