package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class kf extends kh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private jp f874a;

    public kf(int i) {
        this.f874a = new jp(i);
    }

    @Override // com.xiaomi.push.kh
    public int a(byte[] bArr, int i, int i2) {
        byte[] bArrM674a = this.f874a.m674a();
        if (i2 > this.f874a.a() - this.f8154a) {
            i2 = this.f874a.a() - this.f8154a;
        }
        if (i2 > 0) {
            System.arraycopy(bArrM674a, this.f8154a, bArr, i, i2);
            this.f8154a += i2;
        }
        return i2;
    }

    public int a_() {
        return this.f874a.size();
    }

    @Override // com.xiaomi.push.kh
    /* JADX INFO: renamed from: a */
    public void mo690a(byte[] bArr, int i, int i2) throws IOException {
        this.f874a.write(bArr, i, i2);
    }
}
