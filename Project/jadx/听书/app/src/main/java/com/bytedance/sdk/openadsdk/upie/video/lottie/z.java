package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.z;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.fo;
import com.bytedance.adsdk.lottie.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.upie.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bykv.vk.openvk.component.video.api.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1481a;
    private final long dl;
    private final Context e;
    private LottieAnimationView fo;
    private final String g;
    private final int gc;
    private String gz;
    private long h;
    private final String i;
    private boolean io;
    private boolean iq;
    private boolean js;
    private int l;
    private boolean ls;
    private final com.bykv.vk.openvk.component.video.api.renderview.g m;
    private z.InterfaceC0029z p;
    private final com.bykv.vk.openvk.component.video.api.z pf;
    private boolean q;
    private boolean sy;
    private boolean tb;
    private ViewTreeObserverOnGlobalLayoutListenerC0225z ti;
    private boolean uf;
    private Bitmap uy;
    private final JSONObject v;
    private boolean x;
    private boolean zw;
    private final String z = "TTLottieFakeVideoPlayer";
    private final Map<String, Bitmap> kb = new HashMap();
    private final Map<String, Integer> wp = new HashMap();
    private final Set<z.InterfaceC0029z> fv = new HashSet();
    private volatile int hh = 200;
    private float gk = 1.0f;
    private int lq = 0;
    private int mc = 0;
    private final Handler eo = new Handler(Looper.getMainLooper());
    private final Runnable oq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.4
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = z.this.fv.iterator();
            while (it.hasNext()) {
                ((z.InterfaceC0029z) it.next()).z(z.this, r3.l, z.this.fv());
            }
            wp.z("TTLottieFakeVideoPlayer", "--==--play curr: " + z.this.l);
            if (z.this.l >= z.this.fv()) {
                if (z.this.fo != null) {
                    z.this.fo.m();
                }
                if (z.this.q && !z.this.zw && z.this.pf != null && z.this.pf.i()) {
                    z.this.pf.dl();
                }
                z.this.tb = false;
                z.this.iq = true;
                z.this.uf();
                Iterator it2 = z.this.fv.iterator();
                while (it2.hasNext()) {
                    ((z.InterfaceC0029z) it2.next()).z(z.this);
                }
                return;
            }
            z.this.l += z.this.hh;
            z.this.eo.postDelayed(z.this.oq, z.this.hh);
        }
    };
    private long un = SystemClock.elapsedRealtime();

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceHolder e() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceTexture gz() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(SurfaceHolder surfaceHolder) {
    }

    static /* synthetic */ int io(z zVar) {
        int i = zVar.lq;
        zVar.lq = i + 1;
        return i;
    }

    static /* synthetic */ int iq(z zVar) {
        int i = zVar.mc;
        zVar.mc = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.upie.video.lottie.z$z, reason: collision with other inner class name */
    private class ViewTreeObserverOnGlobalLayoutListenerC0225z implements ViewTreeObserver.OnGlobalLayoutListener {
        private int dl;
        private final ViewGroup g;

        private ViewTreeObserverOnGlobalLayoutListenerC0225z(ViewGroup viewGroup) {
            this.dl = 10;
            this.g = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.g.getWidth();
            int height = this.g.getHeight();
            this.g.removeAllViews();
            int i = this.dl;
            this.dl = i - 1;
            if (i < 0) {
                this.g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.g.addView(z.this.fo);
            } else {
                this.g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f = z.this.f1481a / z.this.gc;
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                if (z.this.gc <= 0 || f < f4) {
                    width = (int) (f3 * f);
                } else {
                    height = (int) (f2 / f);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.g.addView(z.this.fo, layoutParams);
            }
            if (!z.this.js || z.this.fo.gc()) {
                return;
            }
            z.this.fo.z();
        }
    }

    public z(com.bykv.vk.openvk.component.video.api.renderview.g gVar, com.bytedance.sdk.openadsdk.upie.z zVar, com.bykv.vk.openvk.component.video.api.z zVar2, a aVar) {
        this.e = gVar.getView().getContext();
        this.m = gVar;
        this.dl = zVar.m();
        this.f1481a = zVar.a();
        this.gc = zVar.gc();
        String strDl = zVar.dl();
        this.i = strDl;
        String strZ = zVar.z();
        this.g = strZ;
        String strG = zVar.g();
        this.v = zVar.e();
        z(strZ);
        g(strDl);
        this.pf = zVar2;
        z(strG, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        final ViewGroup viewGroup = (ViewGroup) this.m.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.fo);
        this.ti = new ViewTreeObserverOnGlobalLayoutListenerC0225z(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.ti);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(z.this.ti);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.8
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.uy == null || z.this.gz == null || !z.this.ls || z.this.fo != null) {
                    return;
                }
                z.this.fo = new LottieAnimationView(z.this.e);
                z.this.fo.z(z.this.gz, z.this.g);
                z.this.fo.setRepeatCount(-1);
                z.this.fo.setSpeed(z.this.gk);
                z.this.fo.setTextDelegate(new tb(z.this.fo) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.8.1
                    @Override // com.bytedance.adsdk.lottie.tb
                    public String z(String str) {
                        return com.bytedance.sdk.openadsdk.upie.z.z.z(str, z.this.v != null ? z.this.v : null);
                    }
                });
                z.this.fo.setImageAssetDelegate(new com.bytedance.adsdk.lottie.a() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.8.2
                    @Override // com.bytedance.adsdk.lottie.a
                    public Bitmap z(fo foVar) {
                        if (foVar != null) {
                            String strWp = foVar.wp();
                            if (!TextUtils.isEmpty(strWp)) {
                                if (strWp.startsWith("${") && strWp.endsWith("}")) {
                                    strWp = com.bytedance.sdk.openadsdk.upie.z.z.z(strWp, z.this.v);
                                    if (TextUtils.isEmpty(strWp)) {
                                        return null;
                                    }
                                    if (!strWp.startsWith("http") || TextUtils.equals(strWp, z.this.i)) {
                                        Bitmap bitmap = z.this.uy;
                                        if (bitmap != null && (bitmap.getWidth() != foVar.z() || bitmap.getHeight() != foVar.g())) {
                                            z.this.uy = Bitmap.createScaledBitmap(bitmap, foVar.z(), foVar.g(), false);
                                        }
                                        return z.this.uy;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) z.this.kb.get(strWp);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                z.this.z(strWp, foVar.z(), foVar.g());
                            }
                        }
                        return null;
                    }
                });
                z.this.tb();
                z.this.q = true;
                wp.z("TTLottieFakeVideoPlayer", "--==--onPrepared");
                z.this.un = SystemClock.elapsedRealtime() - z.this.un;
                for (z.InterfaceC0029z interfaceC0029z : z.this.fv) {
                    interfaceC0029z.g(z.this);
                    z zVar = z.this;
                    interfaceC0029z.z((com.bykv.vk.openvk.component.video.api.z) zVar, zVar.f1481a, z.this.gc);
                }
                if (z.this.js) {
                    z.this.pf.z(z.this.x);
                    z.this.pf.dl(true);
                    if (z.this.h > 0) {
                        z zVar2 = z.this;
                        zVar2.g(zVar2.h);
                    } else {
                        z.this.g();
                    }
                }
                for (z.InterfaceC0029z interfaceC0029z2 : z.this.fv) {
                    z zVar3 = z.this;
                    interfaceC0029z2.z(zVar3, zVar3.un);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.z.g.dl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.9
                @Override // java.lang.Runnable
                public void run() {
                    String strZ = com.bytedance.sdk.openadsdk.upie.g.z().z(str);
                    if (!TextUtils.isEmpty(strZ)) {
                        z.this.gz = strZ;
                        z.this.q();
                    } else {
                        com.bytedance.sdk.openadsdk.upie.g.z().z(str, new g.z<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.9.1
                            @Override // com.bytedance.sdk.openadsdk.upie.g.z
                            public void z(String str2) {
                                wp.z("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr ok");
                                z.this.gz = str2;
                                z.this.q();
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.g.z
                            public void z(int i, String str2) {
                                wp.z("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    z.this.z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, i, str2));
                                    return;
                                }
                                z.iq(z.this);
                                if (z.this.mc <= 3) {
                                    z.this.z(str);
                                } else {
                                    z.this.z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final String str) {
        if (TextUtils.isEmpty(str)) {
            z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.g.z().g(str, new g.z<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.10
                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(Bitmap bitmap) {
                    z.this.uy = bitmap;
                    z.this.q();
                }

                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(int i, String str2) {
                    z.io(z.this);
                    if (z.this.lq <= 3) {
                        z.this.g(str);
                    } else {
                        z.this.z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final String str, final int i, final int i2) {
        Integer num = this.wp.get(str);
        if (num == null || num.intValue() != 1) {
            this.wp.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.g.z().z(this.e, str, new g.z<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.11
                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        z.this.kb.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.z.g.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z.this.fo != null) {
                                    z.this.fo.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.g.z
                public void z(int i3, String str2) {
                    z.this.wp.put(str, 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final com.bykv.vk.openvk.component.video.api.dl.g gVar) {
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.12
            @Override // java.lang.Runnable
            public void run() {
                if (!z.this.uf) {
                    wp.z("TTLottieFakeVideoPlayer", "--==--play err, code: " + gVar.z() + ", extra: " + gVar.g() + ", msg: " + gVar.dl());
                    Iterator it = z.this.fv.iterator();
                    while (it.hasNext()) {
                        ((z.InterfaceC0029z) it.next()).z(z.this, gVar);
                    }
                }
                z.this.uf = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iq() {
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.13
            @Override // java.lang.Runnable
            public void run() {
                if (!z.this.sy) {
                    wp.z("TTLottieFakeVideoPlayer", "--==--audio buffering start");
                    if (z.this.i()) {
                        z.this.hh();
                    }
                    Iterator it = z.this.fv.iterator();
                    while (it.hasNext()) {
                        ((z.InterfaceC0029z) it.next()).z(z.this, -1, -1, -1);
                    }
                }
                z.this.sy = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(final int i) {
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = z.this.fv.iterator();
                while (it.hasNext()) {
                    ((z.InterfaceC0029z) it.next()).g(z.this, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.15
            @Override // java.lang.Runnable
            public void run() {
                wp.z("TTLottieFakeVideoPlayer", "--==--audio buffering end");
                z.this.sy = false;
                if (z.this.v()) {
                    z.this.sy();
                }
                Iterator it = z.this.fv.iterator();
                while (it.hasNext()) {
                    ((z.InterfaceC0029z) it.next()).z((com.bykv.vk.openvk.component.video.api.z) z.this, -1);
                }
            }
        });
    }

    private void a(final boolean z) {
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.2
            @Override // java.lang.Runnable
            public void run() {
                wp.z("TTLottieFakeVideoPlayer", "--==--seek completed");
                Iterator it = z.this.fv.iterator();
                while (it.hasNext()) {
                    ((z.InterfaceC0029z) it.next()).z(z.this, z);
                }
            }
        });
    }

    private void z(String str, a aVar) {
        if (TextUtils.isEmpty(str)) {
            z(new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "lottie音频url为空"));
            return;
        }
        z.InterfaceC0029z interfaceC0029z = new z.InterfaceC0029z() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.3
            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void dl(com.bykv.vk.openvk.component.video.api.z zVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, JSONObject jSONObject, String str2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void g(com.bykv.vk.openvk.component.video.api.z zVar) {
                z.this.ls = true;
                z.this.q();
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, com.bykv.vk.openvk.component.video.api.dl.g gVar) {
                int iZ;
                String strDl;
                int iG;
                if (gVar != null) {
                    iZ = gVar.z();
                    iG = gVar.g();
                    strDl = gVar.dl();
                } else {
                    iZ = -1;
                    strDl = "";
                    iG = -1;
                }
                z.this.z(new com.bykv.vk.openvk.component.video.api.dl.g(iZ, iG, "lottie音频播放失败:".concat(String.valueOf(strDl))));
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2, int i3) {
                z.this.iq();
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
                z.this.zw();
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void g(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
                z.this.dl(i);
            }
        };
        this.p = interfaceC0029z;
        this.pf.z(interfaceC0029z);
        this.pf.z(aVar);
    }

    private void io() {
        this.eo.removeCallbacksAndMessages(null);
        this.eo.post(this.oq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf() {
        this.eo.removeCallbacksAndMessages(null);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(a aVar) {
        wp.z("TTLottieFakeVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(aVar)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z) {
        wp.z("TTLottieFakeVideoPlayer", "--==--setQuietPlay: ".concat(String.valueOf(z)));
        this.x = z;
        com.bykv.vk.openvk.component.video.api.z zVar = this.pf;
        if (zVar != null) {
            zVar.z(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(long j) {
        wp.z("TTLottieFakeVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.l = (int) j;
        LottieAnimationView lottieAnimationView = this.fo;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = fv();
            }
            if (duration > 0) {
                this.fo.setProgress((j % duration) / duration);
            }
        }
        com.bykv.vk.openvk.component.video.api.z zVar = this.pf;
        if (zVar != null && zVar.fv() > 0) {
            this.pf.z((int) (j % this.pf.fv()));
        }
        a(true);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(int i) {
        wp.z("TTLottieFakeVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z, long j, boolean z2) {
        wp.z("TTLottieFakeVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.x = z2;
        this.js = true;
        this.h = j;
        this.pf.z(z, j, z2);
        if (this.q) {
            this.pf.z(z2);
            this.pf.dl(true);
            if (j > 0) {
                g(j);
            } else {
                g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(long j) {
        LottieAnimationView lottieAnimationView = this.fo;
        if (lottieAnimationView != null) {
            lottieAnimationView.z();
        }
        z(j);
        com.bykv.vk.openvk.component.video.api.z zVar = this.pf;
        if (zVar != null) {
            zVar.g();
        }
        this.tb = true;
        io();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z() {
        wp.z("TTLottieFakeVideoPlayer", "--==--reStart");
        uf();
        this.l = 0;
        this.q = true;
        this.iq = false;
        this.zw = false;
        LottieAnimationView lottieAnimationView = this.fo;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
            this.fo.setProgress(0.0f);
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy() {
        com.bykv.vk.openvk.component.video.api.z zVar;
        wp.z("TTLottieFakeVideoPlayer", "--==--play");
        LottieAnimationView lottieAnimationView = this.fo;
        if (lottieAnimationView != null && this.q && !lottieAnimationView.gc()) {
            wp.z("TTLottieFakeVideoPlayer", "--==--play --- enter");
            if (this.l > 0) {
                this.fo.g();
            } else {
                this.fo.z();
            }
        }
        if (this.q && !this.zw && (zVar = this.pf) != null && !zVar.i()) {
            wp.z("TTLottieFakeVideoPlayer", "--==--audio play --- enter");
            if (this.l > 0) {
                this.pf.g();
            } else {
                this.pf.z(0L);
                this.pf.g();
            }
        }
        this.tb = true;
        io();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g() {
        sy();
        if (this.l > 0) {
            com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = z.this.fv.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hh() {
        com.bykv.vk.openvk.component.video.api.z zVar;
        wp.z("TTLottieFakeVideoPlayer", "--==--pause");
        LottieAnimationView lottieAnimationView = this.fo;
        if (lottieAnimationView != null && this.q && lottieAnimationView.gc()) {
            wp.z("TTLottieFakeVideoPlayer", "--==--pause --- enter");
            this.fo.e();
        }
        if (this.q && !this.zw && (zVar = this.pf) != null && zVar.i()) {
            wp.z("TTLottieFakeVideoPlayer", "--==--audio pause --- enter");
            this.pf.dl();
        }
        this.tb = false;
        uf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl() {
        hh();
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = z.this.fv.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void a() {
        com.bykv.vk.openvk.component.video.api.z zVar;
        wp.z("TTLottieFakeVideoPlayer", "--==--stop");
        LottieAnimationView lottieAnimationView = this.fo;
        if (lottieAnimationView != null) {
            lottieAnimationView.m();
            this.js = false;
        }
        if (this.q && !this.zw && (zVar = this.pf) != null && zVar.i()) {
            this.pf.dl();
        }
        uf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void gc() {
        wp.z("TTLottieFakeVideoPlayer", "--==--release");
        this.zw = true;
        uf();
        this.kb.clear();
        this.uy = null;
        com.bykv.vk.openvk.component.video.api.z zVar = this.pf;
        if (zVar != null) {
            if (this.q) {
                zVar.a();
            }
            this.pf.gc();
        }
        com.bytedance.sdk.openadsdk.upie.z.g.g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.z.7
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) z.this.m.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(z.this.ti);
                }
                Iterator it = z.this.fv.iterator();
                while (it.hasNext()) {
                    ((z.InterfaceC0029z) it.next()).dl(z.this);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean m() {
        wp.z("TTLottieFakeVideoPlayer", "--==--isFirstFrameSuccess: " + this.q);
        return this.q;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean fo() {
        wp.z("TTLottieFakeVideoPlayer", "--==--isCompleted: " + this.iq);
        return this.iq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean uy() {
        wp.z("TTLottieFakeVideoPlayer", "--==--isStarted: " + this.js);
        return this.js;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean i() {
        wp.z("TTLottieFakeVideoPlayer", "--==--isPlaying: " + this.tb);
        return this.tb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean v() {
        boolean z = (this.tb || this.iq || this.zw || !this.q) ? false : true;
        wp.z("TTLottieFakeVideoPlayer", "--==--isPaused: ".concat(String.valueOf(z)));
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean pf() {
        wp.z("TTLottieFakeVideoPlayer", "--==--isReleased: " + this.zw);
        return this.zw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int kb() {
        wp.z("TTLottieFakeVideoPlayer", "--==--getVideoWidth: " + this.f1481a);
        return this.f1481a;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int wp() {
        wp.z("TTLottieFakeVideoPlayer", "--==--getVideoHeight: " + this.gc);
        return this.gc;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long ls() {
        if (this.q) {
            wp.z("TTLottieFakeVideoPlayer", "--==--getTotalBufferTime: " + this.un);
            return this.un;
        }
        wp.z("TTLottieFakeVideoPlayer", "--==--is not prepared, getTotalBufferTime: 0");
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int p() {
        wp.z("TTLottieFakeVideoPlayer", "--==--getBufferCount: 1");
        return 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long fv() {
        return this.dl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long js() {
        wp.z("TTLottieFakeVideoPlayer", "--==--getCurrentPosition: " + this.l);
        return this.l;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl(boolean z) {
        wp.z("TTLottieFakeVideoPlayer", "--==--setLoop:".concat(String.valueOf(z)));
        this.io = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(z.InterfaceC0029z interfaceC0029z) {
        this.fv.add(interfaceC0029z);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(int i) {
        this.hh = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(float f) {
        this.gk = f;
    }
}
