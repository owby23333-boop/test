package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: SRV.java */
/* JADX INFO: loaded from: classes3.dex */
public class u extends h implements Comparable<u> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f21646u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f21647v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f21648w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DnsName f21649x;

    public u(int i2, int i3, int i4, DnsName dnsName) {
        this.f21646u = i2;
        this.f21647v = i3;
        this.f21648w = i4;
        this.f21649x = dnsName;
    }

    public static u a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new u(dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), DnsName.a(dataInputStream, bArr));
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.SRV;
    }

    public String toString() {
        return this.f21646u + " " + this.f21647v + " " + this.f21648w + " " + ((Object) this.f21649x) + ".";
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f21646u);
        dataOutputStream.writeShort(this.f21647v);
        dataOutputStream.writeShort(this.f21648w);
        this.f21649x.a(dataOutputStream);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(u uVar) {
        int i2 = uVar.f21646u - this.f21646u;
        return i2 == 0 ? this.f21647v - uVar.f21647v : i2;
    }
}
