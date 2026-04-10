package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7BannerBeanDataBean;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BannerBean implements Serializable {
    private int button;
    private V7BannerBeanDataBean data;
    private String image;
    private String img;
    private String title;
    private int type;

    public int getButton() {
        return this.button;
    }

    public V7BannerBeanDataBean getData() {
        return this.data;
    }

    public String getImage() {
        return this.image;
    }

    public String getImg() {
        return this.img;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void setButton(int i2) {
        this.button = i2;
    }

    public void setData(V7BannerBeanDataBean v7BannerBeanDataBean) {
        this.data = v7BannerBeanDataBean;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public String toString() {
        return "BannerBean{title='" + this.title + "', image='" + this.image + "', type=" + this.type + ", data=" + this.data + '}';
    }
}
