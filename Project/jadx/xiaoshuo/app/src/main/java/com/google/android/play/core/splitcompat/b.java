package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes7.dex */
final class b implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
