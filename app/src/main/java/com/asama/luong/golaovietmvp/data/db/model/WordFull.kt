package com.asama.luong.golaovietmvp.data.db.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class WordFull: RealmObject() {

    @PrimaryKey
    var word: String? = ""

    var commonMean: String? = ""

    var image: String? = ""

    var spell: String? = ""
}