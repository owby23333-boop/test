package com.duokan.reader.ui.store.data.cms;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class ExtraTag implements Serializable {

    @SerializedName("cate_tag")
    public CateTag cateTag;

    @SerializedName("top_tag")
    public CateTag topTag;

    public String toString() {
        return "ExtraTag{cateTag=" + this.cateTag + ", topTag=" + this.topTag + '}';
    }
}
