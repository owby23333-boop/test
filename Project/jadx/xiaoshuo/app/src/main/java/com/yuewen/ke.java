package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class ke<TResult> implements ge<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge<TResult> f13454a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f13455a;

        public a(Object obj) {
            this.f13455a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ke.this.f13454a.b(this.f13455a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f13458b;

        public b(int i, String str) {
            this.f13457a = i;
            this.f13458b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ke.this.f13454a.onFailed(this.f13457a, this.f13458b);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ke.this.f13454a.a();
        }
    }

    public ke(ge<TResult> geVar) {
        this.f13454a = geVar;
    }

    @Override // com.yuewen.ge
    public void a() {
        rv1.m(new c());
    }

    @Override // com.yuewen.ge
    public void b(TResult tresult) {
        rv1.m(new a(tresult));
    }

    @Override // com.yuewen.ge
    public void onFailed(int i, String str) {
        rv1.m(new b(i, str));
    }
}
