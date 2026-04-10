package com.duokan.reader.ui.store.newstore.data;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.reader.ui.store.data.cms.Data;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class HotCategoryData extends Data {

    @SerializedName("item_id")
    public int itemId;

    @SerializedName("item_type")
    public int itemType;

    @SerializedName(TTDownloadField.TT_LABEL)
    public String label;
}
