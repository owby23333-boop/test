package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class RadioProgram extends QTEntity {

    @SerializedName("broadcasters")
    private List<Broadcaster> mBroadcasters;

    @SerializedName("channel_id")
    private Integer mChannelId;

    @SerializedName("duration")
    private Integer mDuration;

    @SerializedName("end_time")
    private String mEndTime;

    @SerializedName("program_id")
    private Integer mProgramId;

    @SerializedName("start_time")
    private String mStartTime;

    @SerializedName("title")
    private String mTitle;

    public List<Broadcaster> getBroadcasters() {
        return this.mBroadcasters;
    }

    public Integer getChannelId() {
        return this.mChannelId;
    }

    public Integer getDuration() {
        return this.mDuration;
    }

    public String getEndTime() {
        return this.mEndTime;
    }

    public Integer getProgramId() {
        return this.mProgramId;
    }

    public String getStartTime() {
        return this.mStartTime;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setBroadcasters(List<Broadcaster> broadcasters) {
        this.mBroadcasters = broadcasters;
    }

    public void setChannelId(Integer channelId) {
        this.mChannelId = channelId;
    }

    public void setDuration(Integer duration) {
        this.mDuration = duration;
    }

    public void setEndTime(String endTime) {
        this.mEndTime = endTime;
    }

    public void setProgramId(Integer programId) {
        this.mProgramId = programId;
    }

    public void setStartTime(String startTime) {
        this.mStartTime = startTime;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
}
