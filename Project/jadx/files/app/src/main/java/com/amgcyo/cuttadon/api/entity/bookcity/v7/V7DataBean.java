package com.amgcyo.cuttadon.api.entity.bookcity.v7;

import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class V7DataBean implements Serializable {
    private int category;
    private List<ShudanListData> data;
    private int more;
    private String name;
    private int style;
    private String sub_name;

    public int getCategory() {
        return this.category;
    }

    public List<ShudanListData> getData() {
        return this.data;
    }

    public int getMore() {
        return this.more;
    }

    public String getName() {
        return this.name;
    }

    public int getStyle() {
        return this.style;
    }

    public String getSub_name() {
        return this.sub_name;
    }

    public void setCategory(int i2) {
        this.category = i2;
    }

    public void setData(List<ShudanListData> list) {
        this.data = list;
    }

    public void setMore(int i2) {
        this.more = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStyle(int i2) {
        this.style = i2;
    }

    public void setSub_name(String str) {
        this.sub_name = str;
    }
}
