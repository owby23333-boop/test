package com.anythink.expressad.foundation.g.f.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.anythink.expressad.foundation.h.o;
import com.taobao.accs.utl.UtilityImpl;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = "b";
    private static volatile b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConnectivityManager f10568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.anythink.expressad.foundation.g.f.c.a f10569d;

    private b() {
    }

    private static b a(Context context) {
        NetworkInfo activeNetworkInfo;
        String lowerCase;
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                    if (context != null) {
                        f10568c = (ConnectivityManager) context.getSystemService("connectivity");
                    }
                    f10569d = new com.anythink.expressad.foundation.g.f.c.a();
                    try {
                        if (f10568c != null && (activeNetworkInfo = f10568c.getActiveNetworkInfo()) != null) {
                            if (UtilityImpl.NET_TYPE_WIFI.equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US))) {
                                f10569d.f10513e = UtilityImpl.NET_TYPE_WIFI;
                                f10569d.f10512d = false;
                            } else {
                                if (activeNetworkInfo.getExtraInfo() != null && (lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase(Locale.US)) != null) {
                                    if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                                        f10569d.f10512d = true;
                                        f10569d.a = lowerCase;
                                        f10569d.b = "10.0.0.172";
                                        f10569d.f10511c = "80";
                                    } else if (lowerCase.startsWith("ctwap")) {
                                        f10569d.f10512d = true;
                                        f10569d.a = lowerCase;
                                        f10569d.b = "10.0.0.200";
                                        f10569d.f10511c = "80";
                                    } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                                        f10569d.f10512d = false;
                                        f10569d.a = lowerCase;
                                    }
                                    com.anythink.expressad.foundation.g.f.c.a aVar = f10569d;
                                    aVar.f10513e = aVar.a;
                                }
                                String defaultHost = Proxy.getDefaultHost();
                                int defaultPort = Proxy.getDefaultPort();
                                if (defaultHost == null || defaultHost.length() <= 0) {
                                    f10569d.f10512d = false;
                                } else {
                                    f10569d.b = defaultHost;
                                    if ("10.0.0.172".equals(f10569d.b.trim()) || "10.0.0.200".equals(f10569d.b.trim())) {
                                        f10569d.f10512d = true;
                                        f10569d.f10511c = "80";
                                    } else {
                                        f10569d.f10512d = false;
                                        f10569d.f10511c = Integer.toString(defaultPort);
                                    }
                                }
                                com.anythink.expressad.foundation.g.f.c.a aVar2 = f10569d;
                                aVar2.f10513e = aVar2.a;
                            }
                        }
                    } catch (Exception e2) {
                        o.d(a, e2.getMessage());
                    }
                }
            }
        }
        return b;
    }

    private static com.anythink.expressad.foundation.g.f.c.a b() {
        return f10569d;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00af A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:3:0x0002, B:6:0x0007, B:8:0x000f, B:10:0x0020, B:12:0x0029, B:15:0x0036, B:17:0x0042, B:19:0x004a, B:21:0x0052, B:24:0x005b, B:26:0x0063, B:49:0x0102, B:27:0x0075, B:29:0x007d, B:31:0x0085, B:33:0x008d, B:35:0x0095, B:36:0x009e, B:37:0x00af, B:39:0x00b9, B:41:0x00bf, B:43:0x00d1, B:44:0x00da, B:46:0x00e8, B:47:0x00f1, B:48:0x00fe), top: B:54:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a() {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.f.g.b.a():void");
    }

    private static void a(NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase(Locale.US)) != null) {
            if (!lowerCase.startsWith("cmwap") && !lowerCase.startsWith("uniwap") && !lowerCase.startsWith("3gwap")) {
                if (lowerCase.startsWith("ctwap")) {
                    com.anythink.expressad.foundation.g.f.c.a aVar = f10569d;
                    aVar.f10512d = true;
                    aVar.a = lowerCase;
                    aVar.b = "10.0.0.200";
                    aVar.f10511c = "80";
                    return;
                }
                if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                    com.anythink.expressad.foundation.g.f.c.a aVar2 = f10569d;
                    aVar2.f10512d = false;
                    aVar2.a = lowerCase;
                    return;
                }
            } else {
                com.anythink.expressad.foundation.g.f.c.a aVar3 = f10569d;
                aVar3.f10512d = true;
                aVar3.a = lowerCase;
                aVar3.b = "10.0.0.172";
                aVar3.f10511c = "80";
                return;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost != null && defaultHost.length() > 0) {
            com.anythink.expressad.foundation.g.f.c.a aVar4 = f10569d;
            aVar4.b = defaultHost;
            if ("10.0.0.172".equals(aVar4.b.trim())) {
                com.anythink.expressad.foundation.g.f.c.a aVar5 = f10569d;
                aVar5.f10512d = true;
                aVar5.f10511c = "80";
                return;
            } else if ("10.0.0.200".equals(f10569d.b.trim())) {
                com.anythink.expressad.foundation.g.f.c.a aVar6 = f10569d;
                aVar6.f10512d = true;
                aVar6.f10511c = "80";
                return;
            } else {
                com.anythink.expressad.foundation.g.f.c.a aVar7 = f10569d;
                aVar7.f10512d = false;
                aVar7.f10511c = Integer.toString(defaultPort);
                return;
            }
        }
        f10569d.f10512d = false;
    }
}
