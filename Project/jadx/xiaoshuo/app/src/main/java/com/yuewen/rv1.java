package com.yuewen;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.duokan.core.diagnostic.LogLevel;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes12.dex */
public abstract class rv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f17259a = new Handler(Looper.getMainLooper());

    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f17260a;

        public a(Runnable runnable) {
            this.f17260a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Runnable runnable = this.f17260a;
            if (runnable == null) {
                return null;
            }
            runnable.run();
            return null;
        }
    }

    public class b implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f17261a;

        public b(Runnable runnable) {
            this.f17261a = runnable;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            Runnable runnable = this.f17261a;
            if (runnable == null) {
                return false;
            }
            runnable.run();
            return false;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hm1 f17262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f17263b;

        public c(hm1 hm1Var, int i) {
            this.f17262a = hm1Var;
            this.f17263b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b80.d(this.f17262a, this.f17263b);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hm1 f17264a;

        public d(hm1 hm1Var) {
            this.f17264a = hm1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b80.c(this.f17264a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class e<T> implements Future<T> {
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public T get() throws ExecutionException, InterruptedException {
            return null;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> extends FutureTask<T> {
        public f(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void setException(Throwable th) {
            super.setException(th);
            ia0.w().j(LogLevel.ERROR, rv1.class.getSimpleName(), "An exception occurs!", th);
        }
    }

    public static final <T> T b(Callable<T> callable) throws InterruptedException {
        try {
            if (!g()) {
                return (T) i(callable).get();
            }
            if (callable != null) {
                return callable.call();
            }
            return null;
        } catch (Exception e2) {
            qt1.d("MainThread", "call error!,msg =" + e2.getMessage());
            return null;
        }
    }

    public static final <T> T c(Callable<T> callable) {
        while (true) {
            try {
                return (T) b(callable);
            } catch (InterruptedException unused) {
            }
        }
    }

    public static final void d(Runnable runnable) {
        if (runnable != null) {
            f17259a.removeCallbacks(runnable);
        }
    }

    public static final Thread e() {
        return Looper.getMainLooper().getThread();
    }

    public static final void f(Runnable runnable) {
        f17259a.post(runnable);
    }

    public static final boolean g() {
        return Thread.currentThread() == e();
    }

    public static /* synthetic */ void h(Runnable runnable) {
        Looper.getMainLooper().getQueue().addIdleHandler(new b(runnable));
    }

    public static final <T> Future<T> i(Callable<T> callable) {
        if (callable == null) {
            return new e();
        }
        f fVar = new f(callable);
        f17259a.post(fVar);
        return fVar;
    }

    public static final void j(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f17259a.removeCallbacks(runnable);
    }

    public static final void k(Runnable runnable) {
        a aVar = new a(runnable);
        if (g()) {
            c(aVar);
        } else {
            i(aVar);
        }
    }

    public static final void l(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        f17259a.postAtTime(runnable, j);
    }

    public static final void m(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f17259a.post(runnable);
    }

    public static final void n(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        f17259a.postDelayed(runnable, j);
    }

    public static final void o(final Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        f17259a.postDelayed(new Runnable() { // from class: com.yuewen.qv1
            @Override // java.lang.Runnable
            public final void run() {
                rv1.h(runnable);
            }
        }, j);
    }

    public static final void p(hm1 hm1Var) {
        f17259a.post(new d(hm1Var));
    }

    public static final void q(hm1 hm1Var, int i) {
        f17259a.post(new c(hm1Var, i));
    }
}
