package com.anythink.expressad.exoplayer.k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private static final Comparator<a> a = new Comparator<a>() { // from class: com.anythink.expressad.exoplayer.k.y.1
        private static int a(a aVar, a aVar2) {
            return aVar.a - aVar2.a;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar.a - aVar2.a;
        }
    };
    private static final Comparator<a> b = new Comparator<a>() { // from class: com.anythink.expressad.exoplayer.k.y.2
        private static int a(a aVar, a aVar2) {
            float f2 = aVar.f9921c;
            float f3 = aVar2.f9921c;
            if (f2 < f3) {
                return -1;
            }
            return f3 < f2 ? 1 : 0;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            float f2 = aVar.f9921c;
            float f3 = aVar2.f9921c;
            if (f2 < f3) {
                return -1;
            }
            return f3 < f2 ? 1 : 0;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9910c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9911d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9912e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9913f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9914g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9918k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9919l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f9920m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a[] f9916i = new a[5];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ArrayList<a> f9915h = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9917j = -1;

    private static class a {
        public int a;
        public int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f9921c;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public y(int i2) {
        this.f9914g = i2;
    }

    private void b() {
        if (this.f9917j != 1) {
            Collections.sort(this.f9915h, a);
            this.f9917j = 1;
        }
    }

    private void c() {
        if (this.f9917j != 0) {
            Collections.sort(this.f9915h, b);
            this.f9917j = 0;
        }
    }

    public final void a(int i2, float f2) {
        a aVar;
        if (this.f9917j != 1) {
            Collections.sort(this.f9915h, a);
            this.f9917j = 1;
        }
        int i3 = this.f9920m;
        byte b2 = 0;
        if (i3 > 0) {
            a[] aVarArr = this.f9916i;
            int i4 = i3 - 1;
            this.f9920m = i4;
            aVar = aVarArr[i4];
        } else {
            aVar = new a(b2);
        }
        int i5 = this.f9918k;
        this.f9918k = i5 + 1;
        aVar.a = i5;
        aVar.b = i2;
        aVar.f9921c = f2;
        this.f9915h.add(aVar);
        this.f9919l += i2;
        while (true) {
            int i6 = this.f9919l;
            int i7 = this.f9914g;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            a aVar2 = this.f9915h.get(0);
            int i9 = aVar2.b;
            if (i9 <= i8) {
                this.f9919l -= i9;
                this.f9915h.remove(0);
                int i10 = this.f9920m;
                if (i10 < 5) {
                    a[] aVarArr2 = this.f9916i;
                    this.f9920m = i10 + 1;
                    aVarArr2[i10] = aVar2;
                }
            } else {
                aVar2.b = i9 - i8;
                this.f9919l -= i8;
            }
        }
    }

    public final float a() {
        if (this.f9917j != 0) {
            Collections.sort(this.f9915h, b);
            this.f9917j = 0;
        }
        float f2 = this.f9919l * 0.5f;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f9915h.size(); i3++) {
            a aVar = this.f9915h.get(i3);
            i2 += aVar.b;
            if (i2 >= f2) {
                return aVar.f9921c;
            }
        }
        if (this.f9915h.isEmpty()) {
            return Float.NaN;
        }
        return this.f9915h.get(r0.size() - 1).f9921c;
    }
}
