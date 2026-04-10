package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class PlayHistory {

    @SerializedName("channel_id")
    private Integer channelId;

    @SerializedName("channel_name")
    private String channelName;

    @SerializedName("type")
    private String channelType;

    @SerializedName("play_time")
    private String playTime;

    @SerializedName("playcount")
    private String playcount;

    @SerializedName("position")
    private Integer position;

    @SerializedName("program_id")
    private Integer programId;

    @SerializedName("program_name")
    private String programName;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("title")
    private String title;

    public Integer getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getChannelType() {
        return this.channelType;
    }

    public String getPlayTime() {
        return this.playTime;
    }

    public Integer getPosition() {
        return this.position;
    }

    public Integer getProgramId() {
        return this.programId;
    }

    public String getProgramName() {
        return this.programName;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
