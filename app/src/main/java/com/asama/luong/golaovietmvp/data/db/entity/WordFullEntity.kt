package com.asama.luong.golaovietmvp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "wordfull",indices =  arrayOf(Index(value = ["word", "common_mean"],
    unique = true)))
data class WordFullEntity (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "word")
    var word: String = "",

    @ColumnInfo(name = "common_mean")
    var commonMean: String? = "",

    @ColumnInfo(name = "image")
    var image: String? = "",

    @ColumnInfo(name = "spell")
    var spell: String? = ""
)