package com.mvp_clean.ny_times_articles.dashboard.view.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvp_clean.ny_times_articles.R
import com.mvp_clean.ny_times_articles.core.constants.IKeyConstant
import com.mvp_clean.ny_times_articles.core.view.fragments.BaseFragment
import com.mvp_clean.ny_times_articles.dashboard.domain.NyTimesMostViewArticlesViewModel
import com.mvp_clean.ny_times_articles.dashboard.view.adapters.NYTimeseMostViewedArticlesAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class NYTimesHomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var mostViewedArticlesList =
            arguments?.getParcelable<NyTimesMostViewArticlesViewModel>(IKeyConstant.articleMostViewedList)!!

        showList(mostViewedArticlesList)
    }

    fun showList(mostViewedArticlesList: NyTimesMostViewArticlesViewModel) {
        rv_nytimes_articles_mostviewd_list.adapter = NYTimeseMostViewedArticlesAdapter(
            this,
            mostViewedArticlesList.resultEntities
        )

        rv_nytimes_articles_mostviewd_list.layoutManager =  LinearLayoutManager(getActivity(),
        LinearLayoutManager.VERTICAL, false);
    }
}