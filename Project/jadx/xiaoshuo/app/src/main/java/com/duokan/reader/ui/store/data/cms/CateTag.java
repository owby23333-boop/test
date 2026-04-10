package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class CateTag implements Serializable {

    @SerializedName("tag")
    public String tag;

    @SerializedName("url")
    public String url;

    public String toString() {
        return "Categorie{url = '" + this.url + "',tag = '" + this.tag + '\'' + l.d;
    }
}
