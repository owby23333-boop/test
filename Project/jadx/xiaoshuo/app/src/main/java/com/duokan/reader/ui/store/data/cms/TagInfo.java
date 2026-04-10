package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class TagInfo implements Serializable {

    @SerializedName("sub")
    public String subName;

    @SerializedName("id")
    public String tagId;

    @SerializedName("name")
    public String tagName;

    public String toString() {
        return "TagInfo{id = '" + this.tagId + "',name = '" + this.tagName + "',sub = '" + this.subName + '\'' + l.d;
    }
}
