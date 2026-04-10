package com.yuewen;

import com.yuewen.s53;

/* JADX INFO: loaded from: classes12.dex */
public class t53<T extends s53> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f17876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17877b = false;
    public boolean c = false;

    public boolean a(Class<T> cls, u53<T> u53Var, boolean z) {
        T tNewInstance;
        T t = null;
        try {
            tNewInstance = cls.newInstance();
        } catch (Throwable th) {
            th = th;
        }
        try {
            u53Var.a(tNewInstance);
        } catch (Throwable th2) {
            th = th2;
            t = tNewInstance;
            th.printStackTrace();
            tNewInstance = t;
        }
        if (tNewInstance == null) {
            return false;
        }
        synchronized (this) {
            this.f17876a = tNewInstance;
            this.c = z;
        }
        if (!z) {
            return true;
        }
        try {
            if (tNewInstance.c()) {
                return true;
            }
            this.f17876a.b();
            return true;
        } catch (Throwable th3) {
            th3.printStackTrace();
            return true;
        }
    }

    public boolean b(u53<T> u53Var, boolean z) {
        synchronized (this) {
            if (this.f17876a == null) {
                return false;
            }
            while (this.f17877b) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            if (this.c) {
                return false;
            }
            this.f17877b = true;
            this.f17876a.c = System.currentTimeMillis();
            T t = this.f17876a;
            t.d = t.c - t.f17369b;
            try {
                u53Var.a(t);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            synchronized (this) {
                this.f17877b = false;
                this.c = z;
                notify();
            }
            if (this.c) {
                try {
                    if (!this.f17876a.c()) {
                        this.f17876a.b();
                    }
                } catch (Throwable unused) {
                }
            }
            return true;
        }
    }
}
