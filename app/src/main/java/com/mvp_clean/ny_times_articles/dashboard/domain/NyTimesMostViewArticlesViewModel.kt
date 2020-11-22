package com.mvp_clean.ny_times_articles.dashboard.domain

import android.os.Parcelable
import com.mvp_clean.ny_times_articles.dashboard.data.model.ResultEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class NyTimesMostViewArticlesViewModel(
    val resultEntities: List<ResultEntity>
) : Parcelable