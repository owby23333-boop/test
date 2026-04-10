package com.bytedance.adsdk.g;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    public static Object z(com.bytedance.adsdk.g.g.z.z zVar) {
        gz gzVarZ;
        if (zVar == null || (gzVarZ = z(zVar.z())) == null) {
            return null;
        }
        return gzVarZ.z(null, zVar.g());
    }

    public static gz z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "modArray":
                return new fo();
            case "find":
                return new m();
            case "chunk":
                return new z();
            case "exist":
                return new gc();
            case "decodeUrl":
                return new g();
            case "translate":
                return new uy();
            case "encodeUrl":
                return new a();
            case "isDigit":
                return new e();
            default:
                return null;
        }
    }
}
