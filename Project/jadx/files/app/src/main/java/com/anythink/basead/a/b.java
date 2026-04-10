package com.anythink.basead.a;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5755c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5756d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5757e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5758f = 6;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5759g = 7;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5760h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5761i = 9;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5762j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5763k = 11;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5764l = 12;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5765m = 13;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5766n = 14;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5767o = 15;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5768p = 16;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5769q = 17;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5770r = 18;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f5771s = 19;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5772t = 20;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5773u = 21;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5774v = 22;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5775w = 23;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5776x = 24;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f5777y = 25;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f5778z = 26;

    public static boolean a(Context context, com.anythink.core.common.e.j jVar, final com.anythink.core.common.e.i iVar, com.anythink.basead.c.d dVar, String str, com.anythink.core.common.f.b bVar) {
        try {
            IExHandler iExHandlerB = n.a().b();
            String str2 = (dVar == null || TextUtils.isEmpty(dVar.f5898c)) ? "" : dVar.f5898c;
            if (iExHandlerB != null) {
                final Context applicationContext = context.getApplicationContext();
                iExHandlerB.handleOfferClick(applicationContext, jVar, iVar, str, str2, new Runnable() { // from class: com.anythink.basead.a.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (iVar instanceof aa) {
                            h.a(applicationContext).a();
                            h.a(applicationContext).a(iVar.p(), iVar);
                        }
                    }
                }, bVar);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void a(final int i2, final com.anythink.core.common.e.i iVar, @NonNull final com.anythink.basead.c.i iVar2) {
        if (iVar.L()) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.anythink.basead.a.b.2
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.e.i iVar3 = iVar;
                if (iVar3 instanceof s) {
                    s sVar = (s) iVar3;
                    boolean zA = iVar3.k() != null ? b.a(i2, iVar.k()) : false;
                    if (i2 == 8) {
                        new com.anythink.basead.g.c(sVar.P(), iVar2.a, zA).a(0, (com.anythink.core.common.g.i) null);
                    }
                    com.anythink.basead.g.b bVar = new com.anythink.basead.g.b(i2, sVar, iVar2.a);
                    bVar.b(iVar2.b);
                    bVar.a(0, (com.anythink.core.common.g.i) null);
                } else {
                    j.a(i2, (aa) iVar3, iVar2);
                }
                if (i2 == 21) {
                    com.anythink.core.common.e.i iVar4 = iVar;
                    if (iVar4 instanceof com.anythink.core.common.e.g) {
                        com.anythink.core.common.e.g gVar = (com.anythink.core.common.e.g) iVar4;
                        if (gVar.c() == 1) {
                            if (!com.anythink.core.common.k.h.a(n.a().g().getApplicationContext(), gVar.B())) {
                                StringBuilder sb = new StringBuilder("check offer installed(Apk Install Broadcast):false,dsp offerid:");
                                sb.append(gVar.U());
                                sb.append(",packagename:");
                                sb.append(gVar.B());
                                return;
                            }
                            StringBuilder sb2 = new StringBuilder("check offer installed(Apk Install Broadcast):true,dsp offerid:");
                            sb2.append(gVar.U());
                            sb2.append(",packagename:");
                            sb2.append(gVar.B());
                            com.anythink.core.common.a.b.a().c(gVar);
                        }
                    }
                }
            }
        };
        if (Looper.getMainLooper() != Looper.myLooper()) {
            runnable.run();
        } else {
            com.anythink.core.common.k.b.a.a().a(runnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(int r3, com.anythink.core.common.e.k r4) {
        /*
            r0 = 0
            r1 = 1
            if (r3 == r1) goto L25
            r2 = 2
            if (r3 == r2) goto L25
            r2 = 3
            if (r3 == r2) goto L25
            r2 = 4
            if (r3 == r2) goto L25
            r2 = 5
            if (r3 == r2) goto L25
            r2 = 8
            if (r3 == r2) goto L25
            r2 = 9
            if (r3 == r2) goto L1d
            r2 = 35
            if (r3 == r2) goto L25
            goto L2c
        L1d:
            int r3 = r4.d()
            if (r3 != r1) goto L2c
        L23:
            r0 = 1
            goto L2c
        L25:
            int r3 = r4.c()
            if (r3 != r1) goto L2c
            goto L23
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.a.b.a(int, com.anythink.core.common.e.k):boolean");
    }

    private static boolean a(com.anythink.core.common.e.i iVar, k kVar) {
        if (iVar instanceof com.anythink.core.common.e.g) {
            if (!(kVar instanceof ab) || ((ab) kVar).Y() != 1) {
                return false;
            }
        } else if (!(iVar instanceof s) || ((s) iVar).O() != 1) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, com.anythink.core.common.e.i iVar) {
        if (!TextUtils.isEmpty(iVar.z()) && com.anythink.core.basead.a.a.a(context, iVar.z(), false)) {
            return true;
        }
        if (TextUtils.isEmpty(iVar.B())) {
            return false;
        }
        return c.a(context, iVar.B());
    }

    private static void a(com.anythink.core.common.e.i iVar) {
        if (iVar instanceof com.anythink.core.common.e.g) {
            com.anythink.core.common.e.g gVar = (com.anythink.core.common.e.g) iVar;
            if (gVar.c() == 1) {
                if (com.anythink.core.common.k.h.a(n.a().g().getApplicationContext(), gVar.B())) {
                    StringBuilder sb = new StringBuilder("check offer installed(Apk Install Broadcast):true,dsp offerid:");
                    sb.append(gVar.U());
                    sb.append(",packagename:");
                    sb.append(gVar.B());
                    com.anythink.core.common.a.b.a().c(gVar);
                    return;
                }
                StringBuilder sb2 = new StringBuilder("check offer installed(Apk Install Broadcast):false,dsp offerid:");
                sb2.append(gVar.U());
                sb2.append(",packagename:");
                sb2.append(gVar.B());
            }
        }
    }
}
