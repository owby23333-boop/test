package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: CNAME.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends s {
    public c(DnsName dnsName) {
        super(dnsName);
    }

    public static c a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new c(DnsName.a(dataInputStream, bArr));
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.CNAME;
    }
}
