package com.asama.luong.golaovietmvp.data.db.model

import io.realm.RealmList
import io.realm.RealmObject

data class MeanType(

    var type: String,

    var meanList: RealmList<Example>
) : RealmObject(){
}