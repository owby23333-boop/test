package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    protected String a;
    protected String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f1399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f1400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f1401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1402f;

    public d(String str, String str2, String str3, String str4, int i2) {
        this.a = str;
        this.f1399c = str3;
        this.f1401e = i2;
        this.b = str2;
        this.f1402f = !TextUtils.isEmpty(str2);
        this.f1400d = str4;
    }

    public boolean a() {
        return this.f1401e == 1;
    }

    public String b() {
        return this.f1400d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.f1399c;
    }

    public int f() {
        return this.f1401e;
    }

    public String g() {
        if (TextUtils.isEmpty(this.b)) {
            return this.a;
        }
        return this.a + "_" + this.b;
    }

    public boolean h() {
        return this.f1402f;
    }
}
