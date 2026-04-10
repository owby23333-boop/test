package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.g.z.dl.dl;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.g.z;
import com.bytedance.sdk.openadsdk.core.kb.gz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.a;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.nativeexpress.gc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.io;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.un.h;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g extends com.bytedance.sdk.openadsdk.core.nativeexpress.g implements l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.ls.dl.dl.g f922a;
    protected na dl;
    protected WeakReference<BannerExpressBackupView> e;
    protected final Context g;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.z gc;
    private boolean hh;
    private int i;
    private gc io;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.z kb;
    protected com.bytedance.sdk.openadsdk.core.kb.g.z m;
    private NativeExpressView sy;
    private a uf;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl uy;
    private com.bytedance.sdk.openadsdk.js.z.g.z.z v;
    private l wp;
    protected z z;
    private volatile View zw;
    private String pf = "banner_ad";
    private final Queue<Long> ls = new LinkedList();
    private Double p = null;
    private boolean fv = false;
    private boolean js = false;
    private AtomicBoolean tb = new AtomicBoolean(false);
    private AtomicBoolean q = new AtomicBoolean(false);
    private AtomicBoolean iq = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void e() {
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(JSONObject jSONObject) {
    }

    public g(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.hh = false;
        this.g = context;
        this.dl = naVar;
        this.f922a = gVar;
        this.hh = zw.g().fn() || zw.g().ts();
        z(context, naVar, gVar);
        z(this.z.getCurView(), this.dl, false);
    }

    protected void z(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (context == null) {
            return;
        }
        this.z = new z(context, naVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public View z() {
        com.bytedance.sdk.openadsdk.core.e.a.z().z(this.dl).z(1);
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int g() {
        na naVar = this.dl;
        if (naVar == null) {
            return -1;
        }
        return naVar.ou();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public com.bytedance.sdk.openadsdk.ls.dl.g.a m() {
        na naVar = this.dl;
        if (naVar == null || naVar.ct() == null) {
            return null;
        }
        this.dl.ct().g(this.pf);
        return new com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.dl.ct());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.z zVarZ = com.bytedance.sdk.openadsdk.core.nativeexpress.z.z(gVar);
        this.gc = zVarZ;
        this.z.setExpressInteractionListener(zVarZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.z zVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.z zVarZ = com.bytedance.sdk.openadsdk.core.nativeexpress.z.z(zVar);
        this.gc = zVarZ;
        this.z.setExpressInteractionListener(zVarZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.m = z.C0184z.z(dlVar);
        if (this.gz != null) {
            this.gz.z(this.m);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public int dl() {
        na naVar = this.dl;
        if (naVar == null) {
            return -1;
        }
        return naVar.lt();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void a() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.kb;
        if (zVar != null) {
            zVar.z(this.z);
        }
        this.z.gc();
        com.bytedance.sdk.openadsdk.core.e.a.z().z(this.dl).z(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void gc() {
        super.gc();
        z zVar = this.z;
        if (zVar != null) {
            zVar.a();
        }
        l lVar = this.wp;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
            this.wp = null;
        }
        na naVar = this.dl;
        un.g(naVar != null ? naVar.gc() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        if (zVar == null || activity == null) {
            return;
        }
        this.v = zVar;
        g(activity, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(String str) {
        com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    protected void z(Dialog dialog) {
        if (dialog == null) {
            wp.dl("dialog is null, please check");
            return;
        }
        z zVar = this.z;
        if (zVar == null || zVar.getCurView() == null) {
            return;
        }
        this.z.getCurView().setOuterDislike(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public na uy() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public e z(Activity activity) {
        if (this.kb == null) {
            g(activity, (com.bytedance.sdk.openadsdk.js.z.g.z.z) null);
        }
        return this.kb;
    }

    private void g(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        if (this.kb == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(activity, this.dl.ct(), this.pf, false);
            this.kb = zVar2;
            com.bytedance.sdk.openadsdk.core.dislike.dl.z(activity, this.dl, zVar2);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar3 = this.kb;
        if (zVar3 != null) {
            zVar3.z(this.z);
        }
        this.kb.z(zVar);
        z zVar4 = this.z;
        if (zVar4 == null || zVar4.getCurView() == null) {
            return;
        }
        this.z.getCurView().setDislike(this.kb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.dl.lt() == 4) {
            com.bytedance.sdk.openadsdk.hh.e.z(new fo("banner_express_register_download") { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (g.this.dl.lt() == 4) {
                        g gVar = g.this;
                        gVar.uy = gz.z(gVar.g, g.this.dl, g.this.pf, false);
                        g.this.uy.z();
                        if (g.this.g instanceof Activity) {
                            g.this.uy.z((Activity) g.this.g);
                        }
                        if (g.this.io != null) {
                            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) g.this.io.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(g.this.uy);
                        }
                        if (g.this.uf != null) {
                            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) g.this.uf.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(g.this.uy);
                        }
                        g gVar2 = g.this;
                        gVar2.z(gVar2.uy, g.this.sy);
                        g.this.uy.z(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        l lVar;
        if (this.zw == null || !this.zw.isShown() || (lVar = this.wp) == null) {
            return;
        }
        lVar.removeCallbacksAndMessages(null);
        this.wp.sendEmptyMessageDelayed(112201, this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        l lVar = this.wp;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(na naVar) {
        if (this.z.getNextView() == null || !this.z.g()) {
            return;
        }
        z(this.z.getNextView(), naVar.ct());
        this.iq.set(false);
        z(this.z.getNextView(), naVar, true);
    }

    private void z(NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        if (gVar == null) {
            return;
        }
        if (this.v != null) {
            this.kb.z(gVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.kb);
            }
        }
        if (this.fo != null) {
            z(gVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.fo);
            }
        }
    }

    protected void z(final NativeExpressView nativeExpressView, final na naVar, boolean z) {
        if (nativeExpressView == null || naVar == null) {
            return;
        }
        this.sy = nativeExpressView;
        na naVar2 = this.dl;
        if (naVar2 != null) {
            un.g(naVar2.gc());
        }
        this.dl = naVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.g.dl() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.g.2
            @Override // com.bytedance.sdk.component.adexpress.g.dl
            public boolean z(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).js();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    bannerExpressBackupView.z(g.this.dl, (NativeExpressView) viewGroup, g.this.uy);
                    bannerExpressBackupView.setDislikeInner(g.this.kb);
                    bannerExpressBackupView.setDislikeOuter(g.this.fo);
                    if (g.this.dl != null) {
                        g.this.z(naVar.ct());
                    }
                    g.this.e = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar);
        EmptyView emptyViewZ = z(nativeExpressView);
        if (emptyViewZ == null) {
            EmptyView emptyView = new EmptyView(this.g, nativeExpressView, naVar != null ? naVar.wk() : 1000);
            emptyView.z(this.dl, this.pf);
            nativeExpressView.addView(emptyView);
            emptyViewZ = emptyView;
        }
        this.zw = emptyViewZ;
        emptyViewZ.setCallback(new EmptyView.z() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.g.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(boolean z2) {
                String unused = g.this.pf;
                if (g.this.uy != null) {
                    if (z2) {
                        g.this.uy.z();
                    } else {
                        com.bytedance.sdk.openadsdk.core.kb.g.dl unused2 = g.this.uy;
                    }
                }
                if (z2) {
                    g.this.v();
                } else {
                    g.this.pf();
                }
                g.this.z(z2, naVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z() {
                g.this.i();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void g() {
                if (g.this.uy != null) {
                    g.this.uy.g();
                }
                g.this.g(naVar);
                g.this.tb.set(false);
                g.this.q.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(View view, Map<String, Object> map) {
                if (g.this.ls != null) {
                    g.this.ls.offer(Long.valueOf(System.currentTimeMillis()));
                }
                Map mapZ = g.this.z(nativeExpressView, naVar);
                if (map != null && map.containsKey("show_send_type")) {
                    mapZ.put("show_send_type", map.get("show_send_type"));
                }
                mapZ.put("is_repeat", Boolean.valueOf(g.this.iq.get()));
                g.this.tb.set(true);
                if (!g.this.q.get()) {
                    g.this.q.set(true);
                    com.bytedance.sdk.openadsdk.core.i.a.z(naVar, g.this.pf, (Map<String, Object>) mapZ, g.this.p);
                    com.bytedance.sdk.openadsdk.core.l.z.z().a();
                    na naVar3 = naVar;
                    un.z(naVar3 != null ? naVar3.gc() : 0);
                }
                boolean zPd = zw.g().pd();
                if (g.this.gc != null && (!g.this.iq.getAndSet(true) || zPd)) {
                    g.this.gc.g(view, naVar.lt());
                }
                g.this.v();
                if (g.this.z == null || g.this.z.getCurView() == null) {
                    return;
                }
                g.this.z.getCurView().fv();
                g.this.z.getCurView().ls();
            }
        });
        gc gcVar = new gc(this.g, naVar, this.pf, 2);
        this.io = gcVar;
        final com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar = (com.bytedance.sdk.openadsdk.core.g.z.dl.dl) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class);
        final EmptyView emptyView2 = emptyViewZ;
        dlVar.z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.g.4
            @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.dl.z
            public boolean z() {
                dlVar.z(emptyView2);
                dlVar.z(g.this.z(nativeExpressView, naVar));
                dlVar.z(g.this.pf);
                dlVar.z(g.this.p);
                return g.this.tb.get();
            }
        });
        this.io.z(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.io.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this);
        nativeExpressView.setClickListener(this.io);
        a aVar = new a(this.g, naVar, this.pf, 2);
        this.uf = aVar;
        final com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar2 = (com.bytedance.sdk.openadsdk.core.g.z.dl.dl) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class);
        dlVar2.z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.g.5
            @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.dl.z
            public boolean z() {
                dlVar2.z(emptyView2);
                dlVar2.z(g.this.z(nativeExpressView, naVar));
                dlVar2.z(g.this.pf);
                dlVar2.z(g.this.p);
                return g.this.tb.get();
            }
        });
        this.uf.z(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.uf.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this);
        nativeExpressView.setClickCreativeListener(this.uf);
        if (!this.hh) {
            emptyViewZ.setNeedCheckingShow(true);
        }
        if (z) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> z(NativeExpressView nativeExpressView, na naVar) {
        HashMap map = new HashMap();
        io.z(map, this.dl, nativeExpressView);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar, NativeExpressView nativeExpressView) {
        if (dlVar == null || nativeExpressView == null) {
            return;
        }
        na naVar = this.dl;
        this.gz = new g.z(this.m, naVar != null ? naVar.mj() : "");
        dlVar.z(this.gz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(na naVar) {
        Queue<Long> queue = this.ls;
        if (queue == null || queue.size() <= 0 || naVar == null) {
            return;
        }
        try {
            long jLongValue = this.ls.poll().longValue();
            if (jLongValue > 0) {
                com.bytedance.sdk.openadsdk.core.i.a.z(new StringBuilder().append(System.currentTimeMillis() - jLongValue).toString(), naVar, this.pf, 21);
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, na naVar) {
        Queue<Long> queue = this.ls;
        if (queue == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(System.currentTimeMillis()));
            } else if (queue.size() > 0) {
                com.bytedance.sdk.openadsdk.core.i.a.z(new StringBuilder().append(System.currentTimeMillis() - this.ls.poll().longValue()).toString(), naVar, this.pf, 1);
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private EmptyView z(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public Map<String, Object> gz() {
        na naVar = this.dl;
        if (naVar != null) {
            return naVar.fq();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc fo() {
        return new MediationNativeManagerDefault();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e A[PHI: r0
  0x001e: PHI (r0v7 int) = (r0v4 int), (r0v5 int) binds: [B:5:0x001c, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(int r4) {
        /*
            r3 = this;
            if (r4 > 0) goto L3
            return
        L3:
            java.lang.String r0 = "slide_banner_ad"
            r3.pf = r0
            com.bytedance.sdk.openadsdk.core.bannerexpress.z r0 = r3.z
            com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView r0 = r0.getCurView()
            com.bytedance.sdk.openadsdk.core.iq.na r1 = r3.dl
            r2 = 0
            r3.z(r0, r1, r2)
            com.bytedance.sdk.openadsdk.core.bannerexpress.z r0 = r3.z
            r1 = 1000(0x3e8, float:1.401E-42)
            r0.setDuration(r1)
            r0 = 30000(0x7530, float:4.2039E-41)
            if (r4 >= r0) goto L20
        L1e:
            r4 = r0
            goto L26
        L20:
            r0 = 120000(0x1d4c0, float:1.68156E-40)
            if (r4 <= r0) goto L26
            goto L1e
        L26:
            r3.i = r4
            com.bytedance.sdk.component.utils.l r4 = new com.bytedance.sdk.component.utils.l
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r4.<init>(r0, r3)
            r3.wp = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.bannerexpress.g.z(int):void");
    }

    private void ls() {
        j jVar = new j();
        jVar.m = 2;
        zw.z().z(this.f922a, jVar, 1, new com.bytedance.sdk.openadsdk.core.z.z(new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.g.6
            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
                g.this.v();
            }

            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(zVar.g());
                if (copyOnWriteArrayList.isEmpty()) {
                    g.this.v();
                    return;
                }
                na naVar = (na) copyOnWriteArrayList.get(0);
                g.this.z.z(naVar, g.this.f922a);
                g.this.z(naVar);
                g.this.z.dl();
            }
        }));
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what == 112201 && this.zw != null && this.zw.isShown()) {
            ls();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
        if (this.fv) {
            return;
        }
        h.z(this.dl, d);
        this.fv = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
        if (this.js) {
            return;
        }
        h.z(this.dl, d, str, str2);
        this.js = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
        this.p = d;
    }
}
