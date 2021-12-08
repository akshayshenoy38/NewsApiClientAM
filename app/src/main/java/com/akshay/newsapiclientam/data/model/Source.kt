package com.akshay.newsapiclientam.data.model


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    var id: Any?,
    @SerializedName("name")
    var name: String?
)