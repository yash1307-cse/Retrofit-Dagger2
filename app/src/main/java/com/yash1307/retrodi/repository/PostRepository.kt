package com.yash1307.retrodi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yash1307.retrodi.PostInterface
import com.yash1307.retrodi.dataclasses.PostsItem
import javax.inject.Inject

class PostRepository @Inject constructor(private val postInterface: PostInterface)  {

    private val postMutableLiveData = MutableLiveData<List<PostsItem>>()

    val postLiveData:LiveData<List<PostsItem>>
    get() = postMutableLiveData

    suspend fun getPosts() {
        val response = postInterface.getPosts()
        if(response.isSuccessful) {
            postMutableLiveData.postValue(response.body())
        }

    }

}