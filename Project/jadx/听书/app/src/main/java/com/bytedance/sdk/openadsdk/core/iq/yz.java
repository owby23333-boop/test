package com.bytedance.sdk.openadsdk.core.iq;

import android.os.Build;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class yz {
    public static int dl = 1;
    public static int g;
    public static int z;

    public static void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("ugen_image_load_config")) == null) {
            return;
        }
        z = jSONObjectOptJSONObject.optInt("api", 0);
        g = jSONObjectOptJSONObject.optInt("size_limit", 0);
        dl = jSONObjectOptJSONObject.optInt("zip_level", 1);
    }

    public static int z(int i, int i2) {
        if (z <= 0 || Build.VERSION.SDK_INT > z || i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = g;
        if (i >= i3 || i2 >= i3) {
            return Math.max(1, dl);
        }
        return 1;
    }
}
