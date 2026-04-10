package com.yuewen;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public abstract class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ae f8478b;
    public a c;

    public interface a {
        void a();

        void b(View view);

        void c();

        void d(View view, String str);
    }

    public ae(String str) {
        this.f8477a = str;
    }

    public void a() {
    }

    public String b() {
        return "";
    }

    public final ae c() {
        return this.f8478b;
    }

    public void d(a aVar) {
        this.c = aVar;
    }

    public final void e(ae aeVar) {
        this.f8478b = aeVar;
    }

    public abstract void f(String str);
}
