package com.mvp_clean.ny_times_articles.dashboard.data.repo

import com.mvp_clean.ny_times_articles.core.constants.IKeyConstant
import com.mvp_clean.ny_times_articles.dashboard.data.model.NYTimesMostPopularArticlesEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface INyTimesMostViewedArticlesRepo {

    @GET("svc/mostpopular/v2/viewed/{day}.json")
    fun getNyTimesMostViewedArticles(
        @Path("day") day: Int?,
        @Query("api-key")apiKey: String
                                     ): Observable<NYTimesMostPopularArticlesEntity?>?
}