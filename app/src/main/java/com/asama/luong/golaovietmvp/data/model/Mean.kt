package com.asama.luong.golaovietmvp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Mean(

    @Expose
    @SerializedName("word")
    var word: String,

    @Expose
    @SerializedName("listtype")
    var listType: List<MeanType>
)