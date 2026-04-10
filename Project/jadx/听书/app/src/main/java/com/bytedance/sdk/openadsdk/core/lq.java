package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class lq implements Function<SparseArray<Object>, Object> {
    private volatile Context z;

    public lq(Context context) {
        this.z = (context == null ? zw.getContext() : context).getApplicationContext();
    }

    private void gz(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        z(com.bytedance.sdk.openadsdk.core.un.l.z(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.gc(function));
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            dlVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.dl.z.g().z(gVar, dlVar, jCurrentTimeMillis);
                } catch (Throwable th) {
                    dlVar.z(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            dlVar.z(10000, "Please exec  TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 5);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(5, gVar);
        }
    }

    public void z(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        g(com.bytedance.sdk.openadsdk.core.un.l.z(6, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.gc(function));
    }

    public void g(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.dl dlVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            dlVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadStream") { // from class: com.bytedance.sdk.openadsdk.core.lq.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.a.z.g().z(gVar, dlVar, jCurrentTimeMillis);
                } catch (Throwable th) {
                    dlVar.z(4000, "feed component maybe not exist, pls check1, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "feed component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            dlVar.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 6);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(6, gVar);
        }
    }

    public void g(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        z(com.bytedance.sdk.openadsdk.core.un.l.z(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.a(function));
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.g gVar2) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            gVar2.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    lq.this.z(gVar);
                    com.bytedance.sdk.openadsdk.core.component.g.z.g().z(gVar, gVar2, jCurrentTimeMillis);
                } catch (Throwable th) {
                    gVar2.z(4000, "feed component maybe not exist, pls check2, msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "feed component maybe not exist, pls check2", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            gVar2.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 9);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(9, gVar);
        }
    }

    public void dl(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        z(1, com.bytedance.sdk.openadsdk.core.un.l.z(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.e(function));
    }

    public void z(int i, final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.gc gcVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            gcVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadNativeAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.z.z.g().z(gVar, gcVar, jCurrentTimeMillis);
                } catch (Throwable th) {
                    gcVar.z(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "Error msg = ", th.getMessage());
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            gcVar.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, i);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(i, gVar.a());
        }
    }

    public void z(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function, int i) {
        z(com.bytedance.sdk.openadsdk.core.un.l.z(3, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.dl(function), i);
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.z zVar, final int i) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            zVar.z(new com.bytedance.sdk.openadsdk.ls.dl.dl(1000, "广告请求开关已关闭,请联系穿山甲管理员"));
            return;
        }
        int iFo = zw.g().fo(com.bytedance.sdk.openadsdk.core.un.eo.g(gVar));
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadSplashAd b") { // from class: com.bytedance.sdk.openadsdk.core.lq.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    uy.ls().e(1);
                    com.bytedance.sdk.openadsdk.core.component.splash.gc.z(lq.this.getContext()).z(gVar, zVar, i);
                } catch (Throwable th) {
                    zVar.z(new com.bytedance.sdk.openadsdk.ls.dl.dl(4000, " msg = " + th.getMessage()));
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "splash component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            zVar.z(new com.bytedance.sdk.openadsdk.ls.dl.dl(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad"));
            return;
        }
        if (AdSdkInitializerHolder.isSdkInitSuccess() && (iFo == 4 || com.bytedance.sdk.openadsdk.core.component.splash.gc.z(gVar))) {
            foVar.run();
        } else if (z()) {
            com.bytedance.sdk.component.uy.e.gc(foVar);
        } else {
            com.bytedance.sdk.component.uy.kb.g.wp().execute(foVar);
        }
        com.bytedance.sdk.openadsdk.core.m.z.dl().z(3, gVar);
    }

    private void fo(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        z(com.bytedance.sdk.openadsdk.core.un.l.z(7, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.fo(function));
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.e eVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            eVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.z.gz.z().z(gVar, new com.bytedance.sdk.openadsdk.core.component.reward.z.a(eVar));
                } catch (Throwable th) {
                    eVar.z(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            eVar.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 7);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(7, gVar);
        }
    }

    public void a(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        z(com.bytedance.sdk.openadsdk.core.un.l.z(8, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.m(function));
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.a aVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            aVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadFullScreenVideoAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.component.reward.z.g.z().z(gVar, new com.bytedance.sdk.openadsdk.core.component.reward.z.a(aVar));
                } catch (Throwable th) {
                    aVar.z(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.g("TTAdNativeImpl", "reward component maybe not exist, pls check2", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            aVar.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 8);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(8, gVar);
        }
    }

    public void gc(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        z(com.bytedance.sdk.openadsdk.core.un.l.z(5, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.gz(function));
    }

    public void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.m mVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            mVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadNativeExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!lq.this.z(gVar, false)) {
                        mVar.z(110, fo.z(110));
                    } else {
                        com.bytedance.sdk.openadsdk.core.component.dl.z.g().z(gVar, mVar, jCurrentTimeMillis);
                    }
                } catch (Throwable th) {
                    mVar.z(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "Error msg = ", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            mVar.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 5);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(5, gVar);
        }
    }

    public void m(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        g(com.bytedance.sdk.openadsdk.core.un.l.z(9, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.gz(function));
    }

    public void g(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.m mVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            mVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadExpressDrawFeedAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!lq.this.z(gVar, false)) {
                        mVar.z(110, fo.z(110));
                    } else {
                        com.bytedance.sdk.openadsdk.core.component.g.z.g().z(gVar, mVar, jCurrentTimeMillis);
                    }
                } catch (Throwable th) {
                    mVar.z(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "Error msg =", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            mVar.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 9);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(9, gVar);
        }
    }

    public void e(PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        dl(com.bytedance.sdk.openadsdk.core.un.l.z(1, pluginValueSet), new com.bytedance.sdk.openadsdk.core.z.gz(function));
    }

    public void dl(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final com.bytedance.sdk.openadsdk.tb.z.g.z.m mVar) {
        if (!com.bytedance.sdk.openadsdk.core.gk.fo.z()) {
            mVar.z(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.uy.fo foVar = new com.bytedance.sdk.component.uy.fo("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.core.lq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!lq.this.z(gVar, false)) {
                        mVar.z(110, fo.z(110));
                    } else {
                        com.bytedance.sdk.openadsdk.core.component.z.z.g().z(gVar, mVar, jCurrentTimeMillis);
                    }
                } catch (Throwable th) {
                    mVar.z(4000, " msg = " + th.getMessage());
                    com.bytedance.sdk.component.utils.wp.dl("TTAdNativeImpl", "Banner express error, pls check", th);
                }
            }
        };
        if (!q.z) {
            com.bytedance.sdk.component.utils.wp.a("TTAdNativeImpl", "please exec TTAdSdk.init and TTAdSdk.start before load ad");
            mVar.z(10000, "please exec TTAdSdk.init and TTAdSdk.start before load ad");
        } else {
            z(foVar, 1);
            com.bytedance.sdk.openadsdk.core.m.z.dl().z(1, gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        com.bytedance.sdk.component.utils.ls.z(gVar.m() > 0, "必须设置图片素材尺寸");
        com.bytedance.sdk.component.utils.ls.z(gVar.e() > 0, "必须设置图片素材尺寸");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z) {
        if (gVar == null) {
            return false;
        }
        return (z && !zw.g().uy(gVar.a())) || gVar.gz() > 0.0f;
    }

    private boolean z() {
        return AdSdkInitializerHolder.isSdkInitSuccess();
    }

    private void z(com.bytedance.sdk.component.uy.fo foVar, int i) {
        if (z()) {
            com.bytedance.sdk.component.uy.e.gc(foVar);
        } else {
            com.bytedance.sdk.component.uy.kb.g.wp().execute(foVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        if (this.z == null) {
            this.z = zw.getContext();
        }
        return this.z;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            com.bytedance.sdk.component.utils.wp.dl("apply->load with null ->SparseArray");
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999982);
        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetG.objectValue(1, Function.class);
        if (function == null) {
            com.bytedance.sdk.component.utils.wp.dl("apply->load with null callback");
            return null;
        }
        z(iIntValue, pluginValueSetG, function);
        return null;
    }

    public void z(int i, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function) {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z(pluginValueSet);
        zVarZ.z(1, 0);
        PluginValueSet pluginValueSetG = zVarZ.g();
        if (i == 1) {
            if (pluginValueSetG.booleanValue(2)) {
                e(pluginValueSetG, function);
                return;
            } else {
                dl(pluginValueSetG, function);
                return;
            }
        }
        if (i == 3) {
            z(pluginValueSetG, function, pluginValueSetG.intValue(3));
            return;
        }
        switch (i) {
            case 5:
                if (pluginValueSetG.booleanValue(2)) {
                    gc(pluginValueSetG, function);
                } else {
                    gz(pluginValueSetG, function);
                }
                break;
            case 6:
                z(pluginValueSetG, function);
                break;
            case 7:
                fo(pluginValueSetG, function);
                break;
            case 8:
                a(pluginValueSetG, function);
                break;
            case 9:
                if (pluginValueSetG.booleanValue(2)) {
                    m(pluginValueSetG, function);
                } else {
                    g(pluginValueSetG, function);
                }
                break;
        }
    }
}
