package com.amgcyo.cuttadon.api.entity.migrate;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MigrateBean implements Serializable {
    private String match_format;
    private int read_time;
    private int use_count;

    public String getMatch_format() {
        return this.match_format;
    }

    public int getRead_time() {
        return this.read_time;
    }

    public int getUse_count() {
        return this.use_count;
    }

    public void setMatch_format(String str) {
        this.match_format = str;
    }

    public void setRead_time(int i2) {
        this.read_time = i2;
    }

    public void setUse_count(int i2) {
        this.use_count = i2;
    }
}
