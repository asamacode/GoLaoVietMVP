package com.asama.luong.golaovietmvp.data.db.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

data class Word(

    @PrimaryKey
    var word: String,

    var mean: String
) : RealmObject(){

}