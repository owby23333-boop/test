package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.yuewen.yd;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class SimpleChannel {

    @SerializedName("channel_id")
    private int channelId;

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private int id;

    @SerializedName("latest_program")
    private String latestProgram;

    @SerializedName("podcasters")
    private List<Podcaster> mPodcasters;

    @SerializedName("purchase_items")
    private List<PurchaseItem> mPurchaseItem;

    @SerializedName("playcount")
    private String playcount;

    @SerializedName("program_count")
    private String programCount;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName(yd.m.a.c)
    private String updateTime;

    public int getChannelId() {
        int i = this.channelId;
        return i == 0 ? this.id : i;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.id;
    }

    public String getPlaycount() {
        return this.playcount;
    }

    public String getProgramCount() {
        return this.programCount;
    }

    public String getThumb() {
        return this.thumb;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public List<Podcaster> getmPodcasters() {
        return this.mPodcasters;
    }

    public List<PurchaseItem> getmPurchaseItem() {
        return this.mPurchaseItem;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public void setProgramCount(String programCount) {
        this.programCount = programCount;
    }

    public void setThumb(String mThumb) {
        this.thumb = mThumb;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setmPodcasters(List<Podcaster> mPodcasters) {
        this.mPodcasters = mPodcasters;
    }

    public void setmPurchaseItem(List<PurchaseItem> mPurchaseItem) {
        this.mPurchaseItem = mPurchaseItem;
    }
}
