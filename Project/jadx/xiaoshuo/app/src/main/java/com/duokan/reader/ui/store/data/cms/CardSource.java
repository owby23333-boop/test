package com.duokan.reader.ui.store.data.cms;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class CardSource implements Serializable {

    @SerializedName("is_change")
    public int isChange;

    @SerializedName("source_id")
    public String sourceId;

    @SerializedName("zt_item_type")
    public String ztItemType;

    public String toString() {
        return "CardSource{sourceId=" + this.sourceId + ", isChange=" + this.isChange + ", ztItemType=" + this.ztItemType + '}';
    }
}
