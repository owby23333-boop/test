package com.yuewen;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b80 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9004a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hm1 f9005b;
        public final /* synthetic */ int c;

        public a(hm1 hm1Var, int i) {
            this.f9005b = hm1Var;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9004a) {
                return;
            }
            this.f9004a = true;
            if (this.f9005b.a()) {
                b80.d(this.f9005b, this.c);
            }
        }
    }

    public class b implements hm1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f9006a;

        public b(Runnable runnable) {
            this.f9006a = runnable;
        }

        @Override // com.yuewen.hm1
        public boolean a() {
            this.f9006a.run();
            return false;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hm1 f9007a;

        public class a implements MessageQueue.IdleHandler {
            public a() {
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                return c.this.f9007a.a();
            }
        }

        public c(hm1 hm1Var) {
            this.f9007a = hm1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.myQueue().addIdleHandler(new a());
        }
    }

    public static final Thread a() {
        return Thread.currentThread();
    }

    public static final void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        runnable.run();
    }

    public static final void c(hm1 hm1Var) {
        if (hm1Var == null) {
            return;
        }
        new Handler().post(new c(hm1Var));
    }

    public static final void d(hm1 hm1Var, int i) {
        if (hm1Var == null) {
            return;
        }
        a aVar = new a(hm1Var, i);
        c(new b(aVar));
        new Handler().postDelayed(aVar, i);
    }

    public static final void e(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
    }
}
