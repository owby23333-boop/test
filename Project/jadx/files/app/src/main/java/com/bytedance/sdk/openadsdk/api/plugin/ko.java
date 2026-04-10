package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.u;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ko implements TTInitializer {
    private static final Map<String, Bundle> b = new ConcurrentHashMap();
    public static ScheduledExecutorService mb = Executors.newSingleThreadScheduledExecutor(new ox());
    private volatile TTInitializer ox;

    private static class mb implements TTAdSdk.InitCallback {
        private TTAdSdk.InitCallback mb;

        public mb(TTAdSdk.InitCallback initCallback) {
            this.mb = initCallback;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            TTAdSdk.InitCallback initCallback = this.mb;
            if (initCallback != null) {
                initCallback.fail(i2, str);
                hj.ox(i2, str, 0L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            TTAdSdk.InitCallback initCallback = this.mb;
            if (initCallback != null) {
                initCallback.success();
            }
            hj.mb();
        }
    }

    private static TTInitializer ox(AdConfig adConfig, h hVar) {
        u uVarMb;
        BaseDexClassLoader baseDexClassLoaderMb;
        try {
            hVar.ox("call_create_initializer");
            uVarMb = u.mb(TTAppContextHolder.getContext());
            baseDexClassLoaderMb = uVarMb.mb(hVar);
        } catch (Throwable th) {
            if (th instanceof b) {
                b bVar = th;
                hj.mb(bVar.mb(), bVar.getMessage(), 0L);
            } else {
                hj.mb(6, th.getMessage(), 0L);
            }
            com.bytedance.sdk.openadsdk.api.mb.h("TTPluginManager", "Create initializer failed: " + th);
        }
        if (baseDexClassLoaderMb == null) {
            hj.mb(6, "Load plugin failed", 0L);
            com.bytedance.sdk.openadsdk.api.mb.h("TTPluginManager", "Load plugin failed");
            return null;
        }
        Class<?> clsLoadClass = baseDexClassLoaderMb.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
        hVar.ox("get_init_class_cost");
        Bundle bundle = new Bundle();
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new u.ox());
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new u.b());
        Bundle bundleMb = mb(b);
        bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundleMb);
        hVar.ox("create_bundle_cost");
        bundle.putSerializable(PluginConstants.KEY_LIVE_SDK, com.bytedance.sdk.openadsdk.live.ox.mb());
        Bundle bundleMb2 = com.bytedance.sdk.openadsdk.live.mb.mb(uVarMb, adConfig.getAppId());
        com.bytedance.sdk.openadsdk.live.ox.mb().mb(uVarMb, bundleMb2);
        if (bundleMb2 != null) {
            bundleMb.putBundle("com.byted.live.lite", bundleMb2);
        }
        hVar.ox("live_init_cost");
        Method declaredMethod = clsLoadClass.getDeclaredMethod("getInstance", Bundle.class);
        hVar.ox("get_init_method_cost");
        TTInitializer tTInitializer = (TTInitializer) declaredMethod.invoke(null, bundle);
        hVar.ox("get_init_instance_cost");
        com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", "Create initializer success");
        return tTInitializer;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        return com.bytedance.sdk.openadsdk.api.plugin.mb.mb;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            initCallback.fail(4201, "Only support >= 5.0");
            return;
        }
        u.mb(context).mb();
        if (this.ox != null) {
            this.ox.init(context, adConfig, new mb(initCallback));
        } else {
            mb(context, adConfig, new mb(initCallback), h.mb("duration"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        if (this.ox != null) {
            return this.ox.isInitSuccess();
        }
        return false;
    }

    public static void mb(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return;
        }
        b.put(str, bundle);
    }

    public static class ox implements ThreadFactory {
        private final String b;
        private final ThreadGroup mb;
        private final AtomicInteger ox;

        ox() {
            this.ox = new AtomicInteger(1);
            this.mb = new ThreadGroup("csj_g_pl_init");
            this.b = "csj_pl_init";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.mb, runnable, this.b + this.ox.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        ox(String str) {
            this.ox = new AtomicInteger(1);
            this.mb = new ThreadGroup("csj_g_pl_init");
            this.b = str;
        }
    }

    private void mb(final Context context, final AdConfig adConfig, final TTAdSdk.InitCallback initCallback, final h hVar) {
        mb.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ko.1
            @Override // java.lang.Runnable
            public void run() {
                hVar.ox("wait_asyn_cost");
                TTInitializer tTInitializerMb = ko.this.mb(adConfig, hVar);
                if (tTInitializerMb == null) {
                    initCallback.fail(4201, "No initializer");
                    return;
                }
                com.bytedance.sdk.openadsdk.api.plugin.mb.mb.mb(tTInitializerMb.getAdManager());
                tTInitializerMb.init(context, adConfig, initCallback);
                tTInitializerMb.getAdManager().register(com.bytedance.sdk.openadsdk.mb.ox.mb());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTInitializer mb(AdConfig adConfig, h hVar) {
        if (this.ox == null) {
            synchronized (this) {
                if (this.ox == null) {
                    hj.mb(adConfig);
                    com.bytedance.sdk.openadsdk.api.mb.ox("TTPluginManager", "Create initializer");
                    this.ox = ox(adConfig, hVar);
                    hVar.mb();
                    JSONObject jSONObject = new JSONObject();
                    hVar.mb(jSONObject, 20L);
                    try {
                        jSONObject.put("zeus", u.mb(TTAppContextHolder.getContext()).ox());
                    } catch (JSONException unused) {
                    }
                    adConfig.setExtra("plugin", jSONObject);
                }
            }
        }
        return this.ox;
    }

    private static final Bundle mb(Map<String, Bundle> map) {
        if (map != null && map.size() != 0) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, Bundle> entry : map.entrySet()) {
                String key = entry.getKey();
                Bundle value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    bundle.putBundle(key, value);
                }
            }
            return bundle;
        }
        return new Bundle();
    }
}
