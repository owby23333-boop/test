package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.google.gson.annotations.SerializedName;
import com.yuewen.so2;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ElegantRecommendResponse implements Serializable {

    @SerializedName("items")
    public List<? extends ElegantCard> cards;

    @SerializedName("count")
    public int count;

    @SerializedName(so2.Tb)
    public Boolean hasMore;

    @SerializedName("result")
    public int result;

    @SerializedName("sub_title")
    public String subTitle;

    @SerializedName("title")
    public String title;

    @SerializedName("total")
    public int total;

    public boolean isSuccess() {
        return this.result == 0;
    }

    public String toString() {
        return "Extend{count = '" + this.count + "',total = '" + this.total + "',items = '" + this.cards + '\'' + l.d;
    }
}
