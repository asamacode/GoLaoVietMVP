package com.asama.luong.golaovietmvp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Example(

    @Expose
    @SerializedName("mean")
    var mean: String,

    @Expose
    @SerializedName("ex")
    var ex: String,

    @Expose
    @SerializedName("extran")
    var extran: String
)