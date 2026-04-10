package com.google.android.play.core.a;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.tasks.i<?> f6912a;

    public a() {
        this.f6912a = null;
    }

    public final com.google.android.play.core.tasks.i<?> a() {
        return this.f6912a;
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e) {
            if (this.f6912a != null) {
                this.f6912a.a(e);
            }
        }
    }

    public a(com.google.android.play.core.tasks.i<?> iVar) {
        this.f6912a = iVar;
    }
}
