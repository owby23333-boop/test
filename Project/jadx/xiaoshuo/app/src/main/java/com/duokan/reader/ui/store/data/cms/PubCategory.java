package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import com.iflytek.aikit.media.speech.SpeechConstant;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class PubCategory implements Serializable {

    @SerializedName(SpeechConstant.IST_SESSION_ID)
    public int categoryId;

    @SerializedName("child")
    public PubCategory child;

    @SerializedName(TTDownloadField.TT_LABEL)
    public String label;

    public String toString() {
        return "PubCategory{sid = '" + this.categoryId + "',label = '" + this.label + '\'' + l.d;
    }
}
