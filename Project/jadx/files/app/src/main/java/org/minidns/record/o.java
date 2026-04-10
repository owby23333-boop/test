package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.record.Record;

/* JADX INFO: compiled from: OPENPGPKEY.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final byte[] f21630u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private transient String f21631v;

    o(byte[] bArr) {
        this.f21630u = bArr;
    }

    public static o a(DataInputStream dataInputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        dataInputStream.readFully(bArr);
        return new o(bArr);
    }

    public String b() {
        if (this.f21631v == null) {
            this.f21631v = org.minidns.util.b.a(this.f21630u);
        }
        return this.f21631v;
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.OPENPGPKEY;
    }

    public String toString() {
        return b();
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f21630u);
    }
}
