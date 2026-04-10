package com.anythink.expressad.splash.d;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.out.e;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.anythink.expressad.splash.b.d {
    private static final String a = "SplashShowListenerImpl";
    private e b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.anythink.expressad.foundation.d.c f11346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f11348e;

    public d(c cVar, e eVar, double d2, com.anythink.expressad.foundation.d.c cVar2) {
        this.f11348e = cVar;
        this.b = eVar;
        this.f11346c = cVar2;
        this.f11347d = a(d2, cVar2);
    }

    private static void d() {
    }

    private static void e() {
    }

    private void f() {
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a() {
        c cVar = this.f11348e;
        if (cVar != null) {
            cVar.a = true;
        }
        StringBuffer stringBuffer = new StringBuffer("load_to=");
        stringBuffer.append(this.f11348e.c());
        stringBuffer.append("&allow_skip=");
        stringBuffer.append(this.f11348e.d() ? 1 : 0);
        stringBuffer.append("&countdown=");
        stringBuffer.append(this.f11348e.e());
        stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        e eVar = this.b;
        if (eVar == null || this.f11347d) {
            return;
        }
        eVar.a();
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void b() {
        e eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
        c cVar = this.f11348e;
        if (cVar != null) {
            cVar.a = false;
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void c() {
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a(String str) {
        c cVar = this.f11348e;
        if (cVar != null) {
            cVar.a = false;
        }
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    @Override // com.anythink.expressad.splash.b.d
    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        e eVar = this.b;
        if (eVar == null || this.f11347d) {
            return;
        }
        eVar.a(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(double r11, com.anythink.expressad.foundation.d.c r13) {
        /*
            java.lang.String r0 = "SplashShowListenerImpl"
            r1 = 0
            com.anythink.expressad.foundation.b.a r2 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Exception -> L9e
            java.lang.String r2 = r2.e()     // Catch: java.lang.Exception -> L9e
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L9e
            r3 = 0
            if (r2 != 0) goto L2e
            com.anythink.expressad.d.b.a()     // Catch: java.lang.Exception -> L9e
            com.anythink.expressad.d.a r2 = com.anythink.expressad.d.b.b()     // Catch: java.lang.Exception -> L9e
            if (r2 == 0) goto L2e
            long r3 = r2.l()     // Catch: java.lang.Exception -> L9e
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            long r7 = r2.x()     // Catch: java.lang.Exception -> L9e
            long r5 = r5 * r7
            r9 = r3
            r3 = r5
            r5 = r9
            goto L2f
        L2e:
            r5 = r3
        L2f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e
            java.lang.String r7 = "cbp : "
            r2.<init>(r7)     // Catch: java.lang.Exception -> L9e
            r2.append(r11)     // Catch: java.lang.Exception -> L9e
            java.lang.String r7 = " plct : "
            r2.append(r7)     // Catch: java.lang.Exception -> L9e
            r2.append(r3)     // Catch: java.lang.Exception -> L9e
            java.lang.String r7 = " plctb : "
            r2.append(r7)     // Catch: java.lang.Exception -> L9e
            r2.append(r5)     // Catch: java.lang.Exception -> L9e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L9e
            com.anythink.expressad.foundation.h.o.d(r0, r2)     // Catch: java.lang.Exception -> L9e
            r2 = 1
            if (r13 == 0) goto L60
            boolean r3 = r13.a(r3, r5)     // Catch: java.lang.Exception -> L9e
            if (r3 == 0) goto L5d
            r13.e(r2)     // Catch: java.lang.Exception -> L9e
            return r2
        L5d:
            r13.e(r1)     // Catch: java.lang.Exception -> L9e
        L60:
            if (r13 == 0) goto L9d
            boolean r13 = r13.A()     // Catch: java.lang.Exception -> L9e
            if (r13 != 0) goto L9d
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 != 0) goto L6f
            return r1
        L6f:
            java.util.Random r13 = new java.util.Random     // Catch: java.lang.Exception -> L9e
            r13.<init>()     // Catch: java.lang.Exception -> L9e
            double r3 = r13.nextDouble()     // Catch: java.lang.Exception -> L9e
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e
            java.lang.String r5 = "hit : "
            r13.<init>(r5)     // Catch: java.lang.Exception -> L9e
            r13.append(r3)     // Catch: java.lang.Exception -> L9e
            java.lang.String r5 = " "
            r13.append(r5)     // Catch: java.lang.Exception -> L9e
            int r5 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r5 <= 0) goto L8d
            r5 = 1
            goto L8e
        L8d:
            r5 = 0
        L8e:
            r13.append(r5)     // Catch: java.lang.Exception -> L9e
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Exception -> L9e
            com.anythink.expressad.foundation.h.o.d(r0, r13)     // Catch: java.lang.Exception -> L9e
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 <= 0) goto L9d
            return r2
        L9d:
            return r1
        L9e:
            r11 = move-exception
            java.lang.String r12 = "CBPERROR"
            com.anythink.expressad.foundation.h.o.b(r0, r12, r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.d.d.a(double, com.anythink.expressad.foundation.d.c):boolean");
    }
}
