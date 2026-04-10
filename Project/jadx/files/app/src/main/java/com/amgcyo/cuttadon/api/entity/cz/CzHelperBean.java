package com.amgcyo.cuttadon.api.entity.cz;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class CzHelperBean implements Serializable {
    private String remark;
    private String title;

    public String getRemark() {
        return this.remark;
    }

    public String getTitle() {
        return this.title;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
