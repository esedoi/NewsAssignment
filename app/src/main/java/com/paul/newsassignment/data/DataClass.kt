package com.paul.newsassignment.data

data class NewsData(
    val getVector: GetVector
)

data class GetVector(
    val items: List<Item>?
)

data class Item(
    val _meta: Meta?,
    val appearance: Appearance?,
    val extra: Extra?,
    val items: List<ItemX>?,
    val ref: String?,
    val source: String?,
    val style: String?,
    val title: String?,
    val type: String?
)

data class Meta(
    val category: List<String>?,
    val section: String?
)

data class Appearance(
    val mainTitle: String?,
    val subTitle: String?,
    val subscript: String?,
    val thumbnail: String?
)

data class Extra(
    val created: Int?,
    val description: String?
)

data class ItemX(
    val _meta: Meta?,
    val appearance: Appearance?,
    val extra: Extra?,
    val ref: String?,
    val source: String?,
    val type: String?
)

