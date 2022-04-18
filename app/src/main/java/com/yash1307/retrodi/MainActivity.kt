package com.yash1307.retrodi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yash1307.retrodi.application.PostApplication
import com.yash1307.retrodi.factory.PostFactory
import com.yash1307.retrodi.viewmodel.PostViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var postViewModel: PostViewModel

    @Inject
    lateinit var postFactory: PostFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        (application as PostApplication).postComponent.inject(this)
        postViewModel = ViewModelProvider(this, postFactory)[PostViewModel::class.java]

        postViewModel.postLiveData.observe(this, Observer {
            textView.text = it.toString()
        })
    }
}