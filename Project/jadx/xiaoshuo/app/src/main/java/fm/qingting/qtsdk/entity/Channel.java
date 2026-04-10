package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.yuewen.yd;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Channel extends QTEntity {

    @SerializedName("categories")
    private List<Category> categories;

    @SerializedName("is_free")
    private boolean isFree = true;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("id")
    private Integer mId;

    @SerializedName("is_finished")
    private Integer mIsFinished;

    @SerializedName("latest_program")
    private ChannelProgram mLatestProgram;

    @SerializedName("podcasters")
    private List<Podcaster> mPodcasters;

    @SerializedName("program_count")
    private Integer mProgramCount;

    @SerializedName("purchase_items")
    private List<PurchaseItem> mPurchaseItem;

    @SerializedName("star")
    private Integer mStar;

    @SerializedName("thumbs")
    private Thumbs mThumbs;

    @SerializedName("title")
    private String mTitle;

    @SerializedName(yd.m.a.c)
    private String mUpdateTime;

    @SerializedName("playcount")
    private String playcount;

    @SerializedName("popularity")
    private int popularity;

    public List<Category> getCategories() {
        return this.categories;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Integer getId() {
        return this.mId;
    }

    public Integer getIsFinished() {
        return this.mIsFinished;
    }

    public ChannelProgram getLatestProgram() {
        return this.mLatestProgram;
    }

    public String getPlaycount() {
        return this.playcount;
    }

    public List<Podcaster> getPodcasters() {
        return this.mPodcasters;
    }

    public int getPopularity() {
        return this.popularity;
    }

    public Integer getProgramCount() {
        return this.mProgramCount;
    }

    public List<PurchaseItem> getPurchaseItem() {
        return this.mPurchaseItem;
    }

    public Integer getStar() {
        return this.mStar;
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

    public boolean isFree() {
        return this.isFree;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public void setFree(boolean free) {
        this.isFree = free;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    public void setIsFinished(Integer isFinished) {
        this.mIsFinished = isFinished;
    }

    public void setLatestProgram(ChannelProgram latestProgram) {
        this.mLatestProgram = latestProgram;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public void setPodcasters(List<Podcaster> podcasters) {
        this.mPodcasters = podcasters;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setProgramCount(Integer programCount) {
        this.mProgramCount = programCount;
    }

    public void setPurchaseItem(List<PurchaseItem> purchaseItem) {
        this.mPurchaseItem = purchaseItem;
    }

    public void setStar(Integer star) {
        this.mStar = star;
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
