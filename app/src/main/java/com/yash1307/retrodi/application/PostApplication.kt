package com.yash1307.retrodi.application

import android.app.Application
import com.yash1307.retrodi.component.DaggerPostComponent
import com.yash1307.retrodi.component.PostComponent

class PostApplication : Application() {


    lateinit var postComponent: PostComponent

    override fun onCreate() {
        super.onCreate()

        postComponent = DaggerPostComponent.builder().build()
    }
}