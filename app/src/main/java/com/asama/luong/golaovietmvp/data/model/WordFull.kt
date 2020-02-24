package com.asama.luong.golaovietmvp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WordFull(

    @Expose
    @SerializedName("commonmean")
    var commonmean: String? = "",

    @Expose
    @SerializedName("image")
    var image: String? = "",

    @Expose
    @SerializedName("spell")
    var spell: String? = "",

    @Expose
    @SerializedName("word")
    var word: String? = ""
)