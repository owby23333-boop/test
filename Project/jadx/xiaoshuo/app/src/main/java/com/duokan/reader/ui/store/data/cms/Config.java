package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class Config implements Serializable {

    @SerializedName("count")
    public int count;

    @SerializedName("module")
    public int module;

    @SerializedName("user_type")
    public int user_type;

    public String toString() {
        return "Config{count = '" + this.count + "',user_type = '" + this.user_type + "',module = '" + this.module + '\'' + l.d;
    }
}
