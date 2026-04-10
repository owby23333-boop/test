package com.yuewen;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes15.dex */
public class sv1<T> {
    public static final String f = "MainThreadFuture";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f17759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<T> f17760b;
    public final b<T> c = new b<>();
    public final ReentrantLock d;
    public final Condition e;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            Exception exc = null;
            try {
                objCall = sv1.this.f17760b.call();
            } catch (Exception e) {
                objCall = null;
                exc = e;
            }
            try {
                sv1.this.d.lock();
                if (exc == null) {
                    sv1.this.c.f(objCall);
                } else {
                    sv1.this.c.e(exc);
                }
                sv1.this.c.d();
                sv1.this.e.signalAll();
            } finally {
                sv1.this.d.unlock();
            }
        }
    }

    public static class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f17762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Exception f17763b;
        public boolean c;

        public T a() {
            return this.f17762a;
        }

        public Exception b() {
            return this.f17763b;
        }

        public boolean c() {
            return this.c;
        }

        public void d() {
            this.c = true;
        }

        public void e(Exception exc) {
            this.f17763b = exc;
        }

        public void f(T t) {
            this.f17762a = t;
        }

        public b() {
        }
    }

    public sv1(Callable<T> callable) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.d = reentrantLock;
        this.e = reentrantLock.newCondition();
        this.f17759a = new Handler(Looper.getMainLooper());
        this.f17760b = callable;
    }

    public T e() throws ExecutionException, InterruptedException, TimeoutException {
        return f(3000L, TimeUnit.MILLISECONDS);
    }

    public T f(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                return this.f17760b.call();
            } catch (Exception e) {
                throw new ExecutionException(e);
            }
        }
        this.f17759a.post(new a());
        try {
            this.d.lock();
            while (!this.c.c()) {
                if (!this.e.await(j, timeUnit)) {
                    throw new TimeoutException();
                }
            }
            Exception excB = this.c.b();
            if (excB == null) {
                return this.c.a();
            }
            throw new ExecutionException(excB);
        } finally {
            this.d.unlock();
        }
    }

    public T g(T t) {
        try {
            return e();
        } catch (Exception e) {
            pw3.c(f, e);
            return t;
        }
    }
}
