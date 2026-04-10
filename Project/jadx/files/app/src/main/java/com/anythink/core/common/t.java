package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public static final String a = "t";
    private static volatile t b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, com.anythink.core.common.e.w> f7941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<com.anythink.core.common.e.w> f7942d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f7944f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7945g = 500;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f7943e = Collections.synchronizedList(new ArrayList(8));

    private t() {
    }

    public static boolean a(int i2) {
        boolean z2;
        switch (i2) {
            case com.anythink.core.common.g.g.f7499d /* -1003 */:
            case com.anythink.core.common.g.g.f7498c /* -1002 */:
            case com.anythink.core.common.g.g.b /* -1001 */:
            case -1000:
                z2 = true;
                break;
            default:
                z2 = false;
                break;
        }
        if (z2 || ((i2 < -99 || i2 >= 200) && i2 < 400)) {
            return z2;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e A[Catch: all -> 0x0046, TryCatch #0 {, blocks: (B:11:0x002a, B:13:0x002e, B:14:0x0035, B:16:0x0039, B:10:0x0027, B:3:0x0001, B:5:0x0005, B:7:0x0009), top: B:22:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[Catch: all -> 0x0046, TRY_LEAVE, TryCatch #0 {, blocks: (B:11:0x002a, B:13:0x002e, B:14:0x0035, B:16:0x0039, B:10:0x0027, B:3:0x0001, B:5:0x0005, B:7:0x0009), top: B:22:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void c() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, com.anythink.core.common.e.w> r0 = r2.f7941c     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L2a
            java.util.List<com.anythink.core.common.e.w> r0 = r2.f7942d     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L2a
            com.anythink.core.common.b.n r0 = com.anythink.core.common.b.n.a()     // Catch: java.lang.Throwable -> L26
            android.content.Context r0 = r0.g()     // Catch: java.lang.Throwable -> L26
            com.anythink.core.common.c.c r0 = com.anythink.core.common.c.c.a(r0)     // Catch: java.lang.Throwable -> L26
            com.anythink.core.common.c.i r0 = com.anythink.core.common.c.i.a(r0)     // Catch: java.lang.Throwable -> L26
            com.anythink.core.common.c.i$a r0 = r0.c()     // Catch: java.lang.Throwable -> L26
            java.util.Map<java.lang.String, com.anythink.core.common.e.w> r1 = r0.b     // Catch: java.lang.Throwable -> L26
            r2.f7941c = r1     // Catch: java.lang.Throwable -> L26
            java.util.List<com.anythink.core.common.e.w> r0 = r0.a     // Catch: java.lang.Throwable -> L26
            r2.f7942d = r0     // Catch: java.lang.Throwable -> L26
            goto L2a
        L26:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L46
        L2a:
            java.util.Map<java.lang.String, com.anythink.core.common.e.w> r0 = r2.f7941c     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto L35
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L46
            r0.<init>()     // Catch: java.lang.Throwable -> L46
            r2.f7941c = r0     // Catch: java.lang.Throwable -> L46
        L35:
            java.util.List<com.anythink.core.common.e.w> r0 = r2.f7942d     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto L44
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L46
            r0.<init>()     // Catch: java.lang.Throwable -> L46
            java.util.List r0 = java.util.Collections.synchronizedList(r0)     // Catch: java.lang.Throwable -> L46
            r2.f7942d = r0     // Catch: java.lang.Throwable -> L46
        L44:
            monitor-exit(r2)
            return
        L46:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.t.c():void");
    }

    public final synchronized void b() {
        try {
            c();
            List<com.anythink.core.common.e.w> listSynchronizedList = Collections.synchronizedList(new ArrayList(this.f7942d));
            if (listSynchronizedList != null && listSynchronizedList.size() > 0) {
                for (com.anythink.core.common.e.w wVar : listSynchronizedList) {
                    new StringBuilder("tryToReSendNoticeUrl: ").append(wVar.a());
                    a(wVar, true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static t a() {
        if (b == null) {
            synchronized (t.class) {
                if (b == null) {
                    b = new t();
                }
            }
        }
        return b;
    }

    public final synchronized void a(String str, String str2, long j2) {
        com.anythink.core.common.e.w wVar = new com.anythink.core.common.e.w();
        wVar.b = 2;
        wVar.f7384d = str;
        wVar.f7383c = str2;
        wVar.f7386f = j2;
        new StringBuilder("reSendNow: ").append(wVar.a());
        a(wVar, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.anythink.core.common.e.w wVar) {
        if (TextUtils.isEmpty(wVar.a)) {
            wVar.f7385e = System.currentTimeMillis();
            wVar.a = com.anythink.core.common.k.f.a(wVar.f7384d + wVar.f7385e);
            this.f7941c.put(wVar.a, wVar);
            this.f7942d.add(wVar);
        }
        new StringBuilder("insertOrUpdate: ").append(wVar.a());
        com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).a(wVar);
        if (this.f7942d.size() > 500) {
            com.anythink.core.common.e.w wVar2 = this.f7942d.get(0);
            new StringBuilder("insertOrUpdate,  exceeded the maximum number of records, start to delete: ").append(wVar.a());
            this.f7943e.remove(wVar.a);
            a(wVar2);
        }
    }

    private synchronized void a(final com.anythink.core.common.e.w wVar, final boolean z2) {
        if (System.currentTimeMillis() > wVar.f7386f) {
            new StringBuilder("resendNoticeUrl: do nothing because offer is out date: ").append(wVar.a());
            this.f7943e.remove(wVar.a);
            if (z2) {
                a(wVar);
            }
            return;
        }
        if (this.f7943e.contains(wVar.a)) {
            new StringBuilder("resendNoticeUrl: do nothing because it is loading... ").append(wVar.a());
            return;
        }
        this.f7943e.add(wVar.a);
        if (z2) {
            wVar.f7387g++;
            if (wVar.f7387g >= 5) {
                new StringBuilder("resendNoticeUrl: The number of retries is greater than or equal to the maximum number of retries, start deleting and continue: ").append(wVar.a());
                a(wVar);
            } else {
                b(wVar);
            }
        } else {
            wVar.f7387g++;
            if (wVar.f7387g >= 5) {
                new StringBuilder("resendNoticeUrl: The number of retries is greater than or equal to the maximum number of retries, start deleting and continue: ").append(wVar.a());
                this.f7943e.remove(wVar.a);
                return;
            }
        }
        new StringBuilder("resendNoticeUrl: start to send notice: ").append(wVar.a());
        new com.anythink.core.common.g.k(wVar).a(0, new com.anythink.core.common.g.i() { // from class: com.anythink.core.common.t.1
            @Override // com.anythink.core.common.g.i
            public final void onLoadCanceled(int i2) {
                synchronized (t.this) {
                    t.this.f7943e.remove(wVar.a);
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadError(int i2, String str, AdError adError) {
                new StringBuilder("resendNoticeUrl:  send notice failed: ").append(wVar.a());
                synchronized (t.this) {
                    t.this.f7943e.remove(wVar.a);
                    if (!z2) {
                        t.this.b(wVar);
                    }
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadFinish(int i2, Object obj) {
                new StringBuilder("resendNoticeUrl:  send notice success: ").append(wVar.a());
                synchronized (t.this) {
                    t.this.f7943e.remove(wVar.a);
                    if (z2) {
                        t.this.a(wVar);
                    }
                }
            }

            @Override // com.anythink.core.common.g.i
            public final void onLoadStart(int i2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.core.common.e.w wVar) {
        new StringBuilder("delete: ").append(wVar.a());
        this.f7941c.remove(wVar.a);
        this.f7942d.remove(wVar);
        com.anythink.core.common.c.i.a(com.anythink.core.common.c.c.a(com.anythink.core.common.b.n.a().g())).b(wVar);
    }
}
