package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: SOA.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends h {
    public final long A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DnsName f21640u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DnsName f21641v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f21642w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f21643x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f21644y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f21645z;

    public t(DnsName dnsName, DnsName dnsName2, long j2, int i2, int i3, int i4, long j3) {
        this.f21640u = dnsName;
        this.f21641v = dnsName2;
        this.f21642w = j2;
        this.f21643x = i2;
        this.f21644y = i3;
        this.f21645z = i4;
        this.A = j3;
    }

    public static t a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new t(DnsName.a(dataInputStream, bArr), DnsName.a(dataInputStream, bArr), ((long) dataInputStream.readInt()) & 4294967295L, dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readInt(), ((long) dataInputStream.readInt()) & 4294967295L);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.SOA;
    }

    public String toString() {
        return ((CharSequence) this.f21640u) + ". " + ((CharSequence) this.f21641v) + ". " + this.f21642w + ' ' + this.f21643x + ' ' + this.f21644y + ' ' + this.f21645z + ' ' + this.A;
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        this.f21640u.a(dataOutputStream);
        this.f21641v.a(dataOutputStream);
        dataOutputStream.writeInt((int) this.f21642w);
        dataOutputStream.writeInt(this.f21643x);
        dataOutputStream.writeInt(this.f21644y);
        dataOutputStream.writeInt(this.f21645z);
        dataOutputStream.writeInt((int) this.A);
    }
}
