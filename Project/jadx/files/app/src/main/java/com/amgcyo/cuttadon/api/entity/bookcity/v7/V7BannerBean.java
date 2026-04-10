package com.amgcyo.cuttadon.api.entity.bookcity.v7;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class V7BannerBean implements Serializable {
    private V7BannerBeanDataBean data;
    private String image;
    private String title;
    private int type;

    public V7BannerBeanDataBean getData() {
        return this.data;
    }

    public String getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setData(V7BannerBeanDataBean v7BannerBeanDataBean) {
        this.data = v7BannerBeanDataBean;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
