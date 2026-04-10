package com.google.zxing.datamatrix.decoder;

import com.arialyy.aria.core.listener.ISchedulers;
import com.google.zxing.FormatException;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final d[] f16196h = h();
    private final int a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f16200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16201g;

    /* JADX INFO: compiled from: Version.java */
    static final class b {
        private final int a;
        private final int b;

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }

        private b(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    private d(int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.a = i2;
        this.b = i3;
        this.f16197c = i4;
        this.f16198d = i5;
        this.f16199e = i6;
        this.f16200f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.f16201g = iA;
    }

    private static d[] h() {
        int i2 = 1;
        int i3 = 5;
        int i4 = 8;
        int i5 = 7;
        d dVar = new d(3, 14, 14, 12, 12, new c(10, new b(i2, i4)));
        int i6 = 2;
        int i7 = 12;
        int i8 = 18;
        d dVar2 = new d(5, 18, 18, 16, 16, new c(14, new b(i2, 18)));
        int i9 = 4;
        d dVar3 = new d(7, 22, 22, 20, 20, new c(20, new b(i2, 30)));
        int i10 = 6;
        b bVar = new b(i2, 36);
        b bVar2 = new b(i2, 44);
        b bVar3 = new b(i2, 62);
        b bVar4 = new b(i2, 86);
        b bVar5 = new b(i2, 114);
        b bVar6 = new b(i2, 144);
        int i11 = 56;
        b bVar7 = new b(i2, 174);
        d dVar4 = new d(15, 52, 52, 24, 24, new c(42, new b(i6, 102)));
        b bVar8 = new b(i9, 92);
        b bVar9 = new b(i9, 114);
        b bVar10 = new b(i9, 174);
        b bVar11 = new b(i10, 175);
        return new d[]{new d(1, 10, 10, 8, 8, new c(i3, new b(i2, 3))), new d(2, 12, 12, 10, 10, new c(i5, new b(i2, i3))), dVar, new d(4, 16, 16, 14, 14, new c(i7, new b(i2, i7))), dVar2, new d(6, 20, 20, 18, 18, new c(i8, new b(i2, 22))), dVar3, new d(8, 24, 24, 22, 22, new c(24, bVar)), new d(9, 26, 26, 24, 24, new c(28, bVar2)), new d(10, 32, 32, 14, 14, new c(36, bVar3)), new d(11, 36, 36, 16, 16, new c(42, bVar4)), new d(12, 40, 40, 18, 18, new c(48, bVar5)), new d(13, 44, 44, 20, 20, new c(56, bVar6)), new d(14, 48, 48, 22, 22, new c(68, bVar7)), dVar4, new d(16, 64, 64, 14, 14, new c(i11, new b(i6, 140))), new d(17, 72, 72, 16, 16, new c(36, bVar8)), new d(18, 80, 80, 18, 18, new c(48, bVar9)), new d(19, 88, 88, 20, 20, new c(i11, new b(i9, 144))), new d(20, 96, 96, 22, 22, new c(68, bVar10)), new d(21, 104, 104, 24, 24, new c(i11, new b(i10, 136))), new d(22, 120, 120, 18, 18, new c(68, bVar11)), new d(23, TbsListener.ErrorCode.DOWNLOAD_CDN_URL_IS_NULL, TbsListener.ErrorCode.DOWNLOAD_CDN_URL_IS_NULL, 20, 20, new c(62, new b(i4, ISchedulers.SUB_STOP))), new d(24, 144, 144, 22, 22, new c(62, new b(i4, 156), new b(i6, TbsListener.ErrorCode.NO_NEED_STARTDOWNLOAD))), new d(25, 8, 18, 6, 16, new c(i5, new b(i2, i3))), new d(26, 8, 32, 6, 14, new c(11, new b(i2, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(i2, 16))), new d(28, 12, 36, 10, 16, new c(i8, new b(i2, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(i2, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(i2, 49)))};
    }

    public int a() {
        return this.f16199e;
    }

    public int b() {
        return this.f16198d;
    }

    c c() {
        return this.f16200f;
    }

    public int d() {
        return this.f16197c;
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.f16201g;
    }

    public int g() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    /* JADX INFO: compiled from: Version.java */
    static final class c {
        private final int a;
        private final b[] b;

        b[] a() {
            return this.b;
        }

        int b() {
            return this.a;
        }

        private c(int i2, b bVar) {
            this.a = i2;
            this.b = new b[]{bVar};
        }

        private c(int i2, b bVar, b bVar2) {
            this.a = i2;
            this.b = new b[]{bVar, bVar2};
        }
    }

    public static d a(int i2, int i3) throws FormatException {
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw FormatException.f();
        }
        for (d dVar : f16196h) {
            if (dVar.b == i2 && dVar.f16197c == i3) {
                return dVar;
            }
        }
        throw FormatException.f();
    }
}
