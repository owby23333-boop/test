package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.bookcity.v7.V7BannerBean;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BookCityHeaderData implements Serializable {
    private List<V7BannerBean> banner;
    private String sex;

    public List<V7BannerBean> getBanner() {
        return this.banner;
    }

    public String getSex() {
        return this.sex;
    }

    public void setBanner(List<V7BannerBean> list) {
        this.banner = list;
    }

    public void setSex(String str) {
        this.sex = str;
    }
}
