package com.vishnuraj.surfaces.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface APIService {

    companion object {

        private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        private val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        fun getApiService(): APIService = Retrofit.Builder()
                .baseUrl("https://2hsjstzo71.execute-api.us-east-1.amazonaws.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)
    }

    // Get Posts
    @GET("/prod/livebarn-interview-project")
    fun getPosts(): Call<List<Post>>


}