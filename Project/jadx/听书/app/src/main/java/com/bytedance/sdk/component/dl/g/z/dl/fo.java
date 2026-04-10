package com.bytedance.sdk.component.dl.g.z.dl;

import com.bytedance.sdk.component.dl.g.js;
import com.bytedance.sdk.component.dl.g.sy;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public final class fo {
    public static String z(sy syVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(syVar.g());
        sb.append(' ');
        if (g(syVar, type)) {
            sb.append(syVar.z());
        } else {
            sb.append(z(syVar.z()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean g(sy syVar, Proxy.Type type) {
        return !syVar.gz() && type == Proxy.Type.HTTP;
    }

    public static String z(js jsVar) {
        String strFo = jsVar.fo();
        try {
            String strKb = jsVar.kb();
            if (strKb != null) {
                return strFo + '?' + strKb;
            }
        } catch (OutOfMemoryError unused) {
        }
        return strFo;
    }
}
