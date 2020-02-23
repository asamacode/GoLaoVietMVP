package com.asama.luong.golaovietmvp.data.db.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Word: RealmObject(){

    @PrimaryKey
    var word: String? = ""

    var mean: String? = ""
}