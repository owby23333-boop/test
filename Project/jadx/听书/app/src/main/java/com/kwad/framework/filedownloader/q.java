package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes4.dex */
final class q {
    private final b amo = new b();

    q() {
    }

    static class a {
        private static final q amp = new q();

        static {
            com.kwad.framework.filedownloader.message.e.yT().a(new aa());
        }
    }

    public static q xG() {
        return a.amp;
    }

    final synchronized void a(x.b bVar) {
        this.amo.c(bVar);
    }

    final synchronized void b(x.b bVar) {
        this.amo.b(bVar);
    }

    static class b {
        private ThreadPoolExecutor amq;
        private LinkedBlockingQueue<Runnable> amr;

        b() {
            init();
        }

        public final void c(x.b bVar) {
            this.amq.execute(new c(bVar));
        }

        public final void b(x.b bVar) {
            this.amr.remove(bVar);
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.amr = linkedBlockingQueue;
            this.amq = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }
    }

    static class c implements Runnable {
        private final x.b ams;
        private boolean amt = false;

        c(x.b bVar) {
            this.ams = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.amt) {
                return;
            }
            this.ams.start();
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.ams;
        }
    }
}
