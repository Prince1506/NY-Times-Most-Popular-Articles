package com.mvp_clean.ny_times_articles.dashboard.data.model;

import com.squareup.moshi.Json;
import java.util.List;

public class NYTimesMostPopularArticlesEntity {

     @Json(name = "status")
    private String status;

     @Json(name = "copyright")
    private String copyright;

     @Json(name = "num_results")
    private Integer numResults;

     @Json(name = "results")
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
