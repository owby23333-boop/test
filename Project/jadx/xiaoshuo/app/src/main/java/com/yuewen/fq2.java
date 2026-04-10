package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public abstract class fq2 implements xl3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kv3<fq2> f11189b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vn1<String> f11190a = new vn1<>(new a());

    public class a implements kv3<String> {
        public a() {
        }

        @Override // com.yuewen.kv3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get() {
            return "";
        }
    }

    public static fq2 d() {
        kv3<fq2> kv3Var = f11189b;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void f(kv3<fq2> kv3Var) {
        f11189b = kv3Var;
    }

    public abstract void c(boolean z, m84 m84Var);

    public String e() {
        return this.f11190a.get();
    }

    public abstract void g();
}
