package com.mvp_clean.ny_times_articles.dashboard.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mvp_clean.ny_times_articles.dashboard.data.model.ResultEntity;

import java.util.List;

public class NYTimesMostPopularArticlesDataModel {

    private String status;
    private String copyright;
    private Integer numResults;
    private List<ResultEntity> resultEntities = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<ResultEntity> getResultEntities() {
        return resultEntities;
    }

    public void setResultEntities(List<ResultEntity> resultEntities) {
        this.resultEntities = resultEntities;
    }

}
