package com.xiaomi.accountsdk.account.data;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceModelInfo {
    private String mDefaultDeviceName;
    private String mImageUrl;
    private String mModel;
    private String mModelName;

    public DeviceModelInfo(String str) {
        this.mModel = str;
    }

    public String getDefaultDeviceName() {
        return this.mDefaultDeviceName;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public String getModel() {
        return this.mModel;
    }

    public String getModelName() {
        return this.mModelName;
    }

    public void setDefaultDeviceName(String str) {
        this.mDefaultDeviceName = str;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public void setModelName(String str) {
        this.mModelName = str;
    }
}
