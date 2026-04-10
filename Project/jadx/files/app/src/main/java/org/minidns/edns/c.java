package org.minidns.edns;

import org.minidns.edns.Edns;
import org.minidns.util.d;

/* JADX INFO: compiled from: UnknownEdnsOption.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends a {
    protected c(int i2, byte[] bArr) {
        super(i2, bArr);
    }

    @Override // org.minidns.edns.a
    protected CharSequence b() {
        return d.a(this.f21505c);
    }

    @Override // org.minidns.edns.a
    public Edns.OptionCode c() {
        return Edns.OptionCode.UNKNOWN;
    }

    @Override // org.minidns.edns.a
    protected CharSequence d() {
        return b();
    }
}
