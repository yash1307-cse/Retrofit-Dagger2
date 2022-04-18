package com.yash1307.retrodi.module

import com.yash1307.retrodi.BASE_URL
import com.yash1307.retrodi.PostInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class PostModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getPostInterface(retrofit: Retrofit): PostInterface {
        return retrofit.create(PostInterface::class.java)
    }
}