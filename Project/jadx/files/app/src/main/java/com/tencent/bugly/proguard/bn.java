package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bn extends m implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static byte[] f18670d;
    public byte a;
    public String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f18671c;

    public bn() {
        this.a = (byte) 0;
        this.b = "";
        this.f18671c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.f18671c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i2) {
    }

    public bn(byte b, String str, byte[] bArr) {
        this.a = (byte) 0;
        this.b = "";
        this.f18671c = null;
        this.a = b;
        this.b = str;
        this.f18671c = bArr;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.b = kVar.b(1, true);
        if (f18670d == null) {
            f18670d = new byte[]{0};
        }
        this.f18671c = kVar.c(2, false);
    }
}
