package com.asama.luong.golaovietmvp.data.db.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

data class WordFull(

    @PrimaryKey
    var word: String,

    var commonMean: String,

    var image: String,

    var spell: String
) : RealmObject() {
}