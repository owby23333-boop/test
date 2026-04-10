package com.bytedance.sdk.component.g.z.g;

/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f716a;
    int dl;
    m e;
    int g;
    boolean gc;
    m m;
    final byte[] z;

    m() {
        this.z = new byte[8192];
        this.gc = true;
        this.f716a = false;
    }

    m(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.z = bArr;
        this.g = i;
        this.dl = i2;
        this.f716a = z;
        this.gc = z2;
    }

    final m z() {
        this.f716a = true;
        return new m(this.z, this.g, this.dl, true, false);
    }

    public final m g() {
        m mVar = this.m;
        m mVar2 = mVar != this ? mVar : null;
        m mVar3 = this.e;
        if (mVar3 != null) {
            mVar3.m = mVar;
        }
        m mVar4 = this.m;
        if (mVar4 != null) {
            mVar4.e = mVar3;
        }
        this.m = null;
        this.e = null;
        return mVar2;
    }

    public final m z(m mVar) {
        mVar.e = this;
        mVar.m = this.m;
        this.m.e = mVar;
        this.m = mVar;
        return mVar;
    }
}
