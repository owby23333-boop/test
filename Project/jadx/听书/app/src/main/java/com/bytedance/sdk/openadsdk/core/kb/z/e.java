package com.bytedance.sdk.openadsdk.core.kb.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.fo.g.dl] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.fo.g.a] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.fo.g.gc] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void execute(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
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
            callback(Dl.z(), iTTHttpCallback);
        }
    }

    public static void postBody(String str, byte[] bArr, String str2, int i, ITTHttpCallback iTTHttpCallback) {
        if (bArr == null) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception("request data is null"));
            }
        } else {
            com.bytedance.sdk.component.fo.g.gc gcVarG = com.bytedance.sdk.openadsdk.core.io.gc.z().g().g();
            gcVarG.z(str);
            gcVarG.z(str2, bArr);
            callback(gcVarG.z(), iTTHttpCallback);
        }
    }

    private static void callback(com.bytedance.sdk.component.fo.g gVar, ITTHttpCallback iTTHttpCallback) {
        String strValueOf;
        if (gVar != null && gVar.gz()) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onResponse(gVar.a());
                return;
            }
            return;
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(gVar != null && gVar.g() != null ? gVar.g() : null);
        if (iTTHttpCallback != null) {
            if (zIsEmpty) {
                strValueOf = gVar.g();
            } else {
                strValueOf = gVar != null ? String.valueOf(gVar.z()) : "";
            }
            iTTHttpCallback.onError(new Exception(strValueOf));
        }
    }
}
