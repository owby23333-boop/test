package fm.qingting.qtsdk.entity;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import fm.qingting.qtsdk.QTConstant;

/* JADX INFO: loaded from: classes8.dex */
public class UserToken extends QTEntity {

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("expires_in")
    private Integer mExpiresIn;
    private Long mExpiresTime;

    @SerializedName(QTConstant.REFRESH_TOKEN)
    private String mRefreshToken;

    @SerializedName("token_type")
    private String mTokenType;

    @SerializedName("user_id")
    private String mUserId;

    public static UserToken fromJson(String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        return (UserToken) new Gson().fromJson(json, UserToken.class);
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public Integer getExpiresIn() {
        return this.mExpiresIn;
    }

    public Long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public boolean isExperied() {
        return this.mExpiresTime == null || System.currentTimeMillis() > this.mExpiresTime.longValue();
    }

    public void setAccessToken(String accessToken) {
        this.mAccessToken = accessToken;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.mExpiresIn = expiresIn;
    }

    public void setExpiresTime(Long mExpiresTime) {
        this.mExpiresTime = mExpiresTime;
    }

    public void setRefreshToken(String refreshToken) {
        this.mRefreshToken = refreshToken;
    }

    public void setTokenType(String tokenType) {
        this.mTokenType = tokenType;
    }

    public void setUserId(String userId) {
        this.mUserId = userId;
    }

    public String toJsonString() {
        return new Gson().toJson(this);
    }
}
