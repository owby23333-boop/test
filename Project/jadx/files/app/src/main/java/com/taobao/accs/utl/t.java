package com.taobao.accs.utl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class t extends ByteArrayInputStream {
    public t(byte[] bArr) {
        super(bArr);
    }

    public int a() {
        return read() & 255;
    }

    public int b() {
        return (a() << 8) | a();
    }

    public byte[] c() throws IOException {
        byte[] bArr = new byte[available()];
        read(bArr);
        return bArr;
    }

    public String a(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = read(bArr);
        if (i3 == i2) {
            return new String(bArr, com.anythink.expressad.foundation.g.a.bN);
        }
        throw new IOException("read len not match. ask for " + i2 + " but read for " + i3);
    }
}
