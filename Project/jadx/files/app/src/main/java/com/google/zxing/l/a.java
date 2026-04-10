package com.google.zxing.l;

import com.google.zxing.common.f;
import com.google.zxing.i;

/* JADX INFO: compiled from: AztecDetectorResult.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f16213e;

    public a(com.google.zxing.common.b bVar, i[] iVarArr, boolean z2, int i2, int i3) {
        super(bVar, iVarArr);
        this.f16211c = z2;
        this.f16212d = i2;
        this.f16213e = i3;
    }

    public int c() {
        return this.f16212d;
    }

    public int d() {
        return this.f16213e;
    }

    public boolean e() {
        return this.f16211c;
    }
}
