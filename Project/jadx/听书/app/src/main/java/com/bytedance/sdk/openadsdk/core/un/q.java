package com.bytedance.sdk.openadsdk.core.un;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static void z(final Uri uri, final com.bytedance.sdk.openadsdk.core.mc mcVar) {
        if (mcVar == null || !mcVar.z(uri)) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.q.1
                @Override // java.lang.Runnable
                public void run() {
                    mcVar.g(uri);
                }
            });
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.g("WebView", "TTAndroidObj handleUri exception: ".concat(String.valueOf(e)));
        }
    }

    public static void z(final com.bytedance.sdk.component.i.dl dlVar, final int i, final boolean z) {
        if (dlVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.q.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = dlVar.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/").append(i);
                if (z) {
                    sb.append("/").append(eo.fo());
                }
                dlVar.setUserAgentString(sb.toString());
            }
        });
    }
}
