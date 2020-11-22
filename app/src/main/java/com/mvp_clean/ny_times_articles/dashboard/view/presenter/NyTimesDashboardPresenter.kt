package com.mvp_clean.ny_times_articles.dashboard.view.presenter

import com.mvp_clean.ny_times_articles.core.constants.IKeyConstant
import com.mvp_clean.ny_times_articles.core.view.presenter.BasePresenter
import com.mvp_clean.ny_times_articles.dashboard.domain.NYTimeArticlesDashboardUseCase
import com.mvp_clean.ny_times_articles.dashboard.domain.NYTimesMostPopularArticlesResponseDataToViewMapper
import com.mvp_clean.ny_times_articles.dashboard.domain.NYTimesMostPopularArticlesResponseEntityToDataMapper
import com.mvp_clean.ny_times_articles.dashboard.view.INyTimesDashboardView
import com.mvp_clean.ny_times_articles.dashboard.view.activities.NyTimesDashboardActivity
import java.net.SocketTimeoutException
import javax.inject.Inject

class NyTimesDashboardPresenter :
    BasePresenter<INyTimesDashboardView>, INyTimesDashboardPresenter{

    private val nYTimeArticlesDashboardUseCase: NYTimeArticlesDashboardUseCase?
    private val nyTimesMostPopularArticlesResponseDataToViewMapper: NYTimesMostPopularArticlesResponseDataToViewMapper

    @Inject
    public constructor(
        nYTimeArticlesDashboardUseCase: NYTimeArticlesDashboardUseCase?,
        nyTimesMostPopularArticlesResponseDataToViewMapper: NYTimesMostPopularArticlesResponseDataToViewMapper
    ) {
        this.nYTimeArticlesDashboardUseCase = nYTimeArticlesDashboardUseCase
        this.nyTimesMostPopularArticlesResponseDataToViewMapper = nyTimesMostPopularArticlesResponseDataToViewMapper
    }

    override fun getArticles(previousDate: Int) {
        try {
            if (!(view?.isNetworkAvailable(view as NyTimesDashboardActivity?))!!) {
                view?.startServerApiRetryScreen(
                    IKeyConstant.noInternet,
                    view as NyTimesDashboardActivity?
                )
            } else {
                view?.showProgress()
                nYTimeArticlesDashboardUseCase?.execute(previousDate)?.subscribe({ videoResponseDataModel ->
                    try {
                        if (view != null) {
                            view?.showArticles(
                                nyTimesMostPopularArticlesResponseDataToViewMapper.mapEntityToData(
                                    videoResponseDataModel
                                )
                            )
                            view?.hideProgress()
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
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
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}