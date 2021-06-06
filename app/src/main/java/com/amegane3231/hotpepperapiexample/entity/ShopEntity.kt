package com.amegane3231.hotpepperapiexample.entity

data class ShopEntity(
    val address: String,
    val budget_memo: String,
    val catch: String,
    val food: FoodEntity,
    val genre: GenreEntity,
    val id: String,
    val lat: Double,
    val lng: Double,
    val name: String,
    val photo: PhotoEntity,
    val shop_detail_memo: String,
    val urls: URLsEntity,
)