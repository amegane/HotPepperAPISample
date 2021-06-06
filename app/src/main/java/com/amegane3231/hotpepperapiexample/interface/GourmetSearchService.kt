package com.amegane3231.hotpepperapiexample.`interface`

import com.amegane3231.hotpepperapiexample.entity.ResultEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GourmetSearchService {
    @GET("gourmet/v1/?key=YOUR_API_KEY&format=json&type=lite")
    fun fetchData(
        @Query("count") count: Int,
        @Query("keyword") vararg keyword: String
    ): Call<ResultEntity>
}