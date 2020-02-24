package com.asama.luong.golaovietmvp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asama.luong.golaovietmvp.data.db.entity.ExampleEntity

@Dao
interface ExampleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllExample(examples: List<ExampleEntity>)

    @Query("SELECT * FROM examples WHERE word_id = :word")
    fun loadExampleByWord(word: String): List<ExampleEntity>
}