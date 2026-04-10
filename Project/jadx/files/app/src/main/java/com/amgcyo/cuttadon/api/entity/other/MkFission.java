package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MkFission implements Serializable {
    private String menu_remark;
    private String menu_title;
    private String page_url;

    public String getMenu_remark() {
        return this.menu_remark;
    }

    public String getMenu_title() {
        return this.menu_title;
    }

    public String getPage_url() {
        return this.page_url;
    }

    public void setMenu_remark(String str) {
        this.menu_remark = str;
    }

    public void setMenu_title(String str) {
        this.menu_title = str;
    }

    public void setPage_url(String str) {
        this.page_url = str;
    }
}
