package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.minidns.record.Record;

/* JADX INFO: loaded from: classes3.dex */
public class NSEC3 extends h {
    private static final Map<Byte, HashAlgorithm> C = new HashMap();
    private final byte[] A;
    public final List<Record.TYPE> B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final HashAlgorithm f21525u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte f21526v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte f21527w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f21528x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final byte[] f21529y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final byte[] f21530z;

    public enum HashAlgorithm {
        RESERVED(0, "Reserved"),
        SHA1(1, "SHA-1");


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final byte f21534s;

        HashAlgorithm(int i2, String str) {
            if (i2 < 0 || i2 > 255) {
                throw new IllegalArgumentException();
            }
            this.f21534s = (byte) i2;
            NSEC3.C.put(Byte.valueOf(this.f21534s), this);
        }

        public static HashAlgorithm a(byte b) {
            return (HashAlgorithm) NSEC3.C.get(Byte.valueOf(b));
        }
    }

    private NSEC3(HashAlgorithm hashAlgorithm, byte b, byte b2, int i2, byte[] bArr, byte[] bArr2, List<Record.TYPE> list) {
        this.f21526v = b;
        this.f21525u = hashAlgorithm == null ? HashAlgorithm.a(b) : hashAlgorithm;
        this.f21527w = b2;
        this.f21528x = i2;
        this.f21529y = bArr;
        this.f21530z = bArr2;
        this.B = list;
        this.A = n.a(list);
    }

    public static NSEC3 a(DataInputStream dataInputStream, int i2) throws IOException {
        byte b = dataInputStream.readByte();
        byte b2 = dataInputStream.readByte();
        int unsignedShort = dataInputStream.readUnsignedShort();
        int unsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[unsignedByte];
        if (dataInputStream.read(bArr) != bArr.length) {
            throw new IOException();
        }
        int unsignedByte2 = dataInputStream.readUnsignedByte();
        byte[] bArr2 = new byte[unsignedByte2];
        if (dataInputStream.read(bArr2) != bArr2.length) {
            throw new IOException();
        }
        byte[] bArr3 = new byte[i2 - ((unsignedByte + 6) + unsignedByte2)];
        if (dataInputStream.read(bArr3) == bArr3.length) {
            return new NSEC3(b, b2, unsignedShort, bArr, bArr2, n.a(bArr3));
        }
        throw new IOException();
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.NSEC3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f21525u);
        sb.append(' ');
        sb.append((int) this.f21527w);
        sb.append(' ');
        sb.append(this.f21528x);
        sb.append(' ');
        byte[] bArr = this.f21529y;
        sb.append(bArr.length == 0 ? "-" : new BigInteger(1, bArr).toString(16).toUpperCase());
        sb.append(' ');
        sb.append(org.minidns.util.a.a(this.f21530z));
        for (Record.TYPE type : this.B) {
            sb.append(' ');
            sb.append(type);
        }
        return sb.toString();
    }

    public NSEC3(byte b, byte b2, int i2, byte[] bArr, byte[] bArr2, List<Record.TYPE> list) {
        this(null, b, b2, i2, bArr, bArr2, list);
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.f21526v);
        dataOutputStream.writeByte(this.f21527w);
        dataOutputStream.writeShort(this.f21528x);
        dataOutputStream.writeByte(this.f21529y.length);
        dataOutputStream.write(this.f21529y);
        dataOutputStream.writeByte(this.f21530z.length);
        dataOutputStream.write(this.f21530z);
        dataOutputStream.write(this.A);
    }
}
