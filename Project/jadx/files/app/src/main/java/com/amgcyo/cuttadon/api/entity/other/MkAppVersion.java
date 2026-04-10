package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MkAppVersion implements Serializable {
    private String apk_size;
    private String content;
    private String download_url;
    private String md5_key;
    private String privacy_url;
    private int update_state;
    private int version;
    private ArrayList<Integer> version_data;
    private String version_name;

    public String getApk_size() {
        return this.apk_size;
    }

    public String getContent() {
        return this.content;
    }

    public String getDownload_url() {
        return this.download_url;
    }

    public String getMd5_key() {
        return this.md5_key;
    }

    public String getPrivacy_url() {
        return this.privacy_url;
    }

    public int getUpdate_state() {
        return this.update_state;
    }

    public int getVersion() {
        return this.version;
    }

    public ArrayList<Integer> getVersion_data() {
        return this.version_data;
    }

    public String getVersion_name() {
        return this.version_name;
    }

    public void setApk_size(String str) {
        this.apk_size = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDownload_url(String str) {
        this.download_url = str;
    }

    public void setMd5_key(String str) {
        this.md5_key = str;
    }

    public void setPrivacy_url(String str) {
        this.privacy_url = str;
    }

    public void setUpdate_state(int i2) {
        this.update_state = i2;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }

    public void setVersion_data(ArrayList<Integer> arrayList) {
        this.version_data = arrayList;
    }

    public void setVersion_name(String str) {
        this.version_name = str;
    }

    public String toString() {
        return "MkAppVersion{version=" + this.version + ", version_name='" + this.version_name + "', download_url='" + this.download_url + "', content='" + this.content + "', update_state=" + this.update_state + ", apk_size='" + this.apk_size + "'}";
    }
}
