package com.anythink.expressad.exoplayer.c;

import com.anythink.expressad.exoplayer.c.e;
import com.anythink.expressad.exoplayer.c.f;
import java.lang.Exception;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {
    private final Thread a;
    private final Object b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque<I> f8740c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayDeque<O> f8741d = new ArrayDeque<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final I[] f8742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final O[] f8743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private I f8746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private E f8747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8750m;

    private g(I[] iArr, O[] oArr) {
        this.f8742e = iArr;
        this.f8744g = iArr.length;
        for (int i2 = 0; i2 < this.f8744g; i2++) {
            ((I[]) this.f8742e)[i2] = h();
        }
        this.f8743f = oArr;
        this.f8745h = oArr.length;
        for (int i3 = 0; i3 < this.f8745h; i3++) {
            ((O[]) this.f8743f)[i3] = i();
        }
        this.a = new Thread() { // from class: com.anythink.expressad.exoplayer.c.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                g.a(g.this);
            }
        };
        this.a.start();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
    private void l() throws E {
        E e2 = this.f8747j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void m() {
        if (p()) {
            this.b.notify();
        }
    }

    private void n() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (o());
    }

    private boolean o() {
        synchronized (this.b) {
            while (!this.f8749l && !p()) {
                this.b.wait();
            }
            if (this.f8749l) {
                return false;
            }
            I iRemoveFirst = this.f8740c.removeFirst();
            O[] oArr = this.f8743f;
            int i2 = this.f8745h - 1;
            this.f8745h = i2;
            O o2 = oArr[i2];
            this.f8748k = false;
            if (iRemoveFirst.c()) {
                o2.b(4);
            } else {
                if (iRemoveFirst.b()) {
                    o2.b(Integer.MIN_VALUE);
                }
                try {
                    this.f8747j = (E) k();
                } catch (OutOfMemoryError unused) {
                    this.f8747j = (E) j();
                } catch (RuntimeException unused2) {
                    this.f8747j = (E) j();
                }
                if (this.f8747j != null) {
                    synchronized (this.b) {
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (this.f8748k) {
                    b(o2);
                } else if (o2.b()) {
                    this.f8750m++;
                    b(o2);
                } else {
                    o2.b = this.f8750m;
                    this.f8750m = 0;
                    this.f8741d.addLast(o2);
                }
                b(iRemoveFirst);
            }
            return true;
        }
    }

    private boolean p() {
        return !this.f8740c.isEmpty() && this.f8745h > 0;
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void d() {
        synchronized (this.b) {
            this.f8748k = true;
            this.f8750m = 0;
            if (this.f8746i != null) {
                b(this.f8746i);
                this.f8746i = null;
            }
            while (!this.f8740c.isEmpty()) {
                b(this.f8740c.removeFirst());
            }
            while (!this.f8741d.isEmpty()) {
                b(this.f8741d.removeFirst());
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void e() {
        synchronized (this.b) {
            this.f8749l = true;
            this.b.notify();
        }
        try {
            this.a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final I b() {
        I i2;
        I i3;
        synchronized (this.b) {
            l();
            com.anythink.expressad.exoplayer.k.a.b(this.f8746i == null);
            if (this.f8744g == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f8742e;
                int i4 = this.f8744g - 1;
                this.f8744g = i4;
                i2 = iArr[i4];
            }
            this.f8746i = i2;
            i3 = this.f8746i;
        }
        return i3;
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final O c() {
        synchronized (this.b) {
            l();
            if (this.f8741d.isEmpty()) {
                return null;
            }
            return this.f8741d.removeFirst();
        }
    }

    protected abstract I h();

    protected abstract O i();

    protected abstract E j();

    protected abstract E k();

    private void a(int i2) {
        com.anythink.expressad.exoplayer.k.a.b(this.f8744g == this.f8742e.length);
        for (I i3 : this.f8742e) {
            i3.d(i2);
        }
    }

    private void b(I i2) {
        i2.a();
        I[] iArr = this.f8742e;
        int i3 = this.f8744g;
        this.f8744g = i3 + 1;
        iArr[i3] = i2;
    }

    private void b(O o2) {
        o2.a();
        O[] oArr = this.f8743f;
        int i2 = this.f8745h;
        this.f8745h = i2 + 1;
        oArr[i2] = o2;
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void a(I i2) {
        synchronized (this.b) {
            l();
            com.anythink.expressad.exoplayer.k.a.a(i2 == this.f8746i);
            this.f8740c.addLast(i2);
            m();
            this.f8746i = null;
        }
    }

    protected final void a(O o2) {
        synchronized (this.b) {
            b(o2);
            m();
        }
    }

    static /* synthetic */ void a(g gVar) {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (gVar.o());
    }
}
