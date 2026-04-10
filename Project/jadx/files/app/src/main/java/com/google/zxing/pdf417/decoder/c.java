package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    private final com.google.zxing.common.b a;
    private final com.google.zxing.i b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.zxing.i f16298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.zxing.i f16299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.zxing.i f16300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16302g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f16303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f16304i;

    c(com.google.zxing.common.b bVar, com.google.zxing.i iVar, com.google.zxing.i iVar2, com.google.zxing.i iVar3, com.google.zxing.i iVar4) throws NotFoundException {
        boolean z2 = iVar == null || iVar2 == null;
        boolean z3 = iVar3 == null || iVar4 == null;
        if (z2 && z3) {
            throw NotFoundException.f();
        }
        if (z2) {
            iVar = new com.google.zxing.i(0.0f, iVar3.b());
            iVar2 = new com.google.zxing.i(0.0f, iVar4.b());
        } else if (z3) {
            iVar3 = new com.google.zxing.i(bVar.e() - 1, iVar.b());
            iVar4 = new com.google.zxing.i(bVar.e() - 1, iVar2.b());
        }
        this.a = bVar;
        this.b = iVar;
        this.f16298c = iVar2;
        this.f16299d = iVar3;
        this.f16300e = iVar4;
        this.f16301f = (int) Math.min(iVar.a(), iVar2.a());
        this.f16302g = (int) Math.max(iVar3.a(), iVar4.a());
        this.f16303h = (int) Math.min(iVar.b(), iVar3.b());
        this.f16304i = (int) Math.max(iVar2.b(), iVar4.b());
    }

    static c a(c cVar, c cVar2) throws NotFoundException {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.b, cVar.f16298c, cVar2.f16299d, cVar2.f16300e);
    }

    com.google.zxing.i b() {
        return this.f16300e;
    }

    int c() {
        return this.f16302g;
    }

    int d() {
        return this.f16304i;
    }

    int e() {
        return this.f16301f;
    }

    int f() {
        return this.f16303h;
    }

    com.google.zxing.i g() {
        return this.b;
    }

    com.google.zxing.i h() {
        return this.f16299d;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.google.zxing.pdf417.decoder.c a(int r13, int r14, boolean r15) throws com.google.zxing.NotFoundException {
        /*
            r12 = this;
            com.google.zxing.i r0 = r12.b
            com.google.zxing.i r1 = r12.f16298c
            com.google.zxing.i r2 = r12.f16299d
            com.google.zxing.i r3 = r12.f16300e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.b()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            com.google.zxing.i r13 = new com.google.zxing.i
            float r4 = r4.a()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            com.google.zxing.i r13 = r12.f16298c
            goto L34
        L32:
            com.google.zxing.i r13 = r12.f16300e
        L34:
            float r0 = r13.b()
            int r0 = (int) r0
            int r0 = r0 + r14
            com.google.zxing.common.b r14 = r12.a
            int r14 = r14.c()
            if (r0 < r14) goto L4a
            com.google.zxing.common.b r14 = r12.a
            int r14 = r14.c()
            int r0 = r14 + (-1)
        L4a:
            com.google.zxing.i r14 = new com.google.zxing.i
            float r13 = r13.a()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            com.google.zxing.pdf417.decoder.c r13 = new com.google.zxing.pdf417.decoder.c
            com.google.zxing.common.b r7 = r12.a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.c.a(int, int, boolean):com.google.zxing.pdf417.decoder.c");
    }

    com.google.zxing.i a() {
        return this.f16298c;
    }

    c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.g();
        this.f16298c = cVar.a();
        this.f16299d = cVar.h();
        this.f16300e = cVar.b();
        this.f16301f = cVar.e();
        this.f16302g = cVar.c();
        this.f16303h = cVar.f();
        this.f16304i = cVar.d();
    }
}
