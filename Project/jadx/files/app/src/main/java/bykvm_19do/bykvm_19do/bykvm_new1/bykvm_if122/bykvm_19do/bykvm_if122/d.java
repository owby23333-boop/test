package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122.b;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class d implements ThreadFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f2031e = new AtomicInteger(1);
    private final ThreadGroup a;
    private final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b.a f2033d;

    d(b.a aVar, String str) {
        StringBuilder sb;
        this.f2033d = aVar;
        SecurityManager securityManager = System.getSecurityManager();
        this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        if (TextUtils.isEmpty(str)) {
            sb = new StringBuilder();
            str = "ttdefault-";
        } else {
            sb = new StringBuilder();
        }
        sb.append(str);
        sb.append(f2031e.getAndIncrement());
        sb.append("-thread-");
        this.f2032c = sb.toString();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int i2;
        Thread thread = new Thread(this.a, runnable, this.f2032c + this.b.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        b.a aVar = this.f2033d;
        if (aVar != null && aVar.a() == b.a.LOW.a()) {
            i2 = 1;
        } else {
            if (thread.getPriority() == 5) {
                thread.setPriority(5);
                return thread;
            }
            i2 = 3;
        }
        thread.setPriority(i2);
        return thread;
    }
}
