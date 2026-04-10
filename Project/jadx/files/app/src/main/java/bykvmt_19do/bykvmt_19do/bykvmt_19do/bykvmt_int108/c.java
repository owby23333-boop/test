package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108;

import java.io.Serializable;

/* JADX INFO: compiled from: TTAdnConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2141e;

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.f2140d;
    }

    public void b(String str) {
        this.f2139c = str;
    }

    public String c() {
        return this.f2139c;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public String toString() {
        return "TTAdnConfig{mAppId='" + this.a + "', mAppKey='" + this.b + "'}";
    }

    public void a(String str) {
        this.f2140d = str;
    }

    public int b() {
        return this.f2141e;
    }

    public void a(int i2) {
        this.f2141e = i2;
    }
}
