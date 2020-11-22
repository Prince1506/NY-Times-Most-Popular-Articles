package com.mvp_clean.ny_times_articles.dashboard.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;

public class MediaMetadatumEntity implements Parcelable {

    @Json(name = "url")
    private String url;
    @Json(name = "format")
    private String format;
    @Json(name = "height")
    private Integer height;
    @Json(name = "width")
    private Integer width;

    protected MediaMetadatumEntity(Parcel in) {
        url = in.readString();
        format = in.readString();
        if (in.readByte() == 0) {
            height = null;
        } else {
            height = in.readInt();
        }
        if (in.readByte() == 0) {
            width = null;
        } else {
            width = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(format);
        if (height == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(height);
        }
        if (width == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(width);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MediaMetadatumEntity> CREATOR = new Creator<MediaMetadatumEntity>() {
        @Override
        public MediaMetadatumEntity createFromParcel(Parcel in) {
            return new MediaMetadatumEntity(in);
        }

        @Override
        public MediaMetadatumEntity[] newArray(int size) {
            return new MediaMetadatumEntity[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
