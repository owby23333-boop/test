package com.ss.android.socialbase.downloader.v;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f2113a;
    private z dl;
    private Object z = new Object();
    private Queue<g> g = new ConcurrentLinkedQueue();

    public e(String str) {
        this.dl = new z(str);
    }

    public void z() {
        this.dl.start();
    }

    public void z(Runnable runnable) {
        z(runnable, 0L);
    }

    public void z(Runnable runnable, long j) {
        if (this.f2113a == null) {
            synchronized (this.z) {
                if (this.f2113a == null) {
                    this.g.add(new g(runnable, j));
                    return;
                }
            }
        }
        this.f2113a.postDelayed(runnable, j);
    }

    public void g() {
        this.dl.quit();
    }

    private class z extends HandlerThread {
        z(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (e.this.z) {
                e.this.f2113a = new Handler(looper);
            }
            while (!e.this.g.isEmpty()) {
                g gVar = (g) e.this.g.poll();
                if (gVar != null) {
                    e.this.f2113a.postDelayed(gVar.z, gVar.g);
                }
            }
        }
    }

    private class g {
        public long g;
        public Runnable z;

        public g(Runnable runnable, long j) {
            this.z = runnable;
            this.g = j;
        }
    }
}
