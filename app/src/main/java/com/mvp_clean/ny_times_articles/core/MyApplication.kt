package com.mvp_clean.ny_times_articles.core

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        cntxt = this
    }

    companion object {
        var cntxt: Context? = null

        /*
            get app context
        */
        fun getMyApplicationContext() = cntxt
    }
}