package com.example.mvvm_retrofit_livedata.network

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.mvvm_retrofit_livedata.BookListModel
import com.example.mvvm_retrofit_livedata.MyApplication
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class RetrofitClient {

    private val bookApi: BookApi

    companion object{
        val baseUrl = "https://www.googleapis.com/books/v1/"     //volumes?q=harry
    }

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(MyApplication.getContext()))
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        bookApi=retrofit.create(BookApi::class.java)
    }

    fun fetchBooksData(query: String): Observable<BookListModel> {
        return bookApi.getBookList(query)
    }

    interface BookApi{
        @GET("volumes")
        fun getBookList(@Query("q") query: String):Observable<BookListModel>
    }
}

