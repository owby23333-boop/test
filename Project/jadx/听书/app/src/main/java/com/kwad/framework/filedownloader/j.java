package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    static int alZ = 10;
    static int ama = 5;
    private final Executor alV;
    private final LinkedBlockingQueue<t> alW;
    private final Object alX;
    private final ArrayList<t> alY;
    private final Handler handler;

    /* synthetic */ j(byte b2) {
        this();
    }

    static final class a {
        private static final j amd = new j(0);
    }

    public static j xr() {
        return a.amd;
    }

    private j() {
        this.alV = com.kwad.framework.filedownloader.f.b.r(5, "BlockCompleted");
        this.alX = new Object();
        this.alY = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.alW = new LinkedBlockingQueue<>();
    }

    final void a(t tVar) {
        a(tVar, false);
    }

    private void a(final t tVar, boolean z) {
        if (tVar.xw()) {
            tVar.xv();
            return;
        }
        if (tVar.xx()) {
            this.alV.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.xv();
                }
            });
            return;
        }
        if (!xs() && !this.alW.isEmpty()) {
            synchronized (this.alX) {
                if (!this.alW.isEmpty()) {
                    Iterator<t> it = this.alW.iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                }
                this.alW.clear();
            }
        }
        if (!xs()) {
            b(tVar);
        } else {
            c(tVar);
        }
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.alX) {
            this.alW.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        synchronized (this.alX) {
            if (this.alY.isEmpty()) {
                if (this.alW.isEmpty()) {
                    return;
                }
                int i = 0;
                if (!xs()) {
                    this.alW.drainTo(this.alY);
                } else {
                    int i2 = alZ;
                    int iMin = Math.min(this.alW.size(), ama);
                    while (i < iMin) {
                        this.alY.add(this.alW.remove());
                        i++;
                    }
                    i = i2;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.alY), i);
            }
        }
    }

    static class b implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((t) message.obj).xv();
            } else if (message.what == 2) {
                a((ArrayList) message.obj);
                j.xr().push();
            }
            return true;
        }

        private static void a(ArrayList<t> arrayList) {
            for (t tVar : arrayList) {
                if (tVar != null) {
                    tVar.xv();
                }
            }
            arrayList.clear();
        }
    }

    private static boolean xs() {
        return alZ > 0;
    }
}
