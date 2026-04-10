package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ScheduleBean implements Serializable {
    private String datetime;
    private String title;

    public String getDatetime() {
        return this.datetime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDatetime(String str) {
        this.datetime = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
