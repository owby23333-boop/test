package com.anythink.expressad.exoplayer.k;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public final class g implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9836c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f9837d = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9838e = 12992;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f9839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f9840g = new int[1];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private EGLDisplay f9841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private EGLContext f9842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private EGLSurface f9843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private SurfaceTexture f9844k;

    public static final class a extends RuntimeException {
        /* synthetic */ a(String str, byte b) {
            this(str);
        }

        private a(String str) {
            super(str);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public g(Handler handler) {
        this.f9839f = handler;
    }

    private static EGLDisplay c() {
        byte b2 = 0;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new a("eglGetDisplay failed", b2);
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        throw new a("eglInitialize failed", b2);
    }

    public final void a() {
        this.f9839f.removeCallbacks(this);
        try {
            if (this.f9844k != null) {
                this.f9844k.release();
                GLES20.glDeleteTextures(1, this.f9840g, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f9841h;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f9841h;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f9843j;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f9841h, this.f9843j);
            }
            EGLContext eGLContext = this.f9842i;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f9841h, eGLContext);
            }
            if (af.a >= 19) {
                EGL14.eglReleaseThread();
            }
            this.f9841h = null;
            this.f9842i = null;
            this.f9843j = null;
            this.f9844k = null;
        }
    }

    public final SurfaceTexture b() {
        return (SurfaceTexture) com.anythink.expressad.exoplayer.k.a.a(this.f9844k);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f9839f.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture = this.f9844k;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f9837d, 0, eGLConfigArr, 0, 1, iArr, 0);
        byte b2 = 0;
        if (zEglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null) {
            return eGLConfigArr[0];
        }
        throw new a(af.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]), b2);
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
        byte b2 = 0;
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, f9838e, 1, 12344}, 0);
        if (eGLContextEglCreateContext != null) {
            return eGLContextEglCreateContext;
        }
        throw new a("eglCreateContext failed", b2);
    }

    private static EGLSurface a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i2) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        byte b2 = 0;
        if (i2 == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i2 == 2 ? new int[]{12375, 1, 12374, 1, f9838e, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new a("eglCreatePbufferSurface failed", b2);
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext)) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new a("eglMakeCurrent failed", b2);
    }

    private static void a(int[] iArr) {
        byte b2 = 0;
        GLES20.glGenTextures(1, iArr, 0);
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new a("glGenTextures failed. Error: " + Integer.toHexString(iGlGetError), b2);
    }

    public final void a(int i2) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        byte b2 = 0;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay != null) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                this.f9841h = eGLDisplayEglGetDisplay;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                boolean zEglChooseConfig = EGL14.eglChooseConfig(this.f9841h, f9837d, 0, eGLConfigArr, 0, 1, iArr2, 0);
                if (zEglChooseConfig && iArr2[0] > 0 && eGLConfigArr[0] != null) {
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f9841h, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, f9838e, 1, 12344}, 0);
                    if (eGLContextEglCreateContext != null) {
                        this.f9842i = eGLContextEglCreateContext;
                        EGLDisplay eGLDisplay = this.f9841h;
                        EGLContext eGLContext = this.f9842i;
                        if (i2 == 1) {
                            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
                        } else {
                            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i2 == 2 ? new int[]{12375, 1, 12374, 1, f9838e, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                            if (eGLSurfaceEglCreatePbufferSurface == null) {
                                throw new a("eglCreatePbufferSurface failed", b2);
                            }
                        }
                        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext)) {
                            this.f9843j = eGLSurfaceEglCreatePbufferSurface;
                            GLES20.glGenTextures(1, this.f9840g, 0);
                            int iGlGetError = GLES20.glGetError();
                            if (iGlGetError == 0) {
                                this.f9844k = new SurfaceTexture(this.f9840g[0]);
                                this.f9844k.setOnFrameAvailableListener(this);
                                return;
                            } else {
                                throw new a("glGenTextures failed. Error: " + Integer.toHexString(iGlGetError), b2);
                            }
                        }
                        throw new a("eglMakeCurrent failed", b2);
                    }
                    throw new a("eglCreateContext failed", b2);
                }
                throw new a(af.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]), b2);
            }
            throw new a("eglInitialize failed", b2);
        }
        throw new a("eglGetDisplay failed", b2);
    }
}
