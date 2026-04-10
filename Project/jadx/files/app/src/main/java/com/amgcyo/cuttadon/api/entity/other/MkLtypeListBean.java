package com.amgcyo.cuttadon.api.entity.other;

import androidx.annotation.NonNull;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkLtypeListBean implements Serializable {
    private int select_type;
    private int stype_id;
    private String stype_name;

    public MkLtypeListBean(int i2, String str) {
        this.stype_id = i2;
        this.stype_name = str;
    }

    public int getSelect_type() {
        return this.select_type;
    }

    public int getStype_id() {
        return this.stype_id;
    }

    public String getStype_name() {
        return this.stype_name;
    }

    public void setSelect_type(int i2) {
        this.select_type = i2;
    }

    public void setStype_id(int i2) {
        this.stype_id = i2;
    }

    public void setStype_name(String str) {
        this.stype_name = str;
    }

    @NonNull
    public String toString() {
        return "MkLtypeListBean{stype_id=" + this.stype_id + ", stype_name='" + this.stype_name + "', select_type=" + this.select_type + '}';
    }
}
