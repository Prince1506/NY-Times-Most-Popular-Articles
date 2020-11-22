package com.mvp_clean.ny_times_articles.dashboard.domain;

import com.mvp_clean.ny_times_articles.dashboard.data.model.NYTimesMostPopularArticlesEntity;

import javax.inject.Inject;

public class NYTimesMostPopularArticlesResponseEntityToDataMapper {

    @Inject
    public NYTimesMostPopularArticlesResponseEntityToDataMapper(){}

    public NYTimesMostPopularArticlesDataModel mapEntityToData(NYTimesMostPopularArticlesEntity nyTimesMostPopularArticlesEntity) {
        NYTimesMostPopularArticlesDataModel nyTimesMostPopularArticlesDataModel = new NYTimesMostPopularArticlesDataModel();
        nyTimesMostPopularArticlesDataModel.setCopyright(nyTimesMostPopularArticlesEntity.getCopyright());
        nyTimesMostPopularArticlesDataModel.setNumResults(nyTimesMostPopularArticlesEntity.getNumResults());
        nyTimesMostPopularArticlesDataModel.setStatus(nyTimesMostPopularArticlesEntity.getStatus());
        nyTimesMostPopularArticlesDataModel.setResultEntities(nyTimesMostPopularArticlesEntity.getResultEntities());
        return nyTimesMostPopularArticlesDataModel;
    }
}
