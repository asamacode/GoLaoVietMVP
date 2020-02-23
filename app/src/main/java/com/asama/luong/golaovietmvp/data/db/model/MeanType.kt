package com.asama.luong.golaovietmvp.data.db.model

import io.realm.RealmList
import io.realm.RealmObject

open class MeanType: RealmObject(){

    var type: String? = ""

    var meanList: RealmList<Example>? = null
}