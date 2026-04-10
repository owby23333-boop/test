package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: NS.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends s {
    public l(DnsName dnsName) {
        super(dnsName);
    }

    public static l a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new l(DnsName.a(dataInputStream, bArr));
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.NS;
    }
}
