package com.duokan.reader.ui.store.data.cms;

import com.google.gson.annotations.SerializedName;
import com.yuewen.so2;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Persistent implements Serializable {

    @SerializedName("items")
    public List<RecommendAd> adItems;

    @SerializedName("result")
    public int result = -1;

    @SerializedName("count")
    public int count = 0;

    @SerializedName(so2.Tb)
    public boolean more = true;
}
