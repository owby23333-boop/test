package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.yuewen.yd;

/* JADX INFO: loaded from: classes8.dex */
public class ChannelProgram {

    @SerializedName("description")
    private String mDescription;

    @SerializedName("duration")
    private Integer mDuration;

    @SerializedName("id")
    private Integer mId;

    @SerializedName("is_free")
    private Boolean mIsFree;

    @SerializedName("thumbs")
    private Thumbs mThumbs;

    @SerializedName("title")
    private String mTitle;

    @SerializedName(yd.m.a.c)
    private String mUpdateTime;

    @SerializedName("popularity")
    private Integer popularity;

    public String getDescription() {
        return this.mDescription;
    }

    public Integer getDuration() {
        return this.mDuration;
    }

    public Integer getId() {
        return this.mId;
    }

    public Integer getPopularity() {
        return this.popularity;
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

    public Boolean isFree() {
        return this.mIsFree;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public void setDuration(Integer duration) {
        this.mDuration = duration;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public void setIsFree(Boolean mIsFree) {
        this.mIsFree = mIsFree;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
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
