package me.jessyan.art.e;

import android.content.Context;

/* JADX INFO: compiled from: ErrorHandlerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    private Context a;
    private b b;

    public a(Context context, b bVar) {
        this.b = bVar;
        this.a = context;
    }

    public void a(Throwable th) {
        this.b.a(this.a, th);
    }

    public Context a() {
        return this.a;
    }
}
