package com.asama.luong.golaovietmvp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asama.luong.golaovietmvp.data.db.entity.WordFullEntity

@Dao
interface WordFullDAO {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllWord(wordFull: List<WordFullEntity>)

    @Query("SELECT * FROM wordfull ORDER BY RANDOM() LIMIT 1")
    fun loadRandomWord(): WordFullEntity

    @Query("SELECT * FROM wordfull WHERE word LIKE '%' || :key || '%' LIMIT 5")
    fun searchWord(key: String) : List<WordFullEntity>
}