package com.google.android.play.core.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
public final class TaskExecutors {
    public static final Executor MAIN_THREAD = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Executor f6992a = new j();

    public static final class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f6993a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f6993a.post(runnable);
        }
    }

    private TaskExecutors() {
    }
}
