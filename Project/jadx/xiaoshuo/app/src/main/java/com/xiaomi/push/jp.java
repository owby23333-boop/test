package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes8.dex */
public class jp extends ByteArrayOutputStream {
    public jp(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m674a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public jp() {
    }

    public int a() {
        return ((ByteArrayOutputStream) this).count;
    }
}
