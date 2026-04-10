package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Closeable {
    private final RandomAccessFile a;
    private final File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f19202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19203d;

    public c(File file) throws FileNotFoundException {
        this.f19202c = new byte[8];
        this.b = file;
        this.a = new RandomAccessFile(this.b, "r");
    }

    public c(String str) throws FileNotFoundException {
        this(new File(str));
    }

    public final int a(byte[] bArr) throws IOException {
        return this.a.read(bArr);
    }

    public final int a(char[] cArr) throws IOException {
        byte[] bArr = new byte[cArr.length];
        int i2 = this.a.read(bArr);
        for (int i3 = 0; i3 < cArr.length; i3++) {
            cArr[i3] = (char) bArr[i3];
        }
        return i2;
    }

    public final short a() throws IOException {
        short s2 = this.a.readShort();
        if (!this.f19203d) {
            return s2;
        }
        return (short) (((s2 & 65280) >>> 8) | ((s2 & 255) << 8));
    }

    public void a(long j2) throws IOException {
        this.a.seek(j2);
    }

    public void a(boolean z2) {
        this.f19203d = z2;
    }

    public final int b() throws IOException {
        int i2 = this.a.readInt();
        if (!this.f19203d) {
            return i2;
        }
        return ((i2 & (-16777216)) >>> 24) | ((i2 & 255) << 24) | ((65280 & i2) << 8) | ((16711680 & i2) >>> 8);
    }

    public final long c() throws IOException {
        if (!this.f19203d) {
            return this.a.readLong();
        }
        this.a.readFully(this.f19202c, 0, 8);
        byte[] bArr = this.f19202c;
        return (((long) (bArr[1] & 255)) << 8) | (((long) bArr[7]) << 56) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[2] & 255)) << 16) | ((long) (bArr[0] & 255));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.a.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
