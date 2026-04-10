package com.bytedance.sdk.openadsdk.core.kb.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class uy {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.fo.g.dl] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.fo.g.a] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.fo.g.gc] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void z(int i, String str, Map<String, Object> map, gc gcVar) {
        ?? Dl;
        if (i == 0) {
            Dl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    Dl.z(entry.getKey(), entry.getValue().toString());
                }
            }
        } else if (i != 1) {
            Dl = 0;
        } else {
            Dl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue().toString());
            }
            Dl.z(map2);
        }
        if (Dl != 0) {
            Dl.z(str);
            z(Dl.z(), gcVar);
        }
    }

    public static void z(String str, byte[] bArr, String str2, int i, gc gcVar) {
        if (bArr == null) {
            if (gcVar != null) {
                gcVar.z(new Exception("request data is null"));
            }
        } else {
            com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
            gcVarG.z(str);
            gcVarG.z(str2, bArr);
            z(gcVarG.z(), gcVar);
        }
    }

    private static void z(com.bytedance.sdk.component.fo.g gVar, gc gcVar) {
        String strValueOf;
        if (gVar != null && gVar.gz()) {
            if (gcVar != null) {
                gcVar.z(gVar.a());
                return;
            }
            return;
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(gVar != null && gVar.g() != null ? gVar.g() : null);
        if (gcVar != null) {
            if (zIsEmpty) {
                strValueOf = gVar.g();
            } else {
                strValueOf = gVar != null ? String.valueOf(gVar.z()) : "";
            }
            gcVar.z(new Exception(strValueOf));
        }
    }
}
