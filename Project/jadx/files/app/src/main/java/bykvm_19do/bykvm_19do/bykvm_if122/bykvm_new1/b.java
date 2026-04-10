package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.b, h, f, e, g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile b f1750e;
    private h a = new j();
    private f b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f1751c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f1752d = new i();

    private b() {
    }

    public static b h() {
        if (f1750e == null) {
            synchronized (b.class) {
                if (f1750e == null) {
                    f1750e = new b();
                }
            }
        }
        return f1750e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        return this.f1751c.a(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> a() {
        return this.f1751c.a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public void a(Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> map) {
        this.a.a(map);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public void a(JSONArray jSONArray) {
        this.f1752d.a(jSONArray);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public void a(JSONObject jSONObject) {
        this.b.a(jSONObject);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int b() {
        return this.b.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b(String str) {
        return this.f1752d.b(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void b(JSONObject jSONObject) {
        this.f1751c.b(jSONObject);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public long c() {
        return this.b.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c(String str) {
        return this.a.c(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void d() {
        this.f1751c.d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public boolean e() {
        return this.f1751c.e();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int f() {
        return this.b.f();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public boolean g() {
        return this.f1752d.g();
    }
}
