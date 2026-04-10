package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final OutputStream f184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7844b;

    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(byte[] bArr, int i, int i2) {
        this.f184a = null;
        this.f185a = bArr;
        this.f7844b = i;
        this.f7843a = i + i2;
    }

    public static int a(boolean z) {
        return 1;
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int d(int i) {
        if ((i & com.alipay.sdk.m.p.a.g) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m256b(int i, long j) throws IOException {
        c(i, 0);
        m257b(j);
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    private void c() throws IOException {
        OutputStream outputStream = this.f184a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f185a, 0, this.f7844b);
        this.f7844b = 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m260d(int i) throws IOException {
        while ((i & com.alipay.sdk.m.p.a.g) != 0) {
            m258c((i & 127) | 128);
            i >>>= 7;
        }
        m258c(i);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m255b(int i, int i2) throws IOException {
        c(i, 0);
        m254b(i2);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m243a(int i, long j) throws IOException {
        c(i, 0);
        m248a(j);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m257b(long j) throws IOException {
        m259c(j);
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f184a = outputStream;
        this.f185a = bArr;
        this.f7844b = 0;
        this.f7843a = bArr.length;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m254b(int i) throws IOException {
        m260d(i);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m258c(int i) throws IOException {
        a((byte) i);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m242a(int i, int i2) throws IOException {
        c(i, 0);
        m241a(i2);
    }

    public void c(int i, int i2) throws IOException {
        m260d(f.a(i, i2));
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int b(long j) {
        return c(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m247a(int i, boolean z) throws IOException {
        c(i, 0);
        m252a(z);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m259c(long j) throws IOException {
        while (((-128) & j) != 0) {
            m258c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m258c((int) j);
    }

    public static int b(int i) {
        return d(i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m246a(int i, String str) throws IOException {
        c(i, 2);
        m251a(str);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m245a(int i, e eVar) throws IOException {
        c(i, 2);
        m250a(eVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m244a(int i, com.xiaomi.push.a aVar) throws IOException {
        c(i, 2);
        m249a(aVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m248a(long j) throws IOException {
        m259c(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m241a(int i) throws IOException {
        if (i >= 0) {
            m260d(i);
        } else {
            m259c(i);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m252a(boolean z) throws IOException {
        m258c(z ? 1 : 0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m251a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m260d(bytes.length);
        a(bytes);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m250a(e eVar) throws IOException {
        m260d(eVar.a());
        eVar.a(this);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m249a(com.xiaomi.push.a aVar) throws IOException {
        byte[] bArrM185a = aVar.m185a();
        m260d(bArrM185a.length);
        a(bArrM185a);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int iB = eVar.b();
        return d(iB) + iB;
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m240a() throws IOException {
        if (this.f184a != null) {
            c();
        }
    }

    public int a() {
        if (this.f184a == null) {
            return this.f7843a - this.f7844b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b2) throws IOException {
        if (this.f7844b == this.f7843a) {
            c();
        }
        byte[] bArr = this.f185a;
        int i = this.f7844b;
        this.f7844b = i + 1;
        bArr[i] = b2;
    }

    public void a(byte[] bArr) throws IOException {
        m253a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m253a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f7843a;
        int i4 = this.f7844b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f185a, i4, i2);
            this.f7844b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f185a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f7844b = this.f7843a;
        c();
        if (i7 <= this.f7843a) {
            System.arraycopy(bArr, i6, this.f185a, 0, i7);
            this.f7844b = i7;
        } else {
            this.f184a.write(bArr, i6, i7);
        }
    }
}
