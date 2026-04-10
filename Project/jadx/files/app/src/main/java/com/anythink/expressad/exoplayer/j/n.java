package com.anythink.expressad.exoplayer.j;

import android.content.Context;
import android.net.Uri;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements h {
    private static final String a = "DefaultDataSource";
    private static final String b = "asset";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9698c = "content";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9699d = "rtmp";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9700e = "rawresource";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f9701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final aa<? super h> f9702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h f9703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f9704i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f9705j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private h f9706k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private h f9707l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private h f9708m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private h f9709n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private h f9710o;

    private n(Context context, aa<? super h> aaVar, String str, boolean z2) {
        this(context, aaVar, str, z2, (byte) 0);
    }

    private h c() {
        if (this.f9704i == null) {
            this.f9704i = new r(this.f9702g);
        }
        return this.f9704i;
    }

    private h d() {
        if (this.f9705j == null) {
            this.f9705j = new c(this.f9701f, this.f9702g);
        }
        return this.f9705j;
    }

    private h e() {
        if (this.f9706k == null) {
            this.f9706k = new e(this.f9701f, this.f9702g);
        }
        return this.f9706k;
    }

    private h f() {
        if (this.f9707l == null) {
            try {
                this.f9707l = (h) Class.forName("com.anythink.expressad.exoplayer.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f9707l == null) {
                this.f9707l = this.f9703h;
            }
        }
        return this.f9707l;
    }

    private h g() {
        if (this.f9708m == null) {
            this.f9708m = new f();
        }
        return this.f9708m;
    }

    private h h() {
        if (this.f9709n == null) {
            this.f9709n = new y(this.f9701f, this.f9702g);
        }
        return this.f9709n;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.f9710o == null);
        String scheme = kVar.f9667c.getScheme();
        if (af.a(kVar.f9667c)) {
            if (kVar.f9667c.getPath().startsWith("/android_asset/")) {
                this.f9710o = d();
            } else {
                if (this.f9704i == null) {
                    this.f9704i = new r(this.f9702g);
                }
                this.f9710o = this.f9704i;
            }
        } else if (b.equals(scheme)) {
            this.f9710o = d();
        } else if ("content".equals(scheme)) {
            if (this.f9706k == null) {
                this.f9706k = new e(this.f9701f, this.f9702g);
            }
            this.f9710o = this.f9706k;
        } else if (f9699d.equals(scheme)) {
            this.f9710o = f();
        } else if ("data".equals(scheme)) {
            if (this.f9708m == null) {
                this.f9708m = new f();
            }
            this.f9710o = this.f9708m;
        } else if ("rawresource".equals(scheme)) {
            if (this.f9709n == null) {
                this.f9709n = new y(this.f9701f, this.f9702g);
            }
            this.f9710o = this.f9709n;
        } else {
            this.f9710o = this.f9703h;
        }
        return this.f9710o.a(kVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        h hVar = this.f9710o;
        if (hVar != null) {
            try {
                hVar.b();
            } finally {
                this.f9710o = null;
            }
        }
    }

    private n(Context context, aa<? super h> aaVar, String str, boolean z2, byte b2) {
        this(context, aaVar, new p(str, null, aaVar, 8000, 8000, z2, null));
    }

    public n(Context context, aa<? super h> aaVar, h hVar) {
        this.f9701f = context.getApplicationContext();
        this.f9702g = aaVar;
        this.f9703h = (h) com.anythink.expressad.exoplayer.k.a.a(hVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) {
        return this.f9710o.a(bArr, i2, i3);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        h hVar = this.f9710o;
        if (hVar == null) {
            return null;
        }
        return hVar.a();
    }
}
