package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.ti;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.fv;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.uy;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.v.gz;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.a;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.m.dl.p;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class NativeVideoTsView extends FrameLayout implements dl.z, l.z, a.z {
    private static volatile com.bytedance.sdk.component.a.g.dl sv;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected na f1401a;
    private volatile boolean b;
    private View.OnAttachStateChangeListener bv;
    protected final Context dl;
    protected FrameLayout e;
    private ViewTreeObserver ec;
    private dl.InterfaceC0027dl eo;
    private g f;
    protected boolean fo;
    boolean fv;
    private boolean g;
    private ViewGroup gb;
    protected com.bykv.vk.openvk.component.video.api.a.dl gc;
    private final l gk;
    private boolean gp;
    protected boolean gz;
    private long h;
    private NativeExpressVideoView hh;
    protected ImageView i;
    private boolean io;
    private boolean iq;
    private boolean j;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e jq;
    public a js;
    protected ImageView kb;
    private boolean l;
    private final String lq;
    protected int ls;
    private AtomicBoolean lw;
    protected ViewGroup m;
    private TTViewStub mc;
    private int na;
    private boolean oq;
    AtomicBoolean p;
    protected String pf;
    private String q;
    private boolean qd;
    private boolean sy;
    private boolean t;
    protected final AtomicBoolean tb;
    private long ti;
    private boolean uf;
    private long un;
    protected RelativeLayout uy;
    protected boolean v;
    private dl vm;
    private boolean wj;
    protected ImageView wp;
    private boolean x;
    private int xl;
    private ViewTreeObserver.OnGlobalLayoutListener y;
    private boolean yx;
    private boolean z;
    private boolean zw;
    private boolean zx;

    public interface a {
        void z(boolean z, long j, long j2, long j3, boolean z2, boolean z3);
    }

    public interface z {
        void z(View view, int i);
    }

    public void setEasyPlayableEventSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e eVar) {
        this.jq = eVar;
    }

    public void setDrawVideoListener(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) dlVar).z(zVar);
        }
    }

    public void setAdCreativeClickListener(z zVar) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) dlVar).z(zVar);
        }
    }

    public void setVideoAdClickListenerTTNativeAd(i iVar) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) dlVar).z(iVar);
        }
    }

    public void setControllerStatusCallBack(a aVar) {
        this.js = aVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.z
    public void z(long j, int i) {
        this.yx = true;
        dl.InterfaceC0027dl interfaceC0027dl = this.eo;
        if (interfaceC0027dl != null) {
            interfaceC0027dl.t_();
        }
    }

    private void gz() {
        z(0L, 0);
        this.eo = null;
    }

    public void g(long j, int i) {
        this.zw = true;
    }

    public boolean getVideoError() {
        return this.zw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.z
    public void z() {
        if (this.eo == null || !uf()) {
            return;
        }
        this.eo.t_();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.z
    public void z(long j, long j2) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar;
        if (j != j2) {
            this.yx = false;
        }
        dl.InterfaceC0027dl interfaceC0027dl = this.eo;
        if (interfaceC0027dl != null) {
            interfaceC0027dl.z(j, j2);
        }
        if (hh() || (dlVar = this.gc) == null) {
            return;
        }
        dlVar.m();
    }

    public NativeVideoTsView(Context context, na naVar) {
        this(context, naVar, false, false);
    }

    public NativeVideoTsView(Context context) {
        this(context, null, false, false);
    }

    public NativeVideoTsView(Context context, na naVar, boolean z2, boolean z3) {
        this(context, naVar, z2, z3, "embeded_ad", false, false);
    }

    public NativeVideoTsView(Context context, na naVar, String str, boolean z2, boolean z3) {
        this(context, naVar, false, false, str, z2, z3);
    }

    public NativeVideoTsView(Context context, na naVar, boolean z2, boolean z3, String str, boolean z4, boolean z5) {
        super(context);
        this.z = true;
        this.gz = true;
        this.g = false;
        this.iq = false;
        this.zw = false;
        this.io = false;
        this.uf = true;
        this.sy = false;
        this.v = true;
        this.pf = "embeded_ad";
        this.ls = 50;
        this.l = true;
        this.p = new AtomicBoolean(false);
        this.x = false;
        this.lq = uy.g();
        this.fv = false;
        this.un = 50L;
        this.ti = 500L;
        this.oq = true;
        this.wj = false;
        this.j = true;
        this.gp = true;
        this.yx = false;
        this.tb = new AtomicBoolean(false);
        this.qd = true;
        this.b = false;
        this.lw = new AtomicBoolean(false);
        this.pf = str;
        this.dl = context;
        this.f1401a = naVar;
        this.g = z2;
        this.sy = z3;
        this.io = z4;
        this.uf = z5;
        this.gk = new l(com.bytedance.sdk.openadsdk.hh.e.g(), this);
        setContentDescription("NativeVideoAdView");
        e();
        q();
        com.bytedance.sdk.openadsdk.hh.e.g(new fo("ts_video") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // java.lang.Runnable
            public void run() {
                if (NativeVideoTsView.sv == null) {
                    com.bytedance.sdk.component.a.g.dl unused = NativeVideoTsView.sv = NativeVideoTsView.this.getKvCache();
                }
            }
        });
    }

    public void setEnableBlur(boolean z2) {
        this.fo = z2;
    }

    public void setMaterialMeta(na naVar) {
        this.f1401a = naVar;
    }

    protected void e() {
        na naVar = this.f1401a;
        if (naVar == null) {
            return;
        }
        int iFo = eo.fo(naVar);
        int iE = zw.g().e(iFo);
        if (iE == 1) {
            this.z = v.a(this.dl);
        } else if (iE == 2) {
            this.z = v.gc(this.dl) || v.a(this.dl) || v.m(this.dl) || v.dl(zw.getContext()) == 1;
        } else if (iE == 3) {
            this.z = false;
        } else if (iE == 4) {
            this.fv = true;
        } else if (iE == 5) {
            this.z = v.a(this.dl) || v.m(this.dl);
        }
        if (!this.g) {
            this.gz = zw.g().a(iFo);
        } else {
            this.gz = false;
        }
        if ("splash_ad".equals(this.pf)) {
            this.z = true;
            this.gz = true;
        }
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            dlVar.a(this.z);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        uy();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void uy() {
        a aVar;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar;
        if (this.g || (aVar = this.js) == null || (dlVar = this.gc) == null) {
            return;
        }
        aVar.z(dlVar.tb(), this.gc.v(), this.gc.v() + this.gc.wp(), this.gc.kb(), this.z, this.gz);
    }

    private View z(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(2114387848);
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.m = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(2114387756);
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.e = frameLayout2;
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.gc());
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387607);
        tTViewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(tTViewStub);
        this.mc = tTViewStub;
        return frameLayout;
    }

    private void q() {
        addView(z(this.dl));
        B_();
    }

    protected void z(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.gc.z.z(this.f1401a) || com.bytedance.sdk.openadsdk.gc.z.e(this.f1401a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.gz.g.z(str).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls<Bitmap> lsVar) {
                Bitmap result;
                if (lsVar == null || (result = lsVar.getResult()) == null) {
                    return;
                }
                final Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(NativeVideoTsView.this.dl, result, 25);
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmapZ != null) {
                            imageView.setBackground(new BitmapDrawable(bitmapZ));
                        }
                    }
                });
            }
        }, 4);
    }

    public void kb() {
        TTViewStub tTViewStub;
        if (uf() || this.dl == null || (tTViewStub = this.mc) == null || tTViewStub.getParent() == null || this.f1401a == null || this.uy != null) {
            return;
        }
        if (this.mc.getParent() != null && (this.mc.getParent() instanceof ViewGroup)) {
            this.uy = (RelativeLayout) this.mc.z();
        }
        this.kb = (ImageView) findViewById(2114387954);
        ImageView imageView = (ImageView) findViewById(2114387847);
        this.i = imageView;
        if (this.v) {
            oq.z((View) imageView, 0);
        }
        if (!TextUtils.isEmpty(tf.g(this.f1401a))) {
            com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.f1401a)).to(this.kb);
            z(this.kb, tf.g(this.f1401a));
        }
        iq();
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mc.getParent() != null && (this.mc.getParent() instanceof ViewGroup)) {
            this.uy = (RelativeLayout) this.mc.z();
        }
        ImageView imageView = (ImageView) findViewById(2114387954);
        this.kb = imageView;
        imageView.setImageDrawable(null);
        this.i = (ImageView) findViewById(2114387847);
        com.bytedance.sdk.openadsdk.gz.g.z(str).to(this.kb);
        z(this.kb, str);
        oq.z((View) this.uy, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, int i2) {
        if (ls()) {
            return;
        }
        na naVar = this.f1401a;
        com.bytedance.sdk.openadsdk.core.iq.v vVarWg = naVar == null ? null : naVar.wg();
        if (vVarWg != null && i2 > 0) {
            if (!vVarWg.gz()) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.f1401a, this.pf, 1);
                return;
            }
            this.na = i;
            this.xl = i2;
            if (this.vm == null) {
                this.vm = new dl(vVarWg, this.m, this.f1401a, this.pf, this.na, this.xl);
            }
            com.bytedance.sdk.openadsdk.gz.g.z(vVarWg.gc()).type(3).config(Bitmap.Config.RGB_565).to(this.vm);
        }
    }

    public static class dl implements io {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private na f1403a;
        private WeakReference<GifView> dl = new WeakReference<>(null);
        private int e;
        private WeakReference<ViewGroup> g;
        private String gc;
        private int m;
        private com.bytedance.sdk.openadsdk.core.iq.v z;

        public dl(com.bytedance.sdk.openadsdk.core.iq.v vVar, ViewGroup viewGroup, na naVar, String str, int i, int i2) {
            this.z = vVar;
            this.g = new WeakReference<>(viewGroup);
            this.f1403a = naVar;
            this.gc = str;
            this.m = i;
            this.e = i2;
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onSuccess(final ls lsVar) {
            try {
                ViewGroup viewGroup = this.g.get();
                if (viewGroup == null) {
                    return;
                }
                viewGroup.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.dl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ViewGroup viewGroup2 = (ViewGroup) dl.this.g.get();
                            if (viewGroup2 == null) {
                                return;
                            }
                            Context context = viewGroup2.getContext();
                            dl dlVar = dl.this;
                            dlVar.z(context, dlVar.z, lsVar, viewGroup2);
                        } catch (Exception e) {
                            wp.z(e);
                        }
                    }
                }, 100L);
            } catch (Exception e) {
                onFailed(1002, "", e);
            }
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onFailed(int i, String str, Throwable th) {
            wp.a("copflg", "fail: ".concat(String.valueOf(str)));
            GifView gifView = this.dl.get();
            if (gifView != null) {
                gifView.setVisibility(8);
            }
            com.bytedance.sdk.openadsdk.core.i.a.z(this.f1403a, this.gc, 2);
        }

        private int z() {
            if (this.z.m() > 0.0d) {
                return (int) (((double) this.e) * this.z.m());
            }
            return this.e / 2;
        }

        private void z(Context context, FrameLayout.LayoutParams layoutParams, int i) {
            if (this.z.dl() == 2) {
                layoutParams.gravity = 8388693;
                layoutParams.rightMargin = i;
                layoutParams.bottomMargin = i;
            } else {
                layoutParams.gravity = 8388659;
                layoutParams.leftMargin = i;
                layoutParams.topMargin = oq.dl(context, 19.0f);
            }
        }

        private void z(Object obj, ls lsVar, GifView gifView) {
            if (obj instanceof byte[]) {
                if (lsVar.isGif()) {
                    gifView.z((byte[]) obj, false);
                    gifView.setRepeatConfig(false);
                } else {
                    gifView.setImageDrawable(fv.z((byte[]) obj, 0));
                }
            }
        }

        private void z(GifView gifView) {
            if (gifView == null || gifView.getParent() == null) {
                return;
            }
            ((ViewGroup) gifView.getParent()).removeView(gifView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z(Context context, com.bytedance.sdk.openadsdk.core.iq.v vVar, ls lsVar, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            GifView gifView = new GifView(context);
            gifView.setAdjustViewBounds(true);
            gifView.setBackgroundColor(0);
            int iDl = oq.dl(context, 12.0f);
            this.m = viewGroup.getWidth() <= 0 ? this.m : viewGroup.getWidth();
            this.e = viewGroup.getHeight() <= 0 ? this.e : viewGroup.getHeight();
            int iZ = z();
            if (vVar.z() == 3) {
                if (iZ > oq.dl(context, 88.0f)) {
                    iZ = oq.dl(context, 88.0f);
                }
            } else if (vVar.z() == 4 && iZ > oq.dl(context, 178.0f)) {
                iZ = oq.dl(context, 178.0f);
            }
            int i = this.m - iDl;
            int iE = (int) (((double) iZ) * vVar.e());
            if (iE > i && iE > 0 && i > 0) {
                layoutParams = new FrameLayout.LayoutParams(i, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-2, iZ);
            }
            z(context, layoutParams, iDl);
            gifView.setVisibility(0);
            z(lsVar.getResult(), lsVar, gifView);
            z(this.dl.get());
            viewGroup.addView(gifView, layoutParams);
            this.dl = new WeakReference<>(gifView);
            com.bytedance.sdk.openadsdk.core.i.a.z(this.f1403a, this.gc, 0);
        }
    }

    private void iq() {
        if (!(this instanceof NativeDrawVideoTsView) || this.p.get() || com.bytedance.sdk.openadsdk.core.uy.ls().xl() == null) {
            return;
        }
        this.i.setImageBitmap(com.bytedance.sdk.openadsdk.core.uy.ls().xl());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        int iDl = oq.dl(getContext(), this.ls);
        layoutParams.width = iDl;
        layoutParams.height = iDl;
        this.i.setLayoutParams(layoutParams);
        this.p.set(true);
    }

    protected void B_() {
        this.gc = z(this.dl, this.e, this.f1401a, this.pf, !ls(), this.io, this.uf);
        io();
        this.bv = new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.ec = nativeVideoTsView.m.getViewTreeObserver();
                if (NativeVideoTsView.this.ec == null || NativeVideoTsView.this.y == null) {
                    return;
                }
                NativeVideoTsView.this.ec.addOnGlobalLayoutListener(NativeVideoTsView.this.y);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                NativeVideoTsView.this.zw();
            }
        };
        this.y = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int width = NativeVideoTsView.this.m.getWidth();
                int height = NativeVideoTsView.this.m.getHeight();
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) NativeVideoTsView.this.gc).z(width, height);
                NativeVideoTsView.this.zw();
                NativeVideoTsView.this.g(width, height);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        ViewTreeObserver viewTreeObserver = this.ec;
        if (viewTreeObserver == null || (onGlobalLayoutListener = this.y) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    protected com.bykv.vk.openvk.component.video.api.a.dl z(Context context, ViewGroup viewGroup, na naVar, String str, boolean z2, boolean z3, boolean z4) {
        return new com.bytedance.sdk.openadsdk.core.video.nativevideo.a(context, viewGroup, naVar, str, z2, z3, z4);
    }

    public void setVideoAdLoadListener(dl.a aVar) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            dlVar.z(aVar);
        }
    }

    public void setNativeVideoAdListener(dl.z zVar) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            dlVar.z(zVar);
        }
    }

    public boolean z(long j, boolean z2, boolean z3) {
        boolean z4 = false;
        this.m.setVisibility(0);
        if (this.gc == null) {
            this.gc = new com.bytedance.sdk.openadsdk.core.video.nativevideo.a(this.dl, this.e, this.f1401a, this.pf, this.io, this.uf);
            io();
        }
        this.h = j;
        if (ls()) {
            this.gc.z(false);
            if (tf.v(this.f1401a) != null) {
                com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, this.f1401a);
                aVarZ.g(this.f1401a.mj());
                aVarZ.g(this.m.getWidth());
                aVarZ.dl(this.m.getHeight());
                aVarZ.dl(this.f1401a.vk());
                aVarZ.z(j);
                aVarZ.g(pf());
                if (z3) {
                    this.gc.g(aVarZ);
                    return true;
                }
                z4 = z(aVarZ);
            }
            if (((j > 0 && !z2 && !z3) || (j > 0 && z2 && !this.sy)) && (this.gc instanceof com.bytedance.sdk.openadsdk.core.video.z.z)) {
                p.z zVar = new p.z();
                zVar.z(this.gc.kb());
                zVar.dl(this.gc.v());
                zVar.g(this.gc.wp());
                com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
                ((com.bytedance.sdk.openadsdk.core.video.z.z) dlVar).g(dlVar.fv(), zVar);
            }
            return z4;
        }
        if (wp() || this.fo) {
            z(this.dl, 25, tf.g(this.f1401a));
        }
        return true;
    }

    public boolean wp() {
        na naVar = this.f1401a;
        return naVar != null && naVar.pc() == 4 && vm.z(this.f1401a) == 1 && !TextUtils.equals("draw_ad", this.pf);
    }

    private void io() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar == null) {
            return;
        }
        dlVar.a(this.z);
        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.gc).z((a.z) this);
        this.gc.z(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onAttachedToWindow();
        if (this.j) {
            ViewGroup viewGroup = this.m;
            if (viewGroup != null && (onAttachStateChangeListener = this.bv) != null) {
                viewGroup.addOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            a();
            gz.z(this);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.j) {
            a();
        }
    }

    public void a() {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar == null) {
            B_();
        } else if ((dlVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) && !ls()) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.gc).vm();
        }
        if (this.gc == null || !this.tb.get()) {
            return;
        }
        this.tb.set(false);
        e();
        if (v()) {
            ImageView imageView = this.wp;
            if (imageView != null) {
                oq.z((View) imageView, 8);
            }
            if (tf.v(this.f1401a) != null) {
                com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, this.f1401a);
                aVarZ.g(this.f1401a.mj());
                aVarZ.g(this.m.getWidth());
                aVarZ.dl(this.m.getHeight());
                aVarZ.dl(this.f1401a.vk());
                aVarZ.z(0L);
                aVarZ.z(com.bytedance.sdk.openadsdk.hh.uy.z(this.f1401a));
                aVarZ.g(pf());
                if (uf()) {
                    String strDl = com.bytedance.sdk.openadsdk.hh.fo.z(0).dl();
                    if (this.f1401a.jv()) {
                        strDl = com.bytedance.sdk.openadsdk.hh.fo.z();
                    }
                    aVarZ.z(strDl);
                }
                z(aVarZ);
                this.gc.dl(false);
                return;
            }
            wp.a("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.gc.tb()) {
            a(true);
            return;
        }
        wp.z("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
        kb();
        oq.z((View) this.uy, 0);
    }

    private boolean uf() {
        return TextUtils.equals(this.pf, "splash_ad") || TextUtils.equals(this.pf, "cache_splash_ad");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.onDetachedFromWindow();
        ViewGroup viewGroup = this.m;
        if (viewGroup != null && (onAttachStateChangeListener = this.bv) != null) {
            viewGroup.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        gc();
        this.vm = null;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        gc();
    }

    public void gc() {
        this.js = null;
        p();
        i();
    }

    public void i() {
        if (!this.tb.get()) {
            this.tb.set(true);
            if (this.gc != null) {
                l lVar = this.gk;
                if (lVar != null) {
                    lVar.removeCallbacksAndMessages(null);
                }
                this.gc.z(true, 3);
            }
        }
        this.lw.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            i();
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what != 1) {
            return;
        }
        sy();
    }

    public void setNativeExpressVideoView(NativeExpressVideoView nativeExpressVideoView) {
        this.hh = nativeExpressVideoView;
    }

    private void sy() {
        boolean zHh = hh();
        if (this.b && zHh) {
            com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
            if (dlVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) dlVar).gk();
            }
            this.b = false;
        } else {
            if (this.f == null) {
                this.f = new g();
            } else {
                com.bytedance.sdk.component.utils.gz.g().removeCallbacks(this.f);
            }
            this.f.z(zHh);
            com.bytedance.sdk.component.utils.gz.g().post(this.f);
        }
        this.gk.sendEmptyMessageDelayed(1, this.un);
    }

    private boolean hh() {
        View view;
        if (!com.bytedance.sdk.openadsdk.hh.uy.z(this.f1401a)) {
            view = this;
        } else if (vm.z(this.f1401a) == 2) {
            view = this.hh;
        } else {
            ViewParent parent = getParent();
            view = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        }
        return ti.g(view, 50, 5);
    }

    private boolean l() {
        if (ls()) {
            return false;
        }
        if (sv == null) {
            sv = getKvCache();
        }
        return sv.get("key_video_is_from_detail_page", false) || sv.get("key_video_isfromvideodetailpage", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.component.a.g.dl getKvCache() {
        return x.z("sp_multi_native_video_data");
    }

    private void h() {
        if (ls()) {
            return;
        }
        if (sv == null) {
            sv = getKvCache();
        }
        sv.put("key_video_isfromvideodetailpage", false);
        sv.put("key_video_is_from_detail_page", false);
    }

    public void dl(boolean z2) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e eVar = this.jq;
        if (eVar != null) {
            eVar.z(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z2) {
        if (this.yx || this.iq == z2) {
            return;
        }
        if (!z2) {
            com.bytedance.sdk.component.utils.gz.g().removeCallbacks(this.f);
        }
        this.iq = z2;
        dl(z2);
        if (this.f1401a == null || this.gc == null) {
            return;
        }
        boolean zL = l();
        h();
        if (zL && this.gc.tb()) {
            a(true);
            gz();
            return;
        }
        if (z2 && !this.gc.tb() && !this.gc.ls()) {
            if (this.gc.p() != null && this.gc.p().v()) {
                if (this.z) {
                    if ("ALP-AL00".equals(this.lq)) {
                        this.gc.gz();
                    } else {
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.gc).m(zL);
                    }
                    dl.InterfaceC0027dl interfaceC0027dl = this.eo;
                    if (interfaceC0027dl != null) {
                        interfaceC0027dl.s_();
                        return;
                    }
                    return;
                }
                this.iq = false;
                return;
            }
            if (this.z && this.gc.p() == null) {
                if (!this.tb.get()) {
                    this.tb.set(true);
                }
                this.lw.set(false);
                a();
                return;
            }
            return;
        }
        if (this.gc.p() == null || !this.gc.p().i()) {
            return;
        }
        this.gc.m();
        dl.InterfaceC0027dl interfaceC0027dl2 = this.eo;
        if (interfaceC0027dl2 != null) {
            interfaceC0027dl2.r_();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar2;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar3;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar4;
        super.onWindowFocusChanged(z2);
        if (this.j) {
            this.oq = z2;
            x();
            if (l() && (dlVar4 = this.gc) != null && dlVar4.tb()) {
                h();
                oq.z((View) this.uy, 8);
                a(true);
                gz();
                return;
            }
            e();
            if (ls() || !v() || (dlVar2 = this.gc) == null || dlVar2.ls()) {
                if (v()) {
                    return;
                }
                if (!z2 && (dlVar = this.gc) != null && dlVar.p() != null && this.gc.p().i()) {
                    this.gk.removeMessages(1);
                    g(false);
                    return;
                } else {
                    if (z2) {
                        this.gk.obtainMessage(1).sendToTarget();
                        return;
                    }
                    return;
                }
            }
            if (this.gk != null) {
                if (z2 && (dlVar3 = this.gc) != null && !dlVar3.tb()) {
                    this.gk.obtainMessage(1).sendToTarget();
                } else {
                    this.gk.removeMessages(1);
                    g(false);
                }
            }
        }
    }

    private void gk() {
        if (this.gb == null) {
            return;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                if (viewGroup.hashCode() == this.gb.hashCode()) {
                    this.gb.hashCode();
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar2;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar3;
        super.onWindowVisibilityChanged(i);
        if (this.j) {
            gk();
            x();
            if (this.qd) {
                this.qd = i == 0;
            }
            if (l() && (dlVar3 = this.gc) != null && dlVar3.tb()) {
                h();
                oq.z((View) this.uy, 8);
                a(true);
                gz();
                return;
            }
            e();
            if (ls() || !v() || (dlVar = this.gc) == null || dlVar.ls() || this.f1401a == null) {
                return;
            }
            boolean zG = ti.g(this, 20, 5);
            isShown();
            if (this.l && tf.v(this.f1401a) != null && zG) {
                com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, this.f1401a);
                aVarZ.g(this.f1401a.mj());
                aVarZ.g(this.m.getWidth());
                aVarZ.dl(this.m.getHeight());
                aVarZ.dl(this.f1401a.vk());
                aVarZ.z(this.h);
                aVarZ.g(pf());
                z(aVarZ);
                oq.z((View) this.uy, 8);
            } else {
                try {
                    wp.a("NativeVideoAdView", "onWindowVisibilityChanged materialMeta.getVideo() is null " + (this.uy == null) + " " + this.qd + " " + hashCode());
                    if (this.qd && this.uy == null) {
                        kb();
                        oq.z((View) this.uy, 0);
                    }
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
            if (i != 0 || !this.oq || this.gk == null || (dlVar2 = this.gc) == null || dlVar2.tb()) {
                return;
            }
            this.gk.obtainMessage(1).sendToTarget();
        }
    }

    protected boolean z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        if (this.gc == null) {
            return false;
        }
        this.l = false;
        this.un = this.ti;
        if (this.t) {
            aVar.g(this.gp);
        }
        return this.gc.z(aVar);
    }

    private void x() {
        if (sv == null) {
            sv = getKvCache();
        }
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar == null || ls() || !sv.get("key_video_is_update_flag", false)) {
            return;
        }
        boolean z2 = sv.get("key_native_video_complete", false);
        long j = sv.get("key_video_current_play_position", -1L);
        long j2 = sv.get("key_video_total_play_duration", dlVar.v() + dlVar.wp());
        long j3 = sv.get("key_video_duration", dlVar.v());
        dlVar.dl(z2);
        if (z2) {
            dlVar.g(j3);
        } else {
            dlVar.g(j);
        }
        dlVar.dl(j2);
        dlVar.a(j3);
        sv.put("key_video_is_update_flag", false);
    }

    public void setNativeVideoController(com.bykv.vk.openvk.component.video.api.a.dl dlVar) {
        this.gc = dlVar;
    }

    public com.bykv.vk.openvk.component.video.api.a.dl getNativeVideoController() {
        return this.gc;
    }

    public boolean v() {
        return this.z;
    }

    public void setIsAutoPlay(boolean z2) {
        na naVar;
        if (this.x || (naVar = this.f1401a) == null) {
            return;
        }
        int iE = zw.g().e(eo.fo(naVar));
        if (z2 && iE != 4 && (!v.gc(this.dl) ? !(!v.m(this.dl) ? v.a(this.dl) : lq() || mc()) : !lq())) {
            z2 = false;
        }
        this.z = z2;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            dlVar.a(z2);
        }
        if (!this.z) {
            kb();
            RelativeLayout relativeLayout = this.uy;
            if (relativeLayout != null) {
                oq.z((View) relativeLayout, 0);
                if (tf.v(this.f1401a) != null) {
                    com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.f1401a)).to(this.kb);
                    z(this.kb, tf.g(this.f1401a));
                } else {
                    wp.a("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            oq.z((View) this.uy, 8);
        }
        this.x = true;
    }

    private boolean lq() {
        return 2 == zw.g().e(eo.fo(this.f1401a));
    }

    private boolean mc() {
        return 5 == zw.g().e(eo.fo(this.f1401a));
    }

    public boolean pf() {
        return this.gz;
    }

    public void g(boolean z2, boolean z3) {
        this.gp = z2;
        this.t = z3;
    }

    public void setIsQuiet(boolean z2) {
        this.gz = z2;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            dlVar.g(z2);
        }
    }

    public void setEnableAutoCheck(boolean z2) {
        this.j = z2;
    }

    public boolean ls() {
        return this.g;
    }

    public void setVideoAdInteractionListener(dl.InterfaceC0027dl interfaceC0027dl) {
        this.eo = interfaceC0027dl;
    }

    public void C_() {
        oq.z((View) this.uy, 8);
        dl.InterfaceC0027dl interfaceC0027dl = this.eo;
        if (interfaceC0027dl != null && !this.zx) {
            this.zx = true;
            interfaceC0027dl.q_();
        }
        oq.z((View) this.uy, 8);
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e eVar = this.jq;
        if (eVar != null) {
            eVar.z();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z2) {
        this.v = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a.z
    public void z(int i) {
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a.z
    public void fo() {
        this.b = true;
        if (this.gk.hasMessages(1)) {
            return;
        }
        this.gk.sendEmptyMessage(1);
    }

    protected void g(int i) {
        if (v.dl(zw.getContext()) == 0) {
            return;
        }
        if (this.gc.p() != null) {
            if (this.gc.p().i() && i == 2) {
                g(false);
                l lVar = this.gk;
                if (lVar != null) {
                    lVar.removeMessages(1);
                }
                z(true);
                return;
            }
            if (this.gc.p().v() && i == 3) {
                this.z = true;
                g(true);
                e();
                l lVar2 = this.gk;
                if (lVar2 != null) {
                    lVar2.sendEmptyMessageDelayed(1, this.un);
                }
                z(false);
                return;
            }
        }
        if (v() || this.lw.get()) {
            return;
        }
        this.lw.set(true);
        if (tf.v(this.f1401a) != null) {
            un();
            com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, this.f1401a);
            aVarZ.g(this.f1401a.mj());
            aVarZ.g(this.m.getWidth());
            aVarZ.dl(this.m.getHeight());
            aVarZ.dl(this.f1401a.vk());
            aVarZ.z(this.h);
            aVarZ.g(pf());
            aVarZ.z(com.bytedance.sdk.openadsdk.hh.fo.z(this.f1401a.su()).a());
            z(aVarZ);
        } else {
            wp.a("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        l lVar3 = this.gk;
        if (lVar3 != null) {
            lVar3.sendEmptyMessageDelayed(1, this.un);
        }
        z(false);
    }

    protected void g() {
        if (v.dl(zw.getContext()) == 0) {
            return;
        }
        if (this.gc.p() != null) {
            if (this.gc.p().i()) {
                g(false);
                l lVar = this.gk;
                if (lVar != null) {
                    lVar.removeMessages(1);
                }
                z(true);
                return;
            }
            if (this.gc.p().v()) {
                this.z = true;
                g(true);
                e();
                l lVar2 = this.gk;
                if (lVar2 != null) {
                    lVar2.sendEmptyMessageDelayed(1, this.un);
                }
                z(false);
                return;
            }
        }
        if (v() || this.lw.get()) {
            return;
        }
        this.lw.set(true);
        if (tf.v(this.f1401a) != null) {
            un();
            com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, this.f1401a);
            aVarZ.g(this.f1401a.mj());
            aVarZ.g(this.m.getWidth());
            aVarZ.dl(this.m.getHeight());
            aVarZ.dl(this.f1401a.vk());
            aVarZ.z(this.h);
            aVarZ.g(pf());
            z(aVarZ);
        } else {
            wp.a("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        l lVar3 = this.gk;
        if (lVar3 != null) {
            lVar3.sendEmptyMessageDelayed(1, this.un);
        }
        z(false);
    }

    protected void z(boolean z2) {
        if (this.wp == null) {
            this.wp = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.uy.ls().xl() != null) {
                this.wp.setImageBitmap(com.bytedance.sdk.openadsdk.core.uy.ls().xl());
            } else {
                tb.z(zw.getContext(), "tt_new_play_video", this.wp);
            }
            this.wp.setScaleType(ImageView.ScaleType.FIT_XY);
            int iDl = oq.dl(getContext(), this.ls);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDl, iDl);
            layoutParams.gravity = 17;
            this.m.addView(this.wp, layoutParams);
        }
        if (z2) {
            this.wp.setVisibility(0);
        } else {
            this.wp.setVisibility(8);
        }
    }

    public void a(boolean z2) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            dlVar.dl(z2);
            com.bykv.vk.openvk.component.video.api.a.g gVarFv = this.gc.fv();
            if (gVarFv != null) {
                gVarFv.g();
                View viewDl = gVarFv.dl();
                if (viewDl != null) {
                    if (viewDl.getParent() != null) {
                        ((ViewGroup) viewDl.getParent()).removeView(viewDl);
                    }
                    viewDl.setVisibility(0);
                    addView(viewDl);
                    gVarFv.z(this.f1401a, new WeakReference<>(this.dl), false);
                }
            }
        }
    }

    public void p() {
        com.bykv.vk.openvk.component.video.api.a.g gVarFv;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar == null || (gVarFv = dlVar.fv()) == null) {
            return;
        }
        gVarFv.z();
        View viewDl = gVarFv.dl();
        if (viewDl != null) {
            viewDl.setVisibility(8);
            if (viewDl.getParent() != null) {
                ((ViewGroup) viewDl.getParent()).removeView(viewDl);
            }
        }
    }

    private void un() {
        oq.gc(this.wp);
        oq.gc(this.uy);
    }

    public void z(int i, int i2) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) dlVar).z(i, i2);
        }
    }

    public void setVideoCacheUrl(String str) {
        this.q = str;
    }

    public void z(final Context context, final int i, String str) {
        final com.bykv.vk.openvk.component.video.api.a.g gVarFv;
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar == null || (gVarFv = dlVar.fv()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.gz.g.z(str).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i2, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls<Bitmap> lsVar) {
                Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(context, lsVar.getResult(), i);
                if (bitmapZ == null) {
                    return;
                }
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(NativeVideoTsView.this.getResources(), bitmapZ);
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (gVarFv != null) {
                            gVarFv.z(bitmapDrawable);
                        }
                    }
                });
            }
        }, 4);
    }

    public void fv() {
        if (this.gc != null) {
            un();
            this.gc.g();
        }
    }

    public void setComplete(boolean z2) {
        com.bykv.vk.openvk.component.video.api.a.dl dlVar = this.gc;
        if (dlVar != null) {
            dlVar.dl(z2);
        }
    }

    public void js() {
        l lVar = this.gk;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
        }
    }

    private class g implements Runnable {
        private volatile boolean g;

        private g() {
        }

        public Runnable z(boolean z) {
            this.g = z;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeVideoTsView.this.g(this.g);
        }
    }
}
