package com.ss.android.socialbase.downloader.v;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes4.dex */
public class p {
    private e d;
    private Handler tg;
    private Object e = new Object();
    private Queue<bf> bf = new ConcurrentLinkedQueue();

    public class bf {
        public long bf;
        public Runnable e;

        public bf(Runnable runnable, long j) {
            this.e = runnable;
            this.bf = j;
        }
    }

    public class e extends HandlerThread {
        public e(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (p.this.e) {
                p.this.tg = new Handler(looper);
            }
            while (!p.this.bf.isEmpty()) {
                bf bfVar = (bf) p.this.bf.poll();
                if (bfVar != null) {
                    p.this.tg.postDelayed(bfVar.e, bfVar.bf);
                }
            }
        }
    }

    public p(String str) {
        this.d = new e(str);
    }

    public void bf() {
        this.d.quit();
    }

    public void e() {
        this.d.start();
    }

    public void e(Runnable runnable) {
        e(runnable, 0L);
    }

    public void e(Runnable runnable, long j) {
        if (this.tg == null) {
            synchronized (this.e) {
                if (this.tg == null) {
                    this.bf.add(new bf(runnable, j));
                    return;
                }
            }
        }
        this.tg.postDelayed(runnable, j);
    }
}
