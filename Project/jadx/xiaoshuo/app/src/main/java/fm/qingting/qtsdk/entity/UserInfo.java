package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.xiaomi.onetrack.api.at;
import com.yuewen.so2;

/* JADX INFO: loaded from: classes8.dex */
public class UserInfo {

    @SerializedName("age")
    private Integer mAge;

    @SerializedName(so2.T9)
    private String mAvatar;

    @SerializedName(at.c)
    private String mBirthday;

    @SerializedName("description")
    private String mDescription;

    @SerializedName(at.f7541b)
    private String mGender;

    @SerializedName(at.e)
    private String mJob;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("user_id")
    private String mUserId;

    public Integer getAge() {
        return this.mAge;
    }

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getBirthday() {
        return this.mBirthday;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getGender() {
        return this.mGender;
    }

    public String getJob() {
        return this.mJob;
    }

    public String getNickname() {
        return this.mNickname;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public void setAge(Integer age) {
        this.mAge = age;
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

    public void setGender(String gender) {
        this.mGender = gender;
    }

    public void setJob(String job) {
        this.mJob = job;
    }

    public void setNickname(String nickname) {
        this.mNickname = nickname;
    }

    public void setUserId(String userId) {
        this.mUserId = userId;
    }
}
