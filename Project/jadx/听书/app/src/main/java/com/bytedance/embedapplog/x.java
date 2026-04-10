package com.bytedance.embedapplog;

import android.os.Handler;
import com.bytedance.embedapplog.fo;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private static final int z = Runtime.getRuntime().availableProcessors();
    private static final fo.z<Executor> g = new fo.z<Executor>() { // from class: com.bytedance.embedapplog.x.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.fo.z
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Executor g(Object... objArr) {
            return new com.bytedance.sdk.component.uy.a.a((int) (((double) x.z) * 0.5d), Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.sdk.component.uy.uy("edapplog/av$1"));
        }
    };
    private static final fo.z<ExecutorService> dl = new fo.z<ExecutorService>() { // from class: com.bytedance.embedapplog.x.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.fo.z
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public ExecutorService g(Object... objArr) {
            return new com.bytedance.sdk.component.uy.a.a((int) (((double) x.z) * 0.5d), Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.sdk.component.uy.uy("edapplog/av$2"));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final fo.z<Handler> f309a = new fo.z<Handler>() { // from class: com.bytedance.embedapplog.x.3
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.fo.z
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Handler g(Object... objArr) {
            return new Handler(o.gz());
        }
    };

    private static Executor dl() {
        return g.dl(new Object[0]);
    }

    private static ExecutorService a() {
        return dl.dl(new Object[0]);
    }

    public static Handler z() {
        return f309a.dl(new Object[0]);
    }

    public static void z(Runnable runnable) {
        dl().execute(runnable);
    }

    public static <T> Future<T> z(Callable<T> callable) {
        return a().submit(callable);
    }
}
