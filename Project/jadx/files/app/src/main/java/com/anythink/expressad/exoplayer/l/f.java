package com.anythink.expressad.exoplayer.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class f {
    private static final long a = 500;
    private static final long b = 20000000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f9958c = 80;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9959d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WindowManager f9960e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f9961f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f9962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f9963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f9964i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f9965j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f9966k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f9967l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9968m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9969n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9970o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f9971p;

    @TargetApi(17)
    private final class a implements DisplayManager.DisplayListener {
        private final DisplayManager b;

        public a(DisplayManager displayManager) {
            this.b = displayManager;
        }

        public final void a() {
            this.b.registerDisplayListener(this, null);
        }

        public final void b() {
            this.b.unregisterDisplayListener(this);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i2) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i2) {
            if (i2 == 0) {
                f.this.c();
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i2) {
        }
    }

    private static final class b implements Handler.Callback, Choreographer.FrameCallback {
        private static final int b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f9972c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f9973d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final b f9974e = new b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Handler f9975f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Choreographer f9977h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f9978i;
        public volatile long a = com.anythink.expressad.exoplayer.b.b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final HandlerThread f9976g = new HandlerThread("ChoreographerOwner:Handler");

        private b() {
            this.f9976g.start();
            this.f9975f = new Handler(this.f9976g.getLooper(), this);
            this.f9975f.sendEmptyMessage(0);
        }

        public static b a() {
            return f9974e;
        }

        private void d() {
            this.f9977h = Choreographer.getInstance();
        }

        private void e() {
            this.f9978i++;
            if (this.f9978i == 1) {
                this.f9977h.postFrameCallback(this);
            }
        }

        private void f() {
            this.f9978i--;
            if (this.f9978i == 0) {
                this.f9977h.removeFrameCallback(this);
                this.a = com.anythink.expressad.exoplayer.b.b;
            }
        }

        public final void b() {
            this.f9975f.sendEmptyMessage(1);
        }

        public final void c() {
            this.f9975f.sendEmptyMessage(2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            this.a = j2;
            this.f9977h.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.f9977h = Choreographer.getInstance();
                return true;
            }
            if (i2 == 1) {
                this.f9978i++;
                if (this.f9978i == 1) {
                    this.f9977h.postFrameCallback(this);
                }
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            this.f9978i--;
            if (this.f9978i == 0) {
                this.f9977h.removeFrameCallback(this);
                this.a = com.anythink.expressad.exoplayer.b.b;
            }
            return true;
        }
    }

    public f() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            Display defaultDisplay = this.f9960e.getDefaultDisplay();
            if (defaultDisplay != null) {
                double refreshRate = defaultDisplay.getRefreshRate();
                Double.isNaN(refreshRate);
                this.f9963h = (long) (1.0E9d / refreshRate);
                this.f9964i = (this.f9963h * f9958c) / 100;
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        if (this.f9960e != null) {
            a aVar = this.f9962g;
            if (aVar != null) {
                aVar.b();
            }
            this.f9961f.c();
        }
    }

    public f(@Nullable Context context) {
        DisplayManager displayManager;
        a aVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.f9960e = (WindowManager) context.getSystemService("window");
        } else {
            this.f9960e = null;
        }
        if (this.f9960e != null) {
            if (af.a >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
                aVar = new a(displayManager);
            }
            this.f9962g = aVar;
            this.f9961f = b.a();
        } else {
            this.f9962g = null;
            this.f9961f = null;
        }
        this.f9963h = com.anythink.expressad.exoplayer.b.b;
        this.f9964i = com.anythink.expressad.exoplayer.b.b;
    }

    public final void a() {
        this.f9968m = false;
        if (this.f9960e != null) {
            this.f9961f.b();
            a aVar = this.f9962g;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    private boolean b(long j2, long j3) {
        return Math.abs((j3 - this.f9969n) - (j2 - this.f9970o)) > b;
    }

    public final long a(long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long j7 = 1000 * j2;
        if (this.f9968m) {
            if (j2 != this.f9965j) {
                this.f9971p++;
                this.f9966k = this.f9967l;
            }
            long j8 = this.f9971p;
            if (j8 >= 6) {
                j5 = this.f9966k + ((j7 - this.f9970o) / j8);
                if (b(j5, j3)) {
                    this.f9968m = false;
                } else {
                    j4 = (this.f9969n + j5) - this.f9970o;
                }
            } else if (b(j7, j3)) {
                this.f9968m = false;
            }
            j4 = j3;
            j5 = j7;
        } else {
            j4 = j3;
            j5 = j7;
        }
        if (!this.f9968m) {
            this.f9970o = j7;
            this.f9969n = j3;
            this.f9971p = 0L;
            this.f9968m = true;
        }
        this.f9965j = j2;
        this.f9967l = j5;
        b bVar = this.f9961f;
        if (bVar == null || this.f9963h == com.anythink.expressad.exoplayer.b.b) {
            return j4;
        }
        long j9 = bVar.a;
        if (j9 == com.anythink.expressad.exoplayer.b.b) {
            return j4;
        }
        long j10 = this.f9963h;
        long j11 = j9 + (((j4 - j9) / j10) * j10);
        if (j4 <= j11) {
            j6 = j11 - j10;
        } else {
            j11 = j10 + j11;
            j6 = j11;
        }
        if (j11 - j4 >= j4 - j6) {
            j11 = j6;
        }
        return j11 - this.f9964i;
    }

    @TargetApi(17)
    private a a(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    private static long a(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            j6 = j4 + j6;
            j5 = j6;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }
}
