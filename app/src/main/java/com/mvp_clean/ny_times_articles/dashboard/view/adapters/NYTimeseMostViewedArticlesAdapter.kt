package com.mvp_clean.ny_times_articles.dashboard.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mvp_clean.ny_times_articles.R
import com.mvp_clean.ny_times_articles.dashboard.data.model.ResultEntity
import com.mvp_clean.ny_times_articles.dashboard.view.fragments.home.NYTimesHomeFragment
import kotlinx.android.synthetic.main.dashboard_articles_item.view.*


class NYTimeseMostViewedArticlesAdapter(
    NYTimesHomeFragment: NYTimesHomeFragment,
    resultEntities: List<ResultEntity>
) : RecyclerView.Adapter<NYTimeseMostViewedArticlesAdapter.MyViewHolder>() {

    val homeFragment = NYTimesHomeFragment
    val resultEntities = resultEntities

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem: View = layoutInflater.inflate(R.layout.dashboard_articles_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindArticleUiToData(resultEntities.get(position))
    }

    override fun getItemCount(): Int = resultEntities.size


    class MyViewHolder(itemView: View?) : ViewHolder(itemView!!) {

        fun bindArticleUiToData(resultEntity: ResultEntity) {
            itemView.tv_article_item_body.text = resultEntity.title
            itemView.tv_article_item_author.text = resultEntity.byline
            itemView.tv_article_item_date.text = resultEntity.publishedDate
        }

    }


}
