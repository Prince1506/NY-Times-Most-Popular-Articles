package com.mvp_clean.ny_times_articles.core.view

import android.content.Context
import com.mvp_clean.ny_times_articles.core.callback.IRetryCallBack

interface IBaseView {
    fun startServerApiErrorScreen(error: String?)
    fun isNetworkAvailable(context: Context?): Boolean
    fun startServerApiRetryScreen(error: String?, context: IRetryCallBack?)
    fun showProgress()
    fun hideProgress()
}
