# HotPepperAPISample

このリポジトリはリクルート社が提供するホットペッパーグルメサーチAPIを用いたサンプルプログラムです。入力欄にキーワードを入力し、送信ボタンを押すと、そのキーワードをもとに検索が行われ、検索結果から取得した店名が表示されます。
このプログラムを流用する場合、APIキーを自身が所持しているキーに書き換えてください。また、[リクルート社の利用案内](https://webservice.recruit.co.jp/doc/hotpepper/guideline.html)を必ず確認してください。

```kotlin
interface GourmetSearchService {
    @GET("gourmet/v1/?key=YOUR_API_KEY&format=json&type=lite")
    fun fetchData(
        @Query("count") count: Int,
        @Query("keyword") vararg keyword: String
    ): Call<ResultEntity>
}
```

<img src="https://user-images.githubusercontent.com/51881691/120942905-cb84c600-c766-11eb-8db6-1f9a840a3168.png" width="640">
