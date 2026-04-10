package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.zeus.landingpage.sdk.activity.WebViewActivity;
import com.yuewen.rr3;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static boolean a(String str, boolean z, int i) {
        Intent uri;
        boolean z2 = true;
        if (!(f.f7197a != null)) {
            h.b("LandingPageUtils", "sdk not initSuccess");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            h.b("LandingPageUtils", "url is empty");
            return false;
        }
        try {
            h.a("LandingPageUtils", "url=", str, ",   showTopBar=", z + ",orientation=" + i);
            if (TextUtils.isEmpty(str) || (!str.startsWith("http") && !str.startsWith("https"))) {
                z2 = false;
            }
            if (z2) {
                h.a("LandingPageUtils", "startWebViewActivity");
                return b(str, z, i);
            }
            if (j.a(str)) {
                h.a("LandingPageUtils", "startByMiMarket");
                return j.b(str);
            }
            h.a("LandingPageUtils", "openDeepLink");
            if (TextUtils.isEmpty(str)) {
                uri = null;
            } else {
                try {
                    uri = Intent.parseUri(str, 0);
                } catch (Exception e) {
                    h.a("LandingPageUtils", "openDeepLink e:", e);
                    uri = null;
                }
            }
            if (uri == null) {
                return false;
            }
            uri.addFlags(268435456);
            uri.setComponent(null);
            uri.setSelector(null);
            return a(uri);
        } catch (Exception e2) {
            h.a("LandingPageUtils", "land Exception:", e2);
            return false;
        }
    }

    public static boolean b(String str, boolean z, int i) {
        try {
            Context contextA = f.a();
            Intent intent = new Intent(contextA, (Class<?>) WebViewActivity.class);
            intent.setFlags(268435456);
            Bundle bundle = new Bundle();
            bundle.putString(rr3.i, str);
            bundle.putBoolean("key_show_top_bar", z);
            bundle.putInt("key_orientation", i);
            intent.putExtras(bundle);
            contextA.startActivity(intent);
            return true;
        } catch (Exception e) {
            h.a("LandingPageUtils", "startWebViewActivity e:", e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[LOOP:1: B:29:0x007e->B:83:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Intent r15) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.miui.zeus.landingpage.sdk.g.a(android.content.Intent):boolean");
    }
}
