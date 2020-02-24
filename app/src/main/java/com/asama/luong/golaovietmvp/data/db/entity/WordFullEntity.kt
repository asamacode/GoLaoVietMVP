package com.asama.luong.golaovietmvp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wordfull")
data class WordFullEntity (

    @PrimaryKey
    var word: String,

    var commonMean: String,

    var image: String,

    var spell: String
)