package com.anythink.expressad.exoplayer.j;

import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements b {
    private static final int a = 100;
    private final boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f9675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a[] f9676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f9677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f9678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a[] f9680i;

    public l(byte b) {
        this();
    }

    public final synchronized void a(int i2) {
        boolean z2 = i2 < this.f9677f;
        this.f9677f = i2;
        if (z2) {
            b();
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized void b() {
        int i2 = 0;
        int iMax = Math.max(0, af.a(this.f9677f, this.f9674c) - this.f9678g);
        if (iMax >= this.f9679h) {
            return;
        }
        if (this.f9675d != null) {
            int i3 = this.f9679h - 1;
            while (i2 <= i3) {
                a aVar = this.f9680i[i2];
                if (aVar.a == this.f9675d) {
                    i2++;
                } else {
                    a aVar2 = this.f9680i[i3];
                    if (aVar2.a != this.f9675d) {
                        i3--;
                    } else {
                        this.f9680i[i2] = aVar2;
                        this.f9680i[i3] = aVar;
                        i3--;
                        i2++;
                    }
                }
            }
            iMax = Math.max(iMax, i2);
            if (iMax >= this.f9679h) {
                return;
            }
        }
        Arrays.fill(this.f9680i, iMax, this.f9679h, (Object) null);
        this.f9679h = iMax;
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized int c() {
        return this.f9678g * this.f9674c;
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final int d() {
        return this.f9674c;
    }

    public final synchronized void e() {
        if (this.b) {
            a(0);
        }
    }

    private l() {
        com.anythink.expressad.exoplayer.k.a.a(true);
        com.anythink.expressad.exoplayer.k.a.a(true);
        this.b = true;
        this.f9674c = 65536;
        this.f9679h = 0;
        this.f9680i = new a[100];
        this.f9675d = null;
        this.f9676e = new a[1];
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized a a() {
        a aVar;
        this.f9678g++;
        if (this.f9679h > 0) {
            a[] aVarArr = this.f9680i;
            int i2 = this.f9679h - 1;
            this.f9679h = i2;
            aVar = aVarArr[i2];
            this.f9680i[this.f9679h] = null;
        } else {
            aVar = new a(new byte[this.f9674c]);
        }
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized void a(a aVar) {
        this.f9676e[0] = aVar;
        a(this.f9676e);
    }

    @Override // com.anythink.expressad.exoplayer.j.b
    public final synchronized void a(a[] aVarArr) {
        if (this.f9679h + aVarArr.length >= this.f9680i.length) {
            this.f9680i = (a[]) Arrays.copyOf(this.f9680i, Math.max(this.f9680i.length * 2, this.f9679h + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            if (aVar.a != this.f9675d && aVar.a.length != this.f9674c) {
                throw new IllegalArgumentException("Unexpected allocation: " + System.identityHashCode(aVar.a) + ", " + System.identityHashCode(this.f9675d) + ", " + aVar.a.length + ", " + this.f9674c);
            }
            a[] aVarArr2 = this.f9680i;
            int i2 = this.f9679h;
            this.f9679h = i2 + 1;
            aVarArr2[i2] = aVar;
        }
        this.f9678g -= aVarArr.length;
        notifyAll();
    }
}
