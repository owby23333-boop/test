package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DataInfo implements Serializable {

    @SerializedName("count")
    public int count;

    @SerializedName("data")
    public List<? extends Data> datas;

    @SerializedName("total")
    public int total;

    public String toString() {
        return "Extend{count = '" + this.count + "',total = '" + this.total + "',datas = '" + this.datas + '\'' + l.d;
    }
}
