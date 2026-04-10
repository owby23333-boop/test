package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: classes4.dex */
public class bp extends bv {
    private static final ca d = new ca("");
    private static final bq e = new bq("", (byte) 0, 0);
    private static final byte[] f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f2199a;
    byte[] b;
    byte[] c;
    private au m;
    private short n;
    private bq o;
    private Boolean p;
    private final long q;
    private byte[] r;

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & 15;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void c() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void e() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void f() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void g() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void i() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void m() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void o() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void q() throws bc {
    }

    @Override // com.umeng.analytics.pro.bv
    public void s() throws bc {
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class a implements bx {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f2200a;

        public a() {
            this.f2200a = -1L;
        }

        public a(int i) {
            this.f2200a = i;
        }

        @Override // com.umeng.analytics.pro.bx
        public bv a(cj cjVar) {
            return new bp(cjVar, this.f2200a);
        }
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f2201a = 1;
        public static final byte b = 2;
        public static final byte c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    public bp(cj cjVar, long j2) {
        super(cjVar);
        this.m = new au(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.f2199a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j2;
    }

    public bp(cj cjVar) {
        this(cjVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bv
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bt btVar) throws bc {
        b(h);
        d(((btVar.b << 5) & (-32)) | 1);
        b(btVar.c);
        a(btVar.f2205a);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ca caVar) throws bc {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bv
    public void b() throws bc {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bq bqVar) throws bc {
        if (bqVar.b == 2) {
            this.o = bqVar;
        } else {
            a(bqVar, (byte) -1);
        }
    }

    private void a(bq bqVar, byte b2) throws bc {
        if (b2 == -1) {
            b2 = e(bqVar.b);
        }
        if (bqVar.c > this.n && bqVar.c - this.n <= 15) {
            d(b2 | ((bqVar.c - this.n) << 4));
        } else {
            b(b2);
            a(bqVar.c);
        }
        this.n = bqVar.c;
    }

    @Override // com.umeng.analytics.pro.bv
    public void d() throws bc {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bs bsVar) throws bc {
        if (bsVar.c == 0) {
            d(0);
            return;
        }
        b(bsVar.c);
        d(e(bsVar.b) | (e(bsVar.f2204a) << 4));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(br brVar) throws bc {
        a(brVar.f2203a, brVar.b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(bz bzVar) throws bc {
        a(bzVar.f2209a, bzVar.b);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(boolean z) throws bc {
        bq bqVar = this.o;
        if (bqVar != null) {
            a(bqVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(byte b2) throws bc {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(short s) throws bc {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(int i2) throws bc {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(long j2) throws bc {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(double d2) throws bc {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(String str) throws bc {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bc("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public void a(ByteBuffer byteBuffer) throws bc {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bc {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bc {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void b(int i2) throws bc {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.f2199a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        this.f2199a[i3] = (byte) i2;
        this.g.b(this.f2199a, 0, i3 + 1);
    }

    private void b(long j2) throws bc {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        this.b[i2] = (byte) j2;
        this.g.b(this.b, 0, i2 + 1);
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private void b(byte b2) throws bc {
        this.r[0] = b2;
        this.g.b(this.r);
    }

    private void d(int i2) throws bc {
        b((byte) i2);
    }

    @Override // com.umeng.analytics.pro.bv
    public bt h() throws bc {
        byte bU = u();
        if (bU != -126) {
            throw new bw("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & 31);
        if (b2 != 1) {
            throw new bw("Expected version 1 but got " + ((int) b2));
        }
        return new bt(z(), (byte) ((bU2 >> 5) & 3), E());
    }

    @Override // com.umeng.analytics.pro.bv
    public ca j() throws bc {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.bv
    public void k() throws bc {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bv
    public bq l() throws bc {
        short sV;
        byte bU = u();
        if (bU == 0) {
            return e;
        }
        short s = (short) ((bU & 240) >> 4);
        if (s == 0) {
            sV = v();
        } else {
            sV = (short) (this.n + s);
        }
        byte b2 = (byte) (bU & 15);
        bq bqVar = new bq("", d(b2), sV);
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bqVar.c;
        return bqVar;
    }

    @Override // com.umeng.analytics.pro.bv
    public bs n() throws bc {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new bs(d((byte) (bU >> 4)), d((byte) (bU & 15)), iE);
    }

    @Override // com.umeng.analytics.pro.bv
    public br p() throws bc {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new br(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.bv
    public bz r() throws bc {
        return new bz(p());
    }

    @Override // com.umeng.analytics.pro.bv
    public boolean t() throws bc {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.bv
    public byte u() throws bc {
        if (this.g.h() > 0) {
            byte b2 = this.g.f()[this.g.g()];
            this.g.a(1);
            return b2;
        }
        this.g.d(this.c, 0, 1);
        return this.c[0];
    }

    @Override // com.umeng.analytics.pro.bv
    public short v() throws bc {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bv
    public int w() throws bc {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bv
    public long x() throws bc {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bv
    public double y() throws bc {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bv
    public String z() throws bc {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.g.h() >= iE) {
                String str = new String(this.g.f(), this.g.g(), iE, "UTF-8");
                this.g.a(iE);
                return str;
            }
            return new String(e(iE), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bc("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bv
    public ByteBuffer A() throws bc {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    private byte[] e(int i2) throws bc {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws bw {
        if (i2 < 0) {
            throw new bw("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 != -1 && i2 > j2) {
            throw new bw("Length exceeded max allowed: " + i2);
        }
    }

    private int E() throws bc {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & 127) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & 127) << i5;
                if ((bU & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bc {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                j3 |= ((long) (b2 & 127)) << i3;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                byte bU = u();
                j2 |= ((long) (bU & 127)) << i2;
                if ((bU & 128) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }

    private byte d(byte b2) throws bw {
        byte b3 = (byte) (b2 & 15);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new bw("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f[b2];
    }
}
