package com.george.vkode.ui

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.george.vkode.data.prefereces.PreferencesViewModel
import com.george.vkode.ui.login.LoginKotlinActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler

class VkApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        VK.addTokenExpiredHandler(tokenTracker)
    }

    private val tokenTracker = object: VKTokenExpiredHandler {
        override fun onTokenExpired() {
            LoginKotlinActivity.startFrom(this@VkApplication)
        }
    }

}