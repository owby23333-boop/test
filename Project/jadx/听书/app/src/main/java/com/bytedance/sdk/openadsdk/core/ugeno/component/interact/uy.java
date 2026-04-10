package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    private static boolean z(int i, int i2, int i3, int i4, float f, float f2) {
        return f >= ((float) i) && f <= ((float) (i3 + i)) && f2 >= ((float) i2) && f2 <= ((float) (i4 + i2));
    }

    public static boolean z(View view, com.bytedance.sdk.component.adexpress.dl dlVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (dlVar instanceof zw) {
                zw zwVar = (zw) dlVar;
                return z(i, i2, width, height, zwVar.z, zwVar.g);
            }
        }
        return false;
    }

    public static String z(com.bytedance.sdk.component.adexpress.dl dlVar) {
        JSONObject jSONObjectZ;
        if (!(dlVar instanceof zw) || (jSONObjectZ = ((zw) dlVar).z()) == null) {
            return null;
        }
        return jSONObjectZ.optString("ugen_id");
    }

    public static void z(na naVar, boolean z, String str, int i, Map<String, Object> map) {
        JSONObject jSONObjectZ = eo.z(map);
        if (jSONObjectZ == null) {
            jSONObjectZ = new JSONObject();
        }
        try {
            jSONObjectZ.put("success", z ? 1 : 0);
            jSONObjectZ.put("style_type", i);
            jSONObjectZ.put("style_id", str);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar, "easy_play_show", jSONObjectZ);
    }

    public static void z(na naVar, boolean z, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("area_type", z ? 1 : 2);
            jSONObject.put("style_type", i);
            jSONObject.put("style_id", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar, "easy_play_click", jSONObject);
    }
}
