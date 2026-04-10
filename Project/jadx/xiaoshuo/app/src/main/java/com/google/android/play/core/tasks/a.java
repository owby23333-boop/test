package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
final class a<TResult> implements g<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f6995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f6996b = new Object();
    private OnCompleteListener<TResult> c;

    public a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f6995a = executor;
        this.c = onCompleteListener;
    }

    @Override // com.google.android.play.core.tasks.g
    public final void a(Task<TResult> task) {
        synchronized (this.f6996b) {
            if (this.c == null) {
                return;
            }
            this.f6995a.execute(new b(this, task));
        }
    }
}
