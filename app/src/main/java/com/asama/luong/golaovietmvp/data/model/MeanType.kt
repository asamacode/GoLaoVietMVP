package com.asama.luong.golaovietmvp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MeanType(
    @Expose
    @SerializedName("type")
    var type: String,

    @Expose
    @SerializedName("meanlist")
    var meanList: List<Example>
)