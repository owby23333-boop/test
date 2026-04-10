package com.anythink.core.common.e;

import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Comparable<b> {
    private int a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ATBaseAdAdapter f7219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BaseAd f7220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f7223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f7224h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7225i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f7226j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7227k;

    private long l() {
        return this.f7223g;
    }

    private int m() {
        return this.a;
    }

    private long n() {
        return this.b;
    }

    public final String b() {
        return this.f7224h;
    }

    public final boolean c() {
        return this.f7222f;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(b bVar) {
        return com.anythink.core.common.k.g.a(this.f7219c.getUnitGroupInfo()) > com.anythink.core.common.k.g.a(bVar.f7219c.getUnitGroupInfo()) ? -1 : 1;
    }

    public final int d() {
        return this.f7221e;
    }

    public final ATBaseAdAdapter e() {
        return this.f7219c;
    }

    public final BaseAd f() {
        return this.f7220d;
    }

    public final boolean g() {
        try {
            if (this.f7219c != null && this.f7220d != null) {
                return true;
            }
            if (this.f7219c != null) {
                return this.f7219c.isAdReady();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public final e h() {
        BaseAd baseAd = this.f7220d;
        return baseAd != null ? baseAd.getDetail() : this.f7219c.getTrackingInfo();
    }

    public final boolean i() {
        return this.b + this.f7223g > System.currentTimeMillis();
    }

    public final boolean j() {
        return i() && g();
    }

    public final synchronized void k() {
        if (this.f7227k) {
            return;
        }
        this.f7227k = true;
        com.anythink.core.common.b.n.a().a(new Runnable() { // from class: com.anythink.core.common.e.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.this.f7219c != null) {
                        b.this.f7219c.destory();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final boolean a() {
        return this.f7225i == 1 && System.currentTimeMillis() - this.b < this.f7226j;
    }

    public final void b(long j2) {
        this.f7223g = j2;
    }

    public final void c(long j2) {
        this.f7225i = 1;
        this.b = j2;
    }

    public final void a(long j2) {
        this.f7226j = j2;
    }

    public final void b(int i2) {
        this.a = i2;
    }

    private int b(b bVar) {
        return com.anythink.core.common.k.g.a(this.f7219c.getUnitGroupInfo()) > com.anythink.core.common.k.g.a(bVar.f7219c.getUnitGroupInfo()) ? -1 : 1;
    }

    public final void a(String str) {
        this.f7224h = str;
    }

    public final void a(boolean z2) {
        this.f7222f = z2;
    }

    public final void a(int i2) {
        this.f7221e = i2;
        if (i2 > 0) {
            this.f7225i = 0;
        }
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.f7219c = aTBaseAdAdapter;
    }

    public final void a(BaseAd baseAd) {
        this.f7220d = baseAd;
    }
}
