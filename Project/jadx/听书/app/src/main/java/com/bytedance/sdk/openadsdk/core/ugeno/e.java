package com.bytedance.sdk.openadsdk.core.ugeno;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.x;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static volatile e z;
    private com.bytedance.sdk.component.a.g.dl g = x.z("ugeno_template_file");

    private e() {
    }

    public static e z() {
        if (z == null) {
            synchronized (e.class) {
                if (z == null) {
                    z = new e();
                }
            }
        }
        return z;
    }

    public void z(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.g.put("ugeno_".concat(String.valueOf(str)), str3);
        this.g.put("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject z(String str, String str2) {
        String str3 = this.g.get("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String str4 = this.g.get("ugeno__md5_".concat(String.valueOf(str)), "");
        if (!TextUtils.isEmpty(str4) && TextUtils.equals(str4, str2)) {
            try {
                return new JSONObject(str3);
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        return null;
    }

    public boolean g(String str, String str2) {
        return z(str, str2) != null;
    }
}
