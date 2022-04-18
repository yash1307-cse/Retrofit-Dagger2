package com.yash1307.retrodi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yash1307.retrodi.dataclasses.PostsItem
import com.yash1307.retrodi.repository.PostRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    val postLiveData:LiveData<List<PostsItem>>
    get() = postRepository.postLiveData

    init {
        viewModelScope.launch {
            postRepository.getPosts()
        }
    }
}