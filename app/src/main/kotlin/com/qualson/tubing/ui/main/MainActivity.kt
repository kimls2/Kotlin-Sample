package com.qualson.tubing.ui.main

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.ViewParent
import android.webkit.CookieManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import com.qualson.tubing.Constants
import com.qualson.tubing.R
import com.qualson.tubing.data.model.Channel
import com.qualson.tubing.data.model.menu.MenuResult
import com.qualson.tubing.ui.base.BaseActivity
import com.qualson.tubing.ui.main.list.AdapterCallback
import com.qualson.tubing.ui.main.list.MainAdapter
import com.qualson.tubing.util.hide
import com.qualson.tubing.util.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_loading_progress.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMvpView, AdapterCallback {
    override fun showMenu(result: MenuResult) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCookie(authKey: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun userLeave() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var currentUrl: String = Constants.TUBING_URL_BASE


    @Inject lateinit var presenter: MainPresenter
    private val mAdapter: MainAdapter = MainAdapter(this)

    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent?.inject(this)

        presenter.attachView(this)
        presenter.loadMenu()

        // Setup recycler view
        mainRv.layoutManager = LinearLayoutManager(this)
        mainRv.adapter = mAdapter

        val mActionBarDrawerToggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(mActionBarDrawerToggle)
        setWebView()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers()
        } else {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        try {
            val mParent: ViewParent = webView.parent
            mParent as FrameLayout
            mParent.removeAllViews()
            webView.stopLoading()
            webView.loadUrl("about:blank")
        } catch (ignore: Exception) {

        }
    }

    /***** MVP View methods implementation *****/
    override fun showCategories(channel: MutableList<Channel>) {
        mAdapter.setData(channel)
    }

    override fun showError(message: String) {
        Snackbar.make(drawerLayout, message, Snackbar.LENGTH_SHORT)
    }

    override fun showLoading(show: Boolean) {
        if (show) progressBar.show() else progressBar.hide()
    }

    /***** Adapter callback *****/
    override fun itemOnClicked(url: String) {
        loadPage(url)
        drawerLayout.closeDrawers()
    }


    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView() {

        val mWebViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                showLoading(true)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                showLoading(false)
            }

        }
        webView.setWebViewClient(mWebViewClient)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            val cookieManager: CookieManager = CookieManager.getInstance()
            cookieManager.setAcceptCookie(true)
            cookieManager.setAcceptThirdPartyCookies(webView, true)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }

        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }

        webView.loadUrl(currentUrl)
    }

    private fun loadPage(url: String) {
        webView.loadUrl(url)
    }

}
