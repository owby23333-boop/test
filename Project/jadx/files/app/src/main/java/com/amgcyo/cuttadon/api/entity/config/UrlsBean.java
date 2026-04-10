package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class UrlsBean implements Serializable {
    private String baidu_tts_url;
    private String diversion_url;
    private String domain;
    private String iflytek_tts_url;
    private String qr_code_url;
    private String website_url;

    public String getBaidu_tts_url() {
        return this.baidu_tts_url;
    }

    public String getDiversion_url() {
        return this.diversion_url;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getIflytek_tts_url() {
        return this.iflytek_tts_url;
    }

    public String getQr_code_url() {
        return this.qr_code_url;
    }

    public String getWebsite_url() {
        return this.website_url;
    }

    public void setBaidu_tts_url(String str) {
        this.baidu_tts_url = str;
    }

    public void setDiversion_url(String str) {
        this.diversion_url = str;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setIflytek_tts_url(String str) {
        this.iflytek_tts_url = str;
    }

    public void setQr_code_url(String str) {
        this.qr_code_url = str;
    }

    public void setWebsite_url(String str) {
        this.website_url = str;
    }
}
