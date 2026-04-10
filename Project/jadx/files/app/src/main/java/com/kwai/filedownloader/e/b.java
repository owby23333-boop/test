package com.kwai.filedownloader.e;

import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static volatile ThreadPoolExecutor aHQ;

    static class a implements ThreadFactory {
        private static final AtomicInteger aHR = new AtomicInteger(1);
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        a(String str) {
            this.namePrefix = f.fn(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, "ksad-" + this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    private static ThreadPoolExecutor IM() {
        if (aHQ == null) {
            synchronized (b.class) {
                if (aHQ == null) {
                    com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(""));
                    aHQ = bVar;
                    com.kwad.sdk.core.threads.d.a(bVar, "ksad-filedownload-default");
                }
            }
        }
        return aHQ;
    }

    @Deprecated
    public static ThreadPoolExecutor a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        if (ta()) {
            return IM();
        }
        com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(i2, i2, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        com.kwad.sdk.core.threads.d.a(bVar, "ksad-" + str);
        bVar.allowCoreThreadTimeOut(true);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor fh(String str) {
        if (ta()) {
            return IM();
        }
        com.kwad.sdk.core.threads.kwai.b bVar = new com.kwad.sdk.core.threads.kwai.b(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
        com.kwad.sdk.core.threads.d.a(bVar, "ksad-" + str);
        return bVar;
    }

    @Deprecated
    public static ThreadPoolExecutor n(int i2, String str) {
        return ta() ? IM() : a(i2, new LinkedBlockingQueue(), str);
    }

    private static boolean ta() {
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar != null) {
            return fVar.ta();
        }
        return false;
    }
}
