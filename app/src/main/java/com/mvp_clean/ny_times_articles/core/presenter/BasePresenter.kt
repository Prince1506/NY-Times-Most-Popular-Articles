package com.mvp_clean.ny_times_articles.core.presenter

import com.mvp_clean.ny_times_articles.core.view.IBaseView

open class BasePresenter<V : IBaseView?> {
    var view: V? = null
    fun bind(viewToBind: V) {
        view = viewToBind
    }

    fun unbind() {
        view = null
    }
}

