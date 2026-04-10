package com.bytedance.sdk.openadsdk.core.component.splash.a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarBtn;
import com.bytedance.sdk.openadsdk.core.component.splash.TsView;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m;
import com.bytedance.sdk.openadsdk.core.component.splash.gz;
import com.bytedance.sdk.openadsdk.core.g.z.dl.dl;
import com.bytedance.sdk.openadsdk.core.g.z.z.z;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.io;
import com.bytedance.sdk.openadsdk.core.iq.b;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.qd;
import com.bytedance.sdk.openadsdk.core.iq.rv;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.kb.dl.gc;
import com.bytedance.sdk.openadsdk.core.p.z;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.h;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.dl.z.dl;
import com.bytedance.sdk.openadsdk.mediation.MediationSplashManagerDefault;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.sdk.openadsdk.ls.dl.g.g implements l.z, TsView.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SoftReference<dl> f994a;
    private gz b;
    private boolean bv;
    protected com.bytedance.sdk.openadsdk.core.kb.g.dl dl;
    protected g e;
    private com.bytedance.sdk.openadsdk.a.z.g.z.g f;
    protected com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz fv;
    protected na g;
    protected com.bytedance.sdk.openadsdk.core.g.z gc;
    protected com.bytedance.sdk.openadsdk.a.z.g.z.z gz;
    protected boolean h;
    protected boolean iq;
    private float j;
    protected com.bytedance.sdk.openadsdk.core.io.z.g l;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g lw;
    protected View.OnTouchListener m;
    private String na;
    protected m p;
    protected boolean q;
    private boolean qd;
    private a<fo, e> rv;
    private com.bytedance.sdk.openadsdk.core.component.splash.z.z tc;
    protected e uf;
    private Context wj;
    protected com.bytedance.sdk.openadsdk.core.video.nativevideo.a x;
    private float xl;
    private Activity yx;
    protected TsView z;
    protected AtomicBoolean fo = new AtomicBoolean(false);
    protected final Map<String, Object> uy = new HashMap();
    private Double gp = null;
    private boolean t = false;
    private boolean vm = false;
    protected boolean kb = false;
    protected int wp = 3;
    protected int i = -1;
    private final l y = new l(Looper.getMainLooper(), this);
    protected boolean v = false;
    protected boolean pf = false;
    protected long ls = 0;
    protected Map<String, Object> js = new HashMap();
    protected AtomicBoolean tb = new AtomicBoolean(false);
    protected boolean zw = true;
    protected boolean io = false;
    private com.bytedance.sdk.openadsdk.core.component.splash.z ec = new com.bytedance.sdk.openadsdk.core.component.splash.z();
    private boolean gb = false;
    private long jq = 0;
    private long sv = 5;
    protected AtomicBoolean sy = new AtomicBoolean(false);
    protected AtomicBoolean hh = new AtomicBoolean(false);
    protected AtomicBoolean gk = new AtomicBoolean(false);
    private boolean zx = true;
    protected AtomicBoolean lq = new AtomicBoolean(false);
    protected int mc = -1;
    protected int un = -1;
    protected final AtomicBoolean ti = new AtomicBoolean(false);
    private final AtomicBoolean me = new AtomicBoolean(false);
    protected final AtomicInteger eo = new AtomicInteger(0);
    protected com.bytedance.sdk.openadsdk.core.component.splash.countdown.g oq = null;
    private boolean nh = false;
    private int r = 0;

    public interface g {
        void w_();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public View g() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(ViewGroup viewGroup) {
    }

    protected void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl dlVar, a<fo, e> aVar, com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar) {
        if (dlVar == null || aVar == null) {
            return;
        }
        this.tc = zVar;
        this.lq.set(dlVar.fo());
        this.rv = aVar;
        e eVar = new e();
        this.uf = eVar;
        eVar.g(dlVar.fo());
        this.uf.z(dlVar.g());
        this.uf.z(this);
        this.wj = dlVar.getContext();
        this.na = dlVar.m();
        this.p = dlVar.a();
        boolean z = true;
        z(dlVar.gc(), true);
        this.lw = dlVar.e();
        m mVar = this.p;
        if (mVar == null) {
            this.uf.g(3);
            this.uf.z("render splash ad model is null");
            aVar.z(this.uf);
        } else {
            if (this.fv == null) {
                this.uf.g(3);
                this.uf.z("render splash material is null");
                aVar.z(this.uf);
                return;
            }
            this.g = mVar.g();
            boolean zTs = zw.g().ts();
            if (!zw.g().fn() && !zTs) {
                z = false;
            }
            this.nh = z;
            pf();
        }
    }

    public synchronized void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gz gzVar, boolean z) {
        if (this.fv == null || !z) {
            this.fv = gzVar;
            if (gzVar != null) {
                g(gzVar.gc());
                this.l = gzVar.a();
            }
        }
    }

    public void g(boolean z) {
        this.h = z;
        ls();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public PluginValueSet z() {
        return com.bykv.z.z.z.z.z.z(super.z()).z(1, gk.dl).g();
    }

    private void pf() {
        if (this.g == null) {
            return;
        }
        try {
            this.kb = false;
            TsView tsView = new TsView(this.wj, this.na, this.g);
            this.z = tsView;
            tsView.setAttachedToWindowListener(this);
            ls();
            this.z.setCountDownViewPosition(this.g);
            if (this.g.zx() == 0) {
                TsView tsView2 = this.z;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView3 = this.z;
                if (tsView3 != null) {
                    tsView3.setAdlogoViewVisibility(0);
                }
            }
            if (this.g.um() <= 0) {
                g(3);
            } else {
                int iUm = this.g.um();
                this.wp = iUm;
                g(iUm);
            }
            z(this.g);
            p();
        } catch (ArrayIndexOutOfBoundsException e) {
            wp.a("sbr", e.getMessage());
        }
    }

    private void ls() {
        if (!this.h || this.z == null) {
            return;
        }
        na naVar = this.g;
        if ((naVar == null || naVar.uv() == null || this.g.uv().g() != 0) ? false : true) {
            this.z.setVideoViewVisibility(8);
        } else {
            this.z.setVideoViewVisibility(0);
            this.z.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    z.this.z.setVoiceViewImageDrawable(z.this.zx ? tb.dl(z.this.wj, "tt_splash_unmute") : tb.dl(z.this.wj, "tt_splash_mute"));
                    z.this.zx = !r2.zx;
                    if (z.this.x != null) {
                        z.this.x.g(z.this.zx);
                    }
                }
            });
        }
    }

    private void g(int i) {
        TsView tsView = this.z;
        if (tsView != null) {
            tsView.setCountDownTime(i);
        }
    }

    protected void z(g gVar) {
        this.e = gVar;
    }

    private void z(na naVar) {
        TsView tsView;
        if (naVar == null || (tsView = this.z) == null) {
            return;
        }
        tsView.z(naVar);
    }

    protected void dl(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar = this.tc;
        if (zVar != null) {
            zVar.z(this.rv, this.g, this.lw, z);
        }
    }

    private void p() {
        EmptyView emptyView = new EmptyView(this.wj, this.z, this.g.wk());
        emptyView.z(this.g, this.na);
        emptyView.setAdType(3);
        this.z.addView(emptyView);
        emptyView.setCallback(new EmptyView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.4
            private volatile boolean g = false;

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void g() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(boolean z) {
                if (z.this.dl == null || !z) {
                    return;
                }
                z.this.dl.z();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z() {
                dl();
            }

            private void dl() {
                boolean z = true;
                if (this.g) {
                    if (z.this.dl != null) {
                        try {
                            z.this.dl.z(false);
                            z zVar = z.this;
                            if (vm.z(zVar.g) == 1) {
                                z = false;
                            }
                            zVar.m(z);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    return;
                }
                this.g = true;
                if (z.this.g.lt() == 4) {
                    com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("splash_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context context;
                            z.this.gc(vm.z(z.this.g) != 1);
                            if (z.this.dl != null) {
                                z.this.dl.z(false);
                            }
                            if (z.this.dl == null || z.this.z == null || z.this.z.getParent() == null) {
                                return;
                            }
                            try {
                                context = ((View) z.this.z.getParent()).getContext();
                            } catch (Exception unused2) {
                                context = null;
                            }
                            if (context instanceof Activity) {
                                z.this.dl.z((Activity) context);
                            }
                        }
                    });
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(View view, Map<String, Object> map) {
                dl();
                z.this.ls = System.currentTimeMillis();
                if (z.this.e != null) {
                    z.this.e.w_();
                }
                if (z.this.g != null && z.this.p != null) {
                    z.this.g.gz(z.this.p.gc());
                    z.this.js.put("cache_type", Integer.valueOf(zw.g().fo(eo.fo(z.this.g))));
                    z.this.js.put("splash_show_time_type", Integer.valueOf(z.this.un));
                }
                if (map != null && map.containsKey("show_send_type")) {
                    z.this.js.put("show_send_type", map.get("show_send_type"));
                }
                z.this.js.put("is_repeat", Boolean.valueOf(z.this.tb.get()));
                z.this.ti.set(true);
                if (!z.this.me.get()) {
                    z.this.me.set(true);
                    com.bytedance.sdk.openadsdk.core.i.a.z(z.this.g, z.this.na, z.this.js, z.this.gp);
                    com.bytedance.sdk.openadsdk.core.l.z.z().a();
                    un.z(z.this.g != null ? z.this.g.gc() : 0);
                    com.bytedance.sdk.openadsdk.core.component.splash.g.z(z.this.lw);
                }
                z.this.tb();
                if (!z.this.nh) {
                    z.this.js();
                }
                z zVar = z.this;
                zVar.a(zVar.fo.get());
                boolean zPd = zw.g().pd();
                if (z.this.gz != null && (!z.this.tb.getAndSet(true) || zPd)) {
                    z.this.gz.z(z.this);
                }
                z.this.fv();
                z.this.gk.set(true);
                if (z.this.z != null) {
                    z.this.z.setIsShowSuccess(true);
                }
                z.this.dl(true);
            }
        });
        if (!this.nh) {
            emptyView.setNeedCheckingShow(true);
        }
        this.uy.put("splash_show_type", Integer.valueOf(this.i));
        com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.wj, this.g, this.na, 4) { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.5
            @Override // com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
            public void z(View view, uy uyVar) {
                if ((view instanceof SplashClickBarBtn) && z.this.kb) {
                    return;
                }
                super.z(view, uyVar);
            }
        };
        this.gc = zVar;
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this);
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.gc.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.uy);
        z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) this.gc.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class), emptyView);
        this.gc.g(this.z.getDislikeView());
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.gc.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(new z.InterfaceC0171z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.6
            @Override // com.bytedance.sdk.openadsdk.core.g.z.z.z.InterfaceC0171z
            public void z(View view, int i) {
                com.bytedance.sdk.openadsdk.core.i.a.g(z.this.ls, z.this.g);
                if (z.this.gz != null) {
                    z.this.gz.g(z.this);
                }
                z.this.kb();
            }
        });
        this.z.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                z.this.uy();
            }
        });
    }

    protected void uy() {
        if (!this.pf) {
            this.pf = true;
            this.kb = true;
            if (!TextUtils.isEmpty(this.g.vk())) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.ls > 0 ? System.currentTimeMillis() - this.ls : 0L, this.g);
            }
            iq();
            com.bytedance.sdk.openadsdk.core.i.a.g(this.ls, this.g);
            dl(false);
            v();
        }
        com.bytedance.sdk.openadsdk.a.z.g.z.z zVar = this.gz;
        if (zVar != null) {
            zVar.z(this, 1);
        }
    }

    public void z(final com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar, final EmptyView emptyView) {
        dlVar.z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.8
            @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.dl.z
            public boolean z() {
                dlVar.z(emptyView);
                dlVar.z(z.this.js);
                dlVar.z(z.this.na);
                dlVar.z(z.this.gp);
                return z.this.ti.get();
            }
        });
    }

    protected void kb() {
        this.y.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.9
            @Override // java.lang.Runnable
            public void run() {
                z.this.v = true;
                if (!com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.z) {
                    if (z.this.b != null) {
                        z.this.b.g();
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.kb.dl.dl.m.z = false;
                    if (z.this.dl instanceof gc) {
                        ((gc) z.this.dl).gz().z(new com.bytedance.sdk.openadsdk.core.kb.dl.z.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.9.1
                            @Override // com.bytedance.sdk.openadsdk.core.kb.dl.z.z
                            public void z() {
                                if (z.this.b != null) {
                                    z.this.b.g();
                                }
                            }
                        });
                    }
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv() {
        com.bytedance.sdk.openadsdk.core.uy.ls().a().g(new C0164z(this.g));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js() {
        TsView tsView = this.z;
        if (tsView != null && tsView.getChildCount() > 0) {
            for (int i = 0; i < this.z.getChildCount(); i++) {
                View childAt = this.z.getChildAt(i);
                if (childAt != null && (childAt instanceof EmptyView)) {
                    this.z.removeView(childAt);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        TsView tsView = this.z;
        if (tsView != null) {
            tsView.z(this.g.bm(), this.gc);
            if (vm.z(this.g) == 1) {
                wp();
            }
        }
    }

    protected void wp() {
        b bVarXf;
        na naVar = this.g;
        if (naVar == null || (bVarXf = naVar.xf()) == null || bVarXf.fo() != 5) {
            return;
        }
        final int iPf = bVarXf.pf();
        final b.z zVarV = bVarXf.v();
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int iA = oq.a(z.this.wj, view.getWidth());
                int iA2 = oq.a(z.this.wj, view.getHeight());
                int iA3 = oq.a(z.this.wj, motionEvent.getX());
                int iA4 = oq.a(z.this.wj, motionEvent.getY());
                boolean z = iA3 >= zVarV.z() && iA4 >= zVarV.dl() && iA - iA3 >= zVarV.g() && iA2 - iA4 >= zVarV.a();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            z.this.j = motionEvent.getY();
                        }
                    } else {
                        if (!z) {
                            return false;
                        }
                        z.this.j = motionEvent.getY();
                        int iA5 = oq.a(z.this.wj, Math.abs(z.this.j - z.this.xl));
                        if (z.this.j - z.this.xl < 0.0f && iA5 > iPf && z.this.gc != null && z.this.z != null) {
                            z.this.gc.onClick(z.this.z);
                        }
                    }
                } else {
                    if (!z) {
                        return false;
                    }
                    z.this.xl = motionEvent.getY();
                }
                return true;
            }
        };
        this.m = onTouchListener;
        TsView tsView = this.z;
        if (tsView != null) {
            tsView.setSlideUpTouchListener(onTouchListener);
        }
    }

    protected void a(boolean z) {
        if (z || this.z == null) {
            return;
        }
        if (this.eo.get() == 2 && rv.z(this.g)) {
            com.bytedance.sdk.openadsdk.core.component.splash.countdown.g gVar = this.oq;
            if (gVar != null) {
                gVar.g();
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.a countDownView = this.z.getCountDownView();
        if (countDownView != null) {
            countDownView.setCountdownListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.11
                @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.z
                public void z() {
                    z.this.i();
                }
            });
            countDownView.z(false);
            countDownView.z();
        }
    }

    protected void i() {
        iq();
        com.bytedance.sdk.openadsdk.core.i.a.g(this.ls, this.g);
        com.bytedance.sdk.openadsdk.a.z.g.z.z zVar = this.gz;
        if (zVar != null && !this.kb) {
            this.kb = true;
            zVar.z(this, 2);
            dl(false);
        }
        v();
    }

    protected void v() {
        com.bytedance.sdk.openadsdk.core.uy.ls().gz(true);
        com.bytedance.sdk.openadsdk.core.un.z zVarA = com.bytedance.sdk.openadsdk.core.uy.ls().a();
        if (zVarA == null) {
            return;
        }
        zVarA.g((z.g) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc(boolean z) {
        this.dl = com.bytedance.sdk.openadsdk.core.kb.gz.z(this.wj, this.g, this.na, false);
        m(z);
        com.bytedance.sdk.openadsdk.core.g.z zVar = this.gc;
        if (zVar != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.dl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final boolean z) {
        final String strMj = this.g.mj();
        this.dl.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.2
            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z() {
                if (z.this.f994a != null && z.this.f994a.get() != null) {
                    z.this.f994a.get().z();
                }
                if (z) {
                    z.C0193z.z(strMj, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, long j2, String str, String str2) {
                if (z.this.f994a != null && z.this.f994a.get() != null) {
                    z.this.f994a.get().z(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                z.C0193z.z(strMj, 3, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void g(long j, long j2, String str, String str2) {
                if (z.this.f994a != null && z.this.f994a.get() != null) {
                    z.this.f994a.get().g(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                z.C0193z.z(strMj, 2, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void dl(long j, long j2, String str, String str2) {
                if (z.this.f994a != null && z.this.f994a.get() != null) {
                    z.this.f994a.get().dl(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                z.C0193z.z(strMj, 4, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(long j, String str, String str2) {
                if (z.this.f994a != null && z.this.f994a.get() != null) {
                    z.this.f994a.get().z(j, str, str2);
                }
                if (z) {
                    z.C0193z.z(strMj, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
            public void z(String str, String str2) {
                if (z.this.f994a != null && z.this.f994a.get() != null) {
                    z.this.f994a.get().z(str, str2);
                }
                if (z) {
                    z.C0193z.z(strMj, 6, 100);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int i = message.what;
        if (i == 1) {
            long j = this.jq + 1;
            this.jq = j;
            if (j >= this.sv) {
                this.y.sendEmptyMessage(2);
                return;
            } else {
                this.y.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (!this.qd && qd.z(this.g)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("splash_card_close_type", 0);
                com.bytedance.sdk.openadsdk.core.i.a.g(this.g, "splash_ad", "splash_card_close", jSONObject);
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        zw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.z
    public void gz() {
        AtomicBoolean atomicBoolean = this.gk;
        if (atomicBoolean != null && atomicBoolean.get()) {
            wp.dl("开屏view重复展示");
            TsView tsView = this.z;
            if (tsView != null && tsView.getCountDownView() != null && this.z.getCountDownView().getView() != null) {
                this.z.getCountDownView().getView().setVisibility(0);
            }
            a(this.fo.get());
        }
        this.r = 1;
    }

    public void fo() {
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.dl;
        if (dlVar != null) {
            dlVar.g();
        }
        na naVar = this.g;
        if (naVar != null) {
            io.z(naVar.dc());
        }
        na naVar2 = this.g;
        un.g(naVar2 != null ? naVar2.gc() : 0);
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.g gVar = this.oq;
        if (gVar != null) {
            gVar.z();
        }
        com.bytedance.sdk.openadsdk.core.component.splash.m.z(1, this.g, this.na, this.r);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.TsView.z
    public void z(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.g gVar = this.oq;
        if (gVar != null) {
            gVar.z(z);
        }
        this.r++;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.a.z$z, reason: collision with other inner class name */
    private static class C0164z implements z.g {
        na z;

        public C0164z(na naVar) {
            this.z = naVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.un.z.g
        public void g() {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.z, "splash_ad", "splash_enter_background", System.currentTimeMillis());
        }

        @Override // com.bytedance.sdk.openadsdk.core.un.z.g
        public void z() {
            com.bytedance.sdk.openadsdk.core.i.a.g(this.z, "splash_ad", "splash_enter_foreground", System.currentTimeMillis());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public View dl() {
        gz gzVar;
        if (this.iq && (gzVar = this.b) != null) {
            return gzVar.z();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public int a() {
        na naVar = this.g;
        if (naVar == null) {
            return -1;
        }
        return naVar.lt();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        this.f994a = new SoftReference<>(dlVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(com.bytedance.sdk.openadsdk.a.z.g.z.z zVar) {
        this.gz = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void m() {
        if (!this.fo.getAndSet(true)) {
            com.bytedance.sdk.openadsdk.core.component.splash.m.z(2, this.g, this.na, 0);
        }
        TsView tsView = this.z;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(com.bytedance.sdk.openadsdk.a.z.g.z.g gVar) {
        this.f = gVar;
        com.bytedance.sdk.openadsdk.core.component.splash.z zVar = this.ec;
        if (zVar != null) {
            zVar.z(gVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(ViewGroup viewGroup, Activity activity) {
        this.yx = activity;
        g(viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.e e() {
        return new MediationSplashManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.g
    public Map<String, Object> gc() {
        na naVar = this.g;
        if (naVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.iq.gk gkVar = naVar.jz().get(0);
        if (gkVar == null) {
            return this.g.fq();
        }
        if (!gkVar.m()) {
            return this.g.fq();
        }
        String strZ = gkVar.z();
        Map<String, Object> mapFq = this.g.fq();
        mapFq.put("image_url", strZ);
        return mapFq;
    }

    private void g(ViewGroup viewGroup) {
        TsView tsView;
        if (!this.iq || (tsView = this.z) == null || this.g == null || this.b == null || this.bv) {
            return;
        }
        ViewParent parent = tsView.getParent();
        this.bv = true;
        ViewGroup viewGroupZ = this.b.z();
        if (viewGroupZ == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar = this.x;
        if (aVar != null) {
            aVar.m();
        }
        if (viewGroupZ.getParent() != null) {
            ((ViewGroup) viewGroupZ.getParent()).removeView(viewGroupZ);
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).addView(viewGroupZ);
            oq.gz(this.z);
            this.z.removeAllViews();
            this.z = null;
        }
        viewGroupZ.setOnClickListener(null);
        viewGroupZ.setOnTouchListener(null);
        if (this.io) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar2 = this.x;
            if (aVar2 != null) {
                aVar2.uy();
            }
            this.x = null;
        }
        this.b.z(this.x, new gz.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.z.3
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.gz.z
            public void z(long j) {
                z.this.y.removeMessages(1);
                if (j < 0) {
                    z.this.y.sendEmptyMessageDelayed(1, 1000L);
                } else {
                    if (j == 0) {
                        z.this.y.sendEmptyMessage(2);
                        return;
                    }
                    z.this.sv = j;
                    z.this.jq = 0L;
                    z.this.y.sendEmptyMessageDelayed(1, 1000L);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.gz.z
            public void z() {
                z.this.y.removeMessages(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.gz.z
            public void g() {
                z.this.qd = true;
                z.this.zw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.gz.z
            public Context getActivity() {
                return z.this.yx;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
        if (this.t) {
            return;
        }
        h.z(this.g, d);
        this.t = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
        if (this.vm) {
            return;
        }
        h.z(this.g, d, str, str2);
        this.vm = true;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
        this.gp = d;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        na naVar = this.g;
        if (naVar != null) {
            io.z(naVar.dc(), gVar, com.bytedance.sdk.openadsdk.ls.dl.z.g.class);
        }
    }

    private boolean q() {
        return (!qd.z(this.g) || this.v || this.pf || this.q) ? false : true;
    }

    private void iq() {
        boolean z = false;
        this.qd = false;
        gz gzVar = new gz();
        this.b = gzVar;
        gzVar.z(this.wj, this.g);
        if (!this.ec.dl() && q()) {
            z = true;
        }
        if (z) {
            SoftReference<com.bytedance.sdk.openadsdk.ls.dl.z.dl> softReference = this.f994a;
            if (softReference == null) {
                this.b.z(this.na, this.i, this.ec, null);
            } else {
                this.b.z(this.na, this.i, this.ec, softReference.get());
            }
            this.iq = true;
            this.b.z(2);
            com.bytedance.sdk.openadsdk.core.component.splash.z zVar = this.ec;
            if (zVar != null) {
                zVar.z(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        if (!this.bv) {
            this.zw = false;
            return;
        }
        if (this.gb) {
            return;
        }
        this.gb = true;
        com.bytedance.sdk.openadsdk.core.component.splash.z zVar = this.ec;
        if (zVar != null) {
            zVar.z();
            this.ec = null;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar = this.x;
        if (aVar != null) {
            aVar.uy();
        }
        this.gz = null;
        this.dl = null;
        this.yx = null;
    }

    public void z(int i) {
        this.mc = i;
    }
}
