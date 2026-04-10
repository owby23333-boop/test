package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class j {
    public static boolean a(String str) {
        return str.startsWith("market") || str.startsWith("mimarket");
    }

    public static boolean b(String str) {
        Context contextA = f.a();
        if (!TextUtils.isEmpty(str) && a(str)) {
            try {
                Intent intent = new Intent();
                intent.setData(Uri.parse(str));
                intent.setPackage("com.xiaomi.market");
                intent.addFlags(268435456);
                intent.addFlags(8388608);
                intent.addFlags(134217728);
                contextA.startActivity(intent);
                return true;
            } catch (Exception e) {
                h.a("MarketUtils", "startDownloadByMiMarket", e);
            }
        }
        return false;
    }
}
