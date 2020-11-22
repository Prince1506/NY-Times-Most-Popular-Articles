package com.mvp_clean.ny_times_articles.dashboard.data.repo

import com.mvp_clean.ny_times_articles.BuildConfig.BASE_URL
import com.mvp_clean.ny_times_articles.core.network.NetworkHelper
import com.mvp_clean.ny_times_articles.dashboard.data.model.NYTimesMostPopularArticlesEntity
import io.reactivex.Observable
import javax.inject.Inject


class NYTimesMostViewedArticlesRepo @Inject constructor(networkHelper: NetworkHelper) : INyTimesMostViewedArticlesRepo {
    private val networkHelper: NetworkHelper

    init {
        this.networkHelper = networkHelper
    }

    override fun getNyTimesMostViewedArticles(day: Int?, apiKey: String): Observable<NYTimesMostPopularArticlesEntity?>? {
        return networkHelper.createRetrofitApi(BASE_URL, INyTimesMostViewedArticlesRepo::class.java)
            ?.getNyTimesMostViewedArticles(day, apiKey)
    }

}