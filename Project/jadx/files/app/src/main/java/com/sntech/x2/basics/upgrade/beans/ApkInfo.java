package com.sntech.x2.basics.upgrade.beans;

import androidx.annotation.Keep;
import y.b;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class ApkInfo {

    @Keep
    public String cancelBtn;

    @Keep
    public String confirmBtn;

    @Keep
    public String downloadURL;

    @Keep
    public Integer flag;

    @Keep
    public String md5;

    @Keep
    public String text;

    @Keep
    public String title;

    @Keep
    public Integer versionCode;

    @Keep
    public String versionName;

    public String getCancelBtn() {
        return this.cancelBtn;
    }

    public String getConfirmBtn() {
        return this.confirmBtn;
    }

    public String getDownloadURL() {
        return this.downloadURL;
    }

    public Integer getFlag() {
        return this.flag;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getText() {
        return this.text;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean hasUpgrade() {
        return this.flag.intValue() != 0;
    }

    public boolean isForceUpgrade() {
        return this.flag.intValue() == 1;
    }

    public void setCancelBtn(String str) {
        this.cancelBtn = str;
    }

    public void setConfirmBtn(String str) {
        this.confirmBtn = str;
    }

    public void setDownloadURL(String str) {
        this.downloadURL = str;
    }

    public void setFlag(Integer num) {
        this.flag = num;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVersionCode(Integer num) {
        this.versionCode = num;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        StringBuilder sbA = b.a("ApkInfo{versionCode=");
        sbA.append(this.versionCode);
        sbA.append(", versionName='");
        sbA.append(this.versionName);
        sbA.append('\'');
        sbA.append(", downloadURL='");
        sbA.append(this.downloadURL);
        sbA.append('\'');
        sbA.append(", flag=");
        sbA.append(this.flag);
        sbA.append(", title='");
        sbA.append(this.title);
        sbA.append('\'');
        sbA.append(", text='");
        sbA.append(this.text);
        sbA.append('\'');
        sbA.append(", confirmBtn='");
        sbA.append(this.confirmBtn);
        sbA.append('\'');
        sbA.append(", cancelBtn='");
        sbA.append(this.cancelBtn);
        sbA.append('\'');
        sbA.append(", md5='");
        sbA.append(this.md5);
        sbA.append('\'');
        sbA.append('}');
        return sbA.toString();
    }
}
