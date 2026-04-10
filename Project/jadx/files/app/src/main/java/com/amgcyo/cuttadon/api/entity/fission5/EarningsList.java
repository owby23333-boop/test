package com.amgcyo.cuttadon.api.entity.fission5;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class EarningsList implements Serializable {
    private String log_amount;
    private int log_as;
    private String log_day;
    private String log_title;

    public String getLog_amount() {
        return this.log_amount;
    }

    public int getLog_as() {
        return this.log_as;
    }

    public String getLog_day() {
        return this.log_day;
    }

    public String getLog_title() {
        return this.log_title;
    }

    public void setLog_amount(String str) {
        this.log_amount = str;
    }

    public void setLog_as(int i2) {
        this.log_as = i2;
    }

    public void setLog_day(String str) {
        this.log_day = str;
    }

    public void setLog_title(String str) {
        this.log_title = str;
    }
}
