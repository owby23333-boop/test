package com.ss.android.downloadlib.addownload.z;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class g {
    g() {
    }

    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.g.z> z(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.g.z> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = com.bytedance.sdk.openadsdk.ats.a.z(wp.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.ss.android.downloadlib.addownload.g.z zVarZ = com.ss.android.downloadlib.addownload.g.z.z(jSONObject.optJSONObject(itKeys.next()));
                    if (zVarZ != null) {
                        copyOnWriteArrayList.add(zVarZ);
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return copyOnWriteArrayList;
    }

    void z(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.g.z> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.ss.android.downloadlib.addownload.g.z zVar : copyOnWriteArrayList) {
                if (zVar != null) {
                    jSONObject.put(String.valueOf(zVar.g), zVar.z());
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.bytedance.sdk.openadsdk.ats.a.z(wp.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    void g(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.sdk.openadsdk.ats.a.z(wp.getContext(), str, 0).edit().putString(str2, "").apply();
    }
}
