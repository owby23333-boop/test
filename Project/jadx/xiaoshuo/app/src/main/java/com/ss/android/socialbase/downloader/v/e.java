package com.ss.android.socialbase.downloader.v;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class e implements ThreadFactory {
    private final AtomicInteger bf;
    private final boolean d;
    private final String e;

    public e(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.e + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.bf.incrementAndGet());
        if (!this.d) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public e(String str, boolean z) {
        this.bf = new AtomicInteger();
        this.e = str;
        this.d = z;
    }
}
