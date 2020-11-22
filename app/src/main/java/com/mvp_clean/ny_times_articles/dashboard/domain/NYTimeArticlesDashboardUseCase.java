package com.mvp_clean.ny_times_articles.dashboard.domain;

import com.mvp_clean.ny_times_articles.core.constants.IKeyConstant;
import com.mvp_clean.ny_times_articles.core.usecase.UseCase;
import com.mvp_clean.ny_times_articles.core.usecase.UseCaseComposer;
import com.mvp_clean.ny_times_articles.dashboard.data.repo.NYTimesMostViewedArticlesRepo;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import io.reactivex.Observable;


public class NYTimeArticlesDashboardUseCase extends UseCase<Integer, NYTimesMostPopularArticlesDataModel> {

    @Inject
    public NYTimesMostViewedArticlesRepo NYTimesMostViewedArticlesRepo;
    @Inject
    public NYTimesMostPopularArticlesResponseEntityToDataMapper nyTimesMostPopularArticlesResponseEntityToDataMapper;

    @Inject
    public  NYTimeArticlesDashboardUseCase(UseCaseComposer useCaseComposer,
                                             NYTimesMostViewedArticlesRepo NYTimesMostViewedArticlesRepo,
                                             NYTimesMostPopularArticlesResponseEntityToDataMapper nyTimesMostPopularArticlesResponseEntityToDataMapper) {
        super(useCaseComposer);
        this.NYTimesMostViewedArticlesRepo = NYTimesMostViewedArticlesRepo;
        this.nyTimesMostPopularArticlesResponseEntityToDataMapper = nyTimesMostPopularArticlesResponseEntityToDataMapper;
    }

    @NotNull
    @Override
    protected Observable<NYTimesMostPopularArticlesDataModel> createUseCaseObservable(Integer days) {
        return NYTimesMostViewedArticlesRepo.getNyTimesMostViewedArticles(days, IKeyConstant.Companion.getApiKeyVal()).
                map(nyTimesMostPopularArticlesResponseEntityToDataMapper::mapEntityToData);
    }

}
