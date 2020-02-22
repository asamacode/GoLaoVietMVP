package com.asama.luong.golaovietmvp.data.db

import com.asama.luong.golaovietmvp.data.db.model.Mean
import com.asama.luong.golaovietmvp.data.db.model.Word
import com.asama.luong.golaovietmvp.data.db.model.WordFull
import io.realm.Case
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.Sort
import javax.inject.Inject

class RealmDbHelper @Inject constructor(
    realmConfiguration: RealmConfiguration
) : DbHelper {

    companion object {
        internal val fieldWord = "word"
    }

    private val mRealm: Realm = Realm.getInstance(realmConfiguration)

    override fun getMeanWord(word: String): Mean = mRealm.where(Mean::class.java)
        .equalTo(fieldWord, word)
        .findFirst()

    override fun getListSaveWord(): List<Word> = mRealm.where(Word::class.java).findAll()

    override fun searchWord(word: String): List<WordFull> = mRealm.where(WordFull::class.java)
        .like(fieldWord, word, Case.SENSITIVE)
        .findAllSortedAsync(fieldWord, Sort.ASCENDING)

    override fun insertWord(word: Word) {
        mRealm.beginTransaction()
        mRealm.copyToRealmOrUpdate(word)
        mRealm.commitTransaction()
    }

    override fun deleteWord(word: Word) = mRealm.delete(Word::class.java)
}