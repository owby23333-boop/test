package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: classes3.dex */
public class bo extends bu {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final bz f19557d = new bz("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final bp f19558e = new bp("", (byte) 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f19559f = new byte[16];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte f19560h = -126;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte f19561i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte f19562j = 31;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final byte f19563k = -32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f19564l = 5;
    byte[] a;
    byte[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    byte[] f19565c;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private at f19566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private short f19567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private bp f19568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Boolean f19569p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final long f19570q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private byte[] f19571r;

    /* JADX INFO: compiled from: TCompactProtocol.java */
    private static class b {
        public static final byte a = 1;
        public static final byte b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final byte f19572c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final byte f19573d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte f19574e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte f19575f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final byte f19576g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final byte f19577h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final byte f19578i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final byte f19579j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final byte f19580k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final byte f19581l = 12;

        private b() {
        }
    }

    static {
        byte[] bArr = f19559f;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    public bo(ci ciVar, long j2) {
        super(ciVar);
        this.f19566m = new at(15);
        this.f19567n = (short) 0;
        this.f19568o = null;
        this.f19569p = null;
        this.a = new byte[5];
        this.b = new byte[10];
        this.f19571r = new byte[1];
        this.f19565c = new byte[1];
        this.f19570q = j2;
    }

    private int E() throws bb {
        int i2 = 0;
        if (this.f19587g.h() >= 5) {
            byte[] bArrF = this.f19587g.f();
            int iG = this.f19587g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & 127) << i4;
                if ((b2 & 128) != 128) {
                    this.f19587g.a(i2 + 1);
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

    private long F() throws bb {
        int i2 = 0;
        long j2 = 0;
        if (this.f19587g.h() >= 10) {
            byte[] bArrF = this.f19587g.f();
            int iG = this.f19587g.g();
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                j2 |= ((long) (b2 & 127)) << i3;
                if ((b2 & 128) != 128) {
                    break;
                }
                i3 += 7;
                i2++;
            }
            this.f19587g.a(i2 + 1);
        } else {
            while (true) {
                byte bU = u();
                j2 |= ((long) (bU & 127)) << i2;
                if ((bU & 128) != 128) {
                    break;
                }
                i2 += 7;
            }
        }
        return j2;
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & cb.f19604m;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) throws bb {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.f19587g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws bv {
        if (i2 < 0) {
            throw new bv("Negative length: " + i2);
        }
        long j2 = this.f19570q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new bv("Length exceeded max allowed: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public ByteBuffer A() throws bb {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.f19587g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void B() {
        this.f19566m.c();
        this.f19567n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bs bsVar) throws bb {
        b(f19560h);
        d(((bsVar.b << 5) & (-32)) | 1);
        b(bsVar.f19584c);
        a(bsVar.a);
    }

    @Override // com.umeng.analytics.pro.bu
    public void b() throws bb {
        this.f19567n = this.f19566m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public void c() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void d() throws bb {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void e() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void f() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void g() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bs h() throws bb {
        byte bU = u();
        if (bU != -126) {
            throw new bv("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & f19562j);
        if (b2 == 1) {
            return new bs(z(), (byte) ((bU2 >> 5) & 3), E());
        }
        throw new bv("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void i() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bz j() throws bb {
        this.f19566m.a(this.f19567n);
        this.f19567n = (short) 0;
        return f19557d;
    }

    @Override // com.umeng.analytics.pro.bu
    public void k() throws bb {
        this.f19567n = this.f19566m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public bp l() throws bb {
        byte bU = u();
        if (bU == 0) {
            return f19558e;
        }
        short s2 = (short) ((bU & 240) >> 4);
        short sV = s2 == 0 ? v() : (short) (this.f19567n + s2);
        byte b2 = (byte) (bU & cb.f19604m);
        bp bpVar = new bp("", d(b2), sV);
        if (c(bU)) {
            this.f19569p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f19567n = bpVar.f19582c;
        return bpVar;
    }

    @Override // com.umeng.analytics.pro.bu
    public void m() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public br n() throws bb {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new br(d((byte) (bU >> 4)), d((byte) (bU & cb.f19604m)), iE);
    }

    @Override // com.umeng.analytics.pro.bu
    public void o() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bq p() throws bb {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new bq(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.bu
    public void q() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public by r() throws bb {
        return new by(p());
    }

    @Override // com.umeng.analytics.pro.bu
    public void s() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public boolean t() throws bb {
        Boolean bool = this.f19569p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.f19569p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.bu
    public byte u() throws bb {
        if (this.f19587g.h() <= 0) {
            this.f19587g.d(this.f19565c, 0, 1);
            return this.f19565c[0];
        }
        byte b2 = this.f19587g.f()[this.f19587g.g()];
        this.f19587g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.bu
    public short v() throws bb {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public int w() throws bb {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public long x() throws bb {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bu
    public double y() throws bb {
        byte[] bArr = new byte[8];
        this.f19587g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bu
    public String z() throws bb {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.f19587g.h() < iE) {
                return new String(e(iE), "UTF-8");
            }
            String str = new String(this.f19587g.f(), this.f19587g.g(), iE, "UTF-8");
            this.f19587g.a(iE);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class a implements bw {
        private final long a;

        public a() {
            this.a = -1L;
        }

        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            return new bo(ciVar, this.a);
        }

        public a(int i2) {
            this.a = i2;
        }
    }

    private void b(int i2) throws bb {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i2;
        this.f19587g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) throws bb {
        b((byte) i2);
    }

    private byte d(byte b2) throws bv {
        byte b3 = (byte) (b2 & cb.f19604m);
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
                return cb.f19604m;
            case 10:
                return cb.f19603l;
            case 11:
                return cb.f19602k;
            case 12:
                return (byte) 12;
            default:
                throw new bv("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f19559f[b2];
    }

    private void b(long j2) throws bb {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.b;
        bArr[i2] = (byte) j2;
        this.f19587g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bz bzVar) throws bb {
        this.f19566m.a(this.f19567n);
        this.f19567n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bp bpVar) throws bb {
        if (bpVar.b == 2) {
            this.f19568o = bpVar;
        } else {
            a(bpVar, (byte) -1);
        }
    }

    private void b(byte b2) throws bb {
        byte[] bArr = this.f19571r;
        bArr[0] = b2;
        this.f19587g.b(bArr);
    }

    private void a(bp bpVar, byte b2) throws bb {
        if (b2 == -1) {
            b2 = e(bpVar.b);
        }
        short s2 = bpVar.f19582c;
        short s3 = this.f19567n;
        if (s2 > s3 && s2 - s3 <= 15) {
            d(b2 | ((s2 - s3) << 4));
        } else {
            b(b2);
            a(bpVar.f19582c);
        }
        this.f19567n = bpVar.f19582c;
    }

    public bo(ci ciVar) {
        this(ciVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(br brVar) throws bb {
        int i2 = brVar.f19583c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(brVar.b) | (e(brVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bq bqVar) throws bb {
        a(bqVar.a, bqVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(by byVar) throws bb {
        a(byVar.a, byVar.b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(boolean z2) throws bb {
        bp bpVar = this.f19568o;
        if (bpVar != null) {
            a(bpVar, z2 ? (byte) 1 : (byte) 2);
            this.f19568o = null;
        } else {
            b(z2 ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(byte b2) throws bb {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(short s2) throws bb {
        b(c((int) s2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(int i2) throws bb {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(long j2) throws bb {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(double d2) throws bb {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.f19587g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(String str) throws bb {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(ByteBuffer byteBuffer) throws bb {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bb {
        b(i3);
        this.f19587g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bb {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
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

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }
}
