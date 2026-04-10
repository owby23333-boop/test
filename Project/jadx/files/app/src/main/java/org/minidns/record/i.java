package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.minidns.constants.DnssecConstants;

/* JADX INFO: compiled from: DelegatingDnssecRR.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f21609u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DnssecConstants.SignatureAlgorithm f21610v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte f21611w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DnssecConstants.DigestAlgorithm f21612x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final byte f21613y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected final byte[] f21614z;

    /* JADX INFO: compiled from: DelegatingDnssecRR.java */
    protected static final class b {
        protected final int a;
        protected final byte b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final byte f21615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final byte[] f21616d;

        private b(int i2, byte b, byte b2, byte[] bArr) {
            this.a = i2;
            this.b = b;
            this.f21615c = b2;
            this.f21616d = bArr;
        }
    }

    protected i(int i2, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte b2, DnssecConstants.DigestAlgorithm digestAlgorithm, byte b3, byte[] bArr) {
        this.f21609u = i2;
        this.f21611w = b2;
        this.f21610v = signatureAlgorithm == null ? DnssecConstants.SignatureAlgorithm.a(b2) : signatureAlgorithm;
        this.f21613y = b3;
        this.f21612x = digestAlgorithm == null ? DnssecConstants.DigestAlgorithm.a(b3) : digestAlgorithm;
        this.f21614z = bArr;
    }

    protected static b a(DataInputStream dataInputStream, int i2) throws IOException {
        int unsignedShort = dataInputStream.readUnsignedShort();
        byte b2 = dataInputStream.readByte();
        byte b3 = dataInputStream.readByte();
        byte[] bArr = new byte[i2 - 4];
        if (dataInputStream.read(bArr) == bArr.length) {
            return new b(unsignedShort, b2, b3, bArr);
        }
        throw new IOException();
    }

    public String toString() {
        return this.f21609u + ' ' + this.f21610v + ' ' + this.f21612x + ' ' + new BigInteger(1, this.f21614z).toString(16).toUpperCase();
    }

    protected i(int i2, byte b2, byte b3, byte[] bArr) {
        this(i2, null, b2, null, b3, bArr);
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f21609u);
        dataOutputStream.writeByte(this.f21611w);
        dataOutputStream.writeByte(this.f21613y);
        dataOutputStream.write(this.f21614z);
    }
}
