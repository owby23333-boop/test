package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: FileDownloadTaskLauncher.java */
/* JADX INFO: loaded from: classes3.dex */
class p {
    private final b a = new b();

    /* JADX INFO: compiled from: FileDownloadTaskLauncher.java */
    private static class a {
        private static final p a = new p();

        static {
            com.liulishuo.filedownloader.message.c.a().a(new a0());
        }
    }

    /* JADX INFO: compiled from: FileDownloadTaskLauncher.java */
    private static class b {
        private ThreadPoolExecutor a;
        private LinkedBlockingQueue<Runnable> b;

        b() {
            a();
        }

        public void a(x.b bVar) {
            this.a.execute(new c(bVar));
        }

        private void a() {
            this.b = new LinkedBlockingQueue<>();
            this.a = com.liulishuo.filedownloader.h0.b.a(3, this.b, "LauncherTask");
        }
    }

    /* JADX INFO: compiled from: FileDownloadTaskLauncher.java */
    private static class c implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final x.b f17275s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f17276t = false;

        c(x.b bVar) {
            this.f17275s = bVar;
        }

        public boolean equals(Object obj) {
            return super.equals(obj) || obj == this.f17275s;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17276t) {
                return;
            }
            this.f17275s.start();
        }
    }

    p() {
    }

    public static p a() {
        return a.a;
    }

    synchronized void a(x.b bVar) {
        this.a.a(bVar);
    }
}
