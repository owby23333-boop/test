package com.bytedance.sdk.openadsdk.e;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.fo.g.a;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class dl extends z {
    public static g z;

    @Override // com.bytedance.sdk.openadsdk.e.z
    public String z() {
        return TKDownloadReason.KSAD_TK_NET;
    }

    public static String z(a aVar, String str) {
        Map map;
        g gVarZ = com.bytedance.sdk.openadsdk.core.ti.z.dl.z(TKDownloadReason.KSAD_TK_NET);
        if (gVarZ == null || (map = (Map) gVarZ.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                aVar.g(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void z(JSONObject jSONObject, int i) {
        try {
            g gVarZ = com.bytedance.sdk.openadsdk.core.ti.z.dl.z(TKDownloadReason.KSAD_TK_NET);
            if (gVarZ == null) {
                return;
            }
            String string = com.bytedance.sdk.component.utils.z.z(jSONObject.toString()).toString();
            HashMap map = new HashMap();
            map.put(TtmlNode.TAG_BODY, string);
            map.put("type", Integer.valueOf(i));
            gVarZ.call(2, map);
        } catch (Throwable unused) {
        }
    }

    public static void g(JSONObject jSONObject, int i) {
        try {
            g gVarZ = com.bytedance.sdk.openadsdk.core.ti.z.dl.z(TKDownloadReason.KSAD_TK_NET);
            if (gVarZ != null && jSONObject != null) {
                String string = com.bytedance.sdk.component.utils.z.z(jSONObject.toString()).toString();
                HashMap map = new HashMap();
                map.put(TtmlNode.TAG_BODY, string);
                map.put("type", Integer.valueOf(i));
                gVarZ.call(3, map);
            }
        } catch (Throwable unused) {
        }
    }
}
