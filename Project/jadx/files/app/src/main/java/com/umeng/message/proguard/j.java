package com.umeng.message.proguard;

/* JADX INFO: compiled from: BaseNCodec.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    private static final int a = 2;
    public static final int b = 76;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f20465c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final int f20466d = 255;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final byte f20467e = 61;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f20468m = 8192;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final byte f20469f = f20467e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final int f20470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected byte[] f20471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f20472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f20473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f20474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f20475l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f20476n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f20477o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f20478p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f20479q;

    protected j(int i2, int i3, int i4, int i5) {
        this.f20476n = i2;
        this.f20477o = i3;
        this.f20470g = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f20478p = i5;
    }

    private void a() {
        byte[] bArr = this.f20471h;
        if (bArr == null) {
            this.f20471h = new byte[d()];
            this.f20472i = 0;
            this.f20479q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f20471h = bArr2;
        }
    }

    protected static boolean c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void e() {
        this.f20471h = null;
        this.f20472i = 0;
        this.f20479q = 0;
        this.f20474k = 0;
        this.f20475l = 0;
        this.f20473j = false;
    }

    abstract void a(byte[] bArr, int i2, int i3);

    abstract void b(byte[] bArr, int i2, int i3);

    boolean b() {
        return this.f20471h != null;
    }

    protected abstract boolean b(byte b2);

    int c() {
        if (this.f20471h != null) {
            return this.f20472i - this.f20479q;
        }
        return 0;
    }

    protected int d() {
        return 8192;
    }

    public byte[] j(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f20472i];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    public byte[] k(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f20472i - this.f20479q];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    protected boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (61 == bArr[i2] || b(bArr[i2])) {
                return true;
            }
        }
        return false;
    }

    public long m(byte[] bArr) {
        int length = bArr.length;
        long j2 = ((long) (((length + r0) - 1) / this.f20476n)) * ((long) this.f20477o);
        int i2 = this.f20470g;
        return i2 > 0 ? j2 + ((((((long) i2) + j2) - 1) / ((long) i2)) * ((long) this.f20478p)) : j2;
    }

    public Object b(Object obj) throws Exception {
        if (obj instanceof byte[]) {
            return j((byte[]) obj);
        }
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new Exception("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    int c(byte[] bArr, int i2, int i3) {
        if (this.f20471h == null) {
            return this.f20473j ? -1 : 0;
        }
        int iMin = Math.min(c(), i3);
        System.arraycopy(this.f20471h, this.f20479q, bArr, i2, iMin);
        this.f20479q += iMin;
        if (this.f20479q >= this.f20472i) {
            this.f20471h = null;
        }
        return iMin;
    }

    public byte[] b(String str) {
        return j(g.a(str));
    }

    protected void a(int i2) {
        byte[] bArr = this.f20471h;
        if (bArr == null || bArr.length < this.f20472i + i2) {
            a();
        }
    }

    public boolean b(byte[] bArr, boolean z2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!b(bArr[i2]) && (!z2 || (bArr[i2] != 61 && !c(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    public boolean c(String str) {
        return b(g.a(str), true);
    }

    public Object a(Object obj) throws Exception {
        if (obj instanceof byte[]) {
            return k((byte[]) obj);
        }
        throw new Exception("Parameter supplied to Base-N encode is not a byte[]");
    }
}
