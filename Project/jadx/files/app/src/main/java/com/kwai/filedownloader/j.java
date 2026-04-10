package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    static int aEp = 10;
    static int aEq = 5;
    private final Executor aEl;
    private final LinkedBlockingQueue<t> aEm;
    private final Object aEn;
    private final ArrayList<t> aEo;
    private final Handler handler;

    static final class a {
        private static final j aEt = new j(0);
    }

    static class b implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        private static void b(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().GQ();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                ((t) message.obj).GQ();
            } else if (i2 == 2) {
                b((ArrayList) message.obj);
                j.GM().push();
            }
            return true;
        }
    }

    private j() {
        this.aEl = com.kwai.filedownloader.e.b.n(5, "BlockCompleted");
        this.aEn = new Object();
        this.aEo = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aEm = new LinkedBlockingQueue<>();
    }

    /* synthetic */ j(byte b2) {
        this();
    }

    public static j GM() {
        return a.aEt;
    }

    private static boolean GN() {
        return aEp > 0;
    }

    private void a(final t tVar, boolean z2) {
        if (tVar.GR()) {
            tVar.GQ();
            return;
        }
        if (tVar.GS()) {
            this.aEl.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.GQ();
                }
            });
            return;
        }
        if (!GN() && !this.aEm.isEmpty()) {
            synchronized (this.aEn) {
                if (!this.aEm.isEmpty()) {
                    Iterator<t> it = this.aEm.iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                }
                this.aEm.clear();
            }
        }
        if (GN()) {
            c(tVar);
        } else {
            b(tVar);
        }
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.aEn) {
            this.aEm.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        int i2;
        synchronized (this.aEn) {
            if (this.aEo.isEmpty()) {
                if (this.aEm.isEmpty()) {
                    return;
                }
                if (GN()) {
                    i2 = aEp;
                    int iMin = Math.min(this.aEm.size(), aEq);
                    for (int i3 = 0; i3 < iMin; i3++) {
                        this.aEo.add(this.aEm.remove());
                    }
                } else {
                    this.aEm.drainTo(this.aEo);
                    i2 = 0;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.aEo), i2);
            }
        }
    }

    final void a(t tVar) {
        a(tVar, false);
    }
}
