package com.asama.luong.golaovietmvp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "examples", indices = arrayOf(Index(value = ["word_id"], unique = false))
)
data class ExampleEntity(

    @PrimaryKey(autoGenerate = true) var id: Long = 0,

    @ColumnInfo(name = "mean")
    var mean: String? = "",

    @ColumnInfo(name = "type")
    var type: String? = "",

    @ColumnInfo(name = "word_id")
    var word_id: String = "",

    @ColumnInfo(name = "ex")
    var ex: String? = "",

    @ColumnInfo(name = "extran")
    var extran: String? = ""
) {
}