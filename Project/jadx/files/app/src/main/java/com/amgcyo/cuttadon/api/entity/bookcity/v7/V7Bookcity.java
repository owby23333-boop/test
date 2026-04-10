package com.amgcyo.cuttadon.api.entity.bookcity.v7;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class V7Bookcity implements Serializable {
    private List<V7BannerBean> banner;
    private List<V7DataBean> data;
    private List<V7IconBean> icon;

    public List<V7BannerBean> getBanner() {
        return this.banner;
    }

    public List<V7DataBean> getData() {
        return this.data;
    }

    public List<V7IconBean> getIcon() {
        return this.icon;
    }

    public void setBanner(List<V7BannerBean> list) {
        this.banner = list;
    }

    public void setData(List<V7DataBean> list) {
        this.data = list;
    }

    public void setIcon(List<V7IconBean> list) {
        this.icon = list;
    }
}
