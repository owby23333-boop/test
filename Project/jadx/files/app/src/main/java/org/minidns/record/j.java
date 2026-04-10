package org.minidns.record;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: InternetAddressRR.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j<IA extends InetAddress> extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected final byte[] f21617u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private transient IA f21618v;

    protected j(byte[] bArr) {
        this.f21617u = bArr;
    }

    @Override // org.minidns.record.h
    public final void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f21617u);
    }

    public final IA b() {
        if (this.f21618v == null) {
            try {
                this.f21618v = (IA) InetAddress.getByAddress(this.f21617u);
            } catch (UnknownHostException e2) {
                throw new IllegalStateException(e2);
            }
        }
        return this.f21618v;
    }

    public final byte[] c() {
        return (byte[]) this.f21617u.clone();
    }
}
