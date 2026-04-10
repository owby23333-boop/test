package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class NotifyBean implements Serializable {
    private String notify_content;
    private int notify_open_type;
    private int notify_tips_type;
    private String notify_url;

    public String getNotify_content() {
        return this.notify_content;
    }

    public int getNotify_open_type() {
        return this.notify_open_type;
    }

    public int getNotify_tips_type() {
        return this.notify_tips_type;
    }

    public String getNotify_url() {
        return this.notify_url;
    }

    public void setNotify_content(String str) {
        this.notify_content = str;
    }

    public void setNotify_open_type(int i2) {
        this.notify_open_type = i2;
    }

    public void setNotify_tips_type(int i2) {
        this.notify_tips_type = i2;
    }

    public void setNotify_url(String str) {
        this.notify_url = str;
    }
}
