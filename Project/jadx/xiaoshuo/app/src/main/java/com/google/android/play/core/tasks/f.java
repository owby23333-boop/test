package com.google.android.play.core.tasks;

/* JADX INFO: loaded from: classes7.dex */
final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Task f7005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e f7006b;

    public f(e eVar, Task task) {
        this.f7006b = eVar;
        this.f7005a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f7006b.f7004b) {
            if (this.f7006b.c != null) {
                this.f7006b.c.onSuccess(this.f7005a.getResult());
            }
        }
    }
}
