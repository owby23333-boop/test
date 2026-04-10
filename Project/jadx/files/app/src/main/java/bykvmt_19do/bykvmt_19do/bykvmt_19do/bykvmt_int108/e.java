package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108;

import java.io.Serializable;

/* JADX INFO: compiled from: TTWaterFallConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Comparable<e>, Serializable {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f2149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f2151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f2152k;

    public String a() {
        return this.f2149h;
    }

    public int b() {
        return this.f2148g;
    }

    public void c(int i2) {
        this.f2147f = i2;
    }

    public void d(int i2) {
        this.f2152k = i2;
    }

    public void e(int i2) {
        this.f2151j = i2;
    }

    public int f() {
        return this.f2152k;
    }

    public int g() {
        return this.f2151j;
    }

    public void g(int i2) {
    }

    public int h() {
        return this.f2150i;
    }

    public String i() {
        return this.f2146e;
    }

    public int j() {
        return this.f2145d;
    }

    public boolean k() {
        int i2 = this.f2144c;
        return i2 == 1 || i2 == 2;
    }

    public void a(String str) {
        this.f2149h = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(String str) {
        this.f2146e = str;
    }

    public int e() {
        return this.f2147f;
    }

    public void f(int i2) {
        this.f2145d = i2;
    }

    public void a(int i2) {
        this.f2148g = i2;
    }

    public void b(int i2) {
        this.f2144c = i2;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        if (eVar != null && this.f2147f <= eVar.e()) {
            return this.f2147f < eVar.e() ? -1 : 0;
        }
        return 1;
    }
}
