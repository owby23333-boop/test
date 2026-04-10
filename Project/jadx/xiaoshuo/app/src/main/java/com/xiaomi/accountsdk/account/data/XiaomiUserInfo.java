package com.xiaomi.accountsdk.account.data;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class XiaomiUserInfo {
    private Bitmap mAvatar;
    private String mAvatarAddress;
    private String mEmail;
    private String mNickName;
    private String mPhone;
    private ArrayList<String> mPhoneList;
    private String mUserId;
    private String mUserName;

    public XiaomiUserInfo(String str) {
        this.mUserId = str;
    }

    public Bitmap getAvatar() {
        return this.mAvatar;
    }

    public String getAvatarAddress() {
        return this.mAvatarAddress;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getNickName() {
        return this.mNickName;
    }

    public String getPhone() {
        return this.mPhone;
    }

    public ArrayList<String> getPhoneList() {
        return this.mPhoneList;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public void setAvatar(Bitmap bitmap) {
        this.mAvatar = bitmap;
    }

    public void setAvatarAddress(String str) {
        this.mAvatarAddress = str;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public void setNickName(String str) {
        this.mNickName = str;
    }

    public void setPhone(String str) {
        this.mPhone = str;
    }

    public void setPhoneList(ArrayList<String> arrayList) {
        this.mPhoneList = arrayList;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public XiaomiUserInfo(String str, XiaomiUserCoreInfo xiaomiUserCoreInfo) {
        this.mUserId = str;
        if (xiaomiUserCoreInfo != null) {
            this.mUserName = xiaomiUserCoreInfo.userName;
            this.mNickName = xiaomiUserCoreInfo.nickName;
            this.mAvatarAddress = xiaomiUserCoreInfo.avatarAddress;
            this.mPhone = xiaomiUserCoreInfo.safePhone;
            this.mPhoneList = xiaomiUserCoreInfo.phoneList;
            this.mEmail = xiaomiUserCoreInfo.emailAddress;
        }
    }
}
