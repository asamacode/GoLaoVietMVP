package com.asama.luong.golaovietmvp.data.db.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

data class Mean(

    @PrimaryKey
    var word: String,

    var listType: RealmList<MeanType>
) : RealmObject(){
}