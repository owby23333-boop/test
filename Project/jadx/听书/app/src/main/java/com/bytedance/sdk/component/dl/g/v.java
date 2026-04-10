package com.bytedance.sdk.component.dl.g;

import com.bytedance.sdk.component.dl.g.uf;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f647a;
    private Runnable dl;
    private ExecutorService gc;
    private int z = 64;
    private int g = 5;
    private final Deque<uf.z> m = new ArrayDeque();
    private final Deque<uf.z> e = new ArrayDeque();
    private final Deque<uf> gz = new ArrayDeque();

    public v() {
    }

    public v(String str) {
        this.f647a = str;
    }

    public synchronized ExecutorService z() {
        if (this.gc == null) {
            String str = this.f647a;
            this.gc = new com.bytedance.sdk.component.uy.a.a(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.dl.g.z.dl.z((str == null || str.length() == 0) ? TKDownloadReason.KSAD_TK_NET : this.f647a, false));
        }
        return this.gc;
    }

    public synchronized void z(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        this.z = i;
        dl();
    }

    public synchronized void g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("max < 1: ".concat(String.valueOf(i)));
        }
        this.g = i;
        dl();
    }

    synchronized void z(uf.z zVar) {
        try {
            if (this.e.size() < this.z && dl(zVar) < this.g) {
                this.e.add(zVar);
                if (zVar != null) {
                    zVar.g();
                }
                z().execute(zVar);
                return;
            }
            this.m.add(zVar);
        } catch (Throwable unused) {
        }
    }

    private void dl() {
        if (this.e.size() < this.z && !this.m.isEmpty()) {
            Iterator<uf.z> it = this.m.iterator();
            while (it.hasNext()) {
                uf.z next = it.next();
                if (dl(next) < this.g) {
                    it.remove();
                    this.e.add(next);
                    if (next != null) {
                        next.g();
                    }
                    z().execute(next);
                }
                if (this.e.size() >= this.z) {
                    return;
                }
            }
        }
    }

    private int dl(uf.z zVar) {
        Iterator<uf.z> it = this.e.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().z().equals(zVar.z())) {
                i++;
            }
        }
        return i;
    }

    synchronized void z(uf ufVar) {
        this.gz.add(ufVar);
    }

    void g(uf.z zVar) {
        z(this.e, zVar, true);
    }

    void g(uf ufVar) {
        z(this.gz, ufVar, false);
    }

    private <T> void z(Deque<T> deque, T t, boolean z) {
        int iG;
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                dl();
            }
            iG = g();
            runnable = this.dl;
        }
        if (iG != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }

    public synchronized int g() {
        return this.e.size() + this.gz.size();
    }
}
