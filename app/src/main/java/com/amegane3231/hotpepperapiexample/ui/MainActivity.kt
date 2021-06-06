package com.amegane3231.hotpepperapiexample.ui

import android.os.Bundle
import android.text.util.Linkify
import android.text.util.Linkify.TransformFilter
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amegane3231.hotpepperapiexample.*
import com.amegane3231.hotpepperapiexample.`interface`.GourmetSearchService
import com.amegane3231.hotpepperapiexample.databinding.ActivityMainBinding
import com.amegane3231.hotpepperapiexample.entity.ResultEntity
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://webservice.recruit.co.jp/hotpepper/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GourmetSearchService::class.java)

        binding.buttonSubmit.setOnClickListener {
            val keywords = binding.inputKeywords.text.toString()
            retrofit.fetchData(COUNT, keywords)
                .enqueue(object : Callback<ResultEntity> {
                    override fun onResponse(
                        call: Call<ResultEntity>,
                        response: Response<ResultEntity>
                    ) {
                        if (response.isSuccessful) {
                            val shopList = response.body()
                            Log.d("shopList", shopList.toString())
                            var text = ""
                            shopList?.results?.shop?.forEach {
                                text += "${it.name} \n"
                            }
                            binding.textSearchResult.text = text
                        } else {
                            Log.w("Failure", "Cannot connect the page")
                        }
                    }

                    override fun onFailure(call: Call<ResultEntity>, throwable: Throwable) {
                        Log.e("Error", throwable.toString())
                    }
                })
        }

        val pattern = Pattern.compile(getString(R.string.hot_pepper_web_service))
        val scheme = getString(R.string.url_web_service_recruit)
        Linkify.addLinks(binding.textCredit, pattern, scheme, null,
            TransformFilter { matcher, s -> return@TransformFilter scheme })
    }

    companion object {
        private const val COUNT = 20
    }
}