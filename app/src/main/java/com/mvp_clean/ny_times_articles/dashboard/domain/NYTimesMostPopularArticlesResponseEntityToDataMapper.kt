package com.mvp_clean.ny_times_articles.dashboard.domain

import com.mvp_clean.ny_times_articles.dashboard.data.model.NYTimesMostPopularArticlesEntity
import javax.inject.Inject

class NYTimesMostPopularArticlesResponseEntityToDataMapper @Inject constructor() {

    fun mapEntityToData(
        nyTimesMostPopularArticlesEntity: NYTimesMostPopularArticlesEntity
    ): NyTimesMostViewArticlesDataModel
=
            NyTimesMostViewArticlesDataModel(
                nyTimesMostPopularArticlesEntity.resultEntities
            )


}