package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.xiaomi.onetrack.api.at;
import com.yuewen.so2;

/* JADX INFO: loaded from: classes8.dex */
public class Podcaster {

    @SerializedName(so2.T9)
    private String mAvatar;

    @SerializedName(at.c)
    private String mBirthday;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("fan_num")
    private Integer mFanNum;

    @SerializedName(at.f7541b)
    private String mGender;

    @SerializedName("location")
    private String mLocation;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("podcaster_id")
    private String mPodcasterId;

    @SerializedName("signature")
    private String mSignature;

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getBirthday() {
        return this.mBirthday;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Integer getFanNum() {
        return this.mFanNum;
    }

    public String getGender() {
        return this.mGender;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public String getNickname() {
        return this.mNickname;
    }

    public String getPodcasterId() {
        return this.mPodcasterId;
    }

    public String getSignature() {
        return this.mSignature;
    }

    public void setAvatar(String avatar) {
        this.mAvatar = avatar;
    }

    public void setBirthday(String birthday) {
        this.mBirthday = birthday;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public void setFanNum(Integer fanNum) {
        this.mFanNum = fanNum;
    }

    public void setGender(String gender) {
        this.mGender = gender;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }

    public void setNickname(String nickname) {
        this.mNickname = nickname;
    }

    public void setPodcasterId(String podcasterId) {
        this.mPodcasterId = podcasterId;
    }

    public void setSignature(String signature) {
        this.mSignature = signature;
    }
}
