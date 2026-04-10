package com.yuewen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v74 {
    public static final /* synthetic */ boolean j = false;
    public qr0 d;
    public final pr0 e;
    public final Semaphore f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18917a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18918b = false;
    public boolean c = false;
    public long g = -1;
    public LinkedList<w74> h = new LinkedList<>();
    public final ConcurrentLinkedQueue<Object> i = new ConcurrentLinkedQueue<>();

    public v74(qr0 qr0Var, pr0 pr0Var, Semaphore semaphore) {
        this.d = null;
        this.d = qr0Var;
        this.e = pr0Var;
        this.f = semaphore;
    }

    public void a(Object obj) {
        this.i.add(obj);
        this.f.release();
    }

    public void b(w74 w74Var) {
        synchronized (this.h) {
            this.h.add(w74Var);
        }
    }

    public long c() {
        return this.g;
    }

    public boolean d() {
        return this.e.e;
    }

    public abstract boolean e();

    public boolean f() {
        return this.i.isEmpty();
    }

    public boolean g(Object obj) {
        return this.i.contains(obj);
    }

    public void h(Object obj) {
        this.i.remove(obj);
        this.f.release();
    }

    public void i(w74 w74Var) {
        synchronized (this.h) {
            this.h.remove(w74Var);
        }
    }

    public void j(long j2) {
        long j3 = this.g;
        if (j3 != j2) {
            this.g = j2;
            synchronized (this.h) {
                Iterator<w74> it = this.h.iterator();
                while (it.hasNext()) {
                    it.next().d(this, j3, this.g);
                }
            }
        }
    }
}
