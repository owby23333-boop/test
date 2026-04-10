package org.minidns.record;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: NSEC.java */
/* JADX INFO: loaded from: classes3.dex */
public class n extends h {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Logger f21626x = Logger.getLogger(n.class.getName());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DnsName f21627u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final byte[] f21628v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<Record.TYPE> f21629w;

    public n(DnsName dnsName, List<Record.TYPE> list) {
        this.f21627u = dnsName;
        this.f21629w = Collections.unmodifiableList(list);
        this.f21628v = a(list);
    }

    public static n a(DataInputStream dataInputStream, byte[] bArr, int i2) throws IOException {
        DnsName dnsNameA = DnsName.a(dataInputStream, bArr);
        byte[] bArr2 = new byte[i2 - dnsNameA.j()];
        if (dataInputStream.read(bArr2) == bArr2.length) {
            return new n(dnsNameA, a(bArr2));
        }
        throw new IOException();
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.NSEC;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.f21627u);
        sb.append('.');
        for (Record.TYPE type : this.f21629w) {
            sb.append(' ');
            sb.append(type);
        }
        return sb.toString();
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        this.f21627u.a(dataOutputStream);
        dataOutputStream.write(this.f21628v);
    }

    static byte[] a(List<Record.TYPE> list) {
        ArrayList<Integer> arrayList = new ArrayList(list.size());
        Iterator<Record.TYPE> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().g()));
        }
        Collections.sort(arrayList);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            byte[] bArr = null;
            int iIntValue = -1;
            for (Integer num : arrayList) {
                if (iIntValue == -1 || (num.intValue() >> 8) != iIntValue) {
                    if (iIntValue != -1) {
                        a(bArr, dataOutputStream);
                    }
                    iIntValue = num.intValue() >> 8;
                    dataOutputStream.writeByte(iIntValue);
                    bArr = new byte[32];
                }
                int iIntValue2 = (num.intValue() >> 3) % 32;
                bArr[iIntValue2] = (byte) ((128 >> (num.intValue() % 8)) | bArr[iIntValue2]);
            }
            if (iIntValue != -1) {
                a(bArr, dataOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void a(byte[] bArr, DataOutputStream dataOutputStream) throws IOException {
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (bArr[i3] != 0) {
                i2 = i3 + 1;
            }
        }
        dataOutputStream.writeByte(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            dataOutputStream.writeByte(bArr[i4]);
        }
    }

    static List<Record.TYPE> a(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (bArr.length > i2) {
            int unsignedByte = dataInputStream.readUnsignedByte();
            int unsignedByte2 = dataInputStream.readUnsignedByte();
            for (int i3 = 0; i3 < unsignedByte2; i3++) {
                int unsignedByte3 = dataInputStream.readUnsignedByte();
                for (int i4 = 0; i4 < 8; i4++) {
                    if (((unsignedByte3 >> i4) & 1) > 0) {
                        int i5 = (unsignedByte << 8) + (i3 * 8) + (7 - i4);
                        Record.TYPE type = Record.TYPE.getType(i5);
                        if (type == Record.TYPE.UNKNOWN) {
                            f21626x.warning("Skipping unknown type in type bitmap: " + i5);
                        } else {
                            arrayList.add(type);
                        }
                    }
                }
            }
            i2 += unsignedByte2 + 2;
        }
        return arrayList;
    }
}
