package com.yuewen;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes12.dex */
public abstract class gn3 implements cl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gn3 f11620b;
    public a c;
    public final qn3 d;

    public interface a {
        void a();

        void b(gn3 gn3Var);

        void onClose();
    }

    public gn3(String str, @NonNull qn3 qn3Var) {
        this.f11619a = str;
        this.d = qn3Var;
    }

    public final gn3 c() {
        return this.f11620b;
    }

    public void d(a aVar) {
        this.c = aVar;
    }

    public final void e(gn3 gn3Var) {
        this.f11620b = gn3Var;
    }
}
