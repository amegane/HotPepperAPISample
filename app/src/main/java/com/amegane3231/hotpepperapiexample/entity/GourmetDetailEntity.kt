package com.amegane3231.hotpepperapiexample.entity

data class GourmetDetailEntity(
    val api_version: Float,
    val results_available: Int,
    val results_returned: Int,
    val results_start: Int,
    val shop: List<ShopEntity>
)