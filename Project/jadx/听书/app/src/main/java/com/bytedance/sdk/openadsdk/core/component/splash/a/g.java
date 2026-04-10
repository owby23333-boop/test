package com.bytedance.sdk.openadsdk.core.component.splash.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.component.splash.a.z;
import com.bytedance.sdk.openadsdk.core.component.splash.countdown.g;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.rv;
import com.bytedance.sdk.openadsdk.core.iq.sy;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.SplashExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.gc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.io;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class g extends z implements dl.a, dl.InterfaceC0027dl, z.g, z.InterfaceC0190z {
    private int gp;
    private String j;
    private Context na;
    private final AtomicBoolean t = new AtomicBoolean(false);
    private WeakReference<ViewGroup> vm;
    private NativeExpressView wj;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g xl;
    private a y;

    @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
    public boolean h() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
    public void p_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void s_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void z(long j, long j2) {
    }

    public g(Context context, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl dlVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<fo, e> aVar, com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar) {
        com.bytedance.sdk.openadsdk.hh.e.z(new AnonymousClass1(context, gVar, str, i, dlVar, aVar, zVar));
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.splash.a.g$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f993a;
        final /* synthetic */ String dl;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.z.z e;
        final /* synthetic */ com.bytedance.sdk.openadsdk.ls.dl.dl.g g;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl gc;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a m;
        final /* synthetic */ Context z;

        AnonymousClass1(Context context, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str, int i, com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl dlVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a aVar, com.bytedance.sdk.openadsdk.core.component.splash.z.z zVar) {
            this.z = context;
            this.g = gVar;
            this.dl = str;
            this.f993a = i;
            this.gc = dlVar;
            this.m = aVar;
            this.e = zVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            try {
                g.this.na = this.z;
                g.this.xl = this.g;
                g.this.j = this.dl;
                g.this.gp = this.f993a;
                g gVar = g.this;
                gVar.z((z.g) gVar);
                g.this.z(this.gc, this.m, this.e);
                g.this.y = new a(g.this.g, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.g.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void a() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public int dl() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void dl(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public int g() {
                        return 0;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void g(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void gc() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public long getActualPlayDuration() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void m() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void setPauseFromExpressView(boolean z) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public long z() {
                        return 0L;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void z(float f) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void z(int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
                    public void z(int i, String str) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
                    public void z(View view) {
                        if (g.this.gz != null) {
                            g.this.gz.g(g.this);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
                    public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                        if (g.this.wj != null) {
                            g.this.wj.z(view, i, dlVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
                    public void g(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                        if (g.this.wj != null) {
                            g.this.wj.z(view, i, dlVar);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
                    public void z(ViewGroup viewGroup) {
                        if (sy.m(g.this.g).m()) {
                            TextView textView = new TextView(g.this.na);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                            textView.setTextSize(1, 20.0f);
                            int iDl = oq.dl(zw.getContext(), 80.0f);
                            textView.setText("跳转至详情页或第三方应用");
                            layoutParams.bottomMargin = iDl;
                            int i = iDl / 3;
                            layoutParams.leftMargin = i;
                            layoutParams.rightMargin = i;
                            layoutParams.gravity = 81;
                            textView.setTextColor(-1);
                            int i2 = iDl / 6;
                            textView.setPadding(0, i2, 0, i2);
                            textView.setGravity(17);
                            textView.setLayoutParams(layoutParams);
                            textView.setClickable(true);
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.g.1.1.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (g.this.wj != null) {
                                        g.this.wj.z(view, 2, new zw.z().z());
                                    }
                                }
                            });
                            textView.bringToFront();
                            viewGroup.addView(textView);
                        }
                    }
                });
            } catch (Throwable th) {
                wp.a("splrender", th.getMessage());
            }
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.component.splash.dl.z.dl dlVar, com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<fo, e> aVar) {
        this.i = 3;
        z(aVar);
        pf();
    }

    public void g(int i) {
        this.gp = i;
    }

    private void ls() {
        if (this.g.zr() == 2) {
            this.wj = new NativeExpressView(true, this.na, this.g, this.xl, this.j, true);
        } else {
            this.wj = new NativeExpressView(false, this.na, this.g, this.xl, this.j, true);
        }
    }

    private void p() {
        if (this.g.zr() == 2) {
            this.wj = new NativeExpressVideoView(true, this.na, this.g, this.xl, this.j);
        } else {
            this.wj = new NativeExpressVideoView(false, this.na, this.g, this.xl, this.j);
        }
        if (this.wj.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) {
            this.x = (com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.wj.getVideoController();
        }
        this.wj.setVideoAdListener(this);
        this.wj.setVideoAdInteractionListener(this);
    }

    private void z(final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.a<fo, e> aVar) {
        if (aVar == null || this.g == null) {
            return;
        }
        if (this.h) {
            this.q = true;
            p();
        } else {
            this.q = false;
            ls();
        }
        this.uf.z(this);
        NativeExpressView nativeExpressView = this.wj;
        if (nativeExpressView == null) {
            this.uf.g(3);
            this.uf.z("no render express");
            aVar.z(this.uf);
        } else {
            nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.g.dl() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.g.2
                @Override // com.bytedance.sdk.component.adexpress.g.dl
                public boolean z(ViewGroup viewGroup, int i) {
                    try {
                        SplashExpressBackupView splashExpressBackupView = new SplashExpressBackupView(g.this.na);
                        splashExpressBackupView.z(g.this.l, g.this.g, (NativeExpressView) viewGroup);
                        if (splashExpressBackupView.getVideoController() instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.a) {
                            g.this.x = (com.bytedance.sdk.openadsdk.core.video.nativevideo.a) splashExpressBackupView.getVideoController();
                        }
                        splashExpressBackupView.setVideoAdListener(g.this);
                        g.this.wp();
                        if (g.this.z == null) {
                            return true;
                        }
                        g.this.z.z();
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
            });
            this.i = 3;
            this.wj.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.g.3
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
                public void z(View view, int i) {
                    com.bytedance.sdk.openadsdk.core.i.a.g(g.this.ls, g.this.g);
                    if (g.this.gz != null) {
                        g.this.gz.g(g.this);
                    }
                    g.this.kb();
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
                public void z(View view, String str, int i) {
                    wp.a(MediationConstant.RIT_TYPE_SPLASH, "onRenderFail:".concat(String.valueOf(str)));
                    g.this.uf.g(3);
                    g.this.uf.z("render splash express fail");
                    aVar.z(g.this.uf);
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
                public void z(View view, float f, float f2) {
                    if (view != null && f > 0.0f && f2 > 0.0f) {
                        fo foVar = new fo(g.this.lq.get(), g.this);
                        boolean zQ = g.this.wj.q();
                        if (g.this.wj != null && !zQ) {
                            g.this.z.setComplianceBarVisibility(8);
                        }
                        foVar.z(zQ);
                        g.this.eo.set(zQ ? 1 : 2);
                        g.this.sy.set(true);
                        g.this.z.setExpressView(g.this.wj);
                        g.this.t.set(true);
                        if (g.this.hh.get()) {
                            g gVar = g.this;
                            gVar.z((WeakReference<ViewGroup>) gVar.vm);
                            g.this.hh.set(false);
                        }
                        if (!g.this.fo.get() && !zQ && rv.z(g.this.g)) {
                            g.this.js();
                        }
                        aVar.g(foVar);
                        g.this.y.z(g.this.z.getEasyPlayableLayout(), g.this.wj.getVideoContainer());
                        return;
                    }
                    g.this.uf.g(3);
                    g.this.uf.z("render splash view error");
                    aVar.z(g.this.uf);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.a.z, com.bytedance.sdk.openadsdk.ls.dl.g.g
    public void z(ViewGroup viewGroup) {
        if (viewGroup == null) {
            wp.a(MediationConstant.RIT_TYPE_SPLASH, "展示开屏的容器不能为空");
            return;
        }
        fv();
        WeakReference<ViewGroup> weakReference = new WeakReference<>(viewGroup);
        this.vm = weakReference;
        if (this.sy.get() && this.z != null) {
            z(weakReference);
        } else {
            this.hh.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(WeakReference<ViewGroup> weakReference) {
        ViewGroup viewGroup;
        if (weakReference == null || (viewGroup = weakReference.get()) == null) {
            return;
        }
        if (this.z.getParent() != null) {
            ((ViewGroup) this.z.getParent()).removeView(this.z);
        }
        viewGroup.addView(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.a.z, com.bytedance.sdk.openadsdk.ls.dl.g.g
    public View g() {
        if (this.un == -1) {
            this.un = 0;
        }
        return this.z;
    }

    public void pf() {
        NativeExpressView nativeExpressView = this.wj;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.m(this.gp);
        this.wj.p();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.a.z.g
    public void w_() {
        if (this.g == null || this.js == null) {
            return;
        }
        if (vm.z(this.g) == 2) {
            if (this.t.get()) {
                NativeExpressView nativeExpressView = this.wj;
                if (nativeExpressView != null) {
                    nativeExpressView.ls();
                    io.z(this.js, this.g, this.wj);
                }
                this.js.put("splash_show_type", 3);
            }
        } else if (!this.h) {
            this.js.put("splash_show_type", 0);
        } else {
            if (TextUtils.isEmpty(tf.z(this.g))) {
                this.js.put("splash_show_type", 2);
            }
            this.js.put("splash_show_type", 1);
        }
        z(this.g);
    }

    private void z(na naVar) {
        if (this.wj == null || naVar == null) {
            return;
        }
        Context context = this.na;
        String str = this.j;
        gc gcVar = new gc(context, naVar, str, eo.g(str));
        gcVar.z(this.wj);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.dl);
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.uy);
        this.wj.setClickListener(gcVar);
        Context context2 = this.na;
        String str2 = this.j;
        com.bytedance.sdk.openadsdk.core.nativeexpress.a aVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.a(context2, naVar, str2, eo.g(str2));
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this);
        aVar.z(this.wj);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.dl);
        ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.uy);
        this.wj.setClickCreativeListener(aVar);
        if (this.dl != null) {
            this.dl.z(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
    public com.bytedance.sdk.openadsdk.core.multipro.g.z x() {
        NativeExpressView nativeExpressView;
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
        dl videoController = this.x;
        if (videoController == null && (nativeExpressView = this.wj) != null) {
            videoController = nativeExpressView.getVideoController();
        }
        if (videoController != null) {
            zVar.e = videoController.kb();
            zVar.z = videoController.tb();
            zVar.gz = videoController.js();
        }
        return zVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
    public void z(int i, int i2) {
        this.zw = false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void t_() {
        this.zw = false;
        com.bytedance.sdk.openadsdk.core.i.a.g(this.ls, this.g);
        if (this.gz != null) {
            this.kb = true;
            this.gz.z(this, 4);
            dl(false);
        }
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.a.z, com.bytedance.sdk.openadsdk.core.component.splash.TsView.z
    public void fo() {
        super.fo();
        NativeExpressView nativeExpressView = this.wj;
        if (nativeExpressView != null) {
            nativeExpressView.i();
        }
        this.wj = null;
        this.e = null;
        this.m = null;
        if (this.uy != null) {
            this.uy.clear();
        }
        a aVar = this.y;
        if (aVar != null) {
            aVar.g();
        }
        dl(false);
        v();
    }

    private void fv() {
        if (this.un > 0) {
            return;
        }
        if (this.mc == 1) {
            this.un = 1;
        } else {
            this.un = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js() {
        NativeExpressView nativeExpressView = this.wj;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.g(this.wp, 0);
        this.wj.setDynamicSkipListener(new com.bytedance.sdk.openadsdk.core.component.splash.countdown.dl() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.g.4
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.dl
            public void z() {
                g.this.uy();
            }
        });
        this.z.g();
        this.oq = new com.bytedance.sdk.openadsdk.core.component.splash.countdown.g();
        this.oq.z(this.wp);
        this.oq.z(new g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.a.g.5
            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.g.z
            public void z() {
                g.this.i();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.g.z
            public void z(int i) {
                if (g.this.wj != null) {
                    g.this.wj.g(g.this.wp, i);
                }
            }
        });
        if (this.ti.get()) {
            this.oq.g();
        }
    }
}
