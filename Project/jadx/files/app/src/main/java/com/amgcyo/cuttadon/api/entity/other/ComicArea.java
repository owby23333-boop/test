package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ComicArea implements Serializable {
    private int area_id;
    private String area_name;

    public int getArea_id() {
        return this.area_id;
    }

    public String getArea_name() {
        return this.area_name;
    }

    public void setArea_id(int i2) {
        this.area_id = i2;
    }

    public void setArea_name(String str) {
        this.area_name = str;
    }
}
