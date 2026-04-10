package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class js {
    private Map<String, z> z;

    public void z(Map<String, z> map) {
        this.z = map;
    }

    public int z(String str) {
        int iZ = z(true);
        Map<String, z> map = this.z;
        if (map != null && map.containsKey(str)) {
            z zVar = this.z.get(str);
            iZ = zVar != null ? iZ + zVar.z() : iZ + 5000;
        }
        return iZ + 5000;
    }

    public int g(String str) {
        int iZ = z(false);
        Map<String, z> map = this.z;
        if (map != null && map.containsKey(str)) {
            z zVar = this.z.get(str);
            iZ = zVar != null ? iZ + zVar.g() : iZ + 5000;
        }
        return iZ + 5000;
    }

    private int z(boolean z2) {
        float fBb;
        int iMn = 0;
        if (!com.bytedance.sdk.openadsdk.core.zw.g().jz()) {
            return 0;
        }
        double d = 0.0d;
        try {
            String strZ = com.bytedance.sdk.openadsdk.core.sy.z.z().z("DeviceRate", "bytebench_value");
            if (!TextUtils.isEmpty(strZ)) {
                double d2 = Double.parseDouble(strZ);
                if (d2 >= 0.0d) {
                    try {
                        if (d2 < com.bytedance.sdk.openadsdk.core.zw.g().by()) {
                            iMn = 0 + com.bytedance.sdk.openadsdk.core.zw.g().mn();
                        }
                    } catch (NumberFormatException e) {
                        e = e;
                        d = d2;
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
                d = d2;
            }
        } catch (NumberFormatException e2) {
            e = e2;
        }
        try {
            int i = Integer.parseInt(com.bytedance.sdk.openadsdk.core.sy.z.z().z("ugen_render", z2 ? "h5_render_success" : "native_render_success"));
            int i2 = Integer.parseInt(com.bytedance.sdk.openadsdk.core.sy.z.z().z("ugen_render", z2 ? "h5_render_fail" : "native_render_fail"));
            int i3 = i + i2;
            float f = i3 > 0 ? (i2 / i3) * 100.0f : 0.0f;
            com.bytedance.sdk.component.utils.wp.z("RenderTimeoutControl", "successCount: " + i + "failCount: " + i2 + " errorRate: " + f);
            if (z2) {
                fBb = com.bytedance.sdk.openadsdk.core.zw.g().oz();
            } else {
                fBb = com.bytedance.sdk.openadsdk.core.zw.g().bb();
            }
            if (f >= fBb) {
                iMn += com.bytedance.sdk.openadsdk.core.zw.g().mn();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isH5", z2);
            jSONObject.put("bytebenchScore", d);
            jSONObject.put("successCount", i);
            jSONObject.put("failCount", i2);
            jSONObject.put("errorRate", f);
            jSONObject.put("result", iMn);
            com.bytedance.sdk.openadsdk.core.q.v.z().gc(jSONObject);
        } catch (NumberFormatException | JSONException e3) {
            com.bytedance.sdk.component.utils.wp.z(e3);
        }
        return iMn;
    }

    public String toString() {
        if (this.z == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, z> entry : this.z.entrySet()) {
            z value = entry.getValue();
            JSONArray jSONArray = new JSONArray();
            if (value != null) {
                jSONArray.put(value.z());
                jSONArray.put(value.g());
                try {
                    jSONObject.put(entry.getKey(), jSONArray);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        }
        return jSONObject.toString();
    }

    public static js dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        js jsVar = new js();
        try {
            JSONObject jSONObject = new JSONObject(str);
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() == 2) {
                    map.put(next, new z(jSONArrayOptJSONArray.optInt(0), jSONArrayOptJSONArray.optInt(1)));
                }
            }
            jsVar.z(map);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jsVar;
    }

    static class z {
        private int g;
        private int z;

        public z(int i, int i2) {
            this.z = i;
            this.g = i2;
        }

        public z() {
        }

        public int z() {
            return this.z;
        }

        public int g() {
            return this.g;
        }
    }
}
