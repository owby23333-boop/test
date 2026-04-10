package com.miui.zeus.landingpage.sdk;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class n {
    public static boolean a(String str) {
        try {
            Uri uri = Uri.parse(str);
            if (TextUtils.equals(uri.getScheme(), "https")) {
                String host = uri.getHost();
                if (!TextUtils.isEmpty(host)) {
                    if (!host.endsWith("site.e.mi.com") && !host.endsWith("staging-site.e.mi.com")) {
                        if (!host.endsWith("lite.a.market.xiaomi.com")) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            h.a("UrlUtils", "checkUrl", e);
        }
        return false;
    }
}
