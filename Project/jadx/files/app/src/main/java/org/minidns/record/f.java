package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.constants.DnssecConstants;
import org.minidns.record.Record;

/* JADX INFO: compiled from: DNSKEY.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final short f21603u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte f21604v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final DnssecConstants.SignatureAlgorithm f21605w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final byte[] f21606x;

    private f(short s2, byte b, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte b2, byte[] bArr) {
        this.f21603u = s2;
        this.f21604v = b;
        this.f21605w = signatureAlgorithm == null ? DnssecConstants.SignatureAlgorithm.a(b2) : signatureAlgorithm;
        this.f21606x = bArr;
    }

    public static f a(DataInputStream dataInputStream, int i2) throws IOException {
        short s2 = dataInputStream.readShort();
        byte b = dataInputStream.readByte();
        byte b2 = dataInputStream.readByte();
        byte[] bArr = new byte[i2 - 4];
        dataInputStream.readFully(bArr);
        return new f(s2, b, b2, bArr);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.DNSKEY;
    }

    public String toString() {
        return ((int) this.f21603u) + ' ' + ((int) this.f21604v) + ' ' + this.f21605w + ' ' + org.minidns.util.b.a(this.f21606x);
    }

    public f(short s2, byte b, byte b2, byte[] bArr) {
        this(s2, b, DnssecConstants.SignatureAlgorithm.a(b2), bArr);
    }

    public f(short s2, byte b, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        this(s2, b, signatureAlgorithm, signatureAlgorithm.f21407s, bArr);
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f21603u);
        dataOutputStream.writeByte(this.f21604v);
        dataOutputStream.writeByte(this.f21605w.f21407s);
        dataOutputStream.write(this.f21606x);
    }
}
