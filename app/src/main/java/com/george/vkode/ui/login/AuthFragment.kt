package com.george.vkode.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebView
import android.widget.Toast
import com.george.vkode.BuildConfig
import com.george.vkode.network.auth.AuthStatus
import com.george.vkode.network.auth.AuthWebViewClient
import com.george.vkode.network.auth.VKAccountService
import java.lang.StringBuilder
import java.net.URLEncoder
import java.util.regex.Pattern

@SuppressLint("UseRequireInsteadOfGet")
class AuthFragment : Fragment() {
    val TAG = "AuthFragment"
    private val webview by lazy { WebView(context!!) }
    private val appId = BuildConfig.APP_ID
    private val _authParams = StringBuilder("https://oauth.vk.com/authorize?").apply {
        append(String.format("%s=%s", URLEncoder.encode("client_id", "UTF-8"), URLEncoder.encode(appId, "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("redirect_uri", "UTF-8"), URLEncoder.encode("https://oauth.vk.com/blank.html", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("display", "UTF-8"), URLEncoder.encode("mobile", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("scope", "UTF-8"), URLEncoder.encode(
            VKAccountService.SCOPE, "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("response_type", "UTF-8"), URLEncoder.encode("token", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("v", "UTF-8"), URLEncoder.encode("5.131", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("state", "UTF-8"), URLEncoder.encode("12345", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("revoke", "UTF-8"), URLEncoder.encode("1", "UTF-8")))
    }.toString()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = webview

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webview.webViewClient = AuthWebViewClient(context!!) { status ->
            when (status) {
                AuthStatus.ERROR -> {
                    Toast.makeText(context, "Не верный логин или пароль", Toast.LENGTH_LONG)
                        .show()
                }
                AuthStatus.BLOCKED -> {
                    showAuthWindow()
                    Toast.makeText(context, "Аккаунт заблокирован", Toast.LENGTH_LONG).show()
                }
                AuthStatus.SUCCESS -> {
                    val url = webview.url!!
                    Log.d(TAG, "onViewCreated: $url")
                    val tokenMather = Pattern.compile("access_token=\\w+.*").matcher(url)
                    if (tokenMather.find()) {
                        val parseUrl = tokenMather.group().replace("access_token=".toRegex(), "")
                        val urlParser: List<String> = parseUrl.split("&")
                        val token = urlParser[0]
                    }
                }
                AuthStatus.AUTH -> {
                    Log.d(TAG, "onViewCreated: User in auth")
                }
                AuthStatus.CONFIRM -> {
                    Log.d(TAG, "onViewCreated: User in confirm")
                }
            }
        }


    }

    override fun onStart() {
        super.onStart()

        showAuthWindow()
    }

    private fun showAuthWindow() {
        CookieManager.getInstance().removeAllCookies(null)
        webview.loadUrl(_authParams)
    }

}