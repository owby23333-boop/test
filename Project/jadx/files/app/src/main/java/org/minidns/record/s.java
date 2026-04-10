package org.minidns.record;

import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;

/* JADX INFO: compiled from: RRWithTarget.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DnsName f21639u;

    protected s(DnsName dnsName) {
        this.f21639u = dnsName;
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        this.f21639u.a(dataOutputStream);
    }

    public String toString() {
        return ((Object) this.f21639u) + ".";
    }
}
