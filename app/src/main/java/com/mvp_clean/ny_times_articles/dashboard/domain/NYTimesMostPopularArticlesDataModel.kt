package com.mvp_clean.ny_times_articles.dashboard.domain;

import android.os.Parcelable
import com.mvp_clean.ny_times_articles.dashboard.data.model.ResultEntity;
import kotlinx.android.parcel.Parcelize

@Parcelize
class NyTimesMostViewArticlesDataModel(
        val status: String,
        val copyright: String,
        val numResults: Int,
        val resultEntities: MutableList<ResultEntity>
) : Parcelable {
        }