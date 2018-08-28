package com.firbasedbdemo.api

import com.firbasedbdemo.constants.AppConstants.APIConstants.BASE_URL
import com.firbasedbdemo.constants.AppConstants.APIConstants.TIME_OUT
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class APIService {

    companion object {

        private lateinit var retrofit: Retrofit
        private var apiInterface: APIInterface? = null

        private fun getClient(): Retrofit {

            val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                    .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                    .build()
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

            return retrofit
        }

        fun getAPIInterface(): APIInterface {
            if (apiInterface == null)
                apiInterface = getClient().create(APIInterface::class.java)

            return apiInterface!!
        }

    }

}