package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    g f14636c;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h f14642i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f14643j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int[] f14645l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f14647n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14648o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int[] f14649p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f14650q;
    HashMap<Integer, Integer> a = new HashMap<>();
    boolean b = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14644k = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final a f14646m = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f14637d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f14638e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f14639f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f14640g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f14641h = 4;

    static final class a {
        int[] a = new int[32];
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14651c;

        public final void a() {
            b();
            int i2 = this.b;
            int[] iArr = this.a;
            iArr[i2] = 0;
            iArr[i2 + 1] = 0;
            this.b = i2 + 2;
            this.f14651c++;
        }

        final void b() {
            int[] iArr = this.a;
            int length = iArr.length;
            int i2 = this.b;
            int i3 = length - i2;
            if (i3 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.f14642i = hVar;
        this.f14643j = bArr;
        c();
    }

    private void c() {
        this.f14648o = -1;
        this.f14649p = null;
        this.f14650q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x029b, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.f14644k) {
            this.f14644k = false;
            this.f14636c = null;
            this.f14645l = null;
            a aVar = this.f14646m;
            aVar.b = 0;
            aVar.f14651c = 0;
            c();
        }
    }

    public final int b() throws IOException {
        if (this.f14636c == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            d();
            return this.f14648o;
        } catch (IOException e2) {
            a();
            throw e2;
        }
    }
}
