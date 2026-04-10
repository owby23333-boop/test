package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes7.dex */
final class j implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
