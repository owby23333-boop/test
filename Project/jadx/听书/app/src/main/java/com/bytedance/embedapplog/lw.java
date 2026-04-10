package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class lw extends gp {
    lw() {
        super(true, false);
    }

    @Override // com.bytedance.embedapplog.gp
    protected boolean z(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder(16);
        if (z()) {
            sb.append("MIUI-");
        } else if (g()) {
            sb.append("FLYME-");
        } else {
            String strZ = fo.z();
            if (fo.z(strZ)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(strZ)) {
                sb.append(strZ).append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    private boolean z() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean g() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }
}
