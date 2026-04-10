package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: MX.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f21619u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DnsName f21620v;

    public k(int i2, DnsName dnsName) {
        this.f21619u = i2;
        this.f21620v = dnsName;
    }

    public static k a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new k(dataInputStream.readUnsignedShort(), DnsName.a(dataInputStream, bArr));
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.MX;
    }

    public String toString() {
        return this.f21619u + " " + ((Object) this.f21620v) + '.';
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f21619u);
        this.f21620v.a(dataOutputStream);
    }
}
