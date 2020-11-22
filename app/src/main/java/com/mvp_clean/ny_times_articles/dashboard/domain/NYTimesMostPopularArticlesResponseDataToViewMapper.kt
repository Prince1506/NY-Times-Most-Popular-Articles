package com.mvp_clean.ny_times_articles.dashboard.domain

import javax.inject.Inject

class NYTimesMostPopularArticlesResponseDataToViewMapper @Inject constructor() {

    fun mapEntityToData(
        nyTimesMostPopularArticlesDataModel: NyTimesMostViewArticlesDataModel
    ): NyTimesMostViewArticlesViewModels =

        NyTimesMostViewArticlesViewModels(
            nyTimesMostPopularArticlesDataModel.status,
            nyTimesMostPopularArticlesDataModel.copyright,
            nyTimesMostPopularArticlesDataModel.numResults,
            nyTimesMostPopularArticlesDataModel.resultEntities
        )

}