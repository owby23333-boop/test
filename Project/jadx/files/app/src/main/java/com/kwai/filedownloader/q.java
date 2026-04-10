package com.kwai.filedownloader;

import com.kwai.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
final class q {
    private final b aEE = new b();

    static class a {
        private static final q aEF = new q();

        static {
            com.kwai.filedownloader.message.e.Ij().a(new aa());
        }
    }

    static class b {
        private ThreadPoolExecutor aEG;
        private LinkedBlockingQueue<Runnable> aEH;

        b() {
            init();
        }

        private void init() {
            this.aEH = new LinkedBlockingQueue<>();
            this.aEG = com.kwai.filedownloader.e.b.a(3, this.aEH, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aEH.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aEG.execute(new c(bVar));
        }
    }

    static class c implements Runnable {
        private final x.b aEI;
        private boolean aEJ = false;

        c(x.b bVar) {
            this.aEI = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aEI;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aEJ) {
                return;
            }
            this.aEI.start();
        }
    }

    q() {
    }

    public static q Hb() {
        return a.aEF;
    }

    final synchronized void a(x.b bVar) {
        this.aEE.c(bVar);
    }

    final synchronized void b(x.b bVar) {
        this.aEE.b(bVar);
    }
}
