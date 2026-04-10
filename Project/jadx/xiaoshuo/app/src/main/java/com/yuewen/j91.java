package com.yuewen;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j91 {
    public static final /* synthetic */ boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q91 f12857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q91 f12858b;
    public final k91 c;
    public long d;
    public Interpolator e = new AccelerateInterpolator(1.0f);
    public boolean f = false;
    public boolean g = false;
    public long h = 0;
    public long i = 0;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            j91.this.c.c(j91.this);
            return true;
        }
    }

    public class b implements Handler.Callback {
        public b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            j91.this.c.b(j91.this);
            return true;
        }
    }

    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            j91.this.c.a(j91.this);
            return true;
        }
    }

    public j91(q91 q91Var, q91 q91Var2, long j2, k91 k91Var) {
        this.f12857a = q91Var;
        this.f12858b = q91Var2;
        this.d = j2;
        this.c = k91Var;
    }

    public float b(float f, Interpolator interpolator) {
        return interpolator == null ? f : interpolator.getInterpolation(f);
    }

    public float c(long j2, long j3) {
        long j4 = this.d;
        if (j4 == 0) {
            return 1.0f;
        }
        return (j3 - j2) / j4;
    }

    public void d() {
        if (this.g) {
            return;
        }
        n();
    }

    public k91 e() {
        return this.c;
    }

    public abstract q91 f();

    public Interpolator g() {
        return this.e;
    }

    public long h() {
        return this.d;
    }

    public q91 i() {
        return this.f12858b;
    }

    public float j() {
        if (!this.f) {
            return 0.0f;
        }
        if (this.g) {
            return 1.0f;
        }
        return c(this.h, this.i);
    }

    public q91 k() {
        return this.f12857a;
    }

    public boolean l() {
        return this.g;
    }

    public boolean m() {
        return this.f;
    }

    public void n() {
        if (this.c != null) {
            new Handler(Looper.getMainLooper(), new c()).sendEmptyMessage(0);
        }
    }

    public void o() {
        if (this.c != null) {
            new Handler(Looper.getMainLooper(), new b()).sendEmptyMessage(0);
        }
    }

    public void p() {
        if (this.c != null) {
            new Handler(Looper.getMainLooper(), new a()).sendEmptyMessage(0);
        }
    }

    public void q(long j2) {
        if (!this.f) {
            this.f = true;
            this.h = j2;
            p();
        }
        this.i = j2;
        if (j2 - this.h > this.d) {
            this.g = true;
            o();
        }
    }

    public void r(Interpolator interpolator) {
        this.e = interpolator;
    }

    public void s(long j2) {
        this.d = j2;
    }

    public void t(q91 q91Var) {
        this.f12857a = q91Var;
    }
}
