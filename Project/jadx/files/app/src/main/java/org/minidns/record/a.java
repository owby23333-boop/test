package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import org.minidns.record.Record;

/* JADX INFO: compiled from: A.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends j<Inet4Address> {
    public a(byte[] bArr) {
        super(bArr);
        if (bArr.length != 4) {
            throw new IllegalArgumentException("IPv4 address in A record is always 4 byte");
        }
    }

    public static a a(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return new a(bArr);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.A;
    }

    public String toString() {
        return Integer.toString(this.f21617u[0] & 255) + "." + Integer.toString(this.f21617u[1] & 255) + "." + Integer.toString(this.f21617u[2] & 255) + "." + Integer.toString(this.f21617u[3] & 255);
    }
}
