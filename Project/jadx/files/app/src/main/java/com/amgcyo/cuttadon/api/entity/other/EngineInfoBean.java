package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class EngineInfoBean implements Serializable {
    private String btn_title;
    private String desc;
    private boolean is_baidu_tts;
    private String page_name;
    private String url;
    private String zh_cn_name;

    public EngineInfoBean() {
    }

    public String getBtn_title() {
        return this.btn_title;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getPage_name() {
        return this.page_name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getZh_cn_name() {
        return this.zh_cn_name;
    }

    public boolean isIs_baidu_tts() {
        return this.is_baidu_tts;
    }

    public void setBtn_title(String str) {
        this.btn_title = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIs_baidu_tts(boolean z2) {
        this.is_baidu_tts = z2;
    }

    public void setPage_name(String str) {
        this.page_name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setZh_cn_name(String str) {
        this.zh_cn_name = str;
    }

    public EngineInfoBean(String str, String str2, String str3, boolean z2) {
        this.zh_cn_name = str;
        this.page_name = str2;
        this.desc = str3;
        this.is_baidu_tts = z2;
    }

    public EngineInfoBean(String str, String str2, String str3, String str4, String str5) {
        this.zh_cn_name = str;
        this.page_name = str2;
        this.desc = str3;
        this.url = str4;
        this.btn_title = str5;
    }
}
