package com.asama.luong.golaovietmvp.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class WordFull(

    @Expose
    @SerializedName("word")
    var word: String? = "",

    @Expose
    @SerializedName("commonmean")
    var commonmean: String? = "",

    @Expose
    @SerializedName("image")
    var image: String? = "",

    @Expose
    @SerializedName("spell")
    var spell: String? = ""
) : Serializable