package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet6Address;
import org.minidns.record.Record;

/* JADX INFO: compiled from: AAAA.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends j<Inet6Address> {
    public b(byte[] bArr) {
        super(bArr);
        if (bArr.length != 16) {
            throw new IllegalArgumentException("IPv6 address in AAAA record is always 16 byte");
        }
    }

    public static b a(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[16];
        dataInputStream.readFully(bArr);
        return new b(bArr);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.AAAA;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f21617u.length; i2 += 2) {
            if (i2 != 0) {
                sb.append(':');
            }
            byte[] bArr = this.f21617u;
            sb.append(Integer.toHexString(((bArr[i2] & 255) << 8) + (bArr[i2 + 1] & 255)));
        }
        return sb.toString();
    }
}
