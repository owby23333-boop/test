package com.bytedance.sdk.openadsdk.core.ugeno;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.cv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class d {
    private static volatile d e;
    private com.bytedance.sdk.component.vn.e bf = cv.e("ugeno_template_file");

    private d() {
    }

    public static d e() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    public boolean bf(String str, String str2) {
        return e(str, str2) != null;
    }

    public void e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.bf.e("ugeno_" + str, str3);
        this.bf.e("ugeno__md5_" + str, str2);
    }

    public JSONObject e(String str, String str2) {
        String strBf = this.bf.bf("ugeno_" + str, "");
        if (TextUtils.isEmpty(strBf)) {
            return null;
        }
        String strBf2 = this.bf.bf("ugeno__md5_" + str, "");
        if (!TextUtils.isEmpty(strBf2) && TextUtils.equals(strBf2, str2)) {
            try {
                return new JSONObject(strBf);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}
