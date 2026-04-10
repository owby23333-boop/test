package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.record.Record;
import org.minidns.record.i;

/* JADX INFO: compiled from: DLV.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends i {
    public d(int i2, byte b, byte b2, byte[] bArr) {
        super(i2, b, b2, bArr);
    }

    public static d b(DataInputStream dataInputStream, int i2) throws IOException {
        i.b bVarA = i.a(dataInputStream, i2);
        return new d(bVarA.a, bVarA.b, bVarA.f21615c, bVarA.f21616d);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.DLV;
    }
}
