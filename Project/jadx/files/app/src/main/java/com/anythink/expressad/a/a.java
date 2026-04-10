package com.anythink.expressad.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.anythink.core.common.b.k;
import com.anythink.expressad.a.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.out.LoadingActivity;
import com.anythink.expressad.out.j;
import com.anythink.expressad.out.p;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final String a = "Anythink SDK M";
    public static boolean b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, Long> f7983c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Set<String> f7984d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f7985e = "2";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f7986f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f7988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.anythink.expressad.foundation.c.c f7989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f7990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private c f7991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.anythink.expressad.out.f f7992l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.anythink.expressad.d.a f7994n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f7995o;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f7998r;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private p.c f7993m = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7996p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7997q = true;

    public a(Context context, String str) {
        this.f7989i = null;
        this.f7990j = null;
        com.anythink.expressad.d.b.a();
        this.f7994n = com.anythink.expressad.d.b.b();
        if (this.f7994n == null) {
            com.anythink.expressad.d.b.a();
            this.f7994n = com.anythink.expressad.d.b.c();
        }
        this.f7995o = this.f7994n.t();
        this.f7990j = context.getApplicationContext();
        this.f7987g = str;
        if (this.f7989i == null) {
            this.f7989i = com.anythink.expressad.foundation.c.c.a(this.f7990j);
        }
    }

    private void a(String str) {
        this.f7987g = str;
    }

    private boolean c() {
        return this.f7997q;
    }

    private com.anythink.expressad.out.f d() {
        return this.f7992l;
    }

    private com.anythink.expressad.foundation.c.c e() {
        return this.f7989i;
    }

    private static void f() {
    }

    private void g() {
        c cVar = this.f7991k;
        if (cVar == null || !cVar.a()) {
            return;
        }
        this.f7991k.b();
    }

    private static void h() {
    }

    private int i() {
        try {
            if (this.f7994n != null) {
                return this.f7994n.k();
            }
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    private void j() {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            k.a(this.f7990j).a(intent);
        } catch (Exception e2) {
            o.b(a, "Exception", e2);
        }
    }

    public final void a(p.c cVar) {
        this.f7993m = cVar;
    }

    public final void b() {
        try {
            this.f7993m = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a() {
        this.f7997q = false;
    }

    private void a(com.anythink.expressad.out.f fVar) {
        this.f7992l = fVar;
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        try {
            Intent intent = new Intent(this.f7990j, (Class<?>) LoadingActivity.class);
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.putExtra("icon_url", cVar.bd());
            this.f7990j.startActivity(intent);
        } catch (Exception e2) {
            o.b(a, "Exception", e2);
        }
    }

    private static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        Long l2;
        if (cVar == null) {
            return true;
        }
        try {
            if (2 != cVar.Q() && 3 != cVar.Q()) {
                return true;
            }
            String strAZ = cVar.aZ();
            if (f7983c == null) {
                return true;
            }
            if (f7983c.containsKey(strAZ) && (l2 = f7983c.get(strAZ)) != null) {
                if (l2.longValue() > System.currentTimeMillis() || f7984d.contains(cVar.aZ())) {
                    return false;
                }
            }
            f7983c.put(cVar.aZ(), Long.valueOf(System.currentTimeMillis() + ((long) (cVar.Y() * 1000))));
            return true;
        } catch (Exception e2) {
            if (!com.anythink.expressad.a.a) {
                return true;
            }
            e2.printStackTrace();
            return true;
        }
    }

    private void b(c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z2) {
        if (cVar == null || bVar == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f7988h;
            com.anythink.expressad.foundation.d.f fVar = new com.anythink.expressad.foundation.d.f();
            fVar.i(cVar.aa());
            fVar.a();
            fVar.h(String.valueOf(jCurrentTimeMillis));
            fVar.g(cVar.aZ());
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), com.anythink.expressad.foundation.g.a.bN));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7988h / 1000);
            fVar.b(sb.toString());
            fVar.a(Integer.parseInt(cVar.ac()));
            fVar.b(cVar.Q());
            fVar.a(this.f7987g);
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), com.anythink.expressad.foundation.g.a.bN));
            }
            if (this.f7995o) {
                fVar.c(bVar.a());
                if (!TextUtils.isEmpty(bVar.d())) {
                    fVar.d(URLEncoder.encode(bVar.d(), com.anythink.expressad.foundation.g.a.bN));
                }
                if (!TextUtils.isEmpty(bVar.f())) {
                    fVar.e(URLEncoder.encode(bVar.f(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(bVar.e())) {
                    fVar.c(URLEncoder.encode(bVar.e(), com.anythink.expressad.foundation.g.a.bN));
                }
            }
            if (z2) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(fVar);
            w.b(com.anythink.expressad.foundation.d.f.a(arrayList));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(this.f7990j, cVar, this.f7987g, str, true, false, com.anythink.expressad.a.a.a.f8008k);
    }

    public static void a(Context context, com.anythink.expressad.foundation.d.c cVar, String str, String str2, boolean z2) {
        if (context == null) {
            return;
        }
        new c(context.getApplicationContext()).a("2", str, cVar, null, str2, false, z2, com.anythink.expressad.a.a.a.f8005h);
    }

    public static void a(Context context, com.anythink.expressad.foundation.d.c cVar, String str, String str2, boolean z2, boolean z3, int i2) {
        if (context == null) {
            return;
        }
        new c(context.getApplicationContext()).a("2", str, cVar, null, str2, z2, z3, i2);
    }

    public static void a(Context context, com.anythink.expressad.foundation.d.c cVar, String str, String[] strArr, boolean z2) {
        if (context == null || cVar == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        c cVar2 = new c(context.getApplicationContext());
        for (String str2 : strArr) {
            cVar2.a("2", str, cVar, null, str2, false, z2, com.anythink.expressad.a.a.a.f8005h);
        }
    }

    private void a(final boolean z2, final j jVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anythink.expressad.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (z2 && !a.b && com.anythink.expressad.a.f7971o) {
                    a.a(a.this);
                }
                if (a.this.f7993m == null || a.b || !com.anythink.expressad.a.f7971o) {
                    return;
                }
                a.this.f7993m.b(jVar);
            }
        });
    }

    private void a(c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z2) {
        if (cVar == null || bVar == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f7988h;
            com.anythink.expressad.foundation.d.f fVar = new com.anythink.expressad.foundation.d.f();
            fVar.i(cVar.aa());
            fVar.a();
            fVar.h(String.valueOf(jCurrentTimeMillis));
            fVar.g(cVar.aZ());
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), com.anythink.expressad.foundation.g.a.bN));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7988h / 1000);
            fVar.b(sb.toString());
            fVar.a(Integer.parseInt(cVar.ac()));
            fVar.b(cVar.Q());
            fVar.a(this.f7987g);
            fVar.d(bVar.c());
            if (!TextUtils.isEmpty(bVar.j())) {
                fVar.f(URLEncoder.encode(bVar.j(), com.anythink.expressad.foundation.g.a.bN));
            }
            if (this.f7995o) {
                fVar.c(bVar.a());
                if (!TextUtils.isEmpty(bVar.d())) {
                    fVar.d(URLEncoder.encode(bVar.d(), com.anythink.expressad.foundation.g.a.bN));
                }
                if (!TextUtils.isEmpty(bVar.f())) {
                    fVar.e(URLEncoder.encode(bVar.f(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(bVar.e())) {
                    fVar.c(URLEncoder.encode(bVar.e(), com.anythink.expressad.foundation.g.a.bN));
                }
            }
            if (z2) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(fVar);
            w.b(com.anythink.expressad.foundation.d.f.a(arrayList));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(j jVar, String str) {
        try {
            if (!TextUtils.isEmpty(str) && jVar != null) {
                com.anythink.expressad.foundation.d.c cVar = jVar instanceof com.anythink.expressad.foundation.d.c ? (com.anythink.expressad.foundation.d.c) jVar : null;
                if ((!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) || s.a.a(this.f7990j, str, this.f7993m) || cVar == null) {
                    return;
                }
                if (!TextUtils.isEmpty(cVar.ba())) {
                    s.a.a(this.f7990j, BaseConstants.MARKET_PREFIX + cVar.ba(), this.f7993m);
                    return;
                }
                if (i() == 2) {
                    s.a(this.f7990j, cVar.ad(), cVar, this.f7993m);
                } else {
                    s.a(this.f7990j, cVar.ad(), this.f7993m);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(int i2, String str, com.anythink.expressad.foundation.d.c cVar, p.c cVar2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i2 == 2) {
                s.a(this.f7990j, str, cVar, cVar2);
            } else {
                s.a(this.f7990j, str, cVar2);
            }
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0004, B:6:0x000e, B:10:0x001e, B:11:0x002a, B:13:0x0030, B:16:0x004d, B:17:0x0057, B:21:0x0065, B:23:0x006c, B:24:0x0076, B:27:0x007f), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076 A[Catch: all -> 0x0061, TryCatch #0 {all -> 0x0061, blocks: (B:4:0x0004, B:6:0x000e, B:10:0x001e, B:11:0x002a, B:13:0x0030, B:16:0x004d, B:17:0x0057, B:21:0x0065, B:23:0x006c, B:24:0x0076, B:27:0x007f), top: B:31:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.anythink.expressad.foundation.d.c r6, com.anythink.expressad.a.c.b r7, boolean r8, int r9) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r8 == 0) goto L63
            java.lang.String r2 = r6.ac()     // Catch: java.lang.Throwable -> L61
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L61
            if (r2 != r1) goto L1b
            android.content.Context r9 = r5.f7990j     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = r7.j()     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.out.p$c r3 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.foundation.h.s.a(r9, r2, r3)     // Catch: java.lang.Throwable -> L61
        L19:
            r0 = 1
            goto L63
        L1b:
            r3 = 2
            if (r2 != r3) goto L2a
            android.content.Context r9 = r5.f7990j     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = r7.j()     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.out.p$c r3 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.foundation.h.s.a(r9, r2, r6, r3)     // Catch: java.lang.Throwable -> L61
            goto L19
        L2a:
            java.lang.String r2 = r6.ba()     // Catch: java.lang.Throwable -> L61
            if (r2 == 0) goto L57
            android.content.Context r2 = r5.f7990j     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = "market://details?id="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = r6.ba()     // Catch: java.lang.Throwable -> L61
            r3.append(r4)     // Catch: java.lang.Throwable -> L61
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.out.p$c r4 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            boolean r2 = com.anythink.expressad.foundation.h.s.a.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L61
            if (r2 == 0) goto L4d
            goto L19
        L4d:
            java.lang.String r2 = r7.j()     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.out.p$c r3 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            r5.a(r9, r2, r6, r3)     // Catch: java.lang.Throwable -> L61
            goto L63
        L57:
            java.lang.String r2 = r7.j()     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.out.p$c r3 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            r5.a(r9, r2, r6, r3)     // Catch: java.lang.Throwable -> L61
            goto L63
        L61:
            r6 = move-exception
            goto L89
        L63:
            if (r0 == 0) goto L76
            r5.b(r7, r6, r1)     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.out.p$c r8 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            if (r8 == 0) goto L92
            com.anythink.expressad.out.p$c r8 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            java.lang.String r7 = r7.j()     // Catch: java.lang.Throwable -> L61
            r8.a(r6, r7)     // Catch: java.lang.Throwable -> L61
            goto L92
        L76:
            r5.b(r7, r6, r1)     // Catch: java.lang.Throwable -> L61
            com.anythink.expressad.out.p$c r9 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            if (r9 == 0) goto L92
            if (r8 == 0) goto L92
            com.anythink.expressad.out.p$c r8 = r5.f7993m     // Catch: java.lang.Throwable -> L61
            java.lang.String r7 = r7.j()     // Catch: java.lang.Throwable -> L61
            r8.b(r6, r7)     // Catch: java.lang.Throwable -> L61
            goto L92
        L89:
            java.lang.String r7 = r6.getMessage()
            java.lang.String r8 = "Anythink SDK M"
            com.anythink.expressad.foundation.h.o.b(r8, r7, r6)
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.a(com.anythink.expressad.foundation.d.c, com.anythink.expressad.a.c$b, boolean, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:5:0x0010, B:7:0x0015, B:9:0x0019, B:10:0x0023, B:12:0x0027), top: B:17:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0004, B:5:0x0010, B:7:0x0015, B:9:0x0019, B:10:0x0023, B:12:0x0027), top: B:17:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.anythink.expressad.foundation.d.c r5, com.anythink.expressad.a.c.b r6, boolean r7) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L10
            android.content.Context r7 = r4.f7990j     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r5.ad()     // Catch: java.lang.Throwable -> L31
            com.anythink.expressad.out.p$c r3 = r4.f7993m     // Catch: java.lang.Throwable -> L31
            com.anythink.expressad.foundation.h.s.a(r7, r2, r3)     // Catch: java.lang.Throwable -> L31
            r1 = 1
        L10:
            r4.b(r6, r5, r0)     // Catch: java.lang.Throwable -> L31
            if (r1 == 0) goto L23
            com.anythink.expressad.out.p$c r7 = r4.f7993m     // Catch: java.lang.Throwable -> L31
            if (r7 == 0) goto L3b
            com.anythink.expressad.out.p$c r7 = r4.f7993m     // Catch: java.lang.Throwable -> L31
            java.lang.String r6 = r6.j()     // Catch: java.lang.Throwable -> L31
            r7.a(r5, r6)     // Catch: java.lang.Throwable -> L31
            goto L3b
        L23:
            com.anythink.expressad.out.p$c r7 = r4.f7993m     // Catch: java.lang.Throwable -> L31
            if (r7 == 0) goto L3b
            com.anythink.expressad.out.p$c r7 = r4.f7993m     // Catch: java.lang.Throwable -> L31
            java.lang.String r6 = r6.j()     // Catch: java.lang.Throwable -> L31
            r7.b(r5, r6)     // Catch: java.lang.Throwable -> L31
            goto L3b
        L31:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            java.lang.String r7 = "Anythink SDK M"
            com.anythink.expressad.foundation.h.o.b(r7, r6, r5)
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.a(com.anythink.expressad.foundation.d.c, com.anythink.expressad.a.c$b, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00af A[Catch: Exception -> 0x0151, TryCatch #0 {Exception -> 0x0151, blocks: (B:2:0x0000, B:9:0x000c, B:12:0x0022, B:14:0x0028, B:17:0x0032, B:19:0x0036, B:21:0x0048, B:24:0x0054, B:26:0x005e, B:28:0x0068, B:31:0x0078, B:39:0x00af, B:40:0x00b8, B:43:0x00be, B:63:0x0119, B:65:0x0127, B:67:0x012f, B:71:0x0137, B:66:0x012c, B:35:0x0089, B:37:0x0093, B:46:0x00cc, B:47:0x00d7, B:50:0x00dd, B:52:0x00e9, B:54:0x00ef, B:56:0x00f3, B:58:0x00f9, B:60:0x0101, B:62:0x0110, B:74:0x0143, B:76:0x014a), top: B:81:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.foundation.d.c r7, com.anythink.expressad.a.c.b r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.a(com.anythink.expressad.foundation.d.c, com.anythink.expressad.a.c$b, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0017 -> B:14:0x0018). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(int r3, java.lang.String r4) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            if (r3 != r0) goto Lc
            boolean r3 = com.anythink.expressad.foundation.h.s.a.a(r4)     // Catch: java.lang.Exception -> L13
            if (r3 == 0) goto L17
            goto L18
        Lc:
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L13
            if (r3 != 0) goto L17
            goto L18
        L13:
            r3 = move-exception
            r3.printStackTrace()
        L17:
            r1 = 0
        L18:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.a(int, java.lang.String):boolean");
    }

    static /* synthetic */ void a(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            k.a(aVar.f7990j).a(intent);
        } catch (Exception e2) {
            o.b(a, "Exception", e2);
        }
    }
}
