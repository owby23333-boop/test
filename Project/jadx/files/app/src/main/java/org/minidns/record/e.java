package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: DNAME.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends s {
    public e(DnsName dnsName) {
        super(dnsName);
    }

    public static e a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new e(DnsName.a(dataInputStream, bArr));
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.DNAME;
    }
}
