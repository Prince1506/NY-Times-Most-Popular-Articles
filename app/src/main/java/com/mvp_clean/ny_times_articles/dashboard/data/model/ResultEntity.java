package com.mvp_clean.ny_times_articles.dashboard.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import java.util.List;

public class ResultEntity implements Parcelable {

    @Json(name = "uri")
    private String uri;
    @Json(name = "url")
    private String url;

    @Json(name = "id")
    private long id;

    @Json(name = "asset_id")
    private long assetId;
    @Json(name = "source")
    private String source;
    @Json(name = "published_date")
    private String publishedDate;
    @Json(name = "updated")
    private String updated;
    @Json(name = "section")
    private String section;
    @Json(name = "subsection")
    private String subsection;
    @Json(name = "nytdsection")
    private String nytdsection;
    @Json(name = "adx_keywords")
    private String adxKeywords;
    @Json(name = "column")
    private Object column;
    @Json(name = "byline")
    private String byline;
    @Json(name = "type")
    private String type;
    @Json(name = "title")
    private String title;
    @Json(name = "abstract")
    private String _abstract;
    @Json(name = "des_facet")
    private List<String> desFacet = null;
    @Json(name = "org_facet")
    private List<String> orgFacet = null;
    @Json(name = "per_facet")
    private List<String> perFacet = null;
    @Json(name = "geo_facet")
    private List<String> geoFacet = null;
    @Json(name = "media")
    private List<MediumEntity> media = null;
    @Json(name = "eta_id")
    private Integer etaId;


    protected ResultEntity(Parcel in) {
        uri = in.readString();
        url = in.readString();
        id = in.readLong();
        if (in.readLong() == 0) {
            assetId = 0;
        } else {
            assetId = in.readLong();
        }
        source = in.readString();
        publishedDate = in.readString();
        updated = in.readString();
        section = in.readString();
        subsection = in.readString();
        nytdsection = in.readString();
        adxKeywords = in.readString();
        byline = in.readString();
        type = in.readString();
        title = in.readString();
        _abstract = in.readString();
        desFacet = in.createStringArrayList();
        orgFacet = in.createStringArrayList();
        perFacet = in.createStringArrayList();
        geoFacet = in.createStringArrayList();
        media = in.createTypedArrayList(MediumEntity.CREATOR);
        if (in.readByte() == 0) {
            etaId = null;
        } else {
            etaId = in.readInt();
        }
    }



    public static final Creator<ResultEntity> CREATOR = new Creator<ResultEntity>() {
        @Override
        public ResultEntity createFromParcel(Parcel in) {
            return new ResultEntity(in);
        }

        @Override
        public ResultEntity[] newArray(int size) {
            return new ResultEntity[size];
        }
    };

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getNytdsection() {
        return nytdsection;
    }

    public void setNytdsection(String nytdsection) {
        this.nytdsection = nytdsection;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(Object column) {
        this.column = column;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    public List<String> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public List<String> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    public List<String> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(List<String> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public List<MediumEntity> getMedia() {
        return media;
    }

    public void setMedia(List<MediumEntity> media) {
        this.media = media;
    }

    public Integer getEtaId() {
        return etaId;
    }

    public void setEtaId(Integer etaId) {
        this.etaId = etaId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
