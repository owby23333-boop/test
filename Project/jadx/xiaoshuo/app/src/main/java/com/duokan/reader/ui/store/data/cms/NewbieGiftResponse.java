package com.duokan.reader.ui.store.data.cms;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class NewbieGiftResponse implements Serializable {

    @SerializedName("data")
    public List<NewbieGift> newbieGifts;

    @SerializedName("result")
    public int result = -1;
}
