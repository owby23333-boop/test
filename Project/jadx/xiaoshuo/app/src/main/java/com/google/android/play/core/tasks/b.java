package com.google.android.play.core.tasks;

/* JADX INFO: loaded from: classes7.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f6997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ a f6998b;

    public b(a aVar, Task task) {
        this.f6998b = aVar;
        this.f6997a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6998b.f6996b) {
            if (this.f6998b.c != null) {
                this.f6998b.c.onComplete(this.f6997a);
            }
        }
    }
}
