package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.g.z.dl.dl;
import com.bytedance.sdk.openadsdk.core.g.z.z.z;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class iq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ls.dl.g.i f1147a;
    private final Context dl;
    private com.bytedance.sdk.openadsdk.io.z.g.z.z e;
    private com.bytedance.sdk.component.utils.iq fv;
    private volatile com.bytedance.sdk.openadsdk.core.kb.g.dl g;
    private long gz;
    private WeakReference<NativeVideoTsView> h;
    private com.bytedance.sdk.openadsdk.core.g.z hh;
    private ViewGroup i;
    private volatile com.bytedance.sdk.openadsdk.core.g.g io;
    private EmptyView iq;
    private com.bytedance.sdk.openadsdk.core.kb.g.z js;
    private Activity l;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.z lq;
    private com.bytedance.sdk.openadsdk.io.z.g.z.z ls;
    private String m;
    private View pf;
    private com.bytedance.sdk.openadsdk.core.g.z sy;
    private volatile com.bytedance.sdk.openadsdk.core.g.z uf;
    private WeakReference<ViewGroup> v;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e x;
    private final na z;
    private View zw;
    private List<View> gc = new ArrayList();
    private Double fo = null;
    private AtomicBoolean uy = new AtomicBoolean(false);
    private AtomicBoolean kb = new AtomicBoolean(false);
    private AtomicBoolean wp = new AtomicBoolean(false);
    private int p = 5;
    private volatile long tb = 0;
    private volatile boolean q = true;
    private volatile boolean gk = false;

    public void z(com.bytedance.sdk.openadsdk.ls.dl.g.i iVar) {
        this.f1147a = iVar;
    }

    public iq(Context context, com.bytedance.sdk.openadsdk.ls.dl.g.i iVar, na naVar, String str) {
        this.m = "embeded_ad";
        this.f1147a = iVar;
        this.z = naVar;
        this.dl = context;
        this.m = str;
    }

    public void z(Activity activity) {
        this.l = activity;
        if (this.g != null) {
            this.g.z(activity);
        }
    }

    public void z(View view, int i) {
        com.bytedance.sdk.openadsdk.io.z.g.z.z zVar = this.e;
        if (zVar != null) {
            zVar.g(view, this.f1147a);
        }
    }

    public void z(NativeExpressView nativeExpressView) {
        if (nativeExpressView != null) {
            if (this.uf != null) {
                nativeExpressView.setClickCreativeListener(this.uf);
            }
            if (this.io != null) {
                nativeExpressView.setClickListener(this.io);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.kb.g.dl z() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        na naVar = this.z;
        if (naVar == null || naVar.lt() != 4) {
            return;
        }
        if (this.gk) {
            a();
        } else {
            this.gk = true;
            com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("feed_register_download") { // from class: com.bytedance.sdk.openadsdk.core.iq.1
                @Override // java.lang.Runnable
                public void run() {
                    if (iq.this.g == null) {
                        iq iqVar = iq.this;
                        iqVar.g = com.bytedance.sdk.openadsdk.core.kb.gz.z(iqVar.dl, iq.this.z, iq.this.m, false);
                    }
                    iq.this.g.z(iq.this.l);
                    iq.this.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.g != null) {
            if (this.io != null) {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.io.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.g);
            }
            if (this.uf != null) {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.uf.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.g);
            }
            com.bytedance.sdk.openadsdk.core.g.z zVar = this.hh;
            if (zVar != null) {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.g);
            }
            com.bytedance.sdk.openadsdk.core.g.z zVar2 = this.sy;
            if (zVar2 != null) {
                ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar2.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.g);
            }
            try {
                this.g.z(false);
                this.g.z(this.js);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, final com.bytedance.sdk.openadsdk.io.z.g.z.z zVar, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar2) {
        EmptyView emptyView;
        this.e = zVar;
        this.i = viewGroup;
        this.v = new WeakReference<>(this.i);
        this.pf = view;
        this.ls = zVar2;
        com.bytedance.sdk.openadsdk.core.i.a.z(this.z);
        Context context = this.dl;
        na naVar = this.z;
        String str = this.m;
        this.hh = new com.bytedance.sdk.openadsdk.core.g.z(context, naVar, str, com.bytedance.sdk.openadsdk.core.un.eo.g(str));
        z(viewGroup);
        EmptyView emptyViewDl = dl(viewGroup);
        if (emptyViewDl == null) {
            na naVar2 = this.z;
            EmptyView emptyView2 = new EmptyView(this.dl, viewGroup, naVar2 != null ? naVar2.wk() : 1000) { // from class: com.bytedance.sdk.openadsdk.core.iq.2
                @Override // android.view.View
                protected void onVisibilityChanged(View view2, int i) {
                    super.onVisibilityChanged(view2, i);
                    com.bytedance.sdk.component.utils.iq iqVar = iq.this.fv;
                    if (iqVar == null) {
                        return;
                    }
                    try {
                        iq.this.q = isShown();
                        if (isShown()) {
                            iqVar.z(iq.this.z != null ? iq.this.z.gc() : 0);
                        } else {
                            iqVar.g(iq.this.z != null ? iq.this.z.gc() : 0);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
            emptyView2.z(this.z, this.m);
            viewGroup.addView(emptyView2);
            emptyView = emptyView2;
        } else {
            emptyView = emptyViewDl;
        }
        emptyView.z();
        emptyView.setRefClickViews(list2);
        emptyView.setRefCreativeViews(list3);
        emptyView.setRefDirectDownloadViews(list4);
        this.iq = emptyView;
        z(this.hh, this.i, this.pf, zVar, this.ls, 3);
        this.gc = list;
        Context context2 = this.dl;
        na naVar3 = this.z;
        String str2 = this.m;
        this.io = new com.bytedance.sdk.openadsdk.core.g.g(context2, naVar3, str2, com.bytedance.sdk.openadsdk.core.un.eo.g(str2));
        z(this.io, viewGroup, view, zVar, zVar2, 0);
        Context context3 = this.dl;
        na naVar4 = this.z;
        String str3 = this.m;
        this.uf = new com.bytedance.sdk.openadsdk.core.g.z(context3, naVar4, str3, com.bytedance.sdk.openadsdk.core.un.eo.g(str3));
        z(this.uf, viewGroup, view, zVar, zVar2, 1);
        if (!com.bytedance.sdk.component.utils.uy.z(list4)) {
            Context context4 = this.dl;
            na naVar5 = this.z;
            String str4 = this.m;
            com.bytedance.sdk.openadsdk.core.g.z zVar3 = new com.bytedance.sdk.openadsdk.core.g.z(context4, naVar5, str4, com.bytedance.sdk.openadsdk.core.un.eo.g(str4));
            this.sy = zVar3;
            zVar3.z(2);
            z(this.sy, viewGroup, view, zVar, zVar2, 2);
        }
        emptyView.z(list2, this.io);
        emptyView.z(list3, this.uf);
        emptyView.z(list4, this.sy);
        emptyView.setCallback(new EmptyView.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(boolean z) {
                iq iqVar = iq.this;
                iqVar.gz = com.bytedance.sdk.openadsdk.core.i.a.z(iqVar.gz, z, iq.this.z, iq.this.m, 3);
                if (iq.this.fv != null) {
                    if (z) {
                        iq.this.fv.z(iq.this.z != null ? iq.this.z.gc() : 0);
                        return;
                    }
                    try {
                        if (iq.this.fv != null) {
                            iq.this.fv.g(iq.this.z != null ? iq.this.z.gc() : 0);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.a("ShakeUtils", "onPause error:" + th.getMessage());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z() {
                iq.this.dl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void g() {
                if (iq.this.g != null) {
                    iq.this.g.g();
                }
                try {
                    if (iq.this.fv != null) {
                        iq.this.fv.g(iq.this.z != null ? iq.this.z.gc() : 0);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.a("ShakeUtils", "onPause error:" + th.getMessage());
                }
                iq.this.uy.set(false);
                iq.this.kb.set(false);
                iq iqVar = iq.this;
                iqVar.gz = com.bytedance.sdk.openadsdk.core.i.a.z(iqVar.gz, iq.this.z, iq.this.m, 23);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.z
            public void z(View view2, Map<String, Object> map) {
                com.bytedance.sdk.openadsdk.core.gc.z.z(iq.this.p, iq.this.z);
                iq.this.dl();
                iq.this.gz = System.currentTimeMillis();
                Map mapE = iq.this.e();
                mapE.put("is_repeat", Boolean.valueOf(iq.this.wp.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapE.put("show_send_type", map.get("show_send_type"));
                }
                mapE.put("is_repeat", Boolean.valueOf(iq.this.wp.get()));
                iq.this.uy.set(true);
                if (!iq.this.kb.get()) {
                    iq.this.kb.set(true);
                    com.bytedance.sdk.openadsdk.core.i.a.z(iq.this.z, iq.this.m, (Map<String, Object>) mapE, iq.this.fo);
                    com.bytedance.sdk.openadsdk.core.l.z.z().a();
                    com.bytedance.sdk.openadsdk.core.un.un.z(iq.this.z != null ? iq.this.z.gc() : 0);
                }
                if (zVar != null) {
                    boolean zPd = zw.g().pd();
                    if (!iq.this.wp.getAndSet(true) || zPd) {
                        zVar.z(iq.this.f1147a);
                    }
                    iq.this.tb = System.currentTimeMillis();
                    iq.this.m();
                }
                if (iq.this.lq != null) {
                    iq.this.lq.z();
                }
                if (iq.this.x != null) {
                    iq.this.x.a();
                }
            }
        });
        emptyView.setNeedCheckingShow(true);
        dl();
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.e eVar) {
        this.x = eVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.video.nativevideo.z zVar) {
        this.lq = zVar;
    }

    public void z(WeakReference<NativeVideoTsView> weakReference) {
        this.h = weakReference;
    }

    private void z(final com.bytedance.sdk.openadsdk.core.g.g gVar, ViewGroup viewGroup, View view, final com.bytedance.sdk.openadsdk.io.z.g.z.z zVar, final com.bytedance.sdk.openadsdk.io.z.g.z.z zVar2, int i) {
        z((com.bytedance.sdk.openadsdk.core.g.z.dl.dl) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.dl.class));
        if (i != 3) {
            HashMap map = new HashMap();
            map.put("click_type", 1);
            ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(map);
        }
        gVar.z(viewGroup);
        gVar.g(view);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.f1147a);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) gVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(new z.InterfaceC0171z() { // from class: com.bytedance.sdk.openadsdk.core.iq.4
            @Override // com.bytedance.sdk.openadsdk.core.g.z.z.z.InterfaceC0171z
            public void z(View view2, int i2) {
                if (gVar instanceof com.bytedance.sdk.openadsdk.core.g.z) {
                    com.bytedance.sdk.openadsdk.io.z.g.z.z zVar3 = zVar;
                    if (zVar3 != null) {
                        zVar3.g(view2, iq.this.f1147a);
                    }
                    com.bytedance.sdk.openadsdk.io.z.g.z.z zVar4 = zVar2;
                    if (zVar4 != null) {
                        zVar4.g(view2, iq.this.f1147a);
                    }
                } else {
                    com.bytedance.sdk.openadsdk.io.z.g.z.z zVar5 = zVar;
                    if (zVar5 != null) {
                        zVar5.z(view2, iq.this.f1147a);
                    }
                    com.bytedance.sdk.openadsdk.io.z.g.z.z zVar6 = zVar2;
                    if (zVar6 != null) {
                        zVar6.z(view2, iq.this.f1147a);
                    }
                }
                if (i2 != 2 || iq.this.z == null) {
                    return;
                }
                iq.this.z.dl(true);
            }
        });
    }

    public void z(int i) {
        this.p = i;
    }

    private void z(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        View viewG = g(viewGroup);
        if (viewG != null) {
            HashMap map = new HashMap();
            map.put("tag", "shake_compat");
            map.put("click_listener", this.hh);
            try {
                viewG.setTag(com.bytedance.sdk.openadsdk.core.un.mc.z, map);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.a("ShakeUtils", "onPause error:" + th.getMessage());
                com.bytedance.sdk.openadsdk.core.un.mc.z(com.bytedance.sdk.openadsdk.core.un.mc.z, th.getMessage());
            }
            this.zw = viewG;
            return;
        }
        View view = new View(this.dl);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.iq.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                try {
                    if (iq.this.fv != null) {
                        iq.this.fv.g(iq.this.z != null ? iq.this.z.gc() : 0);
                    }
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.wp.a("ShakeUtils", "onPause error:" + th2.getMessage());
                }
            }
        });
        HashMap map2 = new HashMap();
        map2.put("tag", "shake_compat");
        map2.put("click_listener", this.hh);
        try {
            view.setTag(com.bytedance.sdk.openadsdk.core.un.mc.z, map2);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.wp.a("ShakeUtils", "onPause error:" + th2.getMessage());
            com.bytedance.sdk.openadsdk.core.un.mc.z(com.bytedance.sdk.openadsdk.core.un.mc.z, th2.getMessage());
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        viewGroup.addView(view);
        this.zw = view;
    }

    private View g(ViewGroup viewGroup) {
        Object obj;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            Object tag = childAt.getTag();
            String string = "";
            if ((tag instanceof Map) && (obj = ((Map) tag).get("tag")) != null) {
                string = obj.toString();
            }
            if ("shake_compat".equals(string)) {
                return childAt;
            }
        }
        return null;
    }

    private com.bytedance.sdk.openadsdk.core.iq.kb gc() {
        na naVar;
        com.bytedance.sdk.openadsdk.core.iq.kb kbVarSx;
        if (this.p == 5 && (naVar = this.z) != null && (kbVarSx = naVar.sx()) != null && kbVarSx.z() == 1) {
            return kbVarSx;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.bytedance.sdk.openadsdk.core.iq.kb kbVarGc = gc();
        if (kbVarGc == null) {
            return;
        }
        final float fG = kbVarGc.g();
        final float fDl = kbVarGc.dl();
        if (this.fv == null) {
            this.fv = new com.bytedance.sdk.component.utils.iq(zw.getContext(), 1, uy.ls().gc());
        }
        this.fv.g(this.z.hs());
        this.fv.z(this.z.kk());
        this.fv.g(this.z.jb());
        this.fv.m(this.z.s());
        this.fv.dl(this.z.eb());
        this.fv.z(this.z.fn());
        this.fv.gc(this.z.yw());
        this.fv.z(new iq.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.6
            @Override // com.bytedance.sdk.component.utils.iq.z
            public void z(int i) {
                if (i == 1 && iq.this.q && ti.z(iq.this.i)) {
                    com.bytedance.sdk.openadsdk.core.un.mc.z(iq.this.v, fG, fDl, iq.this.tb);
                }
            }
        });
        com.bytedance.sdk.component.utils.iq iqVar = this.fv;
        na naVar = this.z;
        iqVar.z(naVar != null ? naVar.gc() : 0);
    }

    public void z(final com.bytedance.sdk.openadsdk.core.g.z.dl.dl dlVar) {
        dlVar.z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.7
            @Override // com.bytedance.sdk.openadsdk.core.g.z.dl.dl.z
            public boolean z() {
                dlVar.z(iq.this.iq);
                dlVar.z(iq.this.e());
                dlVar.z(iq.this.m);
                dlVar.z(iq.this.fo);
                return iq.this.uy.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> e() {
        NativeVideoTsView nativeVideoTsView;
        HashMap map = new HashMap();
        if (this.gc != null) {
            JSONArray jSONArray = new JSONArray();
            for (View view : this.gc) {
                if (view != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(MediaFormat.KEY_WIDTH, view.getWidth());
                        jSONObject.put(MediaFormat.KEY_HEIGHT, view.getHeight());
                        jSONObject.put("alpha", view.getAlpha());
                    } catch (Throwable unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
            map.put("image_view", jSONArray.toString());
        }
        if (this.i != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(MediaFormat.KEY_WIDTH, this.i.getWidth());
                jSONObject2.put(MediaFormat.KEY_HEIGHT, this.i.getHeight());
                jSONObject2.put("alpha", this.i.getAlpha());
            } catch (Throwable unused2) {
            }
            map.put("root_view", jSONObject2.toString());
        }
        WeakReference<NativeVideoTsView> weakReference = this.h;
        if (weakReference != null && (nativeVideoTsView = weakReference.get()) != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(MediaFormat.KEY_WIDTH, nativeVideoTsView.getWidth());
                jSONObject3.put(MediaFormat.KEY_HEIGHT, nativeVideoTsView.getHeight());
                jSONObject3.put("alpha", nativeVideoTsView.getAlpha());
            } catch (JSONException unused3) {
            }
            map.put("video_view", jSONObject3.toString());
        }
        return map;
    }

    private EmptyView dl(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void z(com.bytedance.sdk.openadsdk.core.kb.g.z zVar) {
        this.js = zVar;
    }

    public void z(View view, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
        if (this.uf != null) {
            this.uf.z(view, uyVar);
        }
    }

    public void g(View view, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
        if (this.io != null) {
            this.io.z(view, uyVar);
        }
    }

    public void z(Double d) {
        this.fo = d;
    }

    public void g() {
        if (this.g != null) {
            this.g.g();
        }
        WeakReference<ViewGroup> weakReference = this.v;
        if (weakReference != null) {
            weakReference.clear();
        }
        final ViewGroup viewGroup = this.i;
        final EmptyView emptyView = this.iq;
        if (viewGroup != null && emptyView != null) {
            com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.iq.8
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(emptyView);
                }
            });
        }
        final View view = this.zw;
        if (viewGroup != null && view != null) {
            com.bytedance.sdk.component.utils.gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.iq.9
                @Override // java.lang.Runnable
                public void run() {
                    viewGroup.removeView(view);
                }
            });
        }
        com.bytedance.sdk.component.utils.iq iqVar = this.fv;
        if (iqVar != null) {
            na naVar = this.z;
            iqVar.g(naVar != null ? naVar.gc() : 0);
        }
        na naVar2 = this.z;
        com.bytedance.sdk.openadsdk.core.un.un.g(naVar2 != null ? naVar2.gc() : 0);
    }
}
