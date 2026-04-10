package com.funny.audio.models;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003Jc\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!¨\u00063"}, d2 = {"Lcom/funny/audio/models/UserInfo;", "", "id", "", NotificationCompat.CATEGORY_EMAIL, "nickname", "avatarPath", "deviceId", "sex", "", "phone", NotificationCompat.CATEGORY_STATUS, "account", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getAccount", "()Ljava/lang/String;", "setAccount", "(Ljava/lang/String;)V", "getAvatarPath", "setAvatarPath", "getDeviceId", "setDeviceId", "getEmail", "setEmail", "getId", "setId", "getNickname", "setNickname", "getPhone", "setPhone", "getSex", "()I", "setSex", "(I)V", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserInfo {

    @SerializedName("account")
    private String account;

    @SerializedName("avatarPath")
    private String avatarPath;

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName(NotificationCompat.CATEGORY_EMAIL)
    private String email;

    @SerializedName("id")
    private String id;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("phone")
    private String phone;

    @SerializedName("sex")
    private int sex;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private int status;

    public UserInfo() {
        this(null, null, null, null, null, 0, null, 0, null, 511, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAvatarPath() {
        return this.avatarPath;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAccount() {
        return this.account;
    }

    public final UserInfo copy(String id, String email, String nickname, String avatarPath, String deviceId, int sex, String phone, int status, String account) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(account, "account");
        return new UserInfo(id, email, nickname, avatarPath, deviceId, sex, phone, status, account);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.id, userInfo.id) && Intrinsics.areEqual(this.email, userInfo.email) && Intrinsics.areEqual(this.nickname, userInfo.nickname) && Intrinsics.areEqual(this.avatarPath, userInfo.avatarPath) && Intrinsics.areEqual(this.deviceId, userInfo.deviceId) && this.sex == userInfo.sex && Intrinsics.areEqual(this.phone, userInfo.phone) && this.status == userInfo.status && Intrinsics.areEqual(this.account, userInfo.account);
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + this.email.hashCode()) * 31) + this.nickname.hashCode()) * 31) + this.avatarPath.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + Integer.hashCode(this.sex)) * 31) + this.phone.hashCode()) * 31) + Integer.hashCode(this.status)) * 31) + this.account.hashCode();
    }

    public String toString() {
        return "UserInfo(id=" + this.id + ", email=" + this.email + ", nickname=" + this.nickname + ", avatarPath=" + this.avatarPath + ", deviceId=" + this.deviceId + ", sex=" + this.sex + ", phone=" + this.phone + ", status=" + this.status + ", account=" + this.account + ")";
    }

    public UserInfo(String id, String email, String nickname, String avatarPath, String deviceId, int i, String phone, int i2, String account) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(account, "account");
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.avatarPath = avatarPath;
        this.deviceId = deviceId;
        this.sex = i;
        this.phone = phone;
        this.status = i2;
        this.account = account;
    }

    public /* synthetic */ UserInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, int i2, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? "" : str6, (i3 & 128) == 0 ? i2 : 0, (i3 & 256) == 0 ? str7 : "");
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.email = str;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final String getAvatarPath() {
        return this.avatarPath;
    }

    public final void setAvatarPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.avatarPath = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceId = str;
    }

    public final int getSex() {
        return this.sex;
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.phone = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final String getAccount() {
        return this.account;
    }

    public final void setAccount(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.account = str;
    }
}
