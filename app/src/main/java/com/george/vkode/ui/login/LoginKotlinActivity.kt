package com.george.vkode.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.george.vkode.R
import com.george.vkode.data.prefereces.PreferencesViewModel
import com.george.vkode.databinding.ActivityLoginKotlinBinding
import com.george.vkode.ui.MainActivity
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.exceptions.VKAuthException
import com.vk.dto.common.id.UserId


class LoginKotlinActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginKotlinBinding

    private lateinit var authLauncher: ActivityResultLauncher<Collection<VKScope>>

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Login)
        super.onCreate(savedInstanceState)
        binding = ActivityLoginKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencesViewModel: PreferencesViewModel = ViewModelProvider(this)[PreferencesViewModel::class.java]
        preferencesViewModel.deleteToken()

        authLauncher = VK.login(this) { result: VKAuthenticationResult ->
            when (result) {
                is VKAuthenticationResult.Success -> onLogin(result.token.accessToken, result.token.userId)
                is VKAuthenticationResult.Failed -> onLoginFailed(result.exception)
            }
        }

        binding.btnLogin.setOnClickListener {
            authLauncher.launch(
                arrayListOf(
                    VKScope.WALL,
                    VKScope.PHOTOS,
                    VKScope.FRIENDS,
                    VKScope.GROUPS,
                    VKScope.STATS,
                    VKScope.STATUS
                )
            )
        }
    }

    private fun onLoginFailed(exception: VKAuthException) {
        TODO("Not yet implemented")
    }

    private fun onLogin(token: String, userId: UserId) {
        val preferencesViewModel: PreferencesViewModel = ViewModelProvider(this)[PreferencesViewModel::class.java]
        preferencesViewModel.saveToken(token)
        preferencesViewModel.saveUserId(userId.value.toInt())

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, LoginKotlinActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }
}