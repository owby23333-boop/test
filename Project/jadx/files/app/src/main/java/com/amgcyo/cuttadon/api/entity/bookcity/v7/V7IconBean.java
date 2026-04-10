package com.amgcyo.cuttadon.api.entity.bookcity.v7;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class V7IconBean implements Serializable {
    private int data_id;
    private String image;
    private String name;
    private int type_id;

    public int getData_id() {
        return this.data_id;
    }

    public String getImage() {
        return this.image;
    }

    public String getName() {
        return this.name;
    }

    public int getType_id() {
        return this.type_id;
    }

    public void setData_id(int i2) {
        this.data_id = i2;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType_id(int i2) {
        this.type_id = i2;
    }
}
