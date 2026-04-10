package com.bytedance.msdk.m;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.media3.common.C;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.msdk.core.g;
import com.bytedance.msdk.gz.gz;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.mc;
import com.bytedance.msdk.gz.sy;
import com.bytedance.msdk.z.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static boolean dl;
    private static long e;
    private static long g;
    private static long m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f496a = new AtomicBoolean(false);
    static Runnable z = new Runnable() { // from class: com.bytedance.msdk.m.dl.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.z.gc.dl.z("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) m.m()).getQueue().size());
            m.z(dl.z, 5000L);
        }
    };
    private static final ComponentCallbacks gc = new ComponentCallbacks() { // from class: com.bytedance.msdk.m.dl.3
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.bytedance.msdk.core.gc.z.z.z().g();
        }
    };

    interface g {
        public static final String z = mc.z() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static long z() {
        return g;
    }

    public static boolean g() {
        return dl;
    }

    private static void i() {
        com.bytedance.msdk.api.a.z.fo.z zVarEo;
        if (!dl || (zVarEo = com.bytedance.msdk.core.z.kb().eo()) == null) {
            return;
        }
        zVarEo.z();
        com.bytedance.msdk.core.z.kb().z((com.bytedance.msdk.api.a.z.fo.z) null);
    }

    private static void z(boolean z2) {
        dl = z2;
        i();
    }

    public static void z(com.bytedance.msdk.api.a.z zVar, Context context) {
        z(context);
        z(zVar);
        g(context);
    }

    private static void g(final Context context) {
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        z(true);
        g = SystemClock.elapsedRealtime();
        pf();
        a.z(context.getApplicationContext());
        gz.z().dl();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pre_time", jElapsedRealtime - g);
        } catch (Throwable unused) {
        }
        p();
        try {
            jSONObject.put("cfg_time", SystemClock.elapsedRealtime() - jElapsedRealtime);
        } catch (Throwable unused2) {
        }
        dl(context);
        com.bytedance.msdk.core.g.g().z(true, jSONObject, new com.bytedance.msdk.core.m.g() { // from class: com.bytedance.msdk.m.dl.1
            @Override // com.bytedance.msdk.core.m.g
            public void z() {
                com.bytedance.msdk.core.g.g().z((com.bytedance.msdk.core.m.g) null);
                m.a(new Runnable() { // from class: com.bytedance.msdk.m.dl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.gc.dl.g(com.bytedance.msdk.core.g.getContext());
                        dl.g(context, dl.g);
                        dl.v();
                    }
                });
                dl.js();
            }
        });
        fv();
    }

    private static void dl(Context context) {
        com.bytedance.msdk.gc.dl.z(context);
        com.bytedance.msdk.gc.dl.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, long j) {
        if (!a.z()) {
            com.bytedance.msdk.z.gc.dl.z("TMe", "-----==---- 延时上报sdk_init");
            a.z(j);
        } else {
            com.bytedance.msdk.z.gc.dl.z("TMe", "-----==---- 正常上报sdk_init");
            a.g(j);
        }
    }

    private static void z(com.bytedance.msdk.api.a.z zVar) {
        com.bytedance.msdk.core.z.kb().z(zVar.v());
        com.bytedance.msdk.core.z.kb().z(System.currentTimeMillis());
        com.bytedance.msdk.core.z.kb().dl(zVar.z());
        com.bytedance.msdk.core.z.kb().m(zVar.g());
        com.bytedance.msdk.core.z.kb().dl(zVar.pf());
        com.bytedance.msdk.core.z.kb().gc(zVar.m().dl());
        com.bytedance.msdk.core.z.kb().m(zVar.m().a());
        com.bytedance.msdk.core.z.kb().z(zVar.m().g());
        com.bytedance.msdk.core.z.kb().z(zVar.m().gc());
        com.bytedance.msdk.core.z.kb().z(zVar.m().m());
        com.bytedance.msdk.core.z.kb().a(zVar.m().z());
        com.bytedance.msdk.core.z.kb().a(zVar.a());
        com.bytedance.msdk.core.z.kb().g(zVar.gc());
        com.bytedance.msdk.core.z.kb().gc(zVar.m().e());
        com.bytedance.msdk.core.z.kb().z(zVar.m().gz());
        com.bytedance.msdk.core.z.kb().z(zVar.fo(), true);
        com.bytedance.msdk.core.z.kb().e(zVar.m().fo());
        com.bytedance.msdk.core.z.kb().g(zVar.uy());
        com.bytedance.msdk.core.z.kb().dl(zVar.i());
        com.bytedance.msdk.core.z.kb().e(zVar.kb());
        com.bytedance.msdk.core.z.kb().z(zVar.wp());
        com.bytedance.msdk.core.z.kb().gz(zVar.e().g());
        com.bytedance.msdk.core.z.kb().gz(zVar.e().z());
        com.bytedance.msdk.core.z.kb().fo(zVar.e().dl());
        com.bytedance.msdk.core.z.kb().uy(zVar.e().a());
        if (zVar.i() != null) {
            try {
                com.bytedance.msdk.core.z.kb().z((List<String>) zVar.i().get(MediationConstant.GM_EXTRA_KEY_PRIME_RIT_LIST));
            } catch (Throwable unused) {
            }
        }
        if (zVar.gz() != null) {
            com.bytedance.msdk.core.z.kb().g(zVar.gz().z());
        }
    }

    public static void z(SparseArray<Object> sparseArray) {
        for (com.bytedance.msdk.z.z.a aVar : com.bytedance.msdk.m.g.g.z().dl()) {
            if (aVar != null) {
                try {
                    aVar.z(com.bytedance.msdk.core.z.kb().zw(), sparseArray);
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        }
    }

    public static String dl() {
        try {
            com.bytedance.msdk.z.z.a aVarZ = com.bytedance.msdk.m.g.g.z().z(MediationConstant.ADN_PANGLE);
            return aVarZ != null ? aVarZ.dl() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void z(Context context) {
        if (context != null) {
            com.bytedance.msdk.core.g.z(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v() {
        Application applicationZ = g.z.z();
        if (applicationZ == null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "lowMemoryListener注册失败, app = null");
            return;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "lowMemoryListener注册成功");
        ComponentCallbacks componentCallbacks = gc;
        applicationZ.unregisterComponentCallbacks(componentCallbacks);
        applicationZ.registerComponentCallbacks(componentCallbacks);
    }

    private static void pf() {
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "AppStateListener开始注册");
        com.bytedance.sdk.openadsdk.core.un.z zVarA = uy.ls().a();
        if (zVarA != null) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "AppStateListener注册成功");
            zVarA.z(new z.g() { // from class: com.bytedance.msdk.m.dl.4
                @Override // com.bytedance.sdk.openadsdk.core.un.z.g
                public void z() {
                    if (uy.ls().gk()) {
                        return;
                    }
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- AppStateListener on foreground");
                    long unused = dl.m = SystemClock.elapsedRealtime();
                    com.bytedance.msdk.core.g.z.dl();
                }

                @Override // com.bytedance.sdk.openadsdk.core.un.z.g
                public void g() {
                    if (uy.ls().gk()) {
                        return;
                    }
                    com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- AppStateListener on background");
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j = jElapsedRealtime - dl.m;
                    com.bytedance.msdk.gc.m.g(j);
                    com.bytedance.msdk.core.z.kb().g(j);
                    com.bytedance.msdk.gc.g.g.z = true;
                    if (jElapsedRealtime - dl.e < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "badkground too frequently ms: " + (jElapsedRealtime - dl.e));
                        return;
                    }
                    if (com.bytedance.msdk.gc.dl.g()) {
                        long unused = dl.e = jElapsedRealtime;
                        if (!sy.z(com.bytedance.msdk.core.g.getContext())) {
                            dl.ls();
                        } else {
                            com.bytedance.msdk.gc.dl.dl();
                        }
                    }
                }
            });
        }
        if (com.bytedance.msdk.core.z.kb().i()) {
            try {
                com.bytedance.msdk.core.g.getContext().registerReceiver(new z(), new IntentFilter("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver"), g.z, null);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ls() {
        if (com.bytedance.msdk.core.g.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(mc.z());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.bytedance.msdk.core.g.getContext().sendBroadcast(intent, g.z);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    private static class z extends BroadcastReceiver {
        private z() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || uy.ls().gk()) {
                return;
            }
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- event multi receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (sy.z(context)) {
                        com.bytedance.msdk.gc.dl.dl();
                    } else {
                        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==-- event multi receiver not in main proc");
                    }
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        }
    }

    public static void a() {
        Context context;
        if (f496a.get()) {
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("TNCManager_GroMore", "初始化TNC initTTAdNetTNC：supportTNC：" + com.bytedance.msdk.core.g.g().gk());
        if (com.bytedance.msdk.core.g.g().gk() && (context = com.bytedance.msdk.core.g.getContext()) != null) {
            try {
                com.bytedance.msdk.a.g.z().g().z(context, true, new com.bytedance.msdk.a.z(context));
            } catch (Exception unused) {
            }
            f496a.set(true);
        }
    }

    public static void gc() {
        com.bytedance.msdk.core.g.g().g(1);
        if (!f496a.get()) {
            a();
        }
        Context context = com.bytedance.msdk.core.g.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.msdk.z.gc.dl.g("TNCManager_GroMore", "尝试刷新TNC tryRefreshTNCConfig");
            com.bytedance.msdk.a.g.z().g().z(context, false);
        } catch (Exception unused) {
        }
    }

    private static void p() {
        try {
            com.bytedance.msdk.core.g.g().z(true);
        } catch (Throwable th) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    private static void fv() {
        com.bytedance.msdk.core.v.g.z(com.bytedance.msdk.core.g.g()).z(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void js() {
        if (com.bytedance.msdk.core.g.g().l()) {
            tb();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.msdk.m.dl.5
                @Override // java.lang.Runnable
                public void run() {
                    dl.tb();
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tb() {
        if (com.bytedance.msdk.core.g.g().x()) {
            Map<String, String> mapLq = com.bytedance.msdk.core.g.g().lq();
            com.bytedance.msdk.gc.m.z((com.bytedance.msdk.g.dl) null, (com.bytedance.msdk.api.z.g) null, js.z(), 1);
            com.bytedance.msdk.gc.m.z(js.z(mapLq));
        }
    }
}
