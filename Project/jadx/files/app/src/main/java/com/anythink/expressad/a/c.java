package com.anythink.expressad.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.foundation.g.g.a;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f8032i = true;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f8035l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.g.c f8038o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private h f8039p;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f8033j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8034k = null;
    b a = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e f8036m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8037n = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Handler f8040q = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.anythink.expressad.a.c$1, reason: invalid class name */
    final class AnonymousClass1 implements a.b {
        private AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a.b
        public final void a(a.EnumC0209a enumC0209a) {
            if (enumC0209a == a.EnumC0209a.FINISH && c.this.f8037n) {
                c.this.f8040q.post(new Runnable() { // from class: com.anythink.expressad.a.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (c.this.f8036m != null) {
                            if (c.this.a.g()) {
                                e unused = c.this.f8036m;
                            } else {
                                e unused2 = c.this.f8036m;
                                c.this.a.h();
                            }
                        }
                    }
                });
            }
        }
    }

    private class a extends com.anythink.expressad.foundation.g.g.a {
        private a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x00aa A[EDGE_INSN: B:105:0x00aa->B:32:0x00aa BREAK  A[LOOP:0: B:5:0x000d->B:67:0x0157], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x0120 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011a A[Catch: Exception -> 0x0204, TryCatch #6 {Exception -> 0x0204, blocks: (B:3:0x0003, B:7:0x0017, B:10:0x0020, B:17:0x0090, B:39:0x00c8, B:47:0x00e4, B:49:0x00ea, B:51:0x00f2, B:54:0x00fb, B:56:0x010a, B:55:0x0103, B:57:0x0112, B:58:0x011a, B:60:0x0120, B:61:0x0128, B:63:0x0134, B:64:0x0141, B:67:0x0157, B:34:0x00be, B:37:0x00c4, B:70:0x015e, B:71:0x0161, B:72:0x0162, B:74:0x0174, B:77:0x0187, B:79:0x0197, B:87:0x01f5, B:80:0x01b3, B:82:0x01bb, B:85:0x01cc, B:84:0x01c5, B:86:0x01da), top: B:99:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0128 A[Catch: Exception -> 0x0204, TryCatch #6 {Exception -> 0x0204, blocks: (B:3:0x0003, B:7:0x0017, B:10:0x0020, B:17:0x0090, B:39:0x00c8, B:47:0x00e4, B:49:0x00ea, B:51:0x00f2, B:54:0x00fb, B:56:0x010a, B:55:0x0103, B:57:0x0112, B:58:0x011a, B:60:0x0120, B:61:0x0128, B:63:0x0134, B:64:0x0141, B:67:0x0157, B:34:0x00be, B:37:0x00c4, B:70:0x015e, B:71:0x0161, B:72:0x0162, B:74:0x0174, B:77:0x0187, B:79:0x0197, B:87:0x01f5, B:80:0x01b3, B:82:0x01bb, B:85:0x01cc, B:84:0x01c5, B:86:0x01da), top: B:99:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x015e A[Catch: Exception -> 0x0204, TryCatch #6 {Exception -> 0x0204, blocks: (B:3:0x0003, B:7:0x0017, B:10:0x0020, B:17:0x0090, B:39:0x00c8, B:47:0x00e4, B:49:0x00ea, B:51:0x00f2, B:54:0x00fb, B:56:0x010a, B:55:0x0103, B:57:0x0112, B:58:0x011a, B:60:0x0120, B:61:0x0128, B:63:0x0134, B:64:0x0141, B:67:0x0157, B:34:0x00be, B:37:0x00c4, B:70:0x015e, B:71:0x0161, B:72:0x0162, B:74:0x0174, B:77:0x0187, B:79:0x0197, B:87:0x01f5, B:80:0x01b3, B:82:0x01bb, B:85:0x01cc, B:84:0x01c5, B:86:0x01da), top: B:99:0x0003 }] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01da A[Catch: Exception -> 0x0204, TryCatch #6 {Exception -> 0x0204, blocks: (B:3:0x0003, B:7:0x0017, B:10:0x0020, B:17:0x0090, B:39:0x00c8, B:47:0x00e4, B:49:0x00ea, B:51:0x00f2, B:54:0x00fb, B:56:0x010a, B:55:0x0103, B:57:0x0112, B:58:0x011a, B:60:0x0120, B:61:0x0128, B:63:0x0134, B:64:0x0141, B:67:0x0157, B:34:0x00be, B:37:0x00c4, B:70:0x015e, B:71:0x0161, B:72:0x0162, B:74:0x0174, B:77:0x0187, B:79:0x0197, B:87:0x01f5, B:80:0x01b3, B:82:0x01bb, B:85:0x01cc, B:84:0x01c5, B:86:0x01da), top: B:99:0x0003 }] */
        @Override // com.anythink.expressad.foundation.g.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 550
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.c.a.a():void");
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }

        private /* synthetic */ a(c cVar, byte b) {
            this();
        }
    }

    public static class b implements com.anythink.expressad.e.b, Serializable {
        public static final int a = 1;
        public static final int b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f8041c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f8042d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f8043e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f8044f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f8045g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f8046h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f8047i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f8048j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f8049k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f8050l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f8051m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f8052n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f8053o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f8054p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f8055q;

        private boolean l() {
            return this.f8054p;
        }

        private String m() {
            return this.f8048j;
        }

        public final int a() {
            return this.f8055q;
        }

        public final void b() {
            this.f8054p = true;
        }

        public final int c() {
            return this.f8053o;
        }

        public final String d() {
            return this.f8052n;
        }

        public final String e() {
            return this.f8051m;
        }

        public final String f() {
            return this.f8050l;
        }

        public final boolean g() {
            return this.f8044f;
        }

        public final String h() {
            return this.f8045g;
        }

        public final int i() {
            return this.f8046h;
        }

        public final String j() {
            return this.f8047i;
        }

        public final boolean k() {
            return this.f8049k;
        }

        private void f(String str) {
            this.f8048j = str;
        }

        public final void a(int i2) {
            this.f8055q = i2;
        }

        public final void b(int i2) {
            this.f8053o = i2;
        }

        public final void c(String str) {
            this.f8050l = str;
        }

        public final void d(String str) {
            this.f8045g = str;
        }

        public final void e(String str) {
            this.f8047i = str;
        }

        public final void a(String str) {
            this.f8052n = str;
        }

        public final void b(String str) {
            this.f8051m = str;
        }

        public final void c(int i2) {
            this.f8046h = i2;
        }

        public final void a(boolean z2) {
            this.f8044f = z2;
        }

        public final void b(boolean z2) {
            this.f8049k = z2;
        }
    }

    public c(Context context) {
        this.f8038o = new com.anythink.expressad.foundation.g.g.c(context, 2);
        this.f8039p = new h(context);
    }

    static /* synthetic */ int d(c cVar) {
        int i2 = cVar.f8033j;
        cVar.f8033j = i2 + 1;
        return i2;
    }

    @Override // com.anythink.expressad.a.d
    public final void b() {
        this.f8037n = false;
    }

    public final boolean a() {
        return this.f8037n;
    }

    public final void a(String str, String str2, com.anythink.expressad.foundation.d.c cVar, e eVar, String str3, boolean z2, boolean z3, int i2) {
        String strAZ;
        boolean z4;
        this.f8034k = str3;
        this.f8036m = eVar;
        this.a = null;
        this.f8035l = i2;
        if (cVar != null) {
            boolean z5 = "5".equals(cVar.ab()) || "6".equals(cVar.ab());
            strAZ = cVar.aZ();
            z4 = z5;
        } else {
            strAZ = "";
            z4 = false;
        }
        this.f8039p.a(str3, eVar, z4, str, strAZ, str2, null, cVar, z2, z3, i2);
    }

    private void a(String str, String str2, com.anythink.expressad.foundation.d.c cVar, e eVar, com.anythink.expressad.c.b bVar) {
        this.f8034k = new String(cVar.ad());
        this.f8036m = eVar;
        this.a = null;
        this.f8039p.a(cVar.ad(), eVar, "5".equals(cVar.ab()) || "6".equals(cVar.ab()), str, cVar.aZ(), str2, bVar, cVar, true, false, com.anythink.expressad.a.a.a.f8009l);
    }

    private void a(String str, String str2, com.anythink.expressad.foundation.d.c cVar, e eVar) {
        this.f8034k = new String(cVar.ad());
        this.f8036m = eVar;
        this.a = null;
        this.f8039p.a(cVar.ad(), eVar, "5".equals(cVar.ab()) || "6".equals(cVar.ab()), str, cVar.aZ(), str2, null, cVar, true, false, com.anythink.expressad.a.a.a.f8009l);
    }
}
