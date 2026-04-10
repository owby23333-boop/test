package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.minidns.record.Record;

/* JADX INFO: compiled from: TXT.java */
/* JADX INFO: loaded from: classes3.dex */
public class v extends h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final byte[] f21650u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private transient String f21651v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private transient List<String> f21652w;

    public v(byte[] bArr) {
        this.f21650u = bArr;
    }

    public static v a(DataInputStream dataInputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        dataInputStream.readFully(bArr);
        return new v(bArr);
    }

    public List<String> b() {
        if (this.f21652w == null) {
            List<byte[]> listC = c();
            ArrayList arrayList = new ArrayList(listC.size());
            Iterator<byte[]> it = listC.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(new String(it.next(), "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    throw new AssertionError(e2);
                }
            }
            this.f21652w = Collections.unmodifiableList(arrayList);
        }
        return this.f21652w;
    }

    public List<byte[]> c() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f21650u;
            if (i2 >= bArr.length) {
                return arrayList;
            }
            int i3 = bArr[i2] & 255;
            int i4 = i2 + 1;
            int i5 = i3 + i4;
            arrayList.add(Arrays.copyOfRange(bArr, i4, i5));
            i2 = i5;
        }
    }

    public String d() {
        if (this.f21651v == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = b().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(" / ");
                }
            }
            this.f21651v = sb.toString();
        }
        return this.f21651v;
    }

    @Override // org.minidns.record.h
    public Record.TYPE getType() {
        return Record.TYPE.TXT;
    }

    public String toString() {
        return "\"" + d() + "\"";
    }

    @Override // org.minidns.record.h
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f21650u);
    }
}
