package me.jessyan.art.e;

import android.content.Context;

/* JADX INFO: compiled from: RxErrorHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private me.jessyan.art.e.a a;

    /* JADX INFO: compiled from: RxErrorHandler.java */
    public static final class b {
        private Context a;
        private me.jessyan.art.e.b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private me.jessyan.art.e.a f21181c;

        private b() {
        }

        public b a(Context context) {
            if (context == null) {
                throw new NullPointerException("Context cannot be null");
            }
            this.a = context;
            return this;
        }

        public b a(me.jessyan.art.e.b bVar) {
            if (bVar != null) {
                this.b = bVar;
                return this;
            }
            throw new NullPointerException("responseErrorListener cannot be null");
        }

        public c a() {
            Context context = this.a;
            if (context != null) {
                me.jessyan.art.e.b bVar = this.b;
                if (bVar != null) {
                    this.f21181c = new me.jessyan.art.e.a(context, bVar);
                    return new c(this);
                }
                throw new IllegalStateException("ResponseErrorListener is required");
            }
            throw new IllegalStateException("Context is required");
        }
    }

    public static b b() {
        return new b();
    }

    public me.jessyan.art.e.a a() {
        return this.a;
    }

    private c(b bVar) {
        this.a = bVar.f21181c;
    }
}
