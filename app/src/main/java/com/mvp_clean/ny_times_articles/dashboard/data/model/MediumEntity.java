package com.mvp_clean.ny_times_articles.dashboard.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

public class MediumEntity implements Parcelable {

    @Json(name = "type")
    private String type;
    @Json(name = "subtype")
    private String subtype;
    @Json(name = "caption")
    private String caption;
    @Json(name = "copyright")
    private String copyright;
    @Json(name = "approved_for_syndication")
    private Integer approvedForSyndication;
    @Json(name = "media-metadata")
    private List<MediaMetadatumEntity> mediaMetadata = null;

    protected MediumEntity(Parcel in) {
        type = in.readString();
        subtype = in.readString();
        caption = in.readString();
        copyright = in.readString();
        if (in.readByte() == 0) {
            approvedForSyndication = null;
        } else {
            approvedForSyndication = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(subtype);
        dest.writeString(caption);
        dest.writeString(copyright);
        if (approvedForSyndication == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(approvedForSyndication);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MediumEntity> CREATOR = new Creator<MediumEntity>() {
        @Override
        public MediumEntity createFromParcel(Parcel in) {
            return new MediumEntity(in);
        }

        @Override
        public MediumEntity[] newArray(int size) {
            return new MediumEntity[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(Integer approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public List<MediaMetadatumEntity> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<MediaMetadatumEntity> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

}
