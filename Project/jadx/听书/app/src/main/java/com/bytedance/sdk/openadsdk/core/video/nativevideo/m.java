package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.a.g;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bykv.vk.openvk.component.video.z.gc.g;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.g.z.z.z;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.q;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.pf;
import com.bytedance.sdk.openadsdk.core.widget.v;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.upie.video.lottie.TTLottieVideoContainer;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class m implements com.bykv.vk.openvk.component.video.api.a.g<na>, com.bykv.vk.openvk.component.video.api.renderview.z, l.z, pf.g, v.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    View f1408a;
    private e b;
    private RoundImageView bv;
    ImageView dl;
    protected TTViewStub e;
    private RelativeLayout ec;
    private View eo;
    private int f;
    ImageView fo;
    int fv;
    com.bykv.vk.openvk.component.video.api.renderview.g g;
    private TextView gb;
    View gc;
    com.bytedance.sdk.openadsdk.core.kb.g.dl gk;
    private TextView gp;
    View gz;
    boolean h;
    pf hh;
    TextView i;
    EnumSet<g.z> io;
    volatile boolean iq;
    private RoundImageView j;
    private TextView jq;
    int js;
    RoundImageView kb;
    g l;
    com.bytedance.sdk.openadsdk.core.g.z lq;
    protected TTViewStub ls;
    private final int lw;
    ImageView m;
    com.bytedance.sdk.openadsdk.core.g.z mc;
    private AtomicBoolean me;
    private NativeVideoTsView.z na;
    private TextView oq;
    int p;
    TTProgressBar pf;
    boolean q;
    private com.bytedance.sdk.openadsdk.core.g.z qd;
    private final int rv;
    private String sv;
    Context sy;
    private RelativeLayout t;
    int tb;
    private final int tc;
    boolean ti;
    na uf;
    com.bytedance.sdk.openadsdk.q.z.g.z.z un;
    View uy;
    TextView v;
    private TTViewStub vm;
    private TextView wj;
    TextView wp;
    com.bykv.vk.openvk.component.video.api.a.dl x;
    private RelativeLayout xl;
    private View y;
    private boolean yx;
    View z;
    int zw;
    private z.InterfaceC0190z zx;

    public void dl(boolean z) {
    }

    public boolean dl(int i) {
        return false;
    }

    public void g(ViewGroup viewGroup) {
    }

    public void g(boolean z) {
    }

    public void gc() {
    }

    public void m() {
    }

    public boolean uy() {
        return false;
    }

    public void v() {
    }

    public void z(long j) {
    }

    public void z(long j, long j2) {
    }

    public void z(Message message) {
    }

    public void z(View view, boolean z) {
    }

    public void z(ViewGroup viewGroup) {
    }

    public void z(String str) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.g
    public /* bridge */ /* synthetic */ void z(na naVar, WeakReference weakReference, boolean z) {
        z(naVar, (WeakReference<Context>) weakReference, z);
    }

    public m(Context context, View view, boolean z, EnumSet<g.z> enumSet, na naVar, com.bykv.vk.openvk.component.video.api.a.dl dlVar, boolean z2, com.bytedance.sdk.openadsdk.core.g.z zVar) {
        this.q = true;
        this.h = true;
        this.ti = true;
        this.lw = 1;
        this.rv = 2;
        this.tc = 3;
        this.me = new AtomicBoolean(false);
        if (this instanceof gc) {
            return;
        }
        this.sy = zw.getContext().getApplicationContext();
        a(z2);
        this.z = view;
        this.q = z;
        this.io = enumSet == null ? EnumSet.noneOf(g.z.class) : enumSet;
        this.x = dlVar;
        this.qd = zVar;
        this.uf = naVar;
        h();
        a(8);
        z(context, this.z, naVar);
        a();
        ls();
    }

    public m(Context context, View view, boolean z, EnumSet<g.z> enumSet, na naVar, com.bykv.vk.openvk.component.video.api.a.dl dlVar, com.bytedance.sdk.openadsdk.core.g.z zVar) {
        this(context, view, z, enumSet, naVar, dlVar, true, zVar);
    }

    private void h() {
        this.f = 1;
        String strG = eo.g(this.uf);
        String str = "embeded_ad_landingpage";
        if (strG == null) {
            strG = this.h ? "embeded_ad" : "embeded_ad_landingpage";
        }
        this.f = eo.g(strG);
        if (!this.h && strG.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.h || !strG.equals("embeded_ad")) {
            str = strG;
        }
        this.sv = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk() {
        com.bytedance.sdk.openadsdk.hh.e.z(new fo("native_video_layout_download_listener") { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.1
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.gk == null) {
                    m mVar = m.this;
                    mVar.gk = gz.z(mVar.sy, m.this.uf, m.this.sv, false);
                }
                if (m.this.lq != null) {
                    ((com.bytedance.sdk.openadsdk.core.g.z.z.z) m.this.lq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(m.this.gk);
                }
                if (m.this.mc != null) {
                    ((com.bytedance.sdk.openadsdk.core.g.z.z.z) m.this.mc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(m.this.gk);
                }
                if (m.this.zx != null) {
                    m.this.gk.z(m.this.zx);
                }
                if (m.this.gk != null) {
                    m.this.gk.z(false);
                }
            }
        });
    }

    void ls() {
        View view;
        h();
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.uf)) {
            com.bytedance.sdk.openadsdk.core.g.z zVar = this.qd;
            if (zVar != null) {
                this.lq = zVar;
            } else {
                this.lq = new com.bytedance.sdk.openadsdk.core.g.z(this.sy, this.uf, this.sv, this.f);
            }
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.lq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(new z.InterfaceC0171z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.5
                @Override // com.bytedance.sdk.openadsdk.core.g.z.z.z.InterfaceC0171z
                public void z(View view2, int i) {
                    if (m.this.na != null) {
                        m.this.na.z(view2, i);
                    }
                }
            });
            if (this.qd == null && (view = this.z) != null) {
                view.setOnClickListener(this.lq);
                this.z.setOnTouchListener(this.lq);
            }
            if (oq.a(this.t)) {
                this.t.setOnClickListener(this.lq);
                this.t.setOnTouchListener(this.lq);
                return;
            }
            return;
        }
        lq();
        com.bytedance.sdk.openadsdk.core.g.z zVar2 = new com.bytedance.sdk.openadsdk.core.g.z(this.sy, this.uf, this.sv, this.f);
        this.lq = zVar2;
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).g(true);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.lq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(new z.InterfaceC0171z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.6
            @Override // com.bytedance.sdk.openadsdk.core.g.z.z.z.InterfaceC0171z
            public void z(View view2, int i) {
                if (m.this.na != null) {
                    m.this.na.z(view2, i);
                }
            }
        });
        g(this.lq);
        if (this.h) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.lq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
        } else {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.lq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(false);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.lq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
        }
        if (x()) {
            com.bytedance.sdk.openadsdk.core.g.z zVar3 = new com.bytedance.sdk.openadsdk.core.g.z(this.sy, this.uf, this.sv, this.f);
            this.mc = zVar3;
            g(zVar3);
            this.b = new e(this);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.mc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).g(true);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.mc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(new z.InterfaceC0171z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.7
                @Override // com.bytedance.sdk.openadsdk.core.g.z.z.z.InterfaceC0171z
                public void z(View view2, int i) {
                    if (m.this.na != null) {
                        m.this.na.z(view2, i);
                    }
                }
            });
            if (this.h) {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.mc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
            } else {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.mc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(false);
            }
            z(this.mc);
            View view2 = this.z;
            if (view2 != null) {
                view2.setOnClickListener(this.mc);
                this.z.setOnTouchListener(this.mc);
            }
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.g.z zVar) {
        na naVar;
        if (zVar == null || (naVar = this.uf) == null || !com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("click_live_element", "click_live_feed");
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(map);
    }

    private boolean x() {
        na naVar = this.uf;
        return naVar != null && vm.m(naVar) == null && vm.e(this.uf) == null && this.uf.f() == 1 && na.g(this.uf);
    }

    public void z(NativeVideoTsView.z zVar) {
        this.na = zVar;
    }

    public void z(i iVar) {
        z(iVar, this.lq);
        z(iVar, this.mc);
    }

    private void g(com.bytedance.sdk.openadsdk.core.g.z zVar) {
        na naVar;
        if (zVar == null || (naVar = this.uf) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ls.dl.g.v vVarZ = com.bytedance.sdk.openadsdk.core.video.a.z.z(Integer.valueOf(naVar.hashCode()));
        if (vVarZ instanceof q) {
            ((q) vVarZ).z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        }
    }

    private void z(i iVar, com.bytedance.sdk.openadsdk.core.g.z zVar) {
        iq iqVarA;
        if (zVar == null) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(iVar);
        com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar = (com.bytedance.sdk.openadsdk.core.g.z.dl.dl) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class);
        if ((iVar instanceof com.bytedance.sdk.openadsdk.core.zw.a) && (iqVarA = ((com.bytedance.sdk.openadsdk.core.zw.a) iVar).a()) != null) {
            iqVarA.z(dlVar);
        }
    }

    private void lq() {
        if (this.sy == null || this.z == null) {
            return;
        }
        View view = new View(this.sy) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.8
            private final AtomicBoolean g = new AtomicBoolean(true);

            @Override // android.view.View
            protected void onMeasure(int i, int i2) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (m.this.gk == null || !z) {
                    return;
                }
                m.this.gk.z();
            }

            @Override // android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                m.this.me.set(false);
                z();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                z();
            }

            private void z() {
                if (m.this.uf == null) {
                    return;
                }
                if (this.g.getAndSet(false) && (com.bytedance.sdk.openadsdk.core.video.dl.z.z(m.this.uf) || m.this.uf.lt() == 4)) {
                    m.this.gk();
                }
                io.z(m.this.uf.xn(), m.this.b, e.class);
            }

            private void g() {
                if (this.g.getAndSet(true) || m.this.gk == null) {
                    return;
                }
                m.this.gk.g();
            }

            @Override // android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                m.this.me.set(true);
                g();
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                g();
            }
        };
        View view2 = this.z;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.g p() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void z(Context context, View view, na naVar) {
        View sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.bytedance.sdk.openadsdk.gc.z.g(naVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.sy);
        } else if (com.bytedance.sdk.openadsdk.gc.z.dl(naVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.bytedance.sdk.openadsdk.gc.z.fo(naVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.sy);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, layoutParams);
            if (ti()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(-16777216);
            }
        }
        oq.z(sSRenderTextureView, 8);
        this.g = (com.bykv.vk.openvk.component.video.api.renderview.g) sSRenderTextureView;
        this.dl = (ImageView) view.findViewById(2114387626);
        this.pf = (TTProgressBar) view.findViewById(2114387653);
        this.f1408a = view.findViewById(2114387900);
        this.gc = view.findViewById(2114387631);
        this.m = (ImageView) view.findViewById(2114387651);
        this.e = (TTViewStub) view.findViewById(2114387744);
        this.vm = (TTViewStub) view.findViewById(2114387666);
        this.ls = (TTViewStub) view.findViewById(2114387828);
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            g(context, view);
        }
        System.currentTimeMillis();
    }

    private void g(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387888);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387688);
        if (mc()) {
            oq.z((View) relativeLayout, 0);
            oq.z((View) relativeLayout2, 8);
            this.xl = relativeLayout;
        } else {
            oq.z((View) relativeLayout2, 0);
            oq.z((View) relativeLayout, 8);
            this.xl = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.xl;
        if (relativeLayout3 == null) {
            return;
        }
        this.j = (RoundImageView) relativeLayout3.findViewById(2114387831);
        this.gp = (TextView) this.xl.findViewById(2114387742);
        this.t = (RelativeLayout) this.xl.findViewById(2114387693);
    }

    private boolean mc() {
        if (this.uf == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.sv) || "rewarded_video".equals(this.sv)) {
            int iZr = this.uf.zr();
            float fTk = this.uf.tk();
            if (iZr == 1 && fTk == 100.0f) {
                return true;
            }
        }
        return false;
    }

    protected void z(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.vm) == null || tTViewStub.getParent() == null || this.y != null) {
            return;
        }
        this.y = this.vm.z();
        this.ec = (RelativeLayout) view.findViewById(2114387953);
        this.bv = (RoundImageView) view.findViewById(2114387958);
        this.gb = (TextView) view.findViewById(2114387926);
        this.jq = (TextView) view.findViewById(2114387877);
    }

    protected void fv() {
        if (this.uf == null) {
            return;
        }
        if (this.yx) {
            oq.z((View) this.jq, 8);
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.uf)) {
            String strFo = com.bytedance.sdk.openadsdk.core.iq.eo.fo(this.uf);
            String strDl = com.bytedance.sdk.openadsdk.core.iq.eo.dl(this.uf);
            String strGz = com.bytedance.sdk.openadsdk.core.iq.eo.gz(this.uf);
            oq.z(this.y, 0);
            oq.z((View) this.ec, 0);
            if (!TextUtils.isEmpty(strFo)) {
                com.bytedance.sdk.openadsdk.gz.g.z(strFo).to(this.bv);
            }
            if (!TextUtils.isEmpty(strDl)) {
                oq.z(this.gb, strDl);
            }
            if (this.ec == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.gz.g.z(strGz).type(2).to(new com.bytedance.sdk.component.m.io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.9
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(m.this.sy, lsVar.getResult(), 25);
                    if (bitmapZ == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(m.this.ec.getResources(), bitmapZ);
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (m.this.ec != null) {
                                m.this.ec.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void un() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        na naVar = this.uf;
        if (naVar != null && com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            String strFo = com.bytedance.sdk.openadsdk.core.iq.eo.fo(this.uf);
            if (!TextUtils.isEmpty(strFo)) {
                com.bytedance.sdk.openadsdk.gz.g.z(strFo).to(this.j);
            }
            String strDl = com.bytedance.sdk.openadsdk.core.iq.eo.dl(this.uf);
            String strGz = com.bytedance.sdk.openadsdk.core.iq.eo.gz(this.uf);
            if (!TextUtils.isEmpty(strDl)) {
                oq.z(this.gp, strDl);
            }
            if (this.xl == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.gz.g.z(strGz).type(2).to(new com.bytedance.sdk.component.m.io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.10
                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(m.this.sy, lsVar.getResult(), 25);
                    if (bitmapZ == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(m.this.xl.getResources(), bitmapZ);
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (m.this.xl != null) {
                                m.this.xl.setBackground(bitmapDrawable);
                            }
                        }
                    });
                    com.bytedance.sdk.openadsdk.core.i.a.a(m.this.uf, m.this.sv, System.currentTimeMillis() - jCurrentTimeMillis);
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(m.this.uf, m.this.sv, i, str);
                }
            }, 4);
        }
    }

    void z(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.e) == null || tTViewStub.getParent() == null || this.gz != null) {
            return;
        }
        this.gz = this.e.z();
        this.e.setVisibility(0);
        this.fo = (ImageView) view.findViewById(2114387804);
        this.uy = view.findViewById(2114387961);
        this.kb = (RoundImageView) view.findViewById(2114387664);
        this.wp = (TextView) view.findViewById(2114387957);
        this.i = (TextView) view.findViewById(2114387764);
        this.v = (TextView) view.findViewById(2114387686);
    }

    private void g(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.ls) == null || tTViewStub.getParent() == null || this.eo != null) {
            return;
        }
        this.ls.z();
        this.eo = view.findViewById(2114387674);
        this.oq = (TextView) view.findViewById(2114387868);
        this.wj = (TextView) view.findViewById(2114387842);
    }

    void js() {
        if (this.l == null || this.hh != null) {
            return;
        }
        System.currentTimeMillis();
        pf pfVar = new pf();
        this.hh = pfVar;
        pfVar.z(this.sy, this.z);
        this.hh.z(this.l, this);
        System.currentTimeMillis();
    }

    public boolean z(int i, com.bykv.vk.openvk.component.video.api.dl.dl dlVar, boolean z) {
        pf pfVar = this.hh;
        return pfVar == null || pfVar.z(i, dlVar, z);
    }

    public void tb() {
        pf pfVar = this.hh;
        if (pfVar != null) {
            pfVar.z(false);
        }
    }

    public void z(com.bykv.vk.openvk.component.video.api.a.z zVar) {
        if (zVar instanceof g) {
            this.l = (g) zVar;
            js();
        }
    }

    boolean q() {
        if (this.l != null) {
            return true;
        }
        wp.a("NewLiveViewLayout", "callback is null");
        return false;
    }

    void a() {
        this.g.z(this);
        ImageView imageView = this.dl;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.q()) {
                        if (m.this.v == null || m.this.v.getVisibility() != 0) {
                            m.this.l.z(m.this, view);
                        }
                    }
                }
            });
        }
    }

    public void gc(int i) {
        oq.z(this.z, 0);
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.g;
        if (gVar != null) {
            gVar.setVisibility(i);
        }
    }

    public void a(boolean z) {
        this.h = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.g.z zVar = this.lq;
            if (zVar != null) {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
            }
            com.bytedance.sdk.openadsdk.core.g.z zVar2 = this.mc;
            if (zVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.g.z zVar3 = this.lq;
        if (zVar3 != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar3.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.lq.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
        }
        com.bytedance.sdk.openadsdk.core.g.z zVar4 = this.mc;
        if (zVar4 != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar4.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).dl(true);
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.mc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(true);
        }
    }

    public void z(int i, int i2) {
        if (i == -1) {
            i = oq.a(this.sy);
        }
        if (i <= 0) {
            return;
        }
        this.p = i;
        if (kb() || uy() || this.io.contains(g.z.fixedSize)) {
            this.fv = i2;
        } else {
            this.fv = e(i);
        }
        g(this.p, this.fv);
    }

    public void g(boolean z, boolean z2) {
        ImageView imageView = this.dl;
        if (imageView != null) {
            if (z) {
                tb.z(this.sy, "tt_play_movebar_textpage", imageView);
            } else {
                tb.z(this.sy, "tt_stop_movebar_textpage", imageView);
            }
        }
    }

    public void g(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.z;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.z.setLayoutParams(layoutParams);
    }

    private int e(int i) {
        if (this.js <= 0 || this.tb <= 0) {
            return 0;
        }
        int iDl = oq.dl(this.sy, 228.0f);
        int iDl2 = oq.dl(this.sy, 160.0f);
        int i2 = (int) (this.tb * ((i * 1.0f) / this.js));
        return i2 > iDl ? iDl : i2 < iDl2 ? iDl2 : i2;
    }

    public void dl(int i, int i2) {
        this.js = i;
        this.tb = i2;
    }

    public void g(int i) {
        wp.z("Progress", "setSeekProgress-percent=".concat(String.valueOf(i)));
        oq.z((View) this.pf, 0);
        TTProgressBar tTProgressBar = this.pf;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i);
        }
    }

    public void dl(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.z.getParent() == null) {
            viewGroup.addView(this.z);
        }
        a(0);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.g
    public View dl() {
        return this.z;
    }

    public void e() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.uf)) {
            iq();
        } else {
            eo();
        }
        ImageView imageView = this.dl;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        oq.z((View) this.dl, 8);
    }

    private boolean ti() {
        return TextUtils.equals(this.sv, "splash_ad") || TextUtils.equals(this.sv, "cache_splash_ad");
    }

    private void eo() {
        if (ti()) {
            oq.z((View) this.dl, 8);
            if (!zw.g().dt()) {
                oq.z(this.f1408a, 8);
                oq.z(this.gc, 8);
                oq.z((View) this.m, 8);
                return;
            }
        }
        oq.z(this.f1408a, 0);
        oq.z((View) this.xl, 8);
        oq.m(this.f1408a);
        if (ti() && zw.g().dt()) {
            oq.z(this.gc, 8);
        } else {
            oq.m(this.gc);
        }
        if (this.m == null || TextUtils.isEmpty(tf.g(this.uf))) {
            return;
        }
        oq.m(this.m);
        com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.uf)).to(this.m);
        z(this.m, tf.g(this.uf));
    }

    protected void iq() {
        oq.z(this.f1408a, 8);
        oq.z((View) this.xl, 0);
        un();
    }

    public void zw() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.uf)) {
            iq();
        } else {
            oq.z((View) this.xl, 8);
            oq.m(this.f1408a);
            oq.m(this.gc);
        }
        ImageView imageView = this.dl;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        oq.z((View) this.dl, 8);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.g
    public void z() {
        z(false, this.q);
        uf();
    }

    public void io() {
        oq.z(this.z, 0);
        com.bykv.vk.openvk.component.video.api.renderview.g gVar = this.g;
        if (gVar != null) {
            View view = gVar.getView();
            oq.z(view, 8);
            oq.z(view, 0);
        }
    }

    void uf() {
        oq.z(this.gz, 8);
        oq.z((View) this.fo, 8);
        oq.z(this.uy, 8);
        oq.z((View) this.kb, 8);
        oq.z((View) this.wp, 8);
        oq.z((View) this.i, 8);
        oq.z((View) this.v, 8);
        oq.z(this.y, 8);
        oq.z((View) this.ec, 8);
    }

    private void gz(int i) {
        oq.z(this.uy, i);
        oq.z(this.eo, i);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.g
    public void z(boolean z) {
        this.ti = z;
    }

    public void m(int i) {
        na naVar;
        if (this.kb == null || (naVar = this.uf) == null || naVar.kp() == null || this.uf.kp().z() == null) {
            return;
        }
        if (i == 1) {
            int iDl = oq.dl(this.sy, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDl, iDl);
            layoutParams.addRule(14);
            this.kb.setLayoutParams(layoutParams);
            this.wp.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = oq.dl(this.sy, 16.0f);
            layoutParams2.topMargin = oq.dl(this.sy, 8.0f);
            layoutParams2.leftMargin = oq.dl(this.sy, 16.0f);
            layoutParams2.rightMargin = oq.dl(this.sy, 16.0f);
            layoutParams2.addRule(3, this.kb.getId());
            layoutParams2.addRule(14);
            this.i.setLayoutParams(layoutParams2);
            this.i.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, oq.dl(this.sy, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.i.getId());
            layoutParams3.leftMargin = oq.dl(this.sy, 20.0f);
            layoutParams3.rightMargin = oq.dl(this.sy, 20.0f);
            this.v.setPadding(oq.dl(this.sy, 36.0f), oq.dl(this.sy, 7.0f), oq.dl(this.sy, 36.0f), oq.dl(this.sy, 8.0f));
            this.v.setLayoutParams(layoutParams3);
            this.v.setEllipsize(TextUtils.TruncateAt.END);
            this.v.setSingleLine(true);
            this.v.setTextSize(14.0f);
            return;
        }
        if (i == 2) {
            int iDl2 = oq.dl(this.sy, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iDl2, iDl2);
            layoutParams4.addRule(14);
            this.kb.setLayoutParams(layoutParams4);
            this.wp.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = oq.dl(this.sy, 8.0f);
            layoutParams5.topMargin = oq.dl(this.sy, 8.0f);
            layoutParams5.addRule(3, this.kb.getId());
            layoutParams5.addRule(14);
            this.i.setLayoutParams(layoutParams5);
            this.i.setTextSize(10.0f);
            oq.z((View) this.v, 8);
            return;
        }
        int iDl3 = oq.dl(this.sy, 49.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iDl3, iDl3);
        layoutParams6.addRule(14);
        this.kb.setLayoutParams(layoutParams6);
        this.wp.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = oq.dl(this.sy, 8.0f);
        layoutParams7.topMargin = oq.dl(this.sy, 8.0f);
        layoutParams7.addRule(3, this.kb.getId());
        layoutParams7.addRule(14);
        this.i.setLayoutParams(layoutParams7);
        this.i.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, oq.dl(this.sy, 28.0f));
        layoutParams8.addRule(13);
        layoutParams8.addRule(3, this.i.getId());
        int iDl4 = oq.dl(this.sy, 20.0f);
        int iDl5 = oq.dl(this.sy, 25.0f);
        int iDl6 = oq.dl(this.sy, 6.0f);
        TextPaint paint = this.v.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.v.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String string = text.toString();
        paint.getTextBounds(string, 0, string.length(), rect);
        this.v.setTextSize(13.0f);
        if (this.v.getWidth() > (iDl5 * 2) + rect.width() && this.v.getHeight() > (iDl6 * 2) + rect.height()) {
            layoutParams8.leftMargin = iDl4;
            layoutParams8.rightMargin = iDl4;
            this.v.setPadding(iDl5, oq.dl(this.sy, 5.0f), iDl5, iDl6);
        }
        this.v.setEllipsize(TextUtils.TruncateAt.END);
        this.v.setSingleLine(true);
        this.v.setLayoutParams(layoutParams8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.uy;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.z;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.z.getMeasuredHeight();
            int iDl = oq.dl(this.sy, 200.0f);
            int iDl2 = oq.dl(this.sy, 331.0f);
            int iDl3 = oq.dl(this.sy, 110.0f);
            int iDl4 = oq.dl(this.sy, 100.0f);
            if (measuredWidth >= iDl && measuredHeight >= iDl2) {
                m(1);
                return;
            }
            if (measuredWidth > iDl3 && measuredHeight > iDl4) {
                m(3);
                return;
            }
            m(2);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    protected void z(final ImageView imageView, String str) {
        if (imageView == null || !com.bytedance.sdk.openadsdk.gc.z.z(this.uf) || com.bytedance.sdk.openadsdk.gc.z.e(this.uf)) {
            return;
        }
        com.bytedance.sdk.openadsdk.gz.g.z(str).config(Bitmap.Config.ARGB_4444).type(2).to(new com.bytedance.sdk.component.m.io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.12
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls<Bitmap> lsVar) {
                Bitmap result;
                if (lsVar == null || (result = lsVar.getResult()) == null) {
                    return;
                }
                final Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(m.this.sy, result, 25);
                com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.12.1
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

    /* JADX WARN: Can't rename method to resolve collision */
    public void z(na naVar, WeakReference<Context> weakReference, boolean z) {
        String strHe;
        na naVar2;
        if (naVar == null || ti()) {
            return;
        }
        z(false, this.q);
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
            z(zw.getContext(), this.z);
            fv();
            return;
        }
        z(this.z, zw.getContext());
        View view = this.gz;
        if (view != null) {
            oq.z(view, 0);
        }
        ImageView imageView = this.fo;
        if (imageView != null) {
            oq.z((View) imageView, 0);
        }
        if (eo.dl(this.uf)) {
            g(this.z, zw.getContext());
            oq.z(this.uy, 8);
            oq.z((View) this.fo, 0);
            oq.z(this.eo, 0);
            oq.z((View) this.oq, 0);
            oq.z((View) this.wj, 0);
            if (this.wj != null && com.bytedance.sdk.component.utils.v.dl(zw.getContext()) == 0) {
                oq.z((View) this.wj, 8);
            }
            View view2 = this.gz;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (m.this.x != null) {
                            ((com.bykv.vk.openvk.component.video.api.a.z) m.this.x).z();
                            if (m.this.un != null) {
                                m.this.un.z();
                            }
                        }
                    }
                });
            }
            if (this.fo != null && !TextUtils.isEmpty(tf.g(this.uf))) {
                if (com.bytedance.sdk.openadsdk.gc.z.g(naVar)) {
                    com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.uf)).to(this.fo);
                    z(this.fo, tf.g(this.uf));
                } else {
                    com.bykv.vk.openvk.component.video.z.gc.g.z(2147483647L, tf.z(this.uf), new g.InterfaceC0035g() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.3
                        @Override // com.bykv.vk.openvk.component.video.z.gc.g.InterfaceC0035g
                        public void z(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) m.this.fo.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    float height = (bitmap.getHeight() * oq.a(zw.getContext())) / bitmap.getWidth();
                                    layoutParams.width = oq.a(zw.getContext());
                                    layoutParams.height = (int) height;
                                    layoutParams.addRule(13);
                                    m.this.fo.setLayoutParams(layoutParams);
                                }
                                m.this.fo.setImageBitmap(bitmap);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.gz.g.z(tf.g(m.this.uf)).to(m.this.fo);
                        }
                    });
                }
            }
        } else {
            oq.z(this.uy, 0);
            if (this.fo != null && !TextUtils.isEmpty(tf.g(this.uf))) {
                com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.uf)).to(this.fo);
                z(this.fo, tf.g(this.uf));
            }
            if (wj()) {
                this.uy.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.m.4
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.oq();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(naVar.hy())) {
            strHe = naVar.hy();
        } else if (!TextUtils.isEmpty(naVar.li())) {
            strHe = naVar.li();
        } else {
            strHe = !TextUtils.isEmpty(naVar.he()) ? naVar.he() : "";
        }
        if (this.kb != null && (naVar2 = this.uf) != null && naVar2.kp() != null && this.uf.kp().z() != null) {
            oq.z((View) this.kb, 0);
            oq.z((View) this.wp, 4);
            com.bytedance.sdk.openadsdk.gz.g.z(this.uf.kp()).to(this.kb);
            if (x()) {
                this.kb.setOnClickListener(this.mc);
                this.kb.setOnTouchListener(this.mc);
            } else {
                this.kb.setOnClickListener(this.lq);
                this.kb.setOnTouchListener(this.lq);
            }
        } else if (!TextUtils.isEmpty(strHe)) {
            oq.z((View) this.kb, 4);
            oq.z((View) this.wp, 0);
            TextView textView = this.wp;
            if (textView != null) {
                textView.setText(strHe.substring(0, 1));
                if (x()) {
                    this.wp.setOnClickListener(this.mc);
                    this.wp.setOnTouchListener(this.mc);
                } else {
                    this.wp.setOnClickListener(this.lq);
                    this.wp.setOnTouchListener(this.lq);
                }
            }
        }
        if (this.i != null && !TextUtils.isEmpty(strHe)) {
            this.i.setText(strHe);
        }
        oq.z((View) this.i, 0);
        oq.z((View) this.v, 0);
        String strNo = naVar.no();
        if (TextUtils.isEmpty(strNo)) {
            int iLt = naVar.lt();
            strNo = iLt != 4 ? iLt != 5 ? "查看详情" : "立即拨打" : "立即下载";
        }
        TextView textView2 = this.v;
        if (textView2 != null) {
            textView2.setText(strNo);
            this.v.setOnClickListener(this.lq);
            this.v.setOnTouchListener(this.lq);
        }
        TextView textView3 = this.oq;
        if (textView3 != null) {
            textView3.setText(strNo);
            this.oq.setOnClickListener(this.lq);
            this.oq.setOnTouchListener(this.lq);
        }
        if (this.ti) {
            return;
        }
        gz(4);
    }

    private boolean wj() {
        na naVar;
        return this.h && this.uy != null && (naVar = this.uf) != null && naVar.na() == 1;
    }

    public void sy() {
        na naVar = this.uf;
        if (naVar == null) {
            return;
        }
        if (this.uf.d() != 5 ? naVar.d() == 1 && gb.p(this.uf) : true) {
            z(false, this.q);
            z(this.z, zw.getContext());
            if (this.fo == null || TextUtils.isEmpty(tf.g(this.uf))) {
                return;
            }
            oq.z(this.gz, 0);
            oq.z((View) this.fo, 0);
            oq.z(this.uy, 8);
            com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.uf)).to(this.fo);
            z(this.fo, tf.g(this.uf));
        }
    }

    public void hh() {
        if (ti()) {
            oq.z((View) this.dl, 8);
            oq.gc(this.f1408a);
            oq.gc(this.gc);
            ImageView imageView = this.m;
            if (imageView != null) {
                oq.gc(imageView);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.g
    public void g() {
        if (ti()) {
            oq.z(this.f1408a, 8);
            oq.z(this.gc, 8);
            oq.z((View) this.m, 8);
            oq.z((View) this.dl, 8);
            return;
        }
        oq.z((View) this.xl, 8);
        oq.gc(this.f1408a);
        oq.gc(this.gc);
        ImageView imageView = this.m;
        if (imageView != null) {
            oq.gc(imageView);
        }
    }

    public void gz() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.uf)) {
            oq.z((View) this.xl, 8);
        } else {
            oq.gc(this.f1408a);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.z
    public void z(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.g.getHolder()) {
            return;
        }
        this.iq = true;
        if (q()) {
            this.l.z(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.z
    public void z(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder != this.g.getHolder()) {
            return;
        }
        q();
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.z
    public void g(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.g.getHolder()) {
            return;
        }
        this.iq = false;
        if (q()) {
            this.l.g(this, surfaceHolder);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.z
    public void z(SurfaceTexture surfaceTexture, int i, int i2) {
        this.iq = true;
        if (q()) {
            this.l.z(this, surfaceTexture);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.z
    public boolean z(SurfaceTexture surfaceTexture) {
        this.iq = false;
        if (!q()) {
            return true;
        }
        this.l.g(this, surfaceTexture);
        return true;
    }

    public void fo() {
        TTProgressBar tTProgressBar = this.pf;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.pf.setSecondaryProgress(0);
        }
        a(8);
        if (l()) {
            this.g.setVisibility(8);
        }
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.m.setBackground(null);
        }
        ImageView imageView2 = this.fo;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.fo.setBackground(null);
        }
        a(8);
        oq.z(this.gz, 8);
        oq.z((View) this.fo, 8);
        oq.z(this.uy, 8);
        oq.z((View) this.kb, 8);
        oq.z((View) this.wp, 8);
        oq.z((View) this.i, 8);
        oq.z(this.y, 8);
        oq.z((View) this.ec, 8);
        pf pfVar = this.hh;
        if (pfVar != null) {
            pfVar.z(true);
        }
    }

    public boolean kb() {
        return this.q;
    }

    public void z(boolean z, boolean z2, boolean z3) {
        oq.z((View) this.pf, 0);
        oq.z((View) this.dl, (z && (oq.a(this.f1408a) && oq.a(this.xl))) ? 0 : 8);
    }

    public void z(boolean z, boolean z2) {
        oq.z((View) this.pf, z ? 0 : 8);
        oq.z((View) this.dl, 8);
    }

    public void wp() {
        z(true, false);
    }

    public boolean i() {
        return this.iq;
    }

    public void a(int i) {
        this.zw = i;
        oq.z(this.z, i);
    }

    public boolean pf() {
        pf pfVar = this.hh;
        return pfVar != null && pfVar.z();
    }

    boolean l() {
        return !this.io.contains(g.z.alwayShowMediaView) || this.q;
    }

    public void z(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar) {
        this.un = zVar;
        com.bytedance.sdk.openadsdk.core.g.z zVar2 = this.lq;
        if (zVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(zVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.g
    public void z(Drawable drawable) {
        View view = this.z;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.g
    public void z(int i) {
        oq.z((View) this.t, i);
    }

    public void gc(boolean z) {
        this.yx = z;
    }

    public void z(z.InterfaceC0190z interfaceC0190z) {
        this.zx = interfaceC0190z;
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.gk;
        if (dlVar != null) {
            dlVar.z(interfaceC0190z);
        }
    }
}
