package org.minidns.edns;

import java.nio.charset.StandardCharsets;
import org.minidns.edns.Edns;
import org.minidns.util.d;

/* JADX INFO: compiled from: Nsid.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends a {
    static {
        new b();
    }

    private b() {
        this(new byte[0]);
    }

    @Override // org.minidns.edns.a
    protected CharSequence b() {
        return d.a(this.f21505c);
    }

    @Override // org.minidns.edns.a
    public Edns.OptionCode c() {
        return Edns.OptionCode.NSID;
    }

    @Override // org.minidns.edns.a
    protected CharSequence d() {
        return (Edns.OptionCode.NSID + ": ") + new String(this.f21505c, StandardCharsets.US_ASCII);
    }

    public b(byte[] bArr) {
        super(bArr);
    }
}
