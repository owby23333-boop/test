package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class QTOrderEntity {

    @SerializedName("channel_id")
    private Integer mChannelId;

    @SerializedName("expire_time")
    private String mExpireTime;

    @SerializedName("paid_time")
    private String mPaidTime;

    @SerializedName("podcasters")
    private List<Podcaster> mPodcasters;

    @SerializedName("program_ids")
    private List<Integer> mProgramIds;

    @SerializedName("state")
    private String mState;

    @SerializedName("user_id")
    private String mUserId;

    @SerializedName("playcount")
    private String playcount;

    @SerializedName("program_count")
    private String programCount;

    @SerializedName("thumb")
    private String thumb;
    private String type;

    public Integer getChannelId() {
        return this.mChannelId;
    }

    public String getExpireTime() {
        return this.mExpireTime;
    }

    public String getPaidTime() {
        return this.mPaidTime;
    }

    public String getPlaycount() {
        return this.playcount;
    }

    public List<Podcaster> getPodcasters() {
        return this.mPodcasters;
    }

    public String getProgramCount() {
        return this.programCount;
    }

    public List<Integer> getProgramIds() {
        return this.mProgramIds;
    }

    public String getState() {
        return this.mState;
    }

    public String getThumb() {
        return this.thumb;
    }

    public String getType() {
        return this.type;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void semPodcasters(List<Podcaster> mPodcasters) {
        this.mPodcasters = mPodcasters;
    }

    public void setChannelId(Integer channelId) {
        this.mChannelId = channelId;
    }

    public void setExpireTime(String expireTime) {
        this.mExpireTime = expireTime;
    }

    public void setPaidTime(String paidTime) {
        this.mPaidTime = paidTime;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public void setProgramCount(String programCount) {
        this.programCount = programCount;
    }

    public void setProgramIds(List<Integer> programIds) {
        this.mProgramIds = programIds;
    }

    public void setState(String state) {
        this.mState = state;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUserId(String userId) {
        this.mUserId = userId;
    }
}
