package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.g.z.dl.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.g.z;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.h;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class q extends g {
    protected na dl;
    private com.bytedance.sdk.openadsdk.core.kb.g.z e;
    protected final Context g;
    protected WeakReference<wp> gc;
    private final FrameLayout iq;
    private gc js;
    private com.bytedance.sdk.openadsdk.core.kb.g.dl kb;
    private z m;
    private boolean sy;
    private a tb;
    private EmptyView uf;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.z uy;
    protected NativeExpressView z;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a zw;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f1284a = "embeded_ad";
    private long wp = 0;
    private Double i = null;
    private boolean v = false;
    private boolean pf = false;
    private AtomicBoolean ls = new AtomicBoolean(false);
    private AtomicBoolean p = new AtomicBoolean(false);
    private AtomicBoolean fv = new AtomicBoolean(false);
    private volatile boolean q = false;
    private final ViewGroup io = new FrameLayout(com.bytedance.sdk.openadsdk.core.zw.getContext());
    private final z hh = new z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
        public void z(View view, int i) {
            if (q.this.m != null) {
                q.this.m.z(q.this.io, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
        public void g(View view, int i) {
            boolean zPd = com.bytedance.sdk.openadsdk.core.zw.g().pd();
            if (q.this.m != null && (!q.this.fv.getAndSet(true) || zPd)) {
                q.this.m.g(q.this.io, i);
            }
            if (q.this.zw == null || q.this.zw.z() == null) {
                return;
            }
            q.this.zw.z().a();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
        public void z(View view, String str, int i) {
            if (q.this.m != null) {
                q.this.m.z(q.this.io, str, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
        public void z(View view, float f, float f2) {
            if (q.this.z != null && q.this.zw != null) {
                q.this.z.setEasyPlayableSender(q.this.zw.z());
                q.this.zw.z(q.this.z.getEasyPlayableLayout(), q.this.z.getVideoContainer());
            }
            q.this.io.removeAllViews();
            q.this.io.addView(view);
            q.this.io.addView(q.this.iq, new FrameLayout.LayoutParams((int) f, (int) f2));
            if (q.this.m != null) {
                q.this.m.z(q.this.io, f, f2);
            }
        }
    };

    public q(Context context, final na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.sy = false;
        this.g = context;
        this.dl = naVar;
        this.sy = com.bytedance.sdk.openadsdk.core.zw.g().fn() || com.bytedance.sdk.openadsdk.core.zw.g().ts();
        z(context, naVar, gVar);
        this.iq = new FrameLayout(context);
        this.zw = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a(naVar, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void dl(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i) {
                if (q.this.z != null) {
                    q.this.z.z(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long z() {
                if (q.this.z != null) {
                    return q.this.z.z();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int g() {
                if (q.this.z != null) {
                    return q.this.z.g();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int dl() {
                if (q.this.z != null) {
                    return q.this.z.dl();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long getActualPlayDuration() {
                if (q.this.z != null) {
                    return q.this.z.getActualPlayDuration();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void a() {
                if (q.this.z != null) {
                    q.this.z.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void g(int i) {
                if (q.this.z != null) {
                    q.this.z.g(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void gc() {
                if (q.this.z != null) {
                    q.this.z.gc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i, String str) {
                if (q.this.z != null) {
                    q.this.z.z(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void setPauseFromExpressView(boolean z) {
                if (q.this.z != null) {
                    q.this.z.setPauseFromExpressView(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(float f) {
                if (q.this.z != null) {
                    q.this.z.z(f);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void m() {
                if (q.this.z != null) {
                    q.this.z.m();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(View view) {
                q.this.hh.z(view, naVar.lt());
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                if (q.this.z != null) {
                    q.this.z.z(view, i, dlVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z
            public void g(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                if (q.this.z != null) {
                    q.this.z.z(view, i, dlVar);
                }
            }
        });
    }

    public void z(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, naVar, gVar, this.f1284a);
        this.z = nativeExpressView;
        this.io.addView(nativeExpressView);
        z(this.z, this.dl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public View z() {
        com.bytedance.sdk.openadsdk.core.e.a.z().z(this.dl);
        return this.io;
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
        this.dl.ct().g(this.f1284a);
        return new com.bytedance.sdk.openadsdk.core.dislike.dl.z(this.dl.ct());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar) {
        this.m = z.z(gVar);
        this.z.setExpressInteractionListener(this.hh);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.z zVar) {
        this.m = z.z(zVar);
        this.z.setExpressInteractionListener(this.hh);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
        this.e = z.C0184z.z(dlVar);
        if (this.gz != null) {
            this.gz.z(this.e);
        }
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
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar = this.uy;
        if (zVar != null) {
            zVar.z(this.z);
        }
        this.z.p();
        com.bytedance.sdk.openadsdk.core.e.a.z().z(this.dl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void gc() {
        super.gc();
        NativeExpressView nativeExpressView = this.z;
        if (nativeExpressView != null) {
            nativeExpressView.i();
        }
        com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar = this.kb;
        if (dlVar != null) {
            dlVar.g();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a aVar = this.zw;
        if (aVar != null) {
            aVar.g();
        }
        na naVar = this.dl;
        un.g(naVar != null ? naVar.gc() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        if (zVar == null || activity == null) {
            return;
        }
        g(activity, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(String str) {
        com.bytedance.sdk.openadsdk.core.i.a.g(this.dl, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    protected void z(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.wp.dl("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.z;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public na uy() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public com.bytedance.sdk.openadsdk.ls.dl.g.e z(Activity activity) {
        if (this.uy == null) {
            g(activity, null);
        }
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.z;
        if (nativeExpressView != null) {
            nativeExpressView.z(jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void e() {
        NativeExpressView nativeExpressView = this.z;
        if (nativeExpressView != null) {
            nativeExpressView.iq();
        }
    }

    private void g(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        if (this.uy == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar2 = new com.bytedance.sdk.openadsdk.core.dislike.ui.z(activity, this.dl.ct(), this.f1284a, false);
            this.uy = zVar2;
            com.bytedance.sdk.openadsdk.core.dislike.dl.z(activity, this.dl, zVar2);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.z zVar3 = this.uy;
        if (zVar3 != null) {
            zVar3.z(this.z);
        }
        this.uy.z(zVar);
        NativeExpressView nativeExpressView = this.z;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.uy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.q) {
            if (this.kb != null) {
                gc gcVar = this.js;
                if (gcVar != null) {
                    ((com.bytedance.sdk.openadsdk.core.g.z.z.z) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.kb);
                }
                a aVar = this.tb;
                if (aVar != null) {
                    ((com.bytedance.sdk.openadsdk.core.g.z.z.z) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.kb);
                }
                try {
                    z(this.kb, this.z);
                    this.kb.z(false);
                    this.kb.z(this.gz);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        this.q = true;
        if (this.dl.lt() == 4) {
            com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("native_register_download") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.3
                @Override // java.lang.Runnable
                public void run() {
                    q qVar = q.this;
                    qVar.kb = com.bytedance.sdk.openadsdk.core.kb.gz.z(qVar.g, q.this.dl, q.this.f1284a, false);
                    if (q.this.js != null) {
                        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) q.this.js.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(q.this.kb);
                    }
                    if (q.this.tb != null) {
                        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) q.this.tb.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(q.this.kb);
                    }
                    if (q.this.g instanceof Activity) {
                        q.this.kb.z((Activity) q.this.g);
                    }
                    q qVar2 = q.this;
                    qVar2.z(qVar2.kb, q.this.z);
                    q.this.kb.z(false);
                    q.this.kb.z(q.this.gz);
                }
            });
        }
    }

    protected void z(NativeExpressView nativeExpressView, final na naVar) {
        this.dl = naVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.g.dl() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.4
            @Override // com.bytedance.sdk.component.adexpress.g.dl
            public boolean z(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).js();
                    wp wpVar = new wp(viewGroup.getContext());
                    com.bytedance.sdk.openadsdk.core.video.a.z.z(Integer.valueOf(naVar.hashCode()), q.this);
                    wpVar.z(q.this.dl, (NativeExpressView) viewGroup, q.this.kb);
                    wpVar.setDislikeInner(q.this.uy);
                    wpVar.setDislikeOuter(q.this.fo);
                    if (q.this.dl != null) {
                        q qVar = q.this;
                        qVar.z(qVar.dl.ct());
                    }
                    q.this.gc = new WeakReference<>(wpVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.i.a.z(naVar);
        EmptyView emptyViewZ = z(nativeExpressView);
        this.uf = emptyViewZ;
        if (emptyViewZ == null) {
            EmptyView emptyView = new EmptyView(this.g, nativeExpressView, naVar != null ? naVar.wk() : 1000);
            this.uf = emptyView;
            emptyView.z(this.dl, this.f1284a);
            nativeExpressView.addView(this.uf);
        }
        this.uf.setCallback(new EmptyView.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.5
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(boolean z) {
                if (q.this.kb != null) {
                    if (z) {
                        q.this.kb.z();
                    } else {
                        com.bytedance.sdk.openadsdk.core.kb.g.dl unused = q.this.kb;
                    }
                }
                q qVar = q.this;
                qVar.wp = com.bytedance.sdk.openadsdk.core.i.a.z(qVar.wp, z, naVar, q.this.f1284a, 2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z() {
                q.this.i();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void g() {
                if (q.this.kb != null) {
                    q.this.kb.g();
                }
                q qVar = q.this;
                qVar.wp = com.bytedance.sdk.openadsdk.core.i.a.z(qVar.wp, naVar, q.this.f1284a, 22);
                q.this.ls.set(false);
                q.this.p.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(View view, Map<String, Object> map) {
                q.this.i();
                q.this.wp = System.currentTimeMillis();
                Map mapV = q.this.v();
                mapV.put("is_repeat", Boolean.valueOf(q.this.fv.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapV.put("show_send_type", map.get("show_send_type"));
                }
                mapV.put("is_repeat", Boolean.valueOf(q.this.fv.get()));
                q.this.ls.set(true);
                if (!q.this.p.get()) {
                    q.this.p.set(true);
                    com.bytedance.sdk.openadsdk.core.i.a.z(naVar, q.this.f1284a, (Map<String, Object>) mapV, q.this.i);
                    com.bytedance.sdk.openadsdk.core.l.z.z().a();
                    na naVar2 = naVar;
                    un.z(naVar2 != null ? naVar2.gc() : 0);
                }
                q.this.hh.g(view, naVar.lt());
                if (q.this.z != null) {
                    q.this.z.fv();
                    q.this.z.ls();
                }
            }
        });
        Context context = this.g;
        String str = this.f1284a;
        gc gcVar = new gc(context, naVar, str, eo.g(str));
        this.js = gcVar;
        z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) gcVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        this.js.z(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.js.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this);
        this.z.setClickListener(this.js);
        Context context2 = this.g;
        String str2 = this.f1284a;
        a aVar = new a(context2, naVar, str2, eo.g(str2));
        this.tb = aVar;
        z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) aVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        this.tb.z(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.tb.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this);
        this.z.setClickCreativeListener(this.tb);
        if (this.sy) {
            return;
        }
        this.uf.setNeedCheckingShow(true);
    }

    public void z(final com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar) {
        dlVar.z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.q.6
            @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.dl.z
            public boolean z() {
                dlVar.z(q.this.uf);
                dlVar.z(q.this.v());
                dlVar.z(q.this.f1284a);
                dlVar.z(q.this.i);
                return q.this.ls.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> v() {
        HashMap map = new HashMap();
        io.z(map, this.dl, this.z);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.core.kb.g.dl dlVar, NativeExpressView nativeExpressView) {
        if (dlVar == null || nativeExpressView == null) {
            return;
        }
        na naVar = this.dl;
        this.gz = new g.z(this.e, naVar != null ? naVar.mj() : "");
        dlVar.z(this.gz);
    }

    private EmptyView z(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d) {
        if (this.v) {
            return;
        }
        h.z(this.dl, d);
        this.v = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void z(Double d, String str, String str2) {
        if (this.pf) {
            return;
        }
        h.z(this.dl, d, str, str2);
        this.pf = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.gz
    public void g(Double d) {
        this.i = d;
    }
}
