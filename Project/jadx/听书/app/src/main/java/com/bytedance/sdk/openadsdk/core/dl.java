package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.dutexplorer.tmapcloak;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class dl implements Function<SparseArray<Object>, Object> {
    private static Boolean g;
    private static AtomicBoolean m;
    private static int z;
    private com.bytedance.sdk.openadsdk.ats.m e;
    private final x dl = new x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1029a = false;
    private AtomicBoolean gc = new AtomicBoolean(false);

    public dl(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
        if (serializable instanceof Function) {
            com.bytedance.sdk.openadsdk.core.hh.z.g.z().z((Function<SparseArray<Object>, Object>) serializable);
        }
    }

    private static void z(com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar, boolean z2) {
        if (z(zVar)) {
            com.bytedance.sdk.openadsdk.tools.g.dl(1, z2 ? "1" : "0");
            z(zVar.kb());
            com.bytedance.sdk.openadsdk.tools.g.g(2, zVar.z());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.bytedance.sdk.openadsdk.tools.g.dl(2, "0");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.tools.g.dl(2, "1");
            }
            com.bytedance.sdk.openadsdk.tools.g.g(0, gk.f1105a);
        }
    }

    private static void z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar) {
        if (aVar == null || aVar.i()) {
            aVar = uy.z;
        }
        com.bytedance.sdk.openadsdk.tools.g.dl(19, aVar.i() ? "1" : "0");
        com.bytedance.sdk.openadsdk.tools.g.dl(7, String.valueOf(aVar.z() ? 1 : 0));
        com.bytedance.sdk.openadsdk.ls.dl.dl.dl dlVarFo = aVar.fo();
        String strTrim = "";
        com.bytedance.sdk.openadsdk.tools.g.dl(8, dlVarFo != null ? dlVarFo.z() + "," + dlVarFo.g() : "");
        com.bytedance.sdk.openadsdk.tools.g.dl(9, String.valueOf(aVar.dl() ? 1 : 0));
        String strUy = aVar.uy();
        com.bytedance.sdk.openadsdk.tools.g.dl(10, strUy != null ? strUy.trim() : "");
        com.bytedance.sdk.openadsdk.tools.g.dl(11, String.valueOf(aVar.a() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.g.dl(12, String.valueOf(aVar.gc() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.g.dl(17, String.valueOf(aVar.g() ? 1 : 0));
        if (gk.dl >= 4600) {
            com.bytedance.sdk.openadsdk.tools.g.dl(22, String.valueOf(aVar.m() ? 1 : 0));
        }
        if (gk.dl >= 7000) {
            com.bytedance.sdk.openadsdk.tools.g.dl(24, String.valueOf(aVar.gz() ? 1 : 0));
        }
        String strKb = aVar.kb();
        com.bytedance.sdk.openadsdk.tools.g.dl(18, strKb != null ? strKb.trim() : "");
        try {
            if (aVar.wp() != null) {
                strTrim = aVar.wp().trim();
            }
            com.bytedance.sdk.openadsdk.tools.g.dl(13, strTrim);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.wp.dl("Get oaid from controller failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m() {
        if (z == 0) {
            try {
                try {
                    Class.forName("androidx.core.content.FileProvider");
                    z = 1;
                } catch (Throwable unused) {
                    Class.forName("androidx.core.content.FileProvider");
                    z = 2;
                }
            } catch (Throwable unused2) {
                z = -1;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e() {
        if (g == null) {
            try {
                Class.forName("kotlin.Result");
                g = Boolean.TRUE;
            } catch (Throwable unused) {
                g = Boolean.FALSE;
            }
        }
        return g.booleanValue();
    }

    public static boolean z(com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar) {
        AtomicBoolean atomicBoolean = m;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z2 = zVar.gz() && com.bytedance.sdk.openadsdk.core.un.gz.z();
        m = new AtomicBoolean(z2);
        return z2;
    }

    public boolean z() {
        return this.f1029a;
    }

    public x g() {
        return this.dl;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(final android.content.Context r17, final com.bykv.vk.openvk.api.proto.PluginValueSet r18, final com.bytedance.sdk.openadsdk.core.ti.dl r19) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.dl.z(android.content.Context, com.bykv.vk.openvk.api.proto.PluginValueSet, com.bytedance.sdk.openadsdk.core.ti.dl):void");
    }

    private void z(com.bytedance.sdk.openadsdk.core.ti.dl dlVar, Throwable th) {
        if (dlVar != null) {
            String message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            dlVar.z(1, com.bytedance.sdk.openadsdk.ls.gc.z().z(false).z(4000).z(message).g());
            com.bytedance.sdk.component.utils.wp.dl("TTAdSdk", " init fail, msg = ", message);
        }
        this.f1029a = false;
    }

    private void z(PluginValueSet pluginValueSet) {
        try {
            com.bytedance.sdk.openadsdk.core.x.z.z();
        } catch (Exception unused) {
        }
    }

    private void z(com.bytedance.sdk.openadsdk.core.ti.dl dlVar) {
        com.bytedance.sdk.openadsdk.core.dl.z.z();
        if (dlVar != null) {
            dlVar.z(AVMDLDataLoader.KeyIsLiveSetP2pAllow, com.bytedance.sdk.openadsdk.ls.gc.z().z(true).z(com.bytedance.sdk.openadsdk.ls.a.z().z(20, com.bytedance.sdk.component.uy.kb.g.fo()).z(23, dl()).g()).g());
        }
    }

    public Map<String, Object> dl() {
        com.bytedance.sdk.openadsdk.ats.m mVar = this.e;
        if (mVar == null) {
            return null;
        }
        return mVar.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(Context context, com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar, com.bytedance.sdk.openadsdk.core.ti.dl dlVar, uf ufVar) {
        if (this.f1029a) {
            z(dlVar);
            return false;
        }
        try {
            if (com.bytedance.sdk.openadsdk.core.a.z.dl()) {
                if (!tmapcloak.loadLibSuccess) {
                    z(dlVar, new Exception("load maparmor fail"));
                    return false;
                }
                ufVar.g("maparmor_load_cost");
            }
            z(context, zVar, ufVar);
            this.f1029a = true;
            z(context, zVar);
            ufVar.g("async_init_cost");
            com.bytedance.sdk.component.a.z zVarG = com.bytedance.sdk.openadsdk.core.un.io.g();
            if (zVarG != null) {
                zVarG.initPglCryptUtils();
            }
            ufVar.g("armor_load_cost");
            com.bytedance.sdk.component.utils.wp.a("TTAdSdk", "Init done finish: 7105");
            z(dlVar);
        } catch (Throwable th) {
            z(dlVar, th);
        }
        z(zVar, this.f1029a);
        return true;
    }

    private void z(Context context, com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar, uf ufVar) {
        try {
            if (z(zVar)) {
                com.bytedance.sdk.openadsdk.core.un.js.z();
                com.bykv.vk.openvk.component.video.api.m.dl.z();
                com.bytedance.sdk.component.fo.z.z();
                com.bytedance.sdk.openadsdk.tools.g.g();
            }
        } catch (Throwable unused) {
        }
        ufVar.g("debug_set_cost");
        com.bytedance.sdk.openadsdk.core.multipro.a.z(context);
        ufVar.g("web_dir_cost");
        com.bytedance.sdk.component.fo.dl.z.z((ThreadPoolExecutor) com.bytedance.sdk.component.uy.e.z());
        ufVar.g("thread_pool_cost");
        com.bykv.vk.openvk.component.video.api.dl.z(zVar.uy());
        if (zVar.uy()) {
            com.bytedance.sdk.openadsdk.core.multipro.g.z();
            uy.ls().x();
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.g.g();
        }
        ufVar.g("multi_cost");
        com.bykv.vk.openvk.component.video.api.dl.z(context, null);
        com.bykv.vk.openvk.component.video.z.z.z(context);
        ufVar.g("video_config_cost");
        q.gc();
        ufVar.g("dyna_init_cost");
        com.bytedance.sdk.openadsdk.core.un.io.dl();
        ufVar.g("armor_init_cost");
    }

    private void z(com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar, PluginValueSet pluginValueSet) {
        g(zVar, pluginValueSet);
        q.a();
        com.bytedance.sdk.openadsdk.core.q.g.g();
        try {
            com.bytedance.sdk.openadsdk.core.ugeno.gc.z();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        if (zVar.uy()) {
            com.bytedance.sdk.openadsdk.core.un.x.z();
        }
        com.bytedance.sdk.openadsdk.core.dl.dl.z().z(zVar.uy());
    }

    private void g(PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                gk.g = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private void g(com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar, PluginValueSet pluginValueSet) {
        if (zVar == null) {
            return;
        }
        String strG = zVar.g();
        if (strG == null || strG.isEmpty()) {
            strG = com.bytedance.sdk.openadsdk.core.gz.z.g(zw.getContext());
        }
        uy.ls().z((Function<SparseArray<Object>, Object>) pluginValueSet.objectValue(16, Function.class));
        uy.ls().a(strG);
        uy.ls().dl(zVar.z());
        uy.ls().dl(zVar.dl());
        uy.ls().gc(zVar.a());
        uy.ls().m(zVar.gc());
        uy.ls().g(zVar.m());
        uy.ls().gc(zVar.v());
        uy.ls().a(zVar.e());
        uy.ls().z(zVar.fo());
        uy.ls().m(zVar.ls());
        uy.ls().z(zVar.kb());
        if (gk.dl >= 5500) {
            uy.ls().a(zVar.i());
            uy.ls().z(zVar.wp());
        } else {
            uy.ls().a(pluginValueSet.intValue(7));
            uy.ls().z(pluginValueSet.intValue(8));
        }
        if (z(zVar)) {
            com.bytedance.sdk.component.utils.wp.g();
            com.bytedance.sdk.openadsdk.tools.g.g();
            com.ss.android.socialbase.downloader.m.z.z(2);
        }
    }

    private void z(final Context context, final com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar) {
        com.bytedance.sdk.component.uy.e.z(new com.bytedance.sdk.component.uy.fo("init sync") { // from class: com.bytedance.sdk.openadsdk.core.dl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.kb.fo.gc();
                    com.bytedance.sdk.openadsdk.core.gk.uy uyVarG = zw.g();
                    if (!uyVarG.vy()) {
                        synchronized (uyVarG) {
                            if (!uyVarG.vy()) {
                                uyVarG.z();
                            }
                        }
                    }
                    dl.this.z(zVar.uy(), context, true, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (uy.ls().gk()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.pf.g.dl();
                        }
                    }, 120000L);
                    com.bykv.vk.openvk.component.video.api.dl.z(com.bytedance.sdk.openadsdk.core.io.gc.z().g().m());
                    com.bytedance.sdk.openadsdk.core.q.g.z(context, zVar.uy());
                    com.bytedance.sdk.openadsdk.core.kb.g.dl();
                    un.dl();
                    com.bykv.vk.openvk.component.video.z.z.z(com.bytedance.sdk.openadsdk.hh.fo.z(0));
                    if (uyVarG.kb()) {
                        final com.bykv.vk.openvk.component.video.api.z.g gVarZ = com.bytedance.sdk.openadsdk.hh.fo.z(1);
                        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("preloadTTVideo") { // from class: com.bytedance.sdk.openadsdk.core.dl.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.wp.g.g.z(context, gVarZ.a(), 52428800, com.bytedance.sdk.openadsdk.hh.fo.g(), com.bytedance.sdk.openadsdk.hh.fo.dl(), dl.z(zVar), new VideoEventEngineUploader() { // from class: com.bytedance.sdk.openadsdk.core.dl.3.2.1
                                    @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                                    public void onEvent(String str, JSONObject jSONObject) {
                                        m.z().z(str, jSONObject);
                                    }
                                });
                            }
                        });
                    }
                    com.bytedance.sdk.openadsdk.core.un.kb.pf();
                    q.z(context);
                    com.bytedance.sdk.component.uy.e.z(true);
                    com.bytedance.sdk.component.uy.e.z(new com.bytedance.sdk.openadsdk.core.q.g.z());
                    com.bytedance.sdk.openadsdk.core.dislike.g.z();
                    com.bytedance.sdk.openadsdk.core.un.kb.z(context);
                    com.bytedance.sdk.openadsdk.z.g.g.dl(context);
                    com.bytedance.sdk.openadsdk.core.un.kb.gc(context);
                    com.bytedance.sdk.openadsdk.wp.a.z(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.bytedance.sdk.component.utils.js.z();
                            com.bytedance.sdk.component.utils.v.z(new com.bytedance.sdk.openadsdk.hh.gc());
                        } catch (Exception unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.un.v.z();
                    com.bytedance.sdk.openadsdk.core.un.gz.z(zVar);
                    com.bytedance.sdk.openadsdk.core.un.io.z();
                    com.bytedance.sdk.openadsdk.core.eo.z.z().z(context);
                    com.bytedance.sdk.openadsdk.core.un.un.z();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.g("TTAdSdk", "Unexpected asyn init error: ".concat(String.valueOf(th)));
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final boolean z2, final Context context, final boolean z3, long j) {
        com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dl.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.live.g.z();
                if (z2) {
                    if (com.bytedance.sdk.component.utils.p.z(context)) {
                        com.bytedance.sdk.openadsdk.core.gk.gz.z(zw.g()).dl();
                        com.bytedance.sdk.component.utils.wp.z("TTAdSdk", "Load setting in main process");
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.gk.gz.z(zw.g()).dl();
                }
                if (z3) {
                    com.bytedance.sdk.openadsdk.core.q.g.a();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final Context context, final long j, final long j2, final long j3, final uf ufVar, final boolean z2, final com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar, final String str, final int i, final PluginValueSet pluginValueSet, final com.bytedance.sdk.openadsdk.core.gk.e eVar) {
        com.bytedance.sdk.component.utils.gz.z().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dl.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    dl.this.g(context, j, j2, j3, ufVar, z2, zVar, str, i, pluginValueSet, eVar);
                } catch (Throwable unused) {
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final Context context, final long j, final long j2, final long j3, final uf ufVar, final boolean z2, final com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar, final String str, final int i, final PluginValueSet pluginValueSet, final com.bytedance.sdk.openadsdk.core.gk.e eVar) {
        q.dl();
        if (zw.g().lw()) {
            com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.dl.6
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    boolean zTb = uy.ls().tb();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", j);
                    jSONObject.put("is_async", z2);
                    jSONObject.put("is_multi_process", zVar.uy());
                    jSONObject.put("is_debug", dl.z(zVar));
                    jSONObject.put("is_activate_init", zTb);
                    jSONObject.put("is_plugin", gk.z());
                    jSONObject.put("has_kotlin", dl.e());
                    jSONObject.put("use_mediation", zVar.ls());
                    jSONObject.put("is_androidx", dl.m());
                    jSONObject.put("host_abi", com.bytedance.sdk.openadsdk.core.hh.g.g.z());
                    jSONObject.put("minSdkVersion", com.bytedance.sdk.openadsdk.core.un.eo.a(context));
                    jSONObject.put("targetSdkVersion", com.bytedance.sdk.openadsdk.core.un.eo.dl(context));
                    jSONObject.put("ttvideo_plugin_config", true);
                    jSONObject.put("ttvideo_can_use", gk.a());
                    jSONObject.put("is_keva_init_success", com.bytedance.sdk.openadsdk.core.un.x.g());
                    jSONObject.put("thread_name", str);
                    jSONObject.put("thread_priority", i);
                    jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.a.z.a());
                    jSONObject.put("opt_config", String.valueOf(eVar));
                    uy.ls().g(false);
                    Object objObjectValue = pluginValueSet.objectValue(9, Object.class);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("main_cost", j);
                    jSONObject2.put("callback_cost", j2);
                    jSONObject2.put("total_cost", j3);
                    if (objObjectValue != null) {
                        jSONObject2.put("plugin", objObjectValue);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    ufVar.z(jSONObject3, 20L);
                    jSONObject2.put("init", jSONObject3);
                    jSONObject.put("cost", jSONObject2);
                    if (!zVar.ls()) {
                        try {
                            Object objInvoke = Class.forName("com.baidu.mobads.sdk.api.AdSettings").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke instanceof String) {
                                jSONObject.put("baidu_version", objInvoke);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            Object objInvoke2 = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke2 instanceof String) {
                                jSONObject.put("gdt_version", objInvoke2);
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object objInvoke3 = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke3 instanceof String) {
                                jSONObject.put("ks_version", objInvoke3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                    Object objGz = dl.this.gz();
                    if (objGz != null) {
                        jSONObject.put("develop_type", objGz);
                    }
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("pangle_sdk_init").g(jSONObject.toString()).gc(new StringBuilder().append(j2).toString());
                }
            }, "pangle_sdk_init");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String gz() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.android.NativeAdManager");
                return MediationConstant.ADN_UNITY;
            } catch (Throwable unused) {
                return "unity_pure";
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        switch (pluginValueSetG.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(z());
            case -999001:
                z((Context) pluginValueSetG.objectValue(-998000, Context.class), pluginValueSetG, new com.bytedance.sdk.openadsdk.core.ti.dl((Function) pluginValueSetG.objectValue(15, Function.class)));
                return null;
            case -999000:
                return this.dl;
            default:
                return null;
        }
    }
}
