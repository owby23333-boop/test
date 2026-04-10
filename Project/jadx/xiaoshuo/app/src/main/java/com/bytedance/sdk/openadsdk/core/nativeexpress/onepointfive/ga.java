package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdSlot;
import com.bytedance.sdk.openadsdk.core.hb;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ga {
    public static int e(TTAdSlot tTAdSlot) {
        try {
            if (!e() || TextUtils.isEmpty(tTAdSlot.getMediaExtra())) {
                return 0;
            }
            JSONObject jSONObject = new JSONObject(tTAdSlot.getMediaExtra());
            if (jSONObject.has("_tt_group_load_more")) {
                return jSONObject.optInt("_tt_group_load_more");
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    public static boolean e() {
        return hb.e >= 4700;
    }
}
