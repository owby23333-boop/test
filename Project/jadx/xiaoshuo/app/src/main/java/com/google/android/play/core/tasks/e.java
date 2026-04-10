package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
final class e<TResult> implements g<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f7003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7004b = new Object();
    private OnSuccessListener<? super TResult> c;

    public e(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f7003a = executor;
        this.c = onSuccessListener;
    }

    @Override // com.google.android.play.core.tasks.g
    public final void a(Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.f7004b) {
                if (this.c == null) {
                    return;
                }
                this.f7003a.execute(new f(this, task));
            }
        }
    }
}
