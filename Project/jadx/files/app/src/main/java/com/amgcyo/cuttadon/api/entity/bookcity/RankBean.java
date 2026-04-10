package com.amgcyo.cuttadon.api.entity.bookcity;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RankBean implements Serializable {
    private List<MkBook> data;
    private String name;
    private String sub_name;

    public RankBean(String str, String str2, List<MkBook> list) {
        this.name = str;
        this.sub_name = str2;
        this.data = list;
    }

    public List<MkBook> getData() {
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public String getSub_name() {
        return this.sub_name;
    }

    public void setData(List<MkBook> list) {
        this.data = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSub_name(String str) {
        this.sub_name = str;
    }

    public RankBean() {
    }
}
