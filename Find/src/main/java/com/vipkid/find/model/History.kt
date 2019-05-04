package com.vipkid.find.model

import com.google.gson.annotations.SerializedName

/**
 * Created by WWF
 * on 2019/5/4
 */

data class History(
    val error: Boolean,
    val results: List<HistoryResult>
)

data class HistoryResult(
    @SerializedName("content")
    var cover: String?,
    val publishedAt: String,
    val title: String
)