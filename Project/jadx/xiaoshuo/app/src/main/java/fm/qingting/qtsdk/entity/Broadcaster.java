package fm.qingting.qtsdk.entity;

import com.google.gson.annotations.SerializedName;
import com.yuewen.so2;

/* JADX INFO: loaded from: classes8.dex */
public class Broadcaster {

    @SerializedName(so2.T9)
    private String mAvatar;

    @SerializedName("nickname")
    private String mNickname;

    public String getAvatar() {
        return this.mAvatar;
    }

    public String getNickname() {
        return this.mNickname;
    }

    public void setAvatar(String avatar) {
        this.mAvatar = avatar;
    }

    public void setNickname(String nickname) {
        this.mNickname = nickname;
    }
}
