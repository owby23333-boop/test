package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class MkAdBean implements Serializable {
    private String ad_end_datetime;
    private int ad_state;
    private int ad_style;
    private String ad_tips;
    private String message;
    private String serv_datetime;
    private int status;
    private boolean success;

    public MkAdBean(int i2, int i3, String str, String str2, String str3) {
        this.ad_style = i2;
        this.ad_state = i3;
        this.serv_datetime = str;
        this.ad_end_datetime = str2;
        this.ad_tips = str3;
    }

    public String getAd_end_datetime() {
        return this.ad_end_datetime;
    }

    public int getAd_state() {
        return this.ad_state;
    }

    public int getAd_style() {
        return this.ad_style;
    }

    public String getAd_tips() {
        return this.ad_tips;
    }

    public String getMessage() {
        return this.message;
    }

    public String getServ_datetime() {
        return this.serv_datetime;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAd_end_datetime(String str) {
        this.ad_end_datetime = str;
    }

    public void setAd_state(int i2) {
        this.ad_state = i2;
    }

    public void setAd_style(int i2) {
        this.ad_style = i2;
    }

    public void setAd_tips(String str) {
        this.ad_tips = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setServ_datetime(String str) {
        this.serv_datetime = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setSuccess(boolean z2) {
        this.success = z2;
    }

    @NotNull
    public String toString() {
        return "MkAdBean{ad_style=" + this.ad_style + ", ad_state=" + this.ad_state + ", serv_datetime='" + this.serv_datetime + "', ad_end_datetime='" + this.ad_end_datetime + "', success='" + this.success + "', message='" + this.message + "', ad_tips='" + this.ad_tips + "', status=" + this.status + '}';
    }

    public MkAdBean() {
    }

    public MkAdBean(boolean z2) {
        this.success = z2;
    }
}
