package com.mvp_clean.ny_times_articles.dashboard.view

import com.mvp_clean.ny_times_articles.core.view.IBaseView
import com.mvp_clean.ny_times_articles.dashboard.domain.NyTimesMostViewArticlesViewModel

interface INyTimesDashboardView : IBaseView{
    fun showArticles(nyTimesMostViewArticlesViewModel: NyTimesMostViewArticlesViewModel)
}
