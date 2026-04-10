package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.adexpress.g.uy;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.kb.z.g;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.iq.f;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.ti;
import com.bytedance.sdk.openadsdk.core.ugeno.express.g;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.umeng.analytics.pro.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.a, com.bytedance.sdk.component.adexpress.g.gz, com.bytedance.sdk.component.adexpress.g.pf, com.bytedance.sdk.component.adexpress.theme.z, uy {
    public static int js = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dialog f1275a;
    private boolean b;
    private volatile com.bytedance.sdk.component.adexpress.g.v bv;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.z dl;
    protected String e;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.gc ec;
    private final Runnable eo;
    private pf f;
    protected na fo;
    protected boolean fv;
    private int g;
    private com.bytedance.sdk.component.adexpress.g.fo gb;
    private z gc;
    private f gk;
    private List<com.bytedance.sdk.component.adexpress.g.uy> gp;
    protected com.bytedance.sdk.openadsdk.ls.dl.dl.g gz;
    private boolean h;
    private float hh;
    protected dl.InterfaceC0027dl i;
    private final AtomicBoolean io;
    private com.bytedance.sdk.openadsdk.core.g.z iq;
    private uy.z j;
    private com.bytedance.sdk.component.adexpress.g.a<? extends View> jq;
    protected ExpressVideoView kb;
    private com.bytedance.sdk.openadsdk.m.z l;
    private FrameLayout lq;
    protected boolean ls;
    private SparseArray<a.z> lw;
    protected final Context m;
    private FrameLayout mc;
    private float me;
    private io na;
    private float nh;
    private final Runnable oq;
    protected com.bytedance.sdk.component.adexpress.g.dl p;
    protected boolean pf;
    protected FrameLayout q;
    private tb qd;
    private long r;
    private float rv;
    private com.bytedance.sdk.component.adexpress.g.i sv;
    private float sy;
    private com.bytedance.sdk.component.adexpress.g.ls t;
    protected boolean tb;
    private float tc;
    private final Runnable ti;
    private String uf;
    private final ViewTreeObserver.OnScrollChangedListener un;
    protected String uy;
    protected FrameLayout v;
    private com.bytedance.sdk.component.adexpress.g.g vm;
    private ThemeStatusBroadcastReceiver wj;
    protected dl.a wp;
    private com.bytedance.sdk.openadsdk.core.ugeno.uy.z x;
    private com.bytedance.sdk.openadsdk.core.ugeno.express.m xl;
    private com.bytedance.sdk.component.adexpress.g.m y;
    private boolean yx;
    private View yz;
    private boolean z;
    private com.bytedance.sdk.openadsdk.core.g.g zw;
    private com.bytedance.sdk.openadsdk.core.component.splash.countdown.dl zx;

    public void a() {
    }

    public int dl() {
        return 0;
    }

    public void dl(int i) {
    }

    public void fo() {
    }

    public int g() {
        return 0;
    }

    public void g(int i) {
    }

    public void gc() {
    }

    public long getActualPlayDuration() {
        return 0L;
    }

    public com.bykv.vk.openvk.component.video.api.a.dl getVideoController() {
        return null;
    }

    public void kb() {
    }

    public void m() {
    }

    public void setPauseFromExpressView(boolean z) {
    }

    public void setTimeUpdate(int i) {
    }

    public void uy() {
    }

    public long z() {
        return 0L;
    }

    public void z(float f) {
    }

    public void z(float f, float f2, float f3, float f4, int i) {
    }

    public void z(int i) {
    }

    public void z(int i, String str) {
    }

    public NativeExpressView(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str) {
        super(context);
        this.z = true;
        this.g = 0;
        this.e = "embeded_ad";
        this.io = new AtomicBoolean(false);
        this.uf = null;
        this.ls = false;
        this.fv = false;
        this.tb = false;
        this.h = false;
        this.un = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ti);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ti, 500L);
            }
        };
        this.ti = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ti.g(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.gc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.gc(8);
                }
            }
        };
        this.eo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(0);
            }
        };
        this.oq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(8);
            }
        };
        this.lw = new SparseArray<>();
        this.rv = -1.0f;
        this.tc = -1.0f;
        this.me = -1.0f;
        this.nh = -1.0f;
        this.r = 0L;
        this.e = str;
        this.m = context;
        this.fo = naVar;
        this.gz = gVar;
        wp();
    }

    public NativeExpressView(boolean z, Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, boolean z2) {
        super(context);
        this.z = true;
        this.g = 0;
        this.e = "embeded_ad";
        this.io = new AtomicBoolean(false);
        this.uf = null;
        this.ls = false;
        this.fv = false;
        this.tb = false;
        this.h = false;
        this.un = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ti);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ti, 500L);
            }
        };
        this.ti = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ti.g(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.gc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.gc(8);
                }
            }
        };
        this.eo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(0);
            }
        };
        this.oq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(8);
            }
        };
        this.lw = new SparseArray<>();
        this.rv = -1.0f;
        this.tc = -1.0f;
        this.me = -1.0f;
        this.nh = -1.0f;
        this.r = 0L;
        this.e = str;
        this.m = context;
        this.fo = naVar;
        this.gz = gVar;
        this.ls = z;
        this.tb = z2;
        wp();
    }

    public NativeExpressView(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, boolean z) {
        super(context);
        this.z = true;
        this.g = 0;
        this.e = "embeded_ad";
        this.io = new AtomicBoolean(false);
        this.uf = null;
        this.ls = false;
        this.fv = false;
        this.tb = false;
        this.h = false;
        this.un = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ti);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ti, 500L);
            }
        };
        this.ti = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ti.g(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.gc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.gc(8);
                }
            }
        };
        this.eo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(0);
            }
        };
        this.oq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(8);
            }
        };
        this.lw = new SparseArray<>();
        this.rv = -1.0f;
        this.tc = -1.0f;
        this.me = -1.0f;
        this.nh = -1.0f;
        this.r = 0L;
        this.e = str;
        this.m = context;
        this.fo = naVar;
        this.gz = gVar;
        this.tb = z;
        if (gVar.tb() == 9) {
            this.ls = gVar.pf() == 2;
        }
        wp();
    }

    public NativeExpressView(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, boolean z, String str2) {
        super(context);
        this.z = true;
        this.g = 0;
        this.e = "embeded_ad";
        this.io = new AtomicBoolean(false);
        this.uf = null;
        this.ls = false;
        this.fv = false;
        this.tb = false;
        this.h = false;
        this.un = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                nativeExpressView.removeCallbacks(nativeExpressView.ti);
                NativeExpressView nativeExpressView2 = NativeExpressView.this;
                nativeExpressView2.postDelayed(nativeExpressView2.ti, 500L);
            }
        };
        this.ti = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ti.g(NativeExpressView.this, 0, 5)) {
                    NativeExpressView nativeExpressView = NativeExpressView.this;
                    nativeExpressView.gc(nativeExpressView.getVisibility());
                } else {
                    NativeExpressView.this.gc(8);
                }
            }
        };
        this.eo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.3
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(0);
            }
        };
        this.oq = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.4
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.gc(8);
            }
        };
        this.lw = new SparseArray<>();
        this.rv = -1.0f;
        this.tc = -1.0f;
        this.me = -1.0f;
        this.nh = -1.0f;
        this.r = 0L;
        this.e = str;
        this.m = context;
        this.fo = naVar;
        this.uy = str2;
        this.gz = gVar;
        this.tb = z;
        if (gVar.tb() == 9) {
            this.ls = gVar.pf() == 2;
        }
        wp();
    }

    protected void wp() {
        this.q = new FrameLayout(this.m);
        this.lq = new FrameLayout(this.m);
        this.mc = new FrameLayout(this.m);
        addView(this.q);
        addView(this.lq);
        addView(this.mc);
        this.gp = new ArrayList();
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar = this.gz;
        if (gVar != null) {
            this.sy = gVar.gz();
            this.hh = this.gz.fo();
            zw();
            this.uf = this.gz.a();
        }
        if (!pf()) {
            setBackgroundColor(0);
            setBackgroundResource(R.color.transparent);
            v();
        }
        uf();
        x();
        com.bytedance.sdk.component.adexpress.g.ls lsVar = this.t;
        if (lsVar != null) {
            this.na = (io) lsVar.g();
        }
        if (sy()) {
            this.f = new pf(this);
        }
    }

    private void v() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = new ThemeStatusBroadcastReceiver();
        this.wj = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.z(this);
    }

    private boolean pf() {
        return gk() && vm.z(this.fo) == 1;
    }

    private void zw() {
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar;
        if (TextUtils.equals(this.e, "splash_ad") && (gVar = this.gz) != null && this.hh == gVar.e() && this.sy == this.gz.m()) {
            this.hh = oq.a(this.m, this.hh);
            int iA = oq.a(this.m);
            if (this.sy < iA) {
                this.sy = oq.a(this.m, r0);
            } else {
                this.sy = oq.a(this.m, r1);
            }
        }
    }

    public SSWebView getWebView() {
        io ioVar = this.na;
        if (ioVar == null) {
            return null;
        }
        return ioVar.z();
    }

    private void io() {
        try {
            if (this.wj == null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            this.m.registerReceiver(this.wj, intentFilter, eo.sy(), null);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    private void uf() {
        i.z zVar;
        List<gk> listJz;
        gk gkVar;
        boolean zGz = vm.gz(this.fo);
        JSONObject jSONObjectZ = null;
        if (!pf()) {
            if (zGz) {
                jSONObjectZ = com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.fo, com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.sy, this.hh, this.ls), com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.fo), false, this.uy);
            } else if (vm.uy(this.fo)) {
                if (vm.m(this.fo) != null && !TextUtils.isEmpty(vm.m(this.fo).fo())) {
                    jSONObjectZ = com.bytedance.sdk.openadsdk.core.ugeno.uy.z(vm.m(this.fo).fo(), vm.m(this.fo).uy(), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
                }
            } else {
                jSONObjectZ = com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.z(this.sy, this.hh, this.ls, this.fo);
            }
            if (vm.m(this.fo) != null) {
                com.bytedance.sdk.openadsdk.core.a.z().z(vm.m(this.fo).g());
            }
            if (vm.e(this.fo) != null) {
                com.bytedance.sdk.openadsdk.core.a.z().z(vm.e(this.fo).z());
            }
        }
        this.l = h();
        if (pf()) {
            this.gb = new fv();
        } else {
            this.gb = new fo(this.l, this.e, this.fo, this.uf);
        }
        boolean zL = l();
        if (vm.uy(this.fo) || vm.wp(this.fo) || com.bytedance.sdk.openadsdk.core.ugeno.z.z.g(this.fo) || sy()) {
            g.z zVar2 = new g.z();
            zVar2.gc(com.bytedance.sdk.openadsdk.core.ugeno.uy.z(this.fo, (View) this, false));
            zVar2.z((com.bytedance.adsdk.ugeno.dl.iq) this.gb);
            zVar2.z(this.sy);
            zVar2.g(this.hh);
            zVar2.a(sy());
            zVar = zVar2;
        } else {
            zVar = new i.z();
        }
        zVar.dl(zGz);
        if (TextUtils.equals(this.e, "splash_ad")) {
            zVar.m(com.bytedance.sdk.openadsdk.hh.fo.gc());
        }
        if (vm.g(this.fo) == 3 && com.bytedance.sdk.openadsdk.gc.z.a(this.fo) && (listJz = this.fo.jz()) != null && !listJz.isEmpty() && (gkVar = listJz.get(0)) != null) {
            zVar.fo(gkVar.z());
            zVar.z(new UpieImageView(this.m, com.bytedance.sdk.openadsdk.gc.z.fo(this.fo), com.bytedance.sdk.openadsdk.gc.z.uy(this.fo)));
        }
        this.sv = zVar.z(this.e).g(this.fo.mj()).dl(eo.ls(this.fo)).a(this.fo.vk()).z(jSONObjectZ).z(this.gb).z(com.bytedance.sdk.openadsdk.core.zw.g().z(this.e, vm.g(this.fo))).g(zL).g(this.fo.qd()).dl(this.fo.lt()).gc(com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.a(this.fo)).z(com.bytedance.sdk.openadsdk.core.nativeexpress.g.g.gc(this.fo)).a(getRenderThread()).gc(this.fo.fn()).m(this.fo.vl()).e(this.fo.hs()).g(this.fo.kk()).dl(this.fo.eb()).a(this.fo.jb()).fo(this.fo.s()).gz(this.fo.yw()).e(this.fo.sa()).gz("https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/").z(com.bytedance.sdk.openadsdk.core.uy.ls().gc()).uy(this.fo.gc()).z();
    }

    private int getRenderThread() {
        if (hh()) {
            return 1;
        }
        if ((com.bytedance.sdk.openadsdk.core.dl.gc.z().wp() & 2) == 2) {
            return 1;
        }
        return vm.a(this.fo);
    }

    private boolean sy() {
        return this.gz != null && com.bytedance.sdk.openadsdk.core.gk.dl >= 5900 && this.gz.sy();
    }

    private boolean hh() {
        return com.bytedance.sdk.openadsdk.core.zw.g().fo(eo.fo(this.fo)) == 4 && gk();
    }

    private boolean l() {
        if (TextUtils.equals(this.e, "rewarded_video") || TextUtils.equals(this.e, "fullscreen_interstitial_ad")) {
            return this.fo.sz();
        }
        return true;
    }

    private com.bytedance.sdk.openadsdk.m.z h() {
        JSONObject jSONObject = new JSONObject();
        com.bytedance.sdk.openadsdk.core.i.fo foVar = new com.bytedance.sdk.openadsdk.core.i.fo(this.e, this.fo, jSONObject);
        foVar.z(jSONObject, "webview_source", (Object) 1);
        return foVar;
    }

    private boolean gk() {
        return TextUtils.equals(this.e, "splash_ad") || TextUtils.equals(this.e, "cache_splash_ad");
    }

    private void x() {
        this.g = vm.g(this.fo);
        if (gk() && vm.z(this.fo) == 1) {
            this.g = 1000;
        }
        com.bytedance.sdk.openadsdk.core.wp.z.z zVar = new com.bytedance.sdk.openadsdk.core.wp.z.z(this.fo, new WeakReference(this));
        int i = this.g;
        if (i == 3) {
            com.bytedance.sdk.component.adexpress.g.g gVar = new com.bytedance.sdk.component.adexpress.g.g(this.m, this.sv, this.wj, this.tb, new com.bytedance.sdk.component.adexpress.dynamic.a.e(), this, zVar);
            this.vm = gVar;
            this.gp.add(gVar);
            this.vm.z(com.bytedance.sdk.openadsdk.core.zw.g().jt());
        } else if (i == 7) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.a aVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.a(this.m, this.fo, (com.bytedance.sdk.openadsdk.core.ugeno.express.g) this.sv, this);
            this.h = aVar.fo();
            com.bytedance.sdk.openadsdk.core.ugeno.express.gc gcVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.gc(this.m, aVar, this, this.sv);
            this.ec = gcVar;
            this.gp.add(gcVar);
        } else if (i == 10) {
            com.bytedance.sdk.openadsdk.core.ugeno.express.m mVar = new com.bytedance.sdk.openadsdk.core.ugeno.express.m(this.m, this.fo, (com.bytedance.sdk.openadsdk.core.ugeno.express.g) this.sv, this);
            this.xl = mVar;
            this.h = mVar.fo();
            com.bytedance.sdk.openadsdk.core.ugeno.express.gc gcVar2 = new com.bytedance.sdk.openadsdk.core.ugeno.express.gc(this.m, this.xl, this, this.sv);
            this.ec = gcVar2;
            this.gp.add(gcVar2);
        } else if (i != 1000) {
            this.na = new io(this.m, this.sv, this.wj, this.l, this.fo, this.gb);
            com.bytedance.sdk.component.adexpress.g.ls lsVar = new com.bytedance.sdk.component.adexpress.g.ls(this.m, this.sv, this.na, this);
            this.t = lsVar;
            this.gp.add(lsVar);
        }
        int iDl = vm.dl(this.fo);
        if (iDl > 0 && sy() && TextUtils.equals(this.e, "embeded_ad")) {
            this.gp.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.gc(this.m, new com.bytedance.sdk.openadsdk.core.ugeno.z.dl(this.m, this.fo, (com.bytedance.sdk.openadsdk.core.ugeno.express.g) this.sv, this), this, this.sv));
        } else {
            boolean z = iDl == 1;
            this.z = z;
            if (z || this.g == 1000) {
                com.bytedance.sdk.component.adexpress.g.m mVar2 = new com.bytedance.sdk.component.adexpress.g.m(this.m, this.sv, new p(this, this.wj, this.sv));
                this.y = mVar2;
                this.gp.add(mVar2);
            } else if (com.bytedance.sdk.openadsdk.core.ugeno.z.z.g(this.fo)) {
                this.gp.add(new com.bytedance.sdk.openadsdk.core.ugeno.express.gc(this.m, new com.bytedance.sdk.openadsdk.core.ugeno.z.dl(this.m, this.fo, (com.bytedance.sdk.openadsdk.core.ugeno.express.g) this.sv, this), this, this.sv));
            }
        }
        this.j = new com.bytedance.sdk.component.adexpress.g.wp(this.gp, this.gb);
    }

    public void setVideoAdListener(dl.a aVar) {
        this.wp = aVar;
    }

    public void setVideoAdInteractionListener(dl.InterfaceC0027dl interfaceC0027dl) {
        this.i = interfaceC0027dl;
    }

    public void setOuterDislike(Dialog dialog) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (aVar != null && (aVar instanceof p) && (backupView = (BackupView) aVar.e()) != null) {
            backupView.setDislikeOuter(dialog);
        }
        this.f1275a = dialog;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar) {
        BackupView backupView;
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (aVar != null && (aVar instanceof p) && (backupView = (BackupView) aVar.e()) != null) {
            backupView.setDislikeInner(zVar);
        }
        this.dl = zVar;
    }

    public void setExpressInteractionListener(z zVar) {
        this.gc = zVar;
    }

    public void setClickCreativeListener(com.bytedance.sdk.openadsdk.core.g.z zVar) {
        this.iq = zVar;
    }

    public com.bytedance.sdk.openadsdk.core.g.z getClickCreativeListener() {
        return this.iq;
    }

    public com.bytedance.sdk.openadsdk.core.g.g getClickListener() {
        return this.zw;
    }

    public void setClickListener(com.bytedance.sdk.openadsdk.core.g.g gVar) {
        this.zw = gVar;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.g.dl dlVar) {
        this.p = dlVar;
        com.bytedance.sdk.component.adexpress.g.m mVar = this.y;
        if (mVar != null) {
            mVar.z(dlVar);
        }
    }

    public void ls() {
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (aVar instanceof i) {
            ((i) aVar).gz();
        }
        lq();
    }

    private void lq() {
        if (pf()) {
            return;
        }
        io();
    }

    public void gc(int i) {
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (aVar == null || !(aVar instanceof i)) {
            return;
        }
        ((i) aVar).g(i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.oq);
        removeCallbacks(this.eo);
        if (i == 0) {
            postDelayed(this.eo, 50L);
        } else {
            postDelayed(this.oq, 50L);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
    }

    public void m(int i) {
        this.sv.z(i);
    }

    public void p() {
        if (com.bytedance.sdk.openadsdk.core.zw.g().mk() && this.b) {
            if (this.gc != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.gc.z(this, com.bytedance.sdk.openadsdk.core.fo.z(-16), -16);
                    return;
                } else {
                    com.bytedance.sdk.openadsdk.core.q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NativeExpressView.this.gc != null) {
                                NativeExpressView.this.gc.z(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.fo.z(-16), -16);
                            }
                        }
                    });
                    return;
                }
            }
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.zw.g().jt() && com.bytedance.sdk.openadsdk.hh.e.z()) {
            com.bytedance.sdk.component.utils.gz.dl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.6
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.mc();
                }
            });
        } else {
            mc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc() {
        com.bytedance.sdk.openadsdk.m.z zVar = this.l;
        if (zVar instanceof com.bytedance.sdk.openadsdk.core.i.fo) {
            ((com.bytedance.sdk.openadsdk.core.i.fo) zVar).g(this.sv.gz());
        }
        this.l.z();
        this.j.z(this);
        this.j.z();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        pf pfVar;
        if (sy() && (pfVar = this.f) != null) {
            return pfVar.z(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        pf pfVar;
        if (sy() && (pfVar = this.f) != null) {
            return pfVar.g(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, f fVar) {
        this.gk = fVar;
        z(view, i, dlVar);
        this.gk = null;
    }

    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
        com.bytedance.sdk.openadsdk.core.iq.uy uyVar;
        com.bytedance.sdk.openadsdk.core.g.z.dl.z zVar;
        com.bytedance.sdk.openadsdk.core.g.z zVar2;
        com.bytedance.sdk.openadsdk.core.g.g gVar;
        if (i == -1 || dlVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.iq.zw zwVar = (com.bytedance.sdk.openadsdk.core.iq.zw) dlVar;
        com.bytedance.sdk.openadsdk.core.g.z zVar3 = this.iq;
        if (zVar3 != null) {
            zVar3.gc(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.g.g gVar2 = this.zw;
        if (gVar2 != null) {
            gVar2.gc(getDynamicShowType());
        }
        if (i != 1 || (gVar = this.zw) == null) {
            uyVar = null;
            zVar = null;
        } else {
            uyVar = gVar.g();
            zVar = (com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class);
            zVar.z(zVar.gc());
        }
        if (i == 2 && (zVar2 = this.iq) != null) {
            uyVar = zVar2.g();
            zVar = (com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.iq.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class);
            zVar.z(zVar.gc());
        }
        try {
            Object obj = zwVar.z().get("click_extra_map");
            if (zVar != null && (obj instanceof Map)) {
                zVar.z((Map<String, Object>) obj);
            }
        } catch (JSONException unused) {
        }
        if (uyVar == null) {
            uyVar = new com.bytedance.sdk.openadsdk.core.iq.uy();
        }
        if (this.gk != null) {
            uyVar.g(this);
        }
        uyVar.z(zwVar.z);
        uyVar.g(zwVar.g);
        uyVar.dl(zwVar.dl);
        uyVar.a(zwVar.f1208a);
        uyVar.z(zwVar.pf);
        uyVar.e(zwVar.fv);
        uyVar.z(com.bytedance.sdk.openadsdk.core.iq.iq.a(this.fo, zwVar.p));
        uyVar.g(zwVar.p);
        SparseArray<a.z> sparseArray = zwVar.ls;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.lw;
        }
        uyVar.z(sparseArray);
        JSONObject jSONObjectZ = zwVar.z();
        uyVar.dl(jSONObjectZ.optBoolean("is_compliant_download"));
        String strOptString = jSONObjectZ.optString("uchain_event_name");
        uyVar.dl(strOptString);
        int iOptInt = jSONObjectZ.optInt("convertActionType", Integer.MIN_VALUE);
        if (iOptInt == 1) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.g.z zVar4 = this.iq;
                if (zVar4 != null) {
                    zVar4.dl();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.g.g gVar3 = this.zw;
                if (gVar3 != null) {
                    gVar3.dl();
                }
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                com.bytedance.sdk.openadsdk.core.g.z zVar5 = this.iq;
                if (zVar5 != null) {
                    zVar5.a();
                }
            } else {
                com.bytedance.sdk.openadsdk.core.g.g gVar4 = this.zw;
                if (gVar4 != null) {
                    gVar4.a();
                }
            }
        }
        View view2 = view == null ? this : view;
        String str = zwVar.kb;
        na naVar = this.fo;
        int iLt = naVar != null ? naVar.lt() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.v;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                g(view2, zwVar, uyVar, 0, str, iLt);
                break;
            case 2:
                z(view2, zwVar, uyVar, 0, str, iLt);
                break;
            case 3:
                un();
                break;
            case 4:
                FrameLayout frameLayout2 = this.v;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                eo.q(this.fo);
                if ("embeded_ad".equals(this.e) && ti() && !this.pf && eo.q(this.fo)) {
                    z(view2, zwVar, uyVar, 0, str, iLt);
                } else {
                    g(view2, zwVar, uyVar, 0, str, iLt);
                }
                break;
            case 5:
                z(!this.tb);
                break;
            case 6:
                e();
                break;
            case 7:
                if (!z(strOptString)) {
                    com.bytedance.sdk.openadsdk.core.un.m.z(this.m, this.fo);
                }
                break;
            case 8:
                gz();
                break;
            case 9:
                g(this.fo, this.m, this.e);
                break;
            case 10:
                z(this.fo, this.m, this.e);
                break;
            case 12:
                dl(this.fo, this.m, this.e);
                break;
            case 13:
                String strOptString2 = jSONObjectZ.optString("openCommonWebUrl", "");
                String strOptString3 = jSONObjectZ.optString("openCommonWebTitle", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    TTDelegateActivity.a(this.m, strOptString2, strOptString3);
                }
                break;
        }
    }

    private void z(View view, com.bytedance.sdk.openadsdk.core.iq.zw zwVar, com.bytedance.sdk.openadsdk.core.iq.uy uyVar, int i, String str, int i2) {
        if (na.gc(this.fo)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.g.z zVar = this.iq;
        if (zVar != null) {
            zVar.z(zwVar);
            com.bytedance.sdk.openadsdk.core.g.z.dl.z zVar2 = (com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.iq.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class);
            z(zVar2);
            zVar2.g(str);
            this.iq.z(uyVar);
            Map<String, Object> mapZ = com.bytedance.sdk.component.kb.gc.z.z().z(this.fo.hashCode() + this.fo.aq());
            mapZ.put("convert_tag", zwVar.p);
            z(zwVar, mapZ);
            this.iq.z(view, uyVar);
        }
        z zVar3 = this.gc;
        if (zVar3 != null) {
            zVar3.z(this, i2);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.iq.zw zwVar, Map<String, Object> map) {
        try {
            map.put("live_saas_interaction_type", Integer.valueOf(zwVar.z().optInt("live_saas_param_interaction_type", -1)));
        } catch (Exception unused) {
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.g.z.dl.z zVar) {
        f fVar = this.gk;
        if (fVar != null) {
            HashMap map = new HashMap();
            map.put("custom_express_gesture", 1);
            map.put("express_gesture_type", Integer.valueOf(fVar.g()));
            map.put("express_slide_direction", Integer.valueOf(fVar.a()));
            map.put("express_slide_threshold", Double.valueOf(fVar.dl()));
            zVar.z(map);
        }
    }

    private void g(View view, com.bytedance.sdk.openadsdk.core.iq.zw zwVar, com.bytedance.sdk.openadsdk.core.iq.uy uyVar, int i, String str, int i2) {
        if (na.gc(this.fo)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.g.g gVar = this.zw;
        if (gVar != null) {
            gVar.z(zwVar);
            com.bytedance.sdk.openadsdk.core.g.z.dl.z zVar = (com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class);
            z(zVar);
            zVar.g(str);
            this.zw.z(uyVar);
            Map<String, Object> mapZ = com.bytedance.sdk.component.kb.gc.z.z().z(this.fo.hashCode() + this.fo.aq());
            mapZ.put("convert_tag", zwVar.p);
            z(zwVar, mapZ);
            this.zw.z(view, uyVar);
        }
        z zVar2 = this.gc;
        if (zVar2 != null) {
            zVar2.z(this, i2);
        }
    }

    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
        if (i == -1 || dlVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.iq.zw zwVar = (com.bytedance.sdk.openadsdk.core.iq.zw) dlVar;
        com.bytedance.sdk.openadsdk.core.iq.uy uyVar = new com.bytedance.sdk.openadsdk.core.iq.uy();
        uyVar.z(zwVar.ls);
        uyVar.z(zwVar.z);
        uyVar.g(zwVar.g);
        uyVar.dl(zwVar.dl);
        uyVar.a(zwVar.f1208a);
        uyVar.z(zwVar.pf);
        JSONObject jSONObjectZ = zwVar.z();
        int iOptInt = jSONObjectZ.optInt("convertActionType", Integer.MIN_VALUE);
        uyVar.dl(jSONObjectZ.optBoolean("is_compliant_download"));
        if (iOptInt == 1) {
            if (i == 2) {
                this.iq.dl();
            } else {
                this.zw.dl();
            }
        } else if (iOptInt == 2) {
            if (i == 2) {
                this.iq.a();
            } else {
                this.zw.a();
            }
        }
        View view2 = view == null ? this : view;
        com.bytedance.sdk.openadsdk.core.g.z zVar = this.iq;
        if (zVar != null) {
            zVar.gc(getDynamicShowType());
        }
        com.bytedance.sdk.openadsdk.core.g.g gVar = this.zw;
        if (gVar != null) {
            gVar.gc(getDynamicShowType());
        }
        na naVar = this.fo;
        int iLt = naVar != null ? naVar.lt() : 0;
        switch (i) {
            case 1:
                FrameLayout frameLayout = this.v;
                if (frameLayout != null) {
                    frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                z(view2, i2, zwVar, uyVar, iLt);
                break;
            case 2:
                g(view2, i2, zwVar, uyVar, iLt);
                break;
            case 3:
                un();
                break;
            case 4:
                FrameLayout frameLayout2 = this.v;
                if (frameLayout2 != null) {
                    frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                }
                eo.q(this.fo);
                if ("embeded_ad".equals(this.e) && ti() && !this.pf && eo.q(this.fo)) {
                    g(view2, i2, zwVar, uyVar, iLt);
                } else {
                    z(view2, i2, zwVar, uyVar, iLt);
                }
                break;
            case 5:
                z(!this.tb);
                break;
            case 6:
                e();
                break;
            case 8:
                gz();
                break;
        }
    }

    private boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        eo.hh();
        HashMap map = new HashMap();
        map.put("material_meta", this.fo);
        map.put(d.R, this.m);
        new g.z(str).z(this.fo.kv()).z(map).z().z();
        return true;
    }

    private void z(View view, int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar, com.bytedance.sdk.openadsdk.core.iq.uy uyVar, int i2) {
        if (na.gc(this.fo)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.g.g gVar = this.zw;
        if (gVar != null) {
            z(((com.bytedance.sdk.openadsdk.core.g.z.z.z) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(), i);
            this.zw.z(zwVar);
            this.zw.z(uyVar);
            this.zw.z(view, uyVar);
        }
        z zVar = this.gc;
        if (zVar != null) {
            zVar.z(this, i2);
        }
    }

    private void g(View view, int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar, com.bytedance.sdk.openadsdk.core.iq.uy uyVar, int i2) {
        if (na.gc(this.fo)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.g.z zVar = this.iq;
        if (zVar != null) {
            z(((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(), i);
            this.iq.z(zwVar);
            this.iq.z(uyVar);
            this.iq.z(view, uyVar);
        }
        z zVar2 = this.gc;
        if (zVar2 != null) {
            zVar2.z(this, i2);
        }
    }

    private void un() {
        Dialog dialog = this.f1275a;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.dl;
        if (zVar != null) {
            zVar.z();
        } else {
            TTDelegateActivity.z(getContext(), this.fo);
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar, int i) {
        if (dlVar != null && (dlVar instanceof com.bytedance.sdk.openadsdk.core.kb.dl.gc)) {
            com.bytedance.sdk.openadsdk.core.kb.dl.dl.dl dlVarGz = ((com.bytedance.sdk.openadsdk.core.kb.dl.gc) dlVar).gz();
            dlVarGz.g(true);
            dlVarGz.z(i);
        }
    }

    private boolean ti() {
        na naVar = this.fo;
        return naVar != null && naVar.f() == 1 && na.g(this.fo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.sdk.component.utils.wp.a("webviewpool", "onAttachedToWindow+++");
        getViewTreeObserver().addOnScrollChangedListener(this.un);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.bytedance.sdk.component.utils.wp.a("webviewpool", "onFinishTemporaryDetach+++");
    }

    public void fv() {
        io ioVar = this.na;
        if (ioVar == null || ioVar.e() == null) {
            return;
        }
        this.na.gc();
    }

    public void i() {
        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver;
        try {
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            Iterator<com.bytedance.sdk.component.adexpress.g.uy> it = this.gp.iterator();
            while (it.hasNext()) {
                it.next().z();
            }
            this.dl = null;
            this.f1275a = null;
            this.gz = null;
            this.fo = null;
            this.iq = null;
            this.p = null;
            this.zw = null;
            this.wp = null;
            this.i = null;
            this.gc = null;
            Context context = this.m;
            if (context != null && (themeStatusBroadcastReceiver = this.wj) != null) {
                context.unregisterReceiver(themeStatusBroadcastReceiver);
            }
            ExpressVideoView expressVideoView = this.kb;
            if (expressVideoView != null) {
                expressVideoView.js();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl("NativeExpressView", "detach error", th);
        }
    }

    public void js() {
        try {
            FrameLayout frameLayout = this.v;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.v);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.bytedance.sdk.openadsdk.m.z zVar = this.l;
            if (zVar != null) {
                zVar.g(true);
            }
            getViewTreeObserver().removeOnScrollChangedListener(this.un);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.wp.a("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.bytedance.sdk.component.utils.wp.a("webviewpool", "onStartTemporaryDetach===");
    }

    @Override // com.bytedance.sdk.component.adexpress.g.pf
    public void z(final com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar, final com.bytedance.sdk.component.adexpress.g.v vVar) {
        this.b = true;
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.7
            @Override // java.lang.Runnable
            public void run() {
                NativeExpressView.this.g(aVar, vVar);
            }
        });
    }

    public void g(com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar, com.bytedance.sdk.component.adexpress.g.v vVar) {
        try {
            this.jq = aVar;
            this.bv = vVar;
            if (aVar.dl() != 1) {
                View viewE = aVar.e();
                this.yz = viewE;
                if (viewE.getParent() != null) {
                    ((ViewGroup) this.yz.getParent()).removeView(this.yz);
                }
                this.lq.addView(this.yz);
                ViewGroup.LayoutParams layoutParams = this.yz.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
                }
                if (this.qd != null && (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) && !(aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.m)) {
                    this.qd.z(((com.bytedance.sdk.openadsdk.core.ugeno.express.a) aVar).gz());
                    this.qd.z(this);
                }
            }
            com.bytedance.sdk.component.adexpress.g.fo foVar = this.gb;
            if (foVar instanceof fo) {
                ((fo) foVar).v();
            }
            if (this.l != null && aVar.dl() != 0) {
                this.l.z(aVar.dl(), vVar.kb(), vVar.uy());
            }
            com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar2 = this.jq;
            if ((aVar2 instanceof v) && ((v) aVar2).D_() != null) {
                ((v) this.jq).D_().z((uy) this);
            }
            if (vVar.g() == 10 && (vVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.dl)) {
                this.x = ((com.bytedance.sdk.openadsdk.core.ugeno.express.dl) vVar).fv();
            }
            z zVar = this.gc;
            if (zVar != null) {
                zVar.z(this, (float) vVar.a(), (float) vVar.gc());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void z(MotionEvent motionEvent) {
        View view = this.yz;
        if (view != null) {
            view.dispatchTouchEvent(motionEvent);
        }
    }

    public void tb() {
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (!(aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) || (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.m)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.ugeno.express.a) aVar).g();
    }

    @Override // com.bytedance.sdk.component.adexpress.g.pf
    public void a_(final int i) {
        this.b = true;
        if (!this.z) {
            this.gb.kb();
        }
        this.gb.wp();
        com.bytedance.sdk.component.adexpress.g.fo foVar = this.gb;
        if (foVar instanceof fo) {
            ((fo) foVar).v();
        }
        if (this.gc != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.gc.z(this, com.bytedance.sdk.openadsdk.core.fo.z(i), i);
            } else {
                com.bytedance.sdk.openadsdk.core.q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NativeExpressView.this.gc != null) {
                            NativeExpressView.this.gc.z(NativeExpressView.this, com.bytedance.sdk.openadsdk.core.fo.z(i), i);
                        }
                    }
                });
            }
        }
    }

    public boolean q() {
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        return aVar != null && aVar.dl() == 1;
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (aVar != null) {
            return aVar.dl();
        }
        return 0;
    }

    public int getRenderEngineCacheType() {
        m mVarPf;
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (!(aVar instanceof io) || (mVarPf = ((io) aVar).pf()) == null) {
            return 0;
        }
        return mVarPf.z();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.sy).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.hh).intValue();
    }

    public mc getJsObject() {
        io ioVar = this.na;
        if (ioVar != null) {
            return ioVar.D_();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.express.m getUGenV3Render() {
        return this.xl;
    }

    public z getExpressInteractionListener() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a
    public void z(CharSequence charSequence, int i, int i2, boolean z) {
        z(Integer.parseInt(String.valueOf(charSequence)), i, z);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a
    public void setSoundMute(boolean z) {
        this.tb = z;
        com.bytedance.sdk.component.adexpress.g.g gVar = this.vm;
        if (gVar != null && gVar.g() != null) {
            this.vm.g().setSoundMute(z);
        }
        if (this.jq.dl() == 7) {
            com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
            if (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) {
                ((com.bytedance.sdk.component.adexpress.dynamic.a) aVar).setSoundMute(z);
            }
        }
    }

    protected void z(int i, int i2, boolean z) {
        int iGc;
        if (TextUtils.equals(this.e, "fullscreen_interstitial_ad")) {
            iGc = (!hh.z(this.fo) || hh.g(this.fo) <= 0) ? com.bytedance.sdk.openadsdk.core.zw.g().m(Integer.parseInt(this.uf)) : 0;
        } else if (!TextUtils.equals(this.e, "rewarded_video")) {
            return;
        } else {
            iGc = com.bytedance.sdk.openadsdk.core.zw.g().gc(Integer.parseInt(this.uf));
        }
        int i3 = (i2 >= iGc || z) ? 1 : 0;
        int i4 = i2 <= iGc ? iGc - i2 : 0;
        com.bytedance.sdk.component.adexpress.g.g gVar = this.vm;
        if (gVar != null && gVar.g() != null) {
            this.vm.g().z(String.valueOf(i), i3, i4, z);
        }
        if (this.jq.dl() == 7 || this.jq.dl() == 10) {
            com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
            if (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) {
                ((com.bytedance.sdk.component.adexpress.dynamic.a) aVar).z(String.valueOf(i), i3, i4, z);
            }
        }
    }

    private void z(na naVar, Context context, String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.dl(naVar, context, str);
    }

    private void g(na naVar, Context context, String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.g(naVar, context, str);
    }

    private void dl(na naVar, Context context, String str) {
        if (naVar == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.un.m.z(context, naVar, str);
    }

    public void z(boolean z) {
        if (this.jq.dl() == 7) {
            com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
            if (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) {
                ((com.bytedance.sdk.component.adexpress.dynamic.a) aVar).setSoundMute(z);
            }
        }
    }

    public void e() {
        com.bytedance.sdk.openadsdk.core.component.splash.countdown.dl dlVar = this.zx;
        if (dlVar != null) {
            dlVar.z();
        }
    }

    public void gz() {
        if (sy() && TextUtils.equals(this.e, "embeded_ad")) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar = new com.bytedance.sdk.openadsdk.core.dislike.dl.g(this.fo.kv(), com.bytedance.sdk.openadsdk.core.dislike.a.z());
            gVar.g("dislike");
            com.bytedance.sdk.openadsdk.core.dislike.z.z.z().z(this.m, gVar, "close_success");
        }
    }

    public ViewGroup getVideoContainer() {
        return this.v;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.z
    public void b_(int i) {
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (aVar == null || !(aVar instanceof i)) {
            return;
        }
        ((i) aVar).b_(i);
    }

    public void g(int i, String str) {
        mc mcVarD_;
        com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar = this.jq;
        if (aVar == null || !(aVar instanceof io) || (mcVarD_ = ((io) aVar).D_()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            mcVarD_.z("onVideoPaused", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public void z(JSONObject jSONObject) {
        boolean zI = com.bytedance.sdk.openadsdk.core.zw.g().i();
        this.yx = zI;
        if (zI && eo.a(this.fo)) {
            this.qd = new tb(this.fo, jSONObject, this);
        }
    }

    public void iq() {
        tb tbVar = this.qd;
        if (tbVar != null) {
            tbVar.a();
        }
    }

    public void setEasyPlayableSender(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e eVar) {
        ExpressVideoView expressVideoView = this.kb;
        if (expressVideoView == null) {
            return;
        }
        expressVideoView.setEasyPlayableEventSender(eVar);
    }

    public FrameLayout getEasyPlayableLayout() {
        return this.mc;
    }

    public void setDynamicSkipListener(com.bytedance.sdk.openadsdk.core.component.splash.countdown.dl dlVar) {
        this.zx = dlVar;
    }

    public void g(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar = this.x;
        if (zVar != null) {
            zVar.z(i, i2);
        }
    }
}
