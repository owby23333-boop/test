package com.bytedance.sdk.openadsdk.core.component.reward.gc;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.e;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static String z(String str) {
        if (!wp.dl() || TextUtils.isEmpty(str)) {
            return str;
        }
        e eVar = new e(uy.ls().hh());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = eVar.g().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append("&").append(eVar.z());
                } else {
                    sb.append("?").append(eVar.z());
                }
            }
        }
        return sb.toString();
    }
}
