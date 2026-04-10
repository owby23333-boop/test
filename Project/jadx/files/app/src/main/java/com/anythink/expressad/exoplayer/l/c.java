package com.anythink.expressad.exoplayer.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public final class c extends Surface {
    private static final String b = "DummySurface";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9937c = "EGL_EXT_protected_content";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9938d = "EGL_KHR_surfaceless_context";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f9939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f9940f;
    public final boolean a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f9941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f9942h;

    /* synthetic */ c(a aVar, SurfaceTexture surfaceTexture, boolean z2, byte b2) {
        this(aVar, surfaceTexture, z2);
    }

    public static synchronized boolean a(Context context) {
        String strEglQueryString;
        if (!f9940f) {
            f9939e = (af.a >= 24 && (af.a >= 26 || !("samsung".equals(af.f9815c) || "XT1650".equals(af.f9816d))) && ((af.a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(f9937c))) ? strEglQueryString.contains(f9938d) ? 1 : 2 : 0;
            f9940f = true;
        }
        return f9939e != 0;
    }

    @TargetApi(24)
    private static int b(Context context) {
        String strEglQueryString;
        if (af.a < 26 && ("samsung".equals(af.f9815c) || "XT1650".equals(af.f9816d))) {
            return 0;
        }
        if ((af.a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains(f9937c)) {
            return strEglQueryString.contains(f9938d) ? 1 : 2;
        }
        return 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f9941g) {
            if (!this.f9942h) {
                this.f9941g.a();
                this.f9942h = true;
            }
        }
    }

    private c(a aVar, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f9941g = aVar;
        this.a = z2;
    }

    private static class a extends HandlerThread implements Handler.Callback {
        private static final int a = 1;
        private static final int b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private com.anythink.expressad.exoplayer.k.g f9943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Handler f9944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private Error f9945e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private RuntimeException f9946f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private c f9947g;

        public a() {
            super("dummySurface");
        }

        private void b(int i2) {
            com.anythink.expressad.exoplayer.k.a.a(this.f9943c);
            this.f9943c.a(i2);
            this.f9947g = new c(this, this.f9943c.b(), i2 != 0, (byte) 0);
        }

        public final c a(int i2) {
            boolean z2;
            start();
            this.f9944d = new Handler(getLooper(), this);
            this.f9943c = new com.anythink.expressad.exoplayer.k.g(this.f9944d);
            synchronized (this) {
                z2 = false;
                this.f9944d.obtainMessage(1, i2, 0).sendToTarget();
                while (this.f9947g == null && this.f9946f == null && this.f9945e == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f9946f;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f9945e;
            if (error == null) {
                return (c) com.anythink.expressad.exoplayer.k.a.a(this.f9947g);
            }
            throw error;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            try {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return true;
                    }
                    try {
                        com.anythink.expressad.exoplayer.k.a.a(this.f9943c);
                        this.f9943c.a();
                    } catch (Throwable unused) {
                    }
                    quit();
                    return true;
                }
                try {
                    int i3 = message.arg1;
                    com.anythink.expressad.exoplayer.k.a.a(this.f9943c);
                    this.f9943c.a(i3);
                    this.f9947g = new c(this, this.f9943c.b(), i3 != 0, (byte) 0);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e2) {
                    this.f9945e = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e3) {
                    this.f9946f = e3;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }

        private void b() {
            com.anythink.expressad.exoplayer.k.a.a(this.f9943c);
            this.f9943c.a();
        }

        public final void a() {
            com.anythink.expressad.exoplayer.k.a.a(this.f9944d);
            this.f9944d.sendEmptyMessage(2);
        }
    }

    private static void a() {
        if (af.a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static c a(Context context, boolean z2) {
        if (af.a >= 17) {
            com.anythink.expressad.exoplayer.k.a.b(!z2 || a(context));
            return new a().a(z2 ? f9939e : 0);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
}
