package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class s extends ByteArrayOutputStream {
    public s(int i2) {
        super(i2);
    }

    public s a(byte b) {
        write(b);
        return this;
    }

    public s() {
    }

    public s a(short s2) {
        write(s2 >> 8);
        write(s2);
        return this;
    }
}
