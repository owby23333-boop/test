package com.taobao.accs.net;

import com.taobao.accs.utl.UtilityImpl;
import org.android.spdy.AccsSSLCallback;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class z implements AccsSSLCallback {
    final /* synthetic */ v a;

    z(v vVar) {
        this.a = vVar;
    }

    @Override // org.android.spdy.AccsSSLCallback
    public byte[] getSSLPublicKey(int i2, byte[] bArr) {
        v vVar = this.a;
        return UtilityImpl.a(vVar.f18201d, vVar.f18210m, vVar.b, bArr);
    }
}
