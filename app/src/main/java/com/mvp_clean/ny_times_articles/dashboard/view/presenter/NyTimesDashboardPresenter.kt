package com.mvp_clean.ny_times_articles.dashboard.view.presenter

import com.mvp_clean.ny_times_articles.core.constants.IKeyConstant
import com.mvp_clean.ny_times_articles.core.presenter.BasePresenter
import com.mvp_clean.ny_times_articles.dashboard.domain.NYTimeArticlesDashboardUseCase
import com.mvp_clean.ny_times_articles.dashboard.domain.NYTimesMostPopularArticlesResponseDataToViewMapper
import com.mvp_clean.ny_times_articles.dashboard.view.INyTimesDashboardView
import com.mvp_clean.ny_times_articles.dashboard.view.activities.NyTimesDashboardActivity
import java.net.SocketTimeoutException
import javax.inject.Inject

class NyTimesDashboardPresenter :
    BasePresenter<INyTimesDashboardView>, INyTimesDashboardPresenter{

    public lateinit var nYTimeArticlesDashboardUseCase: NYTimeArticlesDashboardUseCase
    public lateinit var nyTimesMostPopularArticlesResponseDataToViewMapper: NYTimesMostPopularArticlesResponseDataToViewMapper

    @Inject
    public constructor(
        nYTimeArticlesDashboardUseCase: NYTimeArticlesDashboardUseCase,
        nyTimesMostPopularArticlesResponseDataToViewMapper: NYTimesMostPopularArticlesResponseDataToViewMapper
    ) {
        this.nYTimeArticlesDashboardUseCase = nYTimeArticlesDashboardUseCase
        this.nyTimesMostPopularArticlesResponseDataToViewMapper = nyTimesMostPopularArticlesResponseDataToViewMapper
    }

    override fun getArticles(previousDate: Int) {
            if (!(view?.isNetworkAvailable(view as NyTimesDashboardActivity?))!!) {
                view?.startServerApiRetryScreen(
                    IKeyConstant.noInternet,
                    view as NyTimesDashboardActivity?
                )
            } else {
                view?.showProgress()
                nYTimeArticlesDashboardUseCase?.execute(previousDate)?.subscribe({ videoResponseDataModel ->
                        if (view != null) {
                            view?.showArticles(
                                nyTimesMostPopularArticlesResponseDataToViewMapper.mapDataToViewMapper(
                                    videoResponseDataModel
                                )
                            )
                            view?.hideProgress()
                        }
                }) { throwable: Throwable? ->
                    if (view == null) return@subscribe
                    view?.hideProgress()
                    if (throwable is SocketTimeoutException) {
                        view?.startServerApiErrorScreen(IKeyConstant.timeOut)
                    } else {
                        view?.startServerApiErrorScreen(IKeyConstant.ServerError)
                    }
                }
            }
    }
}