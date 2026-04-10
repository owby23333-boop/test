package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.minidns.record.NSEC3;
import org.minidns.record.Record;

/* JADX INFO: compiled from: NSEC3PARAM.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final NSEC3.HashAlgorithm f21621u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte f21622v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte f21623w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f21624x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final byte[] f21625y;

    private m(NSEC3.HashAlgorithm hashAlgorithm, byte b, byte b2, int i2, byte[] bArr) {
        this.f21622v = b;
        this.f21621u = hashAlgorithm == null ? NSEC3.HashAlgorithm.a(b) : hashAlgorithm;
        this.f21623w = b2;
        this.f21624x = i2;
        this.f21625y = bArr;
    }

    public static m a(DataInputStream dataInputStream) throws IOException {
        byte b = dataInputStream.readByte();
        byte b2 = dataInputStream.readByte();
        int unsignedShort = dataInputStream.readUnsignedShort();
        byte[] bArr = new byte[dataInputStream.readUnsignedByte()];
        if (dataInputStream.read(bArr) == bArr.length || bArr.length == 0) {
            return new m(b, b2, unsignedShort, bArr);
        }
        throw new IOException();
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.NSEC3PARAM;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f21621u);
        sb.append(' ');
        sb.append((int) this.f21623w);
        sb.append(' ');
        sb.append(this.f21624x);
        sb.append(' ');
        byte[] bArr = this.f21625y;
        sb.append(bArr.length == 0 ? "-" : new BigInteger(1, bArr).toString(16).toUpperCase());
        return sb.toString();
    }

    m(byte b, byte b2, int i2, byte[] bArr) {
        this(null, b, b2, i2, bArr);
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.f21622v);
        dataOutputStream.writeByte(this.f21623w);
        dataOutputStream.writeShort(this.f21624x);
        dataOutputStream.writeByte(this.f21625y.length);
        dataOutputStream.write(this.f21625y);
    }
}
