package com.bytedance.sdk.openadsdk.core.v;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static volatile String gc;
    private static String m;
    private GLSurfaceView z;
    private static AtomicBoolean e = new AtomicBoolean();
    private static AtomicInteger gz = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f1394a = new AtomicBoolean();
    private Handler g = com.bytedance.sdk.component.utils.gz.z();
    private Handler dl = com.bytedance.sdk.component.utils.gz.g();

    interface z {
        void z(GLSurfaceView gLSurfaceView);
    }

    public static String z() {
        if (!TextUtils.isEmpty(gc)) {
            return gc;
        }
        String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("dev20", Long.MAX_VALUE);
        gc = strDl;
        if (!TextUtils.isEmpty(strDl)) {
            return gc;
        }
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        String strDl2 = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("dev21", Long.MAX_VALUE);
        m = strDl2;
        if (!TextUtils.isEmpty(strDl2)) {
            return m;
        }
        if (gz.addAndGet(1) >= 3) {
            return m;
        }
        String strG = sy.g("ro.board.gpu");
        m = strG;
        if (TextUtils.isEmpty(strG)) {
            m = sy.g("ro.hardware.egl");
        }
        if (!TextUtils.isEmpty(m)) {
            com.bytedance.sdk.openadsdk.core.dl.a.z().a("dev21", m);
        }
        return m;
    }

    public static void z(View view) {
        if (TextUtils.isEmpty(gc) && (view instanceof ViewGroup) && zw.g().lq() && e.compareAndSet(false, true)) {
            String strDl = com.bytedance.sdk.openadsdk.core.dl.a.z().dl("dev20", Long.MAX_VALUE);
            if (!TextUtils.isEmpty(strDl)) {
                gc = strDl;
            } else {
                new gz().z((ViewGroup) view, new e() { // from class: com.bytedance.sdk.openadsdk.core.v.gz.1
                    @Override // com.bytedance.sdk.openadsdk.core.v.e
                    public void z(String str) {
                        String unused = gz.gc = str;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.dl.a.z().a("dev20", gz.gc);
                    }
                });
            }
        }
    }

    public void z(final ViewGroup viewGroup, final e eVar) {
        Handler handler = this.dl;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.gz.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Context context = viewGroup.getContext();
                        gz.this.z = new GLSurfaceView(context);
                        gz.this.z.setAlpha(0.0f);
                        gz.this.z.setLayoutParams(new FrameLayout.LayoutParams(1, 1));
                        viewGroup.addView(gz.this.z);
                        gz gzVar = gz.this;
                        gzVar.z(viewGroup, gzVar.z, eVar, new z() { // from class: com.bytedance.sdk.openadsdk.core.v.gz.2.1
                            @Override // com.bytedance.sdk.openadsdk.core.v.gz.z
                            public void z(GLSurfaceView gLSurfaceView) {
                                gz.this.z(gLSurfaceView);
                            }
                        });
                    } catch (Throwable th) {
                        wp.a("gpuInfo", th.getMessage());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final GLSurfaceView gLSurfaceView) {
        Handler handler = this.dl;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.gz.3
                @Override // java.lang.Runnable
                public void run() {
                    ViewParent parent = gLSurfaceView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(gLSurfaceView);
                    }
                    gz.this.z = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ViewGroup viewGroup, final GLSurfaceView gLSurfaceView, final e eVar, final z zVar) {
        final String[] strArr = new String[1];
        final Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.gz.4
            @Override // java.lang.Runnable
            public void run() {
                e eVar2;
                gz.this.f1394a.set(true);
                try {
                    gLSurfaceView.onPause();
                    String str = strArr[0];
                    if (str != null && (eVar2 = eVar) != null) {
                        eVar2.z(str);
                    }
                    z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z(gLSurfaceView);
                    }
                } catch (Throwable th) {
                    wp.a("gpuInfo2", th.getMessage());
                }
            }
        };
        try {
            gLSurfaceView.setEGLContextClientVersion(2);
            gLSurfaceView.setRenderer(new GLSurfaceView.Renderer() { // from class: com.bytedance.sdk.openadsdk.core.v.gz.5
                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    strArr[0] = GLES20.glGetString(7937);
                    Handler handler = gz.this.g;
                    if (handler == null || gz.this.f1394a.get()) {
                        return;
                    }
                    handler.removeCallbacks(runnable);
                    handler.post(runnable);
                }

                @Override // android.opengl.GLSurfaceView.Renderer
                public void onDrawFrame(GL10 gl10) {
                    gLSurfaceView.setRenderMode(0);
                }
            });
            gLSurfaceView.setRenderMode(0);
            Handler handler = this.g;
            if (handler != null) {
                handler.postDelayed(runnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        } catch (Throwable th) {
            wp.a("gpuInfo1", th.getMessage());
        }
    }
}
