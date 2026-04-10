package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class Categorie implements Serializable {

    @SerializedName("category_id")
    public int categoryId;

    @SerializedName(TTDownloadField.TT_LABEL)
    public String label;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.categoryId == ((Categorie) obj).categoryId;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.categoryId));
    }

    public String toString() {
        return "Categorie{category_id = '" + this.categoryId + "',label = '" + this.label + '\'' + l.d;
    }
}
