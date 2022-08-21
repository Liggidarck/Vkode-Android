package com.george.vkode.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.george.vkode.BuildConfig
import com.george.vkode.data.prefereces.PreferencesViewModel
import com.george.vkode.network.api.auth.AuthStatus
import com.george.vkode.network.api.auth.AuthWebViewClient
import com.george.vkode.network.api.auth.VKAccountService
import com.george.vkode.ui.MainActivity
import java.net.URLEncoder
import java.util.regex.Pattern

@SuppressLint("UseRequireInsteadOfGet")
class AuthWebViewFragment : Fragment() {

    private val TAG = "AuthFragment"
    private val webView by lazy { WebView(context!!) }
//    private val appId = BuildConfig.APP_ID

    private val authParams = StringBuilder("https://oauth.vk.com/authorize?").apply {
        append(String.format("%s=%s", URLEncoder.encode("client_id", "UTF-8"), URLEncoder.encode("1", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("redirect_uri", "UTF-8"), URLEncoder.encode("https://oauth.vk.com/blank.html", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("display", "UTF-8"), URLEncoder.encode("mobile", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("scope", "UTF-8"), URLEncoder.encode(
            VKAccountService.SCOPE, "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("response_type", "UTF-8"), URLEncoder.encode("code", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("v", "UTF-8"), URLEncoder.encode("5.131", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("state", "UTF-8"), URLEncoder.encode("12345", "UTF-8")) + "&")
        append(String.format("%s=%s", URLEncoder.encode("revoke", "UTF-8"), URLEncoder.encode("1", "UTF-8")))
    }.toString()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) = webView

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "onViewCreated: $authParams")
        webView.webViewClient = AuthWebViewClient(context!!) { status ->
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
                    val url = webView.url!!
                    Log.d(TAG, "onViewCreated: $url")

                    val codeMather = Pattern.compile("code=\\w+.*").matcher(url)
                    if (codeMather.find()) {
                        val parseUrl = codeMather.group().replace("code=".toRegex(), "")
                        val yourArray: List<String> = parseUrl.split("&")
                        val code = yourArray[0]

                        val preferencesViewModel: PreferencesViewModel =
                            ViewModelProvider(this)[PreferencesViewModel::class.java]
                        Log.d(TAG, "onViewCreated: $code")

                        preferencesViewModel.saveCode(code)

                        activity?.let {
                            val intent = Intent(it, MainActivity::class.java)
                            it.startActivity(intent)
                        }
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
        webView.loadUrl(authParams)
    }

}