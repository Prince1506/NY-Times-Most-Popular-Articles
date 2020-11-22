package com.mvp_clean.ny_times_articles.core.network.dataFactory

import android.content.Context
import com.mvp_clean.ny_times_articles.core.network.NetworkHelper
import javax.inject.Inject

class NYTimesMostViewedArticlesApis @Inject constructor(context: Context) {
    @Inject
    lateinit var networkHelper: NetworkHelper

    init {
        val mContext = context
    }
}