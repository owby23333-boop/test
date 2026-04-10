package com.anythink.expressad.mbbanner.a.e;

import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.foundation.d.d;
import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final String a = "a";
    private final Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10851c;

    public final void b(final com.anythink.expressad.mbbanner.a.c.b bVar, final String str) {
        o.d(a, "postResourceFail unitId=".concat(String.valueOf(str)));
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.4
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    boolean unused = a.this.f10851c;
                    bVar2.b();
                }
            }
        });
    }

    private void a(boolean z2) {
        this.f10851c = z2;
    }

    private void a(final com.anythink.expressad.mbbanner.a.c.b bVar, final d dVar, final String str) {
        o.d(a, "postCampaignSuccess unitId=".concat(String.valueOf(str)));
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    d dVar2 = dVar;
                    boolean unused = a.this.f10851c;
                    bVar2.a(dVar2);
                }
            }
        });
    }

    public final void a(final com.anythink.expressad.mbbanner.a.c.b bVar, final String str, final String str2) {
        o.b(a, "postCampaignFail errorMsg=" + str + " unitId=" + str2);
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    String str3 = str;
                    boolean unused = a.this.f10851c;
                    bVar2.a(str3);
                }
            }
        });
    }

    public final void a(final com.anythink.expressad.mbbanner.a.c.b bVar, final String str) {
        o.d(a, "postResourceSuccess unitId=".concat(String.valueOf(str)));
        this.b.post(new Runnable() { // from class: com.anythink.expressad.mbbanner.a.e.a.3
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.mbbanner.a.c.b bVar2 = bVar;
                if (bVar2 != null) {
                    boolean unused = a.this.f10851c;
                    bVar2.a();
                }
            }
        });
    }
}
