package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.z.z;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressVideoView extends NativeExpressView implements dl.a, dl.InterfaceC0027dl, uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1274a;
    boolean dl;
    boolean g;
    boolean gc;
    private long io;
    private com.bytedance.sdk.openadsdk.core.multipro.g.z iq;
    private HashSet<String> sy;
    private com.bytedance.sdk.component.adexpress.g.a uf;
    int z;
    private long zw;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void dl(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void fo() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void kb() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void uy() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f, float f2, float f3, float f4, int i) {
    }

    public NativeExpressVideoView(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str) {
        super(context, naVar, gVar, str, true);
        this.z = 1;
        this.g = false;
        this.dl = true;
        this.gc = true;
        this.tb = com.bytedance.sdk.openadsdk.core.zw.g().a(eo.fo(this.fo));
        v();
    }

    public NativeExpressVideoView(boolean z, Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str) {
        super(z, context, naVar, gVar, str, true);
        this.z = 1;
        this.g = false;
        this.dl = true;
        this.gc = true;
        this.tb = com.bytedance.sdk.openadsdk.core.zw.g().a(eo.fo(this.fo));
        v();
    }

    protected void v() {
        this.v = new FrameLayout(this.m);
        this.f1274a = eo.fo(this.fo);
        this.sy = new HashSet<>();
        a(this.f1274a);
        zw();
    }

    protected ExpressVideoView z(Context context, na naVar, String str) {
        return new ExpressVideoView(context, naVar, str, false);
    }

    private void zw() {
        try {
            this.iq = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
            this.kb = z(this.m, this.fo, this.e);
            this.kb.setNativeExpressVideoView(this);
            this.kb.setAdCreativeClickListener(new NativeVideoTsView.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.z
                public void z(View view, int i) {
                    z expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.z(view, i);
                }
            });
            this.kb.setShouldCheckNetChange(false);
            this.kb.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                public void z(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                    NativeExpressVideoView.this.iq.z = z;
                    NativeExpressVideoView.this.iq.gc = j;
                    NativeExpressVideoView.this.iq.m = j2;
                    NativeExpressVideoView.this.iq.e = j3;
                    NativeExpressVideoView.this.iq.f1272a = z2;
                    NativeExpressVideoView.this.iq.gz = z3;
                }
            });
            this.kb.setVideoAdLoadListener(this);
            this.kb.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.e)) {
                this.kb.setIsAutoPlay(this.g ? this.gz.gc() : this.dl);
            } else if ("splash_ad".equals(this.e)) {
                this.kb.setIsAutoPlay(true);
            } else {
                this.kb.setIsAutoPlay(this.dl);
            }
            if ("splash_ad".equals(this.e)) {
                this.kb.setIsQuiet(true);
            } else {
                this.kb.setIsQuiet(com.bytedance.sdk.openadsdk.core.zw.g().a(this.f1274a));
            }
            this.kb.dl();
        } catch (Exception e) {
            this.kb = null;
            com.bytedance.sdk.component.utils.wp.a("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    void a(int i) {
        int iE = com.bytedance.sdk.openadsdk.core.zw.g().e(i);
        if (3 == iE) {
            this.g = false;
            this.dl = false;
        } else if (1 == iE) {
            this.g = false;
            this.dl = com.bytedance.sdk.component.utils.v.a(this.m);
        } else if (2 == iE) {
            if (com.bytedance.sdk.component.utils.v.gc(this.m) || com.bytedance.sdk.component.utils.v.a(this.m) || com.bytedance.sdk.component.utils.v.m(this.m)) {
                this.g = false;
                this.dl = true;
            }
        } else if (5 == iE) {
            if (com.bytedance.sdk.component.utils.v.a(this.m) || com.bytedance.sdk.component.utils.v.m(this.m)) {
                this.g = false;
                this.dl = true;
            }
        } else if (4 == iE) {
            this.g = true;
        }
        if (!this.dl) {
            this.z = 3;
        }
        com.bytedance.sdk.component.utils.wp.z("NativeVideoAdView", "mIsAutoPlay=" + this.dl + ",status=" + iE);
    }

    public com.bytedance.sdk.openadsdk.core.multipro.g.z getVideoModel() {
        return this.iq;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.kb != null) {
            this.kb.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        if (this.kb != null) {
            this.kb.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void g(com.bytedance.sdk.component.adexpress.g.a<? extends View> aVar, com.bytedance.sdk.component.adexpress.g.v vVar) {
        this.uf = aVar;
        if ((aVar instanceof v) && ((v) aVar).D_() != null) {
            ((v) this.uf).D_().z((uy) this);
        }
        if (vVar != null && vVar.dl()) {
            if ((vVar.g() == 2 || vVar.g() == 7) && this.kb != null) {
                this.kb.z(this.m, 25, tf.g(this.fo));
            }
            z(vVar);
        }
        com.bytedance.sdk.component.adexpress.g.a aVar2 = this.uf;
        if (aVar2 != null && (aVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z)) {
            ((com.bytedance.sdk.component.adexpress.dynamic.z.z) aVar2).z(com.bytedance.sdk.openadsdk.core.zw.g().a(this.f1274a));
        }
        super.g(aVar, vVar);
    }

    private void z(final com.bytedance.sdk.component.adexpress.g.v vVar) {
        if (vVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g(vVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.g(vVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.bytedance.sdk.component.adexpress.g.v vVar) {
        if (vVar == null) {
            return;
        }
        double dM = vVar.m();
        double dE = vVar.e();
        double dGz = vVar.gz();
        double dFo = vVar.fo();
        int iDl = oq.dl(this.m, (float) dM);
        int iDl2 = oq.dl(this.m, (float) dE);
        int iDl3 = oq.dl(this.m, (float) dGz);
        int iDl4 = oq.dl(this.m, (float) dFo);
        float fDl = vVar.wp() > 0.0f ? oq.dl(this.m, vVar.wp()) : 0.0f;
        float fDl2 = vVar.i() > 0.0f ? oq.dl(this.m, vVar.i()) : 0.0f;
        float fDl3 = vVar.v() > 0.0f ? oq.dl(this.m, vVar.v()) : 0.0f;
        float fDl4 = vVar.pf() > 0.0f ? oq.dl(this.m, vVar.pf()) : 0.0f;
        if (fDl2 < fDl) {
            fDl = fDl2;
        }
        if (fDl3 >= fDl) {
            fDl3 = fDl;
        }
        if (fDl4 >= fDl3) {
            fDl4 = fDl3;
        }
        if (vVar.g() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.v.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(iDl3, iDl4);
            }
            layoutParams.width = iDl3;
            layoutParams.height = iDl4;
            layoutParams.topMargin = iDl2;
            layoutParams.leftMargin = iDl;
            this.v.setLayoutParams(layoutParams);
        }
        oq.g(this.v, fDl4);
        this.v.removeAllViews();
        if (this.kb != null) {
            this.v.addView(this.kb);
            this.kb.z(0L, true, false);
            a(this.f1274a);
            if (!com.bytedance.sdk.component.utils.v.a(this.m) && !this.dl && this.gc) {
                this.kb.z_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.v.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.v);
        }
        if (vVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.dl) {
            FrameLayout frameLayoutLs = ((com.bytedance.sdk.openadsdk.core.ugeno.express.dl) vVar).ls();
            if (frameLayoutLs != null) {
                if (this.kb != null) {
                    this.kb.setClickable(false);
                }
                frameLayoutLs.addView(this.v, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        if (vVar.g() == 2) {
            View viewZ = vVar.z();
            if (viewZ instanceof ViewGroup) {
                if (this.kb != null) {
                    this.kb.setClickable(false);
                }
                ((ViewGroup) viewZ).addView(this.v);
                return;
            }
            return;
        }
        this.q.addView(this.v);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(boolean z) {
        super.z(z);
        this.tb = z;
        this.kb.g(z, true);
        if (this.kb != null && this.kb.getNativeVideoController() != null) {
            this.kb.getNativeVideoController().g(z);
        }
        com.bytedance.sdk.component.adexpress.g.a aVar = this.uf;
        if (aVar == null || !(aVar instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.z.z) aVar).z(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void e() {
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gz() {
        super.gz();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i) {
        if (this.kb == null) {
            com.bytedance.sdk.component.utils.wp.a("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        if (i == 1) {
            this.kb.z(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            this.kb.setVideoPlayStatus(i);
            this.kb.setCanInterruptVideoPlay(true);
            this.kb.performClick();
        } else if (i == 4) {
            this.kb.getNativeVideoController().uy();
        } else {
            if (i != 5) {
                return;
            }
            this.kb.z(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.g.gz
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
        if (i == -1 || dlVar == null) {
            return;
        }
        if (i == 4) {
            io();
        } else if (i == 5) {
            z(!this.tb);
        } else {
            super.z(view, i, dlVar);
        }
    }

    private void io() {
        com.bytedance.sdk.component.adexpress.g.a aVar = this.uf;
        if (((aVar instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z) || (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a)) && this.kb != null) {
            this.kb.g(true);
            if (this.kb.A_()) {
                this.kb.setPauseIcon(true);
                this.kb.setVideoPlayStatus(2);
            } else {
                this.kb.setVideoPlayStatus(3);
                this.kb.setPauseIcon(false);
            }
            this.kb.performClick();
            this.kb.m();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        com.bytedance.sdk.component.adexpress.g.a aVar = this.uf;
        if ((!(aVar instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z) && !(aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a)) || this.kb == null || (i = this.z) == 2 || i == 5) {
            return;
        }
        this.kb.setNeedNativeVideoPlayBtnVisible(true);
        this.kb.z_();
        this.kb.y_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.sdk.component.adexpress.g.a aVar = this.uf;
        if (((aVar instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z) || (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a)) && this.kb != null && z && this.kb.g != null && this.kb.g.getVisibility() == 0) {
            this.kb.g.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.g.gz
    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
        if (i == -1 || dlVar == null) {
            return;
        }
        if (i != 4) {
            if (i != 5) {
                super.z(view, i, dlVar, i2);
                return;
            }
        } else if (this.e == "draw_ad") {
            if (this.kb != null) {
                this.kb.performClick();
                return;
            }
            return;
        }
        z(!this.tb);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long z() {
        return this.zw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int g() {
        if (this.z == 3 && this.kb != null) {
            this.kb.dl();
        }
        if (this.kb == null || !this.kb.getNativeVideoController().iq()) {
            return this.z;
        }
        return 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void q_() {
        this.gc = false;
        if (this.i != null) {
            this.i.q_();
        }
        this.z = 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void r_() {
        this.gc = false;
        if (this.i != null) {
            this.i.r_();
        }
        this.pf = true;
        this.z = 3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void s_() {
        this.gc = false;
        if (this.i != null) {
            this.i.s_();
        }
        this.pf = false;
        this.z = 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void z(long j, long j2) {
        this.gc = false;
        if (this.i != null) {
            this.i.z(j, j2);
        }
        if (z(j)) {
            this.z = 2;
        }
        this.zw = j;
        this.io = j2;
        if (!this.sy.isEmpty()) {
            com.bykv.vk.openvk.component.video.api.a.dl videoController = this.kb.getVideoController();
            if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) videoController).a(50);
            }
        }
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = this.iq;
        if (zVar != null) {
            zVar.e = j;
        }
        com.bytedance.sdk.component.adexpress.g.a aVar = this.uf;
        if (aVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.express.a) aVar).z(j, j2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void t_() {
        this.gc = false;
        com.bytedance.sdk.component.adexpress.g.a aVar = this.uf;
        if (aVar != null) {
            if (aVar instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z) {
                ((com.bytedance.sdk.component.adexpress.dynamic.z.z) aVar).a();
            }
            com.bytedance.sdk.component.adexpress.g.a aVar2 = this.uf;
            if (aVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.a) aVar2).wp();
            }
        }
        if (this.i != null) {
            this.i.t_();
        }
        this.z = 5;
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = this.iq;
        if (zVar != null) {
            zVar.z = true;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
    public void p_() {
        if (this.wp != null) {
            this.wp.p_();
        }
        com.bytedance.sdk.component.adexpress.g.a aVar = this.uf;
        if (aVar != null) {
            if (aVar instanceof com.bytedance.sdk.component.adexpress.dynamic.z.z) {
                ((com.bytedance.sdk.component.adexpress.dynamic.z.z) aVar).gc();
            }
            com.bytedance.sdk.component.adexpress.g.a aVar2 = this.uf;
            if (aVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.a) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.express.a) aVar2).i();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
    public void z(int i, int i2) {
        if (this.wp != null) {
            this.wp.z(i, i2);
        }
        this.zw = this.io;
        this.z = 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(final int i, final String str) {
        super.z(i, str);
        com.bykv.vk.openvk.component.video.api.a.dl videoController = this.kb.getVideoController();
        if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.a aVar = (com.bytedance.sdk.openadsdk.core.video.nativevideo.a) videoController;
            aVar.a(50);
            aVar.z(new z.InterfaceC0212z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4
                @Override // com.bytedance.sdk.openadsdk.core.video.z.z.InterfaceC0212z
                public void z(long j, long j2) {
                    int iAbs = (int) Math.abs(((long) i) - j);
                    int i2 = i;
                    if (i2 < 0 || iAbs > 50 || i2 > j2 || iAbs >= 50 || NativeExpressVideoView.this.sy.contains(str)) {
                        return;
                    }
                    if (i > j) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.kb.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.kb.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.kb.performClick();
                                NativeExpressVideoView.this.g(i, str);
                            }
                        }, iAbs);
                    } else {
                        NativeExpressVideoView.this.kb.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.kb.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.kb.performClick();
                        NativeExpressVideoView.this.g(i, str);
                    }
                    NativeExpressVideoView.this.sy.add(str);
                }
            });
        }
    }

    private boolean z(long j) {
        int i = this.z;
        if (i == 5 || i == 3 || j <= this.zw) {
            return this.kb != null && this.kb.A_();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.a.dl getVideoController() {
        if (this.kb != null) {
            return this.kb.getVideoController();
        }
        return null;
    }

    public void pf() {
        this.kb.uy();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void i() {
        super.i();
        if (this.kb != null) {
            this.kb.js();
        }
    }
}
