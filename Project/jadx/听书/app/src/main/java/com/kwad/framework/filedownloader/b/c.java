package com.kwad.framework.filedownloader.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements a {
    private volatile Thread amO;
    private Handler handler;
    private volatile List<Integer> amM = new CopyOnWriteArrayList();
    private AtomicInteger amN = new AtomicInteger();
    private final b amJ = new b();
    private final d amK = new d();
    private final long amL = com.kwad.framework.filedownloader.f.e.zB().apF;

    static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.amO = null;
        return null;
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.bG("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwad.framework.filedownloader.b.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    if (c.this.amO != null) {
                        LockSupport.unpark(c.this.amO);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.amN.set(i);
                    c.this.bI(i);
                    c.this.amM.add(Integer.valueOf(i));
                    return false;
                } finally {
                    c.this.amN.set(0);
                    if (c.this.amO != null) {
                        LockSupport.unpark(c.this.amO);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(int i) {
        this.amK.b(this.amJ.bD(i));
        List<com.kwad.framework.filedownloader.d.a> listBE = this.amJ.bE(i);
        this.amK.bF(i);
        Iterator<com.kwad.framework.filedownloader.d.a> it = listBE.iterator();
        while (it.hasNext()) {
            this.amK.a(it.next());
        }
    }

    private boolean bJ(int i) {
        return !this.amM.contains(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bC(int i) {
        this.handler.sendEmptyMessageDelayed(i, this.amL);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c bD(int i) {
        return this.amJ.bD(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> bE(int i) {
        return this.amJ.bE(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bF(int i) {
        this.amJ.bF(i);
        if (bJ(i)) {
            return;
        }
        this.amK.bF(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) {
        this.amJ.a(aVar);
        if (bJ(aVar.getId())) {
            return;
        }
        this.amK.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) {
        this.amJ.a(i, i2, j);
        if (bJ(i)) {
            return;
        }
        this.amK.a(i, i2, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(int i, long j) {
        this.amJ.b(i, j);
        if (bJ(i)) {
            return;
        }
        this.amK.b(i, j);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void t(int i, int i2) {
        this.amJ.t(i, i2);
        if (bJ(i)) {
            return;
        }
        this.amK.t(i, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) {
        this.amJ.b(cVar);
        if (bJ(cVar.getId())) {
            return;
        }
        this.amK.b(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean bG(int i) {
        this.amK.bG(i);
        return this.amJ.bG(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() {
        this.amJ.clear();
        this.amK.clear();
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) {
        this.amJ.a(i, str, j, j2, i2);
        if (bJ(i)) {
            return;
        }
        this.amK.a(i, str, j, j2, i2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) {
        this.amJ.a(i, j, str, str2);
        if (bJ(i)) {
            return;
        }
        this.amK.a(i, j, str, str2);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void bH(int i) {
        this.amJ.bH(i);
        if (bJ(i)) {
            return;
        }
        this.amK.bH(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) {
        this.amJ.a(i, th);
        if (bJ(i)) {
            return;
        }
        this.amK.a(i, th);
    }

    private void bK(int i) {
        this.handler.removeMessages(i);
        if (this.amN.get() == i) {
            this.amO = Thread.currentThread();
            this.handler.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        bI(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) {
        this.amJ.a(i, th, j);
        if (bJ(i)) {
            bK(i);
        }
        this.amK.a(i, th, j);
        this.amM.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void c(int i, long j) {
        this.amJ.c(i, j);
        if (bJ(i)) {
            this.handler.removeMessages(i);
            if (this.amN.get() == i) {
                this.amO = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
                this.amK.c(i, j);
            }
        } else {
            this.amK.c(i, j);
        }
        this.amM.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void d(int i, long j) {
        this.amJ.d(i, j);
        if (bJ(i)) {
            bK(i);
        }
        this.amK.d(i, j);
        this.amM.remove(Integer.valueOf(i));
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0371a xT() {
        return this.amK.a(this.amJ.amG, this.amJ.amH);
    }
}
