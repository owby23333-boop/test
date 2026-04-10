package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a {
    private b a;
    private byte b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte f1904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f1905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f1906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f1907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f1908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected JSONObject f1909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte f1910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f1911j;

    public a(String str, b bVar) {
        this.f1908g = str;
        this.a = bVar;
    }

    public a(String str, JSONObject jSONObject) {
        this.f1908g = str;
        this.f1909h = jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public long a() {
        return this.f1905d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void a(byte b) {
        this.b = b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void a(long j2) {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public byte b() {
        return this.b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void b(byte b) {
        this.f1904c = b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void b(long j2) {
        this.f1906e = j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public byte c() {
        return this.f1910i;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public void c(long j2) {
        this.f1905d = j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public JSONObject d() {
        JSONObject jSONObject;
        b bVar;
        synchronized (this) {
            if (this.f1909h == null && (bVar = this.a) != null) {
                this.f1909h = bVar.a(k());
            }
            jSONObject = this.f1909h;
        }
        return jSONObject;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public byte e() {
        return this.f1904c;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public String f() {
        if (TextUtils.isEmpty(this.f1908g)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.f1908g);
            jSONObject.put("event", d());
            jSONObject.put("genTime", j());
            jSONObject.put("priority", (int) this.f1904c);
            jSONObject.put("type", (int) this.b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public b g() {
        return this.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public long h() {
        return this.f1906e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a
    public String i() {
        return this.f1908g;
    }

    public String j() {
        return this.f1907f;
    }

    public String k() {
        return this.f1911j;
    }
}
