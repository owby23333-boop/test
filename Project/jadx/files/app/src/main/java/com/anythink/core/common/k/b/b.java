package com.anythink.core.common.k.b;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7665d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7666e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7667f = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected c f7669h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected boolean f7668g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f7670i = 1;
    private long a = 0;
    private String b = "topon-default-thread";

    private String c() {
        return this.b;
    }

    public abstract void a();

    public final void a(long j2) {
        this.a = j2;
    }

    public final long b() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setName(this.b);
        a();
    }

    private void a(c cVar) {
        this.f7669h = cVar;
    }

    public final void a(String str) {
        this.b = str;
    }
}
