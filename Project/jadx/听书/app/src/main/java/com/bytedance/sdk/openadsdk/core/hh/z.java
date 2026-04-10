package com.bytedance.sdk.openadsdk.core.hh;

import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.live.gc.g;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.hh.kb;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final int z;

    public int a() {
        return 2;
    }

    public z(int i) {
        this.z = i;
    }

    public z(int i, boolean z) {
        this.z = i;
        gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hh.z.1
            @Override // java.lang.Runnable
            public void run() {
                z.this.m();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        e.z(new fo("csj-plugin-check") { // from class: com.bytedance.sdk.openadsdk.core.hh.z.2
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.g() == 5) {
                    g.z();
                }
            }
        });
    }

    public int z(int i) {
        int i2 = this.z >> i;
        int i3 = i2 & 7;
        if (i3 == 0) {
            return a();
        }
        return ((i2 & 8) >> 3) == 1 ? -i3 : i3;
    }

    public int z() {
        return z(0);
    }

    public int g() {
        return z(4);
    }

    public int dl() {
        return z(8);
    }

    public int z(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (zw.g().fq()) {
                return g();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return dl();
        }
        if ("com.byted.pangle".equals(str)) {
            return z();
        }
        return a();
    }

    public void gc() {
        JSONObject jSONObjectGl = zw.g().gl();
        if (jSONObjectGl == null) {
            return;
        }
        try {
            z(jSONObjectGl, "com.byted.live.lite", 4, true);
            z(jSONObjectGl, "com.byted.csj.ext", 8, true);
            z(jSONObjectGl, "com.byted.mixed", 0, true);
            z(jSONObjectGl, "com.byted.pangle", 0, false);
        } catch (Throwable th) {
            wp.g("onReceiveServerStatus", th);
        }
    }

    private void z(JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        int iOptInt = jSONObjectOptJSONObject.optInt("state", 2);
        if (iOptInt == 5) {
            int iG = kb.g(str);
            int iDl = kb.dl(str);
            int iA = kb.a(str);
            if (z || iDl > iA) {
                String strOptString = jSONObjectOptJSONObject.optString("api_rule", "=");
                String strOptString2 = jSONObjectOptJSONObject.optString("plugin_rule", "=");
                int iOptInt2 = jSONObjectOptJSONObject.optInt("api_v", 0);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("plugin_v", 0);
                if (z(iG, iOptInt2, strOptString) && z(iDl, iOptInt3, strOptString2)) {
                    kb.z(str);
                    return;
                }
                return;
            }
            return;
        }
        if (iOptInt == -1 && z(i) == 5 && kb.dl(str) > kb.a(str)) {
            kb.z(str);
        }
    }

    private boolean z(int i, int i2, String str) {
        str.hashCode();
        switch (str) {
            case "<":
                return i < i2;
            case "=":
            case "==":
                return i == i2;
            case ">":
                return i > i2;
            case "<=":
                return i <= i2;
            case ">=":
                return i >= i2;
            default:
                return false;
        }
    }

    public String toString() {
        return String.valueOf(this.z);
    }
}
