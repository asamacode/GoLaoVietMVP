package com.asama.luong.golaovietmvp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wordfull")
data class WordFullEntity (

    @PrimaryKey
    @ColumnInfo(name = "word")
    var word: String = "",

    @ColumnInfo(name = "common_mean")
    var commonMean: String? = "",

    @ColumnInfo(name = "image")
    var image: String? = "",

    @ColumnInfo(name = "spell")
    var spell: String? = ""
)