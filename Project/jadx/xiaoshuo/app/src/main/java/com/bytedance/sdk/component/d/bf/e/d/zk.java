package com.bytedance.sdk.component.d.bf.e.d;

import com.bytedance.sdk.component.d.bf.k;
import com.bytedance.sdk.component.d.bf.lc;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class zk {
    private static boolean bf(lc lcVar, Proxy.Type type) {
        return !lcVar.v() && type == Proxy.Type.HTTP;
    }

    public static String e(lc lcVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(lcVar.bf());
        sb.append(' ');
        if (bf(lcVar, type)) {
            sb.append(lcVar.e());
        } else {
            sb.append(e(lcVar.e()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static String e(k kVar) {
        String strZk = kVar.zk();
        try {
            String strWu = kVar.wu();
            if (strWu == null) {
                return strZk;
            }
            return strZk + '?' + strWu;
        } catch (OutOfMemoryError unused) {
            return strZk;
        }
    }
}
