package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SdkErrorBean implements Serializable {
    private String adPosition;
    private String appId;
    private String codeId;
    private int errorCode;
    private String errorMsg;
    private String platform;
    private String saveTime;

    public SdkErrorBean(int i2, String str, String str2, String str3) {
        this.errorCode = i2;
        this.errorMsg = str;
        this.adPosition = str2;
        this.codeId = str3;
    }

    public String getAdPosition() {
        return this.adPosition;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getSaveTime() {
        return this.saveTime;
    }

    public void setAdPosition(String str) {
        this.adPosition = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setSaveTime(String str) {
        this.saveTime = str;
    }

    public String toString() {
        return "SdkErrorBean{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "', adPosition='" + this.adPosition + "', codeId='" + this.codeId + "', platform='" + this.platform + "', appId='" + this.appId + "'}";
    }

    public SdkErrorBean() {
    }
}
