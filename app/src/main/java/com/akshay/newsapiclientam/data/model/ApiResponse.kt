package com.akshay.newsapiclientam.data.model


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("articles")
    var articles: List<Article>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?
)