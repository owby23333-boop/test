package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.minidns.record.Record;

/* JADX INFO: compiled from: OPT.java */
/* JADX INFO: loaded from: classes3.dex */
public class p extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<org.minidns.edns.a> f21632u;

    public p() {
        this(Collections.emptyList());
    }

    public static p a(DataInputStream dataInputStream, int i2) throws IOException {
        List listEmptyList;
        if (i2 == 0) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(4);
            while (i2 > 0) {
                int unsignedShort = dataInputStream.readUnsignedShort();
                int unsignedShort2 = dataInputStream.readUnsignedShort();
                byte[] bArr = new byte[unsignedShort2];
                dataInputStream.read(bArr);
                arrayList.add(org.minidns.edns.a.a(unsignedShort, bArr));
                i2 -= unsignedShort2 + 4;
            }
            listEmptyList = arrayList;
        }
        return new p(listEmptyList);
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.OPT;
    }

    public p(List<org.minidns.edns.a> list) {
        this.f21632u = Collections.unmodifiableList(list);
    }

    @Override // org.minidns.record.h
    protected void a(DataOutputStream dataOutputStream) throws IOException {
        Iterator<org.minidns.edns.a> it = this.f21632u.iterator();
        while (it.hasNext()) {
            it.next().a(dataOutputStream);
        }
    }
}
