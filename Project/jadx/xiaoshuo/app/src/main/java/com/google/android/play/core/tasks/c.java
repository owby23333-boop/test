package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
final class c<TResult> implements g<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f6999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7000b = new Object();
    private OnFailureListener c;

    public c(Executor executor, OnFailureListener onFailureListener) {
        this.f6999a = executor;
        this.c = onFailureListener;
    }

    @Override // com.google.android.play.core.tasks.g
    public final void a(Task<TResult> task) {
        if (task.isSuccessful()) {
            return;
        }
        synchronized (this.f7000b) {
            if (this.c == null) {
                return;
            }
            this.f6999a.execute(new d(this, task));
        }
    }
}
