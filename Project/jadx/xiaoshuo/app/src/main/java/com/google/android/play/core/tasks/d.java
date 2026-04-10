package com.google.android.play.core.tasks;

/* JADX INFO: loaded from: classes7.dex */
final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f7001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ c f7002b;

    public d(c cVar, Task task) {
        this.f7002b = cVar;
        this.f7001a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f7002b.f7000b) {
            if (this.f7002b.c != null) {
                this.f7002b.c.onFailure(this.f7001a.getException());
            }
        }
    }
}
