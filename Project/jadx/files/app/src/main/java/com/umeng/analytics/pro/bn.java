package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: classes3.dex */
public class bn extends bu {
    protected static final int a = -65536;
    protected static final int b = -2147418112;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final bz f19543h = new bz();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f19544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f19545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f19546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f19547f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f19548i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f19549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f19550k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f19551l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f19552m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f19553n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f19554o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private byte[] f19555p;

    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class a implements bw {
        protected boolean a;
        protected boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f19556c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            bn bnVar = new bn(ciVar, this.a, this.b);
            int i2 = this.f19556c;
            if (i2 != 0) {
                bnVar.c(i2);
            }
            return bnVar;
        }

        public a(boolean z2, boolean z3) {
            this(z2, z3, 0);
        }

        public a(boolean z2, boolean z3, int i2) {
            this.a = false;
            this.b = true;
            this.a = z2;
            this.b = z3;
            this.f19556c = i2;
        }
    }

    public bn(ci ciVar) {
        this(ciVar, false, true);
    }

    @Override // com.umeng.analytics.pro.bu
    public ByteBuffer A() throws bb {
        int iW = w();
        d(iW);
        if (this.f19587g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f19587g.f(), this.f19587g.g(), iW);
            this.f19587g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.f19587g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bs bsVar) throws bb {
        if (this.f19545d) {
            a(b | bsVar.b);
            a(bsVar.a);
            a(bsVar.f19584c);
        } else {
            a(bsVar.a);
            a(bsVar.b);
            a(bsVar.f19584c);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bz bzVar) {
    }

    public String b(int i2) throws bb {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.f19587g.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void c() {
    }

    public void c(int i2) {
        this.f19546e = i2;
        this.f19547f = true;
    }

    @Override // com.umeng.analytics.pro.bu
    public void d() throws bb {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void e() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void f() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void g() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bs h() throws bb {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) == b) {
                return new bs(z(), (byte) (iW & 255), w());
            }
            throw new bv(4, "Bad version in readMessageBegin");
        }
        if (this.f19544c) {
            throw new bv(4, "Missing version in readMessageBegin, old client?");
        }
        return new bs(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bz j() {
        return f19543h;
    }

    @Override // com.umeng.analytics.pro.bu
    public void k() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bp l() throws bb {
        byte bU = u();
        return new bp("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.bu
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bu
    public br n() throws bb {
        return new br(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bq p() throws bb {
        return new bq(u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bu
    public by r() throws bb {
        return new by(u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void s() {
    }

    @Override // com.umeng.analytics.pro.bu
    public boolean t() throws bb {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.bu
    public byte u() throws bb {
        if (this.f19587g.h() < 1) {
            a(this.f19552m, 0, 1);
            return this.f19552m[0];
        }
        byte b2 = this.f19587g.f()[this.f19587g.g()];
        this.f19587g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.bu
    public short v() throws bb {
        byte[] bArrF = this.f19553n;
        int iG = 0;
        if (this.f19587g.h() >= 2) {
            bArrF = this.f19587g.f();
            iG = this.f19587g.g();
            this.f19587g.a(2);
        } else {
            a(this.f19553n, 0, 2);
        }
        return (short) ((bArrF[iG + 1] & 255) | ((bArrF[iG] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.bu
    public int w() throws bb {
        byte[] bArrF = this.f19554o;
        int iG = 0;
        if (this.f19587g.h() >= 4) {
            bArrF = this.f19587g.f();
            iG = this.f19587g.g();
            this.f19587g.a(4);
        } else {
            a(this.f19554o, 0, 4);
        }
        return (bArrF[iG + 3] & 255) | ((bArrF[iG] & 255) << 24) | ((bArrF[iG + 1] & 255) << 16) | ((bArrF[iG + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public long x() throws bb {
        byte[] bArrF = this.f19555p;
        int iG = 0;
        if (this.f19587g.h() >= 8) {
            bArrF = this.f19587g.f();
            iG = this.f19587g.g();
            this.f19587g.a(8);
        } else {
            a(this.f19555p, 0, 8);
        }
        return ((long) (bArrF[iG + 7] & 255)) | (((long) (bArrF[iG] & 255)) << 56) | (((long) (bArrF[iG + 1] & 255)) << 48) | (((long) (bArrF[iG + 2] & 255)) << 40) | (((long) (bArrF[iG + 3] & 255)) << 32) | (((long) (bArrF[iG + 4] & 255)) << 24) | (((long) (bArrF[iG + 5] & 255)) << 16) | (((long) (bArrF[iG + 6] & 255)) << 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public double y() throws bb {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.bu
    public String z() throws bb {
        int iW = w();
        if (this.f19587g.h() < iW) {
            return b(iW);
        }
        try {
            String str = new String(this.f19587g.f(), this.f19587g.g(), iW, "UTF-8");
            this.f19587g.a(iW);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public bn(ci ciVar, boolean z2, boolean z3) {
        super(ciVar);
        this.f19544c = false;
        this.f19545d = true;
        this.f19547f = false;
        this.f19548i = new byte[1];
        this.f19549j = new byte[2];
        this.f19550k = new byte[4];
        this.f19551l = new byte[8];
        this.f19552m = new byte[1];
        this.f19553n = new byte[2];
        this.f19554o = new byte[4];
        this.f19555p = new byte[8];
        this.f19544c = z2;
        this.f19545d = z3;
    }

    protected void d(int i2) throws bb {
        if (i2 < 0) {
            throw new bv("Negative length: " + i2);
        }
        if (this.f19547f) {
            this.f19546e -= i2;
            if (this.f19546e >= 0) {
                return;
            }
            throw new bv("Message length exceeded: " + i2);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bp bpVar) throws bb {
        a(bpVar.b);
        a(bpVar.f19582c);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(br brVar) throws bb {
        a(brVar.a);
        a(brVar.b);
        a(brVar.f19583c);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bq bqVar) throws bb {
        a(bqVar.a);
        a(bqVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(by byVar) throws bb {
        a(byVar.a);
        a(byVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(boolean z2) throws bb {
        a(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(byte b2) throws bb {
        byte[] bArr = this.f19548i;
        bArr[0] = b2;
        this.f19587g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(short s2) throws bb {
        byte[] bArr = this.f19549j;
        bArr[0] = (byte) ((s2 >> 8) & 255);
        bArr[1] = (byte) (s2 & 255);
        this.f19587g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(int i2) throws bb {
        byte[] bArr = this.f19550k;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.f19587g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(long j2) throws bb {
        byte[] bArr = this.f19551l;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        this.f19587g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(double d2) throws bb {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(String str) throws bb {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f19587g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(ByteBuffer byteBuffer) throws bb {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.f19587g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    private int a(byte[] bArr, int i2, int i3) throws bb {
        d(i3);
        return this.f19587g.d(bArr, i2, i3);
    }
}
