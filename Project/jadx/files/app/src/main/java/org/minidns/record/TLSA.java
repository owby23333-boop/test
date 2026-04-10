package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.minidns.record.Record;

/* JADX INFO: loaded from: classes3.dex */
public class TLSA extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final byte f21587u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte f21588v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte f21589w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final byte[] f21590x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Map<Byte, CertUsage> f21585y = new HashMap();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Map<Byte, Selector> f21586z = new HashMap();
    private static final Map<Byte, MatchingType> A = new HashMap();

    public enum CertUsage {
        caConstraint((byte) 0),
        serviceCertificateConstraint((byte) 1),
        trustAnchorAssertion((byte) 2),
        domainIssuedCertificate((byte) 3);

        CertUsage(byte b) {
            TLSA.f21585y.put(Byte.valueOf(b), this);
        }
    }

    public enum MatchingType {
        noHash((byte) 0),
        sha256((byte) 1),
        sha512((byte) 2);

        MatchingType(byte b) {
            TLSA.A.put(Byte.valueOf(b), this);
        }
    }

    public enum Selector {
        fullCertificate((byte) 0),
        subjectPublicKeyInfo((byte) 1);

        Selector(byte b) {
            TLSA.f21586z.put(Byte.valueOf(b), this);
        }
    }

    static {
        CertUsage.values();
        Selector.values();
        MatchingType.values();
    }

    TLSA(byte b, byte b2, byte b3, byte[] bArr) {
        this.f21587u = b;
        f21585y.get(Byte.valueOf(b));
        this.f21588v = b2;
        f21586z.get(Byte.valueOf(b2));
        this.f21589w = b3;
        A.get(Byte.valueOf(b3));
        this.f21590x = bArr;
    }

    public static TLSA a(DataInputStream dataInputStream, int i2) throws IOException {
        byte b = dataInputStream.readByte();
        byte b2 = dataInputStream.readByte();
        byte b3 = dataInputStream.readByte();
        byte[] bArr = new byte[i2 - 3];
        if (dataInputStream.read(bArr) == bArr.length) {
            return new TLSA(b, b2, b3, bArr);
        }
        throw new IOException();
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.TLSA;
    }

    public String toString() {
        return ((int) this.f21587u) + ' ' + ((int) this.f21588v) + ' ' + ((int) this.f21589w) + ' ' + new BigInteger(1, this.f21590x).toString(16);
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.f21587u);
        dataOutputStream.writeByte(this.f21588v);
        dataOutputStream.writeByte(this.f21589w);
        dataOutputStream.write(this.f21590x);
    }
}
