package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: compiled from: PTR.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends s {
    q(DnsName dnsName) {
        super(dnsName);
    }

    public static q a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new q(DnsName.a(dataInputStream, bArr));
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.PTR;
    }
}
