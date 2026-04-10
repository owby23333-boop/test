package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private int a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1405e;

    public int a() {
        return this.f1405e;
    }

    public void a(int i2) {
        this.f1405e = i2;
    }

    public void a(long j2) {
        this.f1404d = j2;
    }

    public void a(e eVar) {
        this.a = eVar.c();
        this.b = eVar.e();
        this.f1403c = eVar.d();
        this.f1404d = eVar.b();
        this.f1405e = eVar.a();
    }

    public void a(String str) {
        this.f1403c = str;
    }

    public long b() {
        return this.f1404d;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void b(long j2) {
        this.b = j2;
    }

    public int c() {
        return this.a;
    }

    public String d() {
        return this.f1403c;
    }

    public long e() {
        return this.b;
    }
}
