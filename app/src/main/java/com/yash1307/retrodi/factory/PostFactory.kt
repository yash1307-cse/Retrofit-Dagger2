package com.yash1307.retrodi.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yash1307.retrodi.repository.PostRepository
import com.yash1307.retrodi.viewmodel.PostViewModel
import javax.inject.Inject

class PostFactory @Inject constructor (private val postRepository: PostRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }

}