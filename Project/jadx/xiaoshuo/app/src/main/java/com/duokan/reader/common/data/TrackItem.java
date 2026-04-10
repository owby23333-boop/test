package com.duokan.reader.common.data;

import com.duokan.reader.ui.store.data.cms.Data;
import com.google.gson.annotations.SerializedName;
import com.yuewen.qe0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TrackItem extends Data {

    @SerializedName("id")
    private String id;

    @SerializedName(qe0.b.g)
    private String mAdId;

    @SerializedName("data")
    private DataItem mDataItem;

    @SerializedName("extend")
    private ExtendItem mExtendItem;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("track")
    private String mTrack;

    @SerializedName("type")
    private int mType;

    public static class DataItem extends Data {

        @SerializedName("data")
        private List<TrackItem> mData;

        public List<TrackItem> getData() {
            return this.mData;
        }

        public void setData(List<TrackItem> list) {
            this.mData = list;
        }
    }

    public static class ExtendItem extends Data {

        @SerializedName("type")
        private String mType;

        public String getType() {
            return this.mType;
        }

        public void setType(String str) {
            this.mType = str;
        }
    }

    public String getAdId() {
        return this.mAdId;
    }

    public DataItem getDataItem() {
        return this.mDataItem;
    }

    public ExtendItem getExtendItem() {
        return this.mExtendItem;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTrack() {
        return this.mTrack;
    }

    public int getType() {
        return this.mType;
    }

    public void setAdId(String str) {
        this.mAdId = str;
    }

    public void setDataItem(DataItem dataItem) {
        this.mDataItem = dataItem;
    }

    public void setExtendItem(ExtendItem extendItem) {
        this.mExtendItem = extendItem;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTrack(String str) {
        this.mTrack = str;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
