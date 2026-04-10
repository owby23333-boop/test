package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.IntentFilter;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class k {
    public static ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>();
    public static k f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f7205b;
    public boolean c = false;
    public HashMap<String, e> d = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7204a = f.a();

    public static k a() {
        if (f == null) {
            synchronized (k.class) {
                if (f == null) {
                    f = new k();
                }
            }
        }
        return f;
    }

    public void b(DownloadListener downloadListener) {
        h.a("MiMarketHelper", "unRegisterDownloadListener");
        try {
            i iVar = this.f7205b;
            if (iVar != null) {
                iVar.f7201a.remove(downloadListener);
            }
        } catch (Exception e2) {
            h.a("MiMarketHelper", "unRegisterDownloadListener", e2);
        }
    }

    public void a(DownloadListener downloadListener) {
        h.a("MiMarketHelper", "registerDownloadListener");
        if (!this.c) {
            h.a("MiMarketHelper", "registerMarketReceiver");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT");
            i iVar = new i();
            this.f7205b = iVar;
            this.f7204a.registerReceiver(iVar, intentFilter, 2);
            this.c = true;
            if (b.f7190b == null) {
                synchronized (b.class) {
                    if (b.f7190b == null) {
                        b.f7190b = new b();
                    }
                }
            }
            b bVar = b.f7190b;
            bVar.getClass();
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter2.addDataScheme("package");
            f.a().registerReceiver(bVar.f7191a, intentFilter2, null, f.b(), 2);
        }
        i iVar2 = this.f7205b;
        iVar2.getClass();
        if (downloadListener == null) {
            return;
        }
        iVar2.f7201a.add(downloadListener);
    }
}
