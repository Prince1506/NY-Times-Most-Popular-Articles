package com.mvp_clean.ny_times_articles.dashboard.domain;

import com.mvp_clean.ny_times_articles.dashboard.data.model.NYTimesMostPopularArticlesEntity;

import javax.inject.Inject;

public class NYTimesMostPopularArticlesResponseDataToViewMapper {

    @Inject
    public NYTimesMostPopularArticlesResponseDataToViewMapper(){}

    public NyTimesMostViewArticlesViewModels mapEntityToData(NYTimesMostPopularArticlesDataModel nyTimesMostPopularArticlesDataModel) {
        NyTimesMostViewArticlesViewModels nyTimesMostPopularArticlesViewModel = new NyTimesMostViewArticlesViewModels();
        nyTimesMostPopularArticlesViewModel.setCopyright(nyTimesMostPopularArticlesDataModel.getCopyright());
        nyTimesMostPopularArticlesViewModel.setNumResults(nyTimesMostPopularArticlesDataModel.getNumResults());
        nyTimesMostPopularArticlesViewModel.setStatus(nyTimesMostPopularArticlesDataModel.getStatus());
        nyTimesMostPopularArticlesViewModel.setResultEntities(nyTimesMostPopularArticlesDataModel.getResultEntities());
        return nyTimesMostPopularArticlesViewModel;
    }
}
