package com.yash1307.retrodi.component

import com.yash1307.retrodi.MainActivity
import com.yash1307.retrodi.module.PostModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PostModule::class])
interface PostComponent {

    fun inject(mainActivity: MainActivity)
}