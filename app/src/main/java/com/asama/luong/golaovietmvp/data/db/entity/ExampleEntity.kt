package com.asama.luong.golaovietmvp.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "examples", foreignKeys = [(ForeignKey(
        entity = WordFullEntity::class,
        parentColumns = arrayOf("word"),
        childColumns = arrayOf("word_id"),
        onDelete = ForeignKey.CASCADE
    ))]
)
data class ExampleEntity(

    @PrimaryKey(autoGenerate = true) var id: Long,

    var mean: String,

    var type: String,

    var word_id: String,

    var ex: String,

    var extran: String
)