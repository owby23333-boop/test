package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.yuewen.yd;

/* JADX INFO: loaded from: classes8.dex */
public class Radio extends QTEntity {

    @SerializedName("description")
    private String mDescription;

    @SerializedName("id")
    private Integer mId;

    @SerializedName("thumbs")
    private Thumbs mThumbs;

    @SerializedName("title")
    private String mTitle;

    @SerializedName(yd.m.a.c)
    private String mUpdateTime;

    public String getDescription() {
        return this.mDescription;
    }

    public Integer getId() {
        return this.mId;
    }

    public Thumbs getThumbs() {
        return this.mThumbs;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUpdateTime() {
        return this.mUpdateTime;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public void setThumbs(Thumbs thumbs) {
        this.mThumbs = thumbs;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setUpdateTime(String updateTime) {
        this.mUpdateTime = updateTime;
    }
}
