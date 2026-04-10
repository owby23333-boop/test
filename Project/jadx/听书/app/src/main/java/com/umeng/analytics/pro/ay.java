package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: TByteArrayOutputStream.java */
/* JADX INFO: loaded from: classes4.dex */
public class ay extends ByteArrayOutputStream {
    public ay(int i) {
        super(i);
    }

    public ay() {
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }
}
