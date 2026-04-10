package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.minidns.constants.DnssecConstants;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: RRSIG.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends h {
    public final Date A;
    public final int B;
    public final DnsName C;
    private final byte[] D;
    private transient String E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Record.TYPE f21633u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DnssecConstants.SignatureAlgorithm f21634v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte f21635w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final byte f21636x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f21637y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Date f21638z;

    private r(Record.TYPE type, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte b, byte b2, long j2, Date date, Date date2, int i2, DnsName dnsName, byte[] bArr) {
        this.f21633u = type;
        this.f21635w = b;
        this.f21634v = signatureAlgorithm == null ? DnssecConstants.SignatureAlgorithm.a(b) : signatureAlgorithm;
        this.f21636x = b2;
        this.f21637y = j2;
        this.f21638z = date;
        this.A = date2;
        this.B = i2;
        this.C = dnsName;
        this.D = bArr;
    }

    public static r a(DataInputStream dataInputStream, byte[] bArr, int i2) throws IOException {
        Record.TYPE type = Record.TYPE.getType(dataInputStream.readUnsignedShort());
        byte b = dataInputStream.readByte();
        byte b2 = dataInputStream.readByte();
        long j2 = ((long) dataInputStream.readInt()) & 4294967295L;
        Date date = new Date((((long) dataInputStream.readInt()) & 4294967295L) * 1000);
        Date date2 = new Date((4294967295L & ((long) dataInputStream.readInt())) * 1000);
        int unsignedShort = dataInputStream.readUnsignedShort();
        DnsName dnsNameA = DnsName.a(dataInputStream, bArr);
        byte[] bArr2 = new byte[(i2 - dnsNameA.j()) - 18];
        if (dataInputStream.read(bArr2) == bArr2.length) {
            return new r(type, null, b, b2, j2, date, date2, unsignedShort, dnsNameA, bArr2);
        }
        throw new IOException();
    }

    public String b() {
        if (this.E == null) {
            this.E = org.minidns.util.b.a(this.D);
        }
        return this.E;
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.f21633u.g());
        dataOutputStream.writeByte(this.f21635w);
        dataOutputStream.writeByte(this.f21636x);
        dataOutputStream.writeInt((int) this.f21637y);
        dataOutputStream.writeInt((int) (this.f21638z.getTime() / 1000));
        dataOutputStream.writeInt((int) (this.A.getTime() / 1000));
        dataOutputStream.writeShort(this.B);
        this.C.a(dataOutputStream);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.RRSIG;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return this.f21633u + ' ' + this.f21634v + ' ' + ((int) this.f21636x) + ' ' + this.f21637y + ' ' + simpleDateFormat.format(this.f21638z) + ' ' + simpleDateFormat.format(this.A) + ' ' + this.B + ' ' + ((CharSequence) this.C) + ". " + b();
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        c(dataOutputStream);
        dataOutputStream.write(this.D);
    }
}
