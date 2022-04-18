package com.yash1307.retrodi

import com.yash1307.retrodi.dataclasses.PostsItem
import retrofit2.Response
import retrofit2.http.GET

interface PostInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<List<PostsItem>>
}