package com.bytedance.sdk.openadsdk.core.component.dl;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.media3.common.C;
import androidx.media3.session.MediaController;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.live.EcMallWebView;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.m.dl.p;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.uc.crashsdk.export.LogType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.bytedance.sdk.openadsdk.ls.dl.g implements dl.a, dl.InterfaceC0027dl, com.bykv.vk.openvk.component.video.api.g.z, z.InterfaceC0190z, LazeLayout.z<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.z<NativeVideoTsView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f927a;
    int dl;
    private int e;
    private boolean fo;
    com.bytedance.sdk.openadsdk.ls.dl.dl.g g;
    private com.bytedance.sdk.openadsdk.iq.z.g.z.z gc;
    private com.bytedance.sdk.openadsdk.iq.z.g.g.z gz;
    private com.bytedance.sdk.openadsdk.iq.z.g.z.g i;
    private volatile WeakReference<NativeVideoTsView> kb;
    private na ls;
    private com.bytedance.sdk.openadsdk.core.zw.a m;
    private com.bytedance.sdk.openadsdk.io.z.g.z.z p;
    private volatile boolean pf;
    private LazeLayout uy;
    private volatile int v;
    private WeakReference<View> wp;
    protected com.bytedance.sdk.openadsdk.core.multipro.g.z z;

    public a(Context context, na naVar, int i, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        super(new com.bytedance.sdk.openadsdk.core.zw.a(context, naVar, i, gVar, true));
        this.f927a = null;
        this.fo = false;
        this.uy = null;
        this.kb = null;
        this.wp = null;
        this.p = new com.bytedance.sdk.openadsdk.io.z.g.z.z(null) { // from class: com.bytedance.sdk.openadsdk.core.component.dl.a.4
            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(i iVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void z(View view, i iVar) {
                if (a.this.kb == null || a.this.kb.get() == null) {
                    return;
                }
                ((NativeVideoTsView) a.this.kb.get()).uy();
            }

            @Override // com.bytedance.sdk.openadsdk.io.z.g.z.z
            public void g(View view, i iVar) {
                if (a.this.kb == null || a.this.kb.get() == null) {
                    return;
                }
                ((NativeVideoTsView) a.this.kb.get()).uy();
            }
        };
        com.bytedance.sdk.openadsdk.core.zw.a aVar = (com.bytedance.sdk.openadsdk.core.zw.a) lq();
        this.m = aVar;
        aVar.a().z(this);
        this.dl = i;
        this.g = gVar;
        this.z = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
        this.ls = naVar;
        int iFo = eo.fo(naVar);
        this.e = iFo;
        z(iFo);
        this.m.z(this.p);
    }

    public NativeVideoTsView sy() {
        if (this.kb != null) {
            return this.kb.get();
        }
        return null;
    }

    public int hh() {
        return this.dl;
    }

    public int l() {
        return this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
    public boolean h() {
        return this.fo;
    }

    public NativeVideoTsView z(boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (z) {
            nativeVideoTsView = new NativeDrawVideoTsView(this.m.getContext(), this.m.sy());
        } else {
            nativeVideoTsView = new NativeVideoTsView(this.m.getContext(), this.m.sy(), false, false, eo.g(this.dl), false, false);
        }
        this.kb = new WeakReference<>(nativeVideoTsView);
        this.m.z(this.kb);
        this.m.g();
        return nativeVideoTsView;
    }

    private View mc() {
        View view;
        WeakReference<View> weakReference = this.wp;
        if (weakReference != null && (view = weakReference.get()) != null) {
            return view;
        }
        EcMallWebView ecMallWebView = new EcMallWebView(this.m.getContext(), this.m.sy(), this.dl == 9 ? 6 : 1);
        ecMallWebView.setMaterialMeta(un.z(this.ls));
        this.wp = new WeakReference<>(ecMallWebView);
        return ecMallWebView;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g, com.bytedance.sdk.openadsdk.ls.dl.g.i
    public View q() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsViewG = null;
        if (this.m.sy() == null || this.m.getContext() == null) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.live.gc.a.z(this.m.sy())) {
            return mc();
        }
        Context context = this.m.getContext();
        if (gk()) {
            if (e.z() && zw.g().ux().g) {
                if (this.kb != null && (nativeVideoTsView = this.kb.get()) != null) {
                    return nativeVideoTsView;
                }
                this.uy = new LazeLayout(context, this, this);
                wp.a("wzj", "4-验证子线程创建的效果-TTAdFeedAd:140016:lazeLayout=" + this.uy);
            } else {
                try {
                    nativeVideoTsViewG = g(context);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewG != null) {
                    z(nativeVideoTsViewG);
                }
                wp.a("wzj", "5-如果本身不在主线程，直接按原来的逻辑处理-TTAdFeedAd:140016:view=".concat(String.valueOf(nativeVideoTsViewG)));
                return nativeVideoTsViewG;
            }
        } else {
            na naVarSy = this.m.sy();
            if (context != null && naVarSy != null && com.bytedance.sdk.openadsdk.gc.z.gz(this.m.sy())) {
                return new UpieImageView(context, com.bytedance.sdk.openadsdk.gc.z.fo(naVarSy), null);
            }
        }
        com.bytedance.sdk.openadsdk.core.e.a.z().z(this.m.sy()).z(this.dl).g(this.e);
        wp.a("wzj", "6-TTAdFeedAd:140016:lazeLayout=" + this.uy);
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.z
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView g(Context context) {
        NativeVideoTsView nativeVideoTsViewZ = z(false);
        nativeVideoTsViewZ.setVideoAdClickListenerTTNativeAd(this);
        nativeVideoTsViewZ.setAdCreativeClickListener(new NativeVideoTsView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.dl.a.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.z
            public void z(View view, int i) {
                if (a.this.m.a() != null) {
                    a.this.m.a().z(view, i);
                }
            }
        });
        uy.ls().z(-1L);
        nativeVideoTsViewZ.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.component.dl.a.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
            public void z(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                if (a.this.z != null) {
                    a.this.z.z = z;
                    a.this.z.gc = j;
                    a.this.z.m = j2;
                    a.this.z.e = j3;
                    a.this.z.f1272a = z2;
                    a.this.z.gz = z3;
                }
            }
        });
        nativeVideoTsViewZ.setVideoAdLoadListener(this);
        nativeVideoTsViewZ.setVideoAdInteractionListener(this);
        if (5 == this.dl) {
            nativeVideoTsViewZ.setIsAutoPlay(this.m.l() ? this.g.gc() : this.m.hh());
        } else {
            nativeVideoTsViewZ.setIsAutoPlay(this.m.hh());
        }
        nativeVideoTsViewZ.setIsQuiet(zw.g().a(this.e));
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVarZ = this.m.a().z();
        if (dlVarZ != null) {
            dlVarZ.z(this);
        }
        return nativeVideoTsViewZ;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.z
    public void z(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.z(0L, true, false);
        }
    }

    boolean gk() {
        return na.g(this.m.sy());
    }

    private void z(int i) {
        int iE = zw.g().e(i);
        if (3 == iE) {
            this.m.g(false);
            this.m.z(false);
            return;
        }
        if (1 == iE && v.a(this.m.getContext())) {
            this.m.g(false);
        } else if (2 == iE) {
            if (!v.gc(this.m.getContext()) && !v.a(this.m.getContext()) && !v.m(this.m.getContext())) {
                return;
            } else {
                this.m.g(false);
            }
        } else if (4 == iE) {
            this.m.g(true);
            return;
        } else {
            if (5 != iE) {
                return;
            }
            if (!v.a(this.m.getContext()) && !v.m(this.m.getContext())) {
                return;
            }
        }
        this.m.z(true);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public void z(com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar) {
        this.gc = zVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public double z() {
        if (com.bytedance.sdk.openadsdk.hh.uy.z(this.m.sy())) {
            return 0.0d;
        }
        return tf.m(this.m.sy());
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public int dl() {
        com.bytedance.sdk.openadsdk.core.zw.a aVar = this.m;
        if (aVar != null) {
            na naVarSy = aVar.sy();
            int iP = this.m.p();
            if (com.bytedance.sdk.openadsdk.gc.z.gz(naVarSy) && (iP == 5 || iP == 15)) {
                return naVarSy.jz().get(0).g();
            }
        }
        try {
            if (this.f927a == null) {
                this.f927a = un();
            }
            int[] iArr = this.f927a;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return LogType.UNEXP_ANR;
        } catch (Throwable th) {
            wp.dl("TTFeedAdImpl", "getAdViewWidth error", th);
            return LogType.UNEXP_ANR;
        }
    }

    private int[] un() {
        if (this.m.sy() == null) {
            return null;
        }
        if (this.m.sy().ou() == 166 && com.bytedance.sdk.openadsdk.core.iq.eo.z(this.m.sy())) {
            return new int[]{com.bytedance.sdk.openadsdk.core.iq.eo.wp(this.m.sy()), com.bytedance.sdk.openadsdk.core.iq.eo.i(this.m.sy())};
        }
        if (this.m.sy().su() == 1 && this.m.sy().te() == 1 && tf.pf(this.m.sy()) != null) {
            return tf.pf(this.m.sy()).uy();
        }
        if (tf.v(this.m.sy()) != null) {
            return tf.v(this.m.sy()).uy();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public int a() {
        com.bytedance.sdk.openadsdk.core.zw.a aVar = this.m;
        if (aVar != null) {
            na naVarSy = aVar.sy();
            int iP = this.m.p();
            if (com.bytedance.sdk.openadsdk.gc.z.gz(naVarSy) && (iP == 5 || iP == 15)) {
                return naVarSy.jz().get(0).dl();
            }
        }
        try {
            if (this.f927a == null) {
                this.f927a = un();
            }
            int[] iArr = this.f927a;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            wp.dl("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public void z(com.bytedance.sdk.openadsdk.iq.z.g.z.g gVar) {
        this.i = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.uy
    public com.bytedance.sdk.openadsdk.iq.z.g.g.z g() {
        if (!na.z(this.m.sy())) {
            return null;
        }
        if (this.gz == null) {
            this.gz = new com.bytedance.sdk.openadsdk.iq.z.g.g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.dl.a.3
                private long g = 0;

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public String z() {
                    if (a.this.m.sy() == null || a.this.m.sy().xl() != 1 || tf.v(a.this.m.sy()) == null) {
                        return null;
                    }
                    if (!a.this.fo) {
                        a.this.fo = true;
                    }
                    return tf.z(a.this.m.sy());
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void g() {
                    this.g = SystemClock.elapsedRealtime();
                    p.z zVar = new p.z();
                    zVar.g(true);
                    zVar.z(true);
                    com.bytedance.sdk.openadsdk.m.g.a.z(a.this, zVar);
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void z(long j) {
                    if (this.g == 0) {
                        this.g = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.g) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    p.z zVar = new p.z();
                    zVar.z(j);
                    zVar.dl(((long) a.this.z()) * 1000);
                    zVar.g(j2);
                    zVar.z(true);
                    com.bytedance.sdk.openadsdk.m.g.a.z(a.this, zVar, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void g(long j) {
                    if (this.g == 0) {
                        this.g = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.g) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    p.z zVar = new p.z();
                    zVar.z(j);
                    zVar.dl(((long) a.this.z()) * 1000);
                    zVar.g(j2);
                    zVar.z(true);
                    com.bytedance.sdk.openadsdk.m.g.a.g(a.this, zVar);
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void dl() {
                    if (this.g == 0) {
                        this.g = SystemClock.elapsedRealtime();
                    }
                    long jZ = ((long) a.this.z()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.g) - jZ;
                    long j = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    p.z zVar = new p.z();
                    zVar.z(jZ);
                    zVar.dl(jZ);
                    zVar.g(j);
                    zVar.m(0);
                    zVar.z(true);
                    com.bytedance.sdk.openadsdk.m.g.a.a(a.this, zVar);
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void dl(long j) {
                    if (this.g == 0) {
                        this.g = SystemClock.elapsedRealtime();
                    }
                    long jZ = ((long) a.this.z()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.g) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    p.z zVar = new p.z();
                    zVar.z(j);
                    zVar.dl(jZ);
                    zVar.g(j2);
                    zVar.gc(0);
                    zVar.m(0);
                    zVar.z(true);
                    com.bytedance.sdk.openadsdk.m.g.a.z(a.this, zVar, (Map<String, Object>) null, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void a() {
                    com.bytedance.sdk.openadsdk.core.i.a.z(a.this.m.sy(), eo.g(a.this.m.sy()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (tf.v(a.this.m.sy()) != null) {
                        com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, a.this.m.sy());
                        aVarZ.z("material_meta", a.this.m.sy());
                        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = a.this.m.sy().lw();
                        aVarZ.z("ad_slot", Integer.valueOf(gVarLw != null ? gVarLw.tb() : 0));
                        aVarZ.gc(-1);
                        com.bytedance.sdk.openadsdk.m.g.a.z(a.this.m.sy(), (com.bykv.vk.openvk.component.video.api.g.z) a.this, aVarZ, true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void z(int i, int i2) {
                    HashMap map = new HashMap();
                    map.put("creative_id", a.this.m.sy().mj());
                    map.put("error_code", Integer.valueOf(i));
                    map.put("extra_error_code", Integer.valueOf(i2));
                    map.put("is_customer", 1);
                    com.bykv.vk.openvk.component.video.api.dl.dl dlVarV = tf.v(a.this.m.sy());
                    if (dlVarV != null) {
                        map.put("video_size", Long.valueOf(dlVarV.gc()));
                        map.put("video_resolution", dlVarV.fo());
                    }
                    com.bytedance.sdk.openadsdk.core.i.a.dl(a.this.m.sy(), eo.g(a.this.m.sy()), "play_start_error", map);
                }

                @Override // com.bytedance.sdk.openadsdk.iq.z.g.g.z
                public void z(long j, int i, int i2) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.g == 0) {
                        this.g = jElapsedRealtime;
                    }
                    long j2 = jElapsedRealtime - this.g;
                    long jZ = ((long) a.this.z()) * 1000;
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int i3 = j2 == 0 ? 1 : 0;
                    p.z zVar = new p.z();
                    zVar.g(j3);
                    zVar.dl(jZ);
                    zVar.z(j);
                    zVar.z(i);
                    zVar.g(i2);
                    zVar.z(true);
                    com.bytedance.sdk.openadsdk.m.g.a.z(a.this, zVar, "customer error", i3, false);
                }
            };
        }
        return this.gz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
    public void p_() {
        com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar = this.gc;
        if (zVar != null) {
            zVar.z(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
    public void z(int i, int i2) {
        com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar = this.gc;
        if (zVar != null) {
            zVar.z(i, i2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void q_() {
        com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar = this.gc;
        if (zVar != null) {
            zVar.g(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void r_() {
        com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar = this.gc;
        if (zVar != null) {
            zVar.dl(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void s_() {
        com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar = this.gc;
        if (zVar != null) {
            zVar.a(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void z(long j, long j2) {
        com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar = this.gc;
        if (zVar != null) {
            zVar.z(j, j2);
        }
        g(j, j2);
    }

    private boolean ti() {
        if (this.m.sy() == null || this.i == null) {
            return false;
        }
        int iYx = this.m.sy().yx();
        return iYx == 1 || iYx == 2;
    }

    private void g(long j, long j2) {
        int i;
        if (ti() && !this.pf) {
            int iYx = this.m.sy().yx();
            long j3 = iYx == 1 ? C.DEFAULT_SEEK_FORWARD_INCREMENT_MS : iYx == 2 ? MediaController.RELEASE_UNBIND_TIMEOUT_MS : 0L;
            if (j2 <= j3) {
                i = (int) ((j2 - j) / 1000);
            } else {
                i = (int) ((j3 - j) / 1000);
            }
            if (i < 0) {
                i = 0;
            }
            if (i == this.v) {
                return;
            }
            this.v = i;
            if (this.v == 0) {
                this.pf = true;
            }
            this.i.z(this.v);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g, com.bytedance.sdk.openadsdk.ls.dl.g.i
    public Map<String, Object> iq() {
        Map<String, Object> mapIq = this.m.iq();
        if (this.m.sy() == null || this.m.sy().ou() != 166) {
            return mapIq;
        }
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m.sy())) {
            int iA = com.bytedance.sdk.openadsdk.core.iq.eo.a(this.m.sy());
            int iGc = com.bytedance.sdk.openadsdk.core.iq.eo.gc(this.m.sy());
            if (mapIq == null) {
                mapIq = new HashMap<>();
            }
            mapIq.put("live_author_follower_count", Integer.valueOf(iA));
            mapIq.put("live_watch_count", Integer.valueOf(iGc));
        }
        return mapIq;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar, com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar) {
        View viewQ;
        try {
            z(viewGroup, (List<View>) null, list, list2, list3, (View) null, zVar);
            if (aVar != null) {
                View viewFindViewById = viewGroup.findViewById(aVar.wp());
                if (viewFindViewById != null && m() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(m());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = oq.dl(viewGroup.getContext(), 38.0f);
                        layoutParams.height = oq.dl(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(m());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(aVar.e());
                if (frameLayout == null || (viewQ = q()) == null) {
                    return;
                }
                oq.gz(viewQ);
                frameLayout.removeAllViews();
                frameLayout.addView(viewQ, -1, -1);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar) {
        com.bytedance.sdk.openadsdk.core.zw.a aVar = this.m;
        if (aVar != null) {
            aVar.z(gVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void t_() {
        com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar = this.gc;
        if (zVar != null) {
            zVar.gc(this);
        }
        if (!ti() || this.pf) {
            return;
        }
        this.i.z(0);
        this.pf = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
    public com.bytedance.sdk.openadsdk.core.multipro.g.z x() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g, com.bytedance.sdk.openadsdk.ls.dl.g.i
    public void io() {
        NativeVideoTsView nativeVideoTsView;
        if (this.kb != null && (nativeVideoTsView = this.kb.get()) != null) {
            nativeVideoTsView.js();
        }
        LazeLayout lazeLayout = this.uy;
        if (lazeLayout != null) {
            lazeLayout.z();
        }
        super.io();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public gc uf() {
        return new MediationNativeManagerDefault();
    }
}
