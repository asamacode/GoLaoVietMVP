package com.asama.luong.golaovietmvp.data

import com.asama.luong.golaovietmvp.data.db.DbHelper
import com.asama.luong.golaovietmvp.data.db.model.Mean
import com.asama.luong.golaovietmvp.data.db.model.Word
import com.asama.luong.golaovietmvp.data.db.model.WordFull
import com.asama.luong.golaovietmvp.data.preferences.PrefHelper
import javax.inject.Inject

class AppDataManager @Inject constructor(
    private val dbHelper: DbHelper,
    private val prefHelper: PrefHelper
) : DataManager {


    override fun getListSaveWord(): List<Word> = dbHelper.getListSaveWord()

    override fun searchWord(word: String): List<WordFull> = dbHelper.searchWord(word)

    override fun getMeanWord(word: String): Mean = dbHelper.getMeanWord(word)

    override fun insertWord(word: Word) = dbHelper.insertWord(word)

    override fun deleteWord(word: Word) = dbHelper.deleteWord(word)

    override fun isLoadedData(): Boolean = prefHelper.isLoadedData()

    override fun setDataLoaded(boolean: Boolean) = prefHelper.setDataLoaded(boolean)
}