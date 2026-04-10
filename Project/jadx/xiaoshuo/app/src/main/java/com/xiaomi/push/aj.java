package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile b f130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7790b;

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* JADX INFO: renamed from: c */
        public void mo323c() {
        }
    }

    public aj() {
        this(false);
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f132a;

        public a() {
            super("PackageProcessor");
            this.f132a = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            try {
                this.f132a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = aj.this.f7789a > 0 ? aj.this.f7789a : Long.MAX_VALUE;
            while (!aj.this.f131a) {
                try {
                    b bVarPoll = this.f132a.poll(j, TimeUnit.SECONDS);
                    aj.this.f130a = bVarPoll;
                    if (bVarPoll != null) {
                        a(0, bVarPoll);
                        bVarPoll.b();
                        a(1, bVarPoll);
                    } else if (aj.this.f7789a > 0) {
                        aj.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }

        private void a(int i, b bVar) {
            try {
                aj.this.f128a.sendMessage(aj.this.f128a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    public aj(boolean z) {
        this(z, 0);
    }

    public aj(boolean z, int i) {
        this.f128a = null;
        this.f131a = false;
        this.f7789a = 0;
        this.f128a = new ak(this, Looper.getMainLooper());
        this.f7790b = z;
        this.f7789a = i;
    }

    public synchronized void a(b bVar) {
        if (this.f129a == null) {
            a aVar = new a();
            this.f129a = aVar;
            aVar.setDaemon(this.f7790b);
            this.f131a = false;
            this.f129a.start();
        }
        this.f129a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f129a = null;
        this.f131a = true;
    }

    public void a(b bVar, long j) {
        this.f128a.postDelayed(new al(this, bVar), j);
    }
}
