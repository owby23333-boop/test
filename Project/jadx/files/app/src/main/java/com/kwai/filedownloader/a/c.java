package com.kwai.filedownloader.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements a {
    private volatile Thread aFe;
    private Handler handler;
    private volatile List<Integer> aFc = new CopyOnWriteArrayList();
    private AtomicInteger aFd = new AtomicInteger();
    private final b aEZ = new b();
    private final d aFa = new d();
    private final long aFb = com.kwai.filedownloader.e.e.IP().aHV;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.fn("RemitHandoverToDB"), 10);
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() { // from class: com.kwai.filedownloader.a.c.1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    if (c.this.aFe != null) {
                        LockSupport.unpark(c.this.aFe);
                        c.a(c.this, (Thread) null);
                    }
                    return false;
                }
                try {
                    c.this.aFd.set(i2);
                    c.this.cI(i2);
                    c.this.aFc.add(Integer.valueOf(i2));
                    return false;
                } finally {
                    c.this.aFd.set(0);
                    if (c.this.aFe != null) {
                        LockSupport.unpark(c.this.aFe);
                        c.a(c.this, (Thread) null);
                    }
                }
            }
        });
    }

    static /* synthetic */ Thread a(c cVar, Thread thread) {
        cVar.aFe = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(int i2) {
        this.aFa.b(this.aEZ.cD(i2));
        List<com.kwai.filedownloader.c.a> listCE = this.aEZ.cE(i2);
        this.aFa.cF(i2);
        Iterator<com.kwai.filedownloader.c.a> it = listCE.iterator();
        while (it.hasNext()) {
            this.aFa.a(it.next());
        }
    }

    private boolean cJ(int i2) {
        return !this.aFc.contains(Integer.valueOf(i2));
    }

    private void cK(int i2) {
        this.handler.removeMessages(i2);
        if (this.aFd.get() != i2) {
            cI(i2);
            return;
        }
        this.aFe = Thread.currentThread();
        this.handler.sendEmptyMessage(0);
        LockSupport.park();
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0462a Hl() {
        d dVar = this.aFa;
        b bVar = this.aEZ;
        return dVar.a(bVar.aEW, bVar.aEX);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, int i3, long j2) {
        this.aEZ.a(i2, i3, j2);
        if (cJ(i2)) {
            return;
        }
        this.aFa.a(i2, i3, j2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, long j2, String str, String str2) {
        this.aEZ.a(i2, j2, str, str2);
        if (cJ(i2)) {
            return;
        }
        this.aFa.a(i2, j2, str, str2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, String str, long j2, long j3, int i3) {
        this.aEZ.a(i2, str, j2, j3, i3);
        if (cJ(i2)) {
            return;
        }
        this.aFa.a(i2, str, j2, j3, i3);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th) {
        this.aEZ.a(i2, th);
        if (cJ(i2)) {
            return;
        }
        this.aFa.a(i2, th);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i2, Throwable th, long j2) {
        this.aEZ.a(i2, th, j2);
        if (cJ(i2)) {
            cK(i2);
        }
        this.aFa.a(i2, th, j2);
        this.aFc.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.a aVar) {
        this.aEZ.a(aVar);
        if (cJ(aVar.getId())) {
            return;
        }
        this.aFa.a(aVar);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        this.aEZ.b(cVar);
        if (cJ(cVar.getId())) {
            return;
        }
        this.aFa.b(cVar);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cC(int i2) {
        this.handler.sendEmptyMessageDelayed(i2, this.aFb);
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cD(int i2) {
        return this.aEZ.cD(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> cE(int i2) {
        return this.aEZ.cE(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cF(int i2) {
        this.aEZ.cF(i2);
        if (cJ(i2)) {
            return;
        }
        this.aFa.cF(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cG(int i2) {
        this.aFa.cG(i2);
        return this.aEZ.cG(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cH(int i2) {
        this.aEZ.cH(i2);
        if (cJ(i2)) {
            return;
        }
        this.aFa.cH(i2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        this.aEZ.clear();
        this.aFa.clear();
    }

    @Override // com.kwai.filedownloader.a.a
    public final void d(int i2, long j2) {
        this.aEZ.d(i2, j2);
        if (cJ(i2)) {
            return;
        }
        this.aFa.d(i2, j2);
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i2, long j2) {
        this.aEZ.e(i2, j2);
        if (cJ(i2)) {
            this.handler.removeMessages(i2);
            if (this.aFd.get() == i2) {
                this.aFe = Thread.currentThread();
                this.handler.sendEmptyMessage(0);
                LockSupport.park();
                this.aFa.e(i2, j2);
            }
        } else {
            this.aFa.e(i2, j2);
        }
        this.aFc.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i2, long j2) {
        this.aEZ.f(i2, j2);
        if (cJ(i2)) {
            cK(i2);
        }
        this.aFa.f(i2, j2);
        this.aFc.remove(Integer.valueOf(i2));
    }

    @Override // com.kwai.filedownloader.a.a
    public final void z(int i2, int i3) {
        this.aEZ.z(i2, i3);
        if (cJ(i2)) {
            return;
        }
        this.aFa.z(i2, i3);
    }
}
