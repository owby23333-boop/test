package com.anythink.expressad.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.anythink.expressad.a.c;
import com.anythink.expressad.a.f;
import com.anythink.expressad.a.g;
import com.anythink.expressad.foundation.g.g.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d implements a.b {
    public static final int a = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f8097i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f8098j = "302";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e f8101m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c.b f8102n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8104p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Context f8105q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.anythink.expressad.foundation.g.g.c f8106r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private f.a f8107s;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8099k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f8100l = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f8103o = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Handler f8108t = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f8109u = true;

    private class a extends com.anythink.expressad.foundation.g.g.a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f8110h = 10;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Context f8112f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f8113g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f8114i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f8115j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f8116k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private com.anythink.expressad.c.b f8117l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private com.anythink.expressad.foundation.d.c f8118m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f8119n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f8120o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f8121p;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Semaphore f8111e = new Semaphore(0);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private g.a f8122q = new g.a() { // from class: com.anythink.expressad.a.h.a.1
            @Override // com.anythink.expressad.a.g.a
            public final boolean a(String str) {
                boolean zA = a.this.a(str);
                a.a(a.this, false, true);
                if (zA) {
                    b();
                }
                return zA;
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean b(String str) {
                boolean zA = a.this.a(str);
                a.a(a.this, false, true);
                if (zA) {
                    a.a(a.this, true, true);
                    b();
                }
                return zA;
            }

            @Override // com.anythink.expressad.a.g.a
            public final boolean a() {
                a.a(a.this, false, false);
                return false;
            }

            private void b() {
                synchronized (h.this) {
                    h.this.f8102n.a(true);
                    a.a(a.this);
                }
            }

            @Override // com.anythink.expressad.a.g.a
            public final void a(String str, String str2) {
                a.this.a(str);
                h.this.f8102n.c(str2);
                a.a(a.this, true, false);
                b();
            }

            @Override // com.anythink.expressad.a.g.a
            public final void a(String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    h.this.f8102n.b(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    h.this.f8102n.c(str3);
                }
                a.this.a(str);
                a.a(a.this, true, false);
                b();
            }
        };

        public a(Context context, String str, String str2, String str3, String str4, com.anythink.expressad.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z2, boolean z3, int i2) {
            this.f8112f = context;
            this.f8113g = str;
            this.f8114i = str2;
            this.f8115j = str3;
            this.f8116k = str4;
            this.f8117l = bVar;
            this.f8118m = cVar;
            this.f8119n = z2;
            this.f8120o = z3;
            this.f8121p = i2;
        }

        private static boolean a(int i2) {
            return i2 == 200;
        }

        private static boolean b(int i2) {
            return i2 == 301 || i2 == 302 || i2 == 307;
        }

        private static boolean b(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        private static boolean c(String str) {
            return str.startsWith("/");
        }

        private void d() {
            this.f8111e.acquireUninterruptibly();
        }

        private static boolean e(String str) {
            return !TextUtils.isEmpty(str) && str.toLowerCase().contains("apk");
        }

        private void h() {
            this.f8111e.release();
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x0176, code lost:
        
            r3.b(true);
            r3.e(r7);
         */
        /* JADX WARN: Removed duplicated region for block: B:101:0x021f A[EDGE_INSN: B:101:0x021f->B:92:0x021f BREAK  A[LOOP:0: B:20:0x005c->B:78:0x01cb], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private com.anythink.expressad.a.c.b a(java.lang.String r16, boolean r17, boolean r18, com.anythink.expressad.foundation.d.c r19, int r20) {
            /*
                Method dump skipped, instruction units count: 544
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.h.a.a(java.lang.String, boolean, boolean, com.anythink.expressad.foundation.d.c, int):com.anythink.expressad.a.c$b");
        }

        private static boolean d(String str) {
            return s.a.a(str);
        }

        private void a(boolean z2, boolean z3) {
            if (h.this.f8100l == 0) {
                h.this.f8100l = System.currentTimeMillis();
            } else {
                h.this.f8100l = System.currentTimeMillis();
            }
            if (!z2) {
                com.anythink.expressad.c.b bVar = this.f8117l;
                return;
            }
            if (z3) {
                if (this.f8117l == null || h.this.f8099k) {
                    return;
                }
                h.f(h.this);
                return;
            }
            if (this.f8117l == null || h.this.f8099k) {
                return;
            }
            h.f(h.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(String str) {
            com.anythink.expressad.foundation.d.c cVar = this.f8118m;
            if (cVar != null) {
                cVar.Q();
            }
            if (s.a.a(str)) {
                h.this.f8102n.c(1);
                h.this.f8102n.e(str);
                h.this.f8102n.b(true);
                return true;
            }
            if (e(str)) {
                h.this.f8102n.c(3);
                h.this.f8102n.e(str);
                h.this.f8102n.b(true);
                return true;
            }
            h.this.f8102n.c(2);
            h.this.f8102n.e(str);
            return false;
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            if (h.this.f8101m != null) {
                e unused = h.this.f8101m;
            }
            h.this.f8102n = new c.b();
            h.this.f8102n.e(this.f8113g);
            h.this.f8102n = a(this.f8113g, this.f8119n, this.f8120o, this.f8118m, this.f8121p);
            if (!TextUtils.isEmpty(h.this.f8102n.e())) {
                h.this.f8102n.a(true);
            }
            if (h.this.f8103o && h.this.f8102n.g()) {
                if (h.this.f8107s != null) {
                    h.this.f8102n.a(h.this.f8107s.f8070f);
                }
                if (!e(h.this.f8102n.j()) && !s.a.a(h.this.f8102n.j()) && 200 == h.this.f8107s.f8070f && !TextUtils.isEmpty(h.this.f8102n.f()) && !h.this.f8102n.f().contains(com.anythink.expressad.foundation.g.a.bU)) {
                    h.this.f8102n.b(2);
                    if (!TextUtils.isEmpty(h.this.f8102n.f())) {
                        new g(h.this.f8109u).a(this.f8114i, this.f8115j, this.f8116k, this.f8112f, h.this.f8102n.j(), h.this.f8102n.f(), this.f8122q);
                        o.d(h.f8098j, "startWebViewHtmlParser");
                    } else {
                        o.a(h.f8098j, "startWebViewSpider");
                        try {
                            new g(h.this.f8109u).a(this.f8114i, this.f8115j, this.f8116k, this.f8112f, h.this.f8102n.j(), this.f8122q);
                        } catch (Exception unused2) {
                            o.d("TAG", "webview spider start error");
                        }
                    }
                    this.f8111e.acquireUninterruptibly();
                    return;
                }
                if (this.f8117l != null) {
                    h.this.f8102n.j();
                }
                if (h.this.f8107s != null) {
                    h.this.f8102n.b(1);
                    h.this.f8102n.b(h.this.f8107s.f8072h);
                    h.this.f8102n.a(h.this.f8107s.f8070f);
                    h.this.f8102n.a(h.this.f8107s.a());
                    h.this.f8102n.c(h.this.f8107s.f8071g);
                }
                a(h.this.f8102n.j());
            }
        }

        static /* synthetic */ void a(a aVar, boolean z2, boolean z3) {
            if (h.this.f8100l == 0) {
                h.this.f8100l = System.currentTimeMillis();
            } else {
                h.this.f8100l = System.currentTimeMillis();
            }
            if (!z2) {
                com.anythink.expressad.c.b bVar = aVar.f8117l;
                return;
            }
            if (z3) {
                if (aVar.f8117l == null || h.this.f8099k) {
                    return;
                }
                h.f(h.this);
                return;
            }
            if (aVar.f8117l == null || h.this.f8099k) {
                return;
            }
            h.f(h.this);
        }

        static /* synthetic */ void a(a aVar) {
            aVar.f8111e.release();
        }
    }

    public h(Context context) {
        this.f8105q = context;
        this.f8106r = new com.anythink.expressad.foundation.g.g.c(context, 2);
    }

    static /* synthetic */ boolean f(h hVar) {
        hVar.f8099k = true;
        return true;
    }

    @Override // com.anythink.expressad.a.d
    public final void b() {
        this.f8103o = false;
    }

    private boolean a() {
        return this.f8103o;
    }

    public final void a(String str, e eVar, boolean z2, String str2, String str3, String str4, com.anythink.expressad.c.b bVar, com.anythink.expressad.foundation.d.c cVar, boolean z3, boolean z4, int i2) {
        this.f8101m = eVar;
        this.f8104p = z2;
        this.f8106r.a(new a(this.f8105q, str, str2, str3, str4, bVar, cVar, z3, z4, i2), this);
    }

    @Override // com.anythink.expressad.foundation.g.g.a.b
    public final void a(a.EnumC0209a enumC0209a) {
        if (enumC0209a == a.EnumC0209a.FINISH && this.f8103o) {
            this.f8108t.post(new Runnable() { // from class: com.anythink.expressad.a.h.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (h.this.f8101m != null) {
                        if (h.this.f8102n.g()) {
                            e unused = h.this.f8101m;
                            c.b unused2 = h.this.f8102n;
                        } else {
                            e unused3 = h.this.f8101m;
                            c.b unused4 = h.this.f8102n;
                            h.this.f8102n.h();
                        }
                    }
                }
            });
        }
    }
}
