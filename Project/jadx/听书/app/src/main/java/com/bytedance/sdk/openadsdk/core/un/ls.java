package com.bytedance.sdk.openadsdk.core.un;

import androidx.media3.extractor.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ls {
    public static boolean z() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectR = com.bytedance.sdk.openadsdk.core.zw.g().r();
        if (jSONObjectR == null) {
            return false;
        }
        return jCurrentTimeMillis >= jSONObjectR.optLong(TtmlNode.START, 1707480000000L) && jCurrentTimeMillis <= jSONObjectR.optLong(TtmlNode.END, 1707498000000L);
    }

    public static boolean g() {
        JSONObject jSONObjectR = com.bytedance.sdk.openadsdk.core.zw.g().r();
        return jSONObjectR != null && z() && jSONObjectR.optInt("force_drop", 0) == 1;
    }
}
