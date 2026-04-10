package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.android.openliveplugin.process.LiveProcessUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.component.uy.kb;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.plugin.fo;
import com.bytedance.sdk.openadsdk.api.z;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends com.bytedance.sdk.openadsdk.api.z {
    private static final z z = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f901a;
    private boolean e;
    private SharedPreferences gc;
    private volatile Initializer g = gc();
    private volatile Initializer dl = null;
    private boolean m = false;
    private com.bytedance.sdk.openadsdk.dl.dl gz = new com.bytedance.sdk.openadsdk.dl.dl() { // from class: com.bytedance.sdk.openadsdk.api.plugin.uy.1
        @Override // com.bytedance.sdk.openadsdk.dl.dl
        public Function<SparseArray<Object>, Object> z(int i) {
            return uy.this.z(i);
        }
    };

    @Override // com.bytedance.sdk.openadsdk.api.z
    protected boolean g(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        super.g(context, adConfig, initCallback);
        this.f901a = e.z("duration");
        boolean z2 = false;
        try {
            if (LiveProcessUtils.inLiveProcess(TTAppContextHolder.getContext()).booleanValue()) {
                return false;
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.m.g("_tt_ad_sdk_", e);
        }
        if (com.bytedance.sdk.openadsdk.api.gc.z()) {
            g(com.bykv.z.z.z.z.g.z().z(false).z(4204).z("Only support >= 7.0").g());
            return false;
        }
        if (adConfig != null && adConfig.isDebug()) {
            z2 = true;
        }
        this.e = z2;
        m.z(adConfig);
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.z
    protected void z(Result result) {
        super.z(result);
        m.z();
    }

    public boolean a() {
        if (this.gc == null) {
            this.gc = com.bytedance.sdk.openadsdk.api.plugin.g.g(TTAppContextHolder.getContext(), "sp_bidding_opt_libra", 0);
        }
        return this.gc.getInt("_use_pl_", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.api.z
    public boolean z(Context context, com.bykv.z.z.z.z.dl dlVar) {
        if (z(context) && a()) {
            com.bytedance.sdk.openadsdk.api.m.dl("_tt_ad_sdk_", "use pl Init");
            return false;
        }
        if (com.bytedance.sdk.openadsdk.api.plugin.dl.dl.g()) {
            com.bytedance.sdk.openadsdk.api.m.gc("_tt_ad_sdk_", "this device does not support arm64-v8a abi");
            return false;
        }
        if (this.g != null) {
            this.m = true;
            z(this.g.getManager(), false);
            this.g.init(context, dlVar.g());
            return false;
        }
        g(com.bykv.z.z.z.z.g.z().z(false).z(4206).g());
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.z
    public void g(Context context, com.bykv.z.z.z.z.dl dlVar) {
        com.bytedance.sdk.openadsdk.api.m.dl("_tt_ad_sdk_", "async init");
        boolean z2 = this.m;
        this.f901a.g("wait_asyn_cost");
        if (com.bytedance.sdk.openadsdk.api.plugin.dl.dl.g() || z(context)) {
            com.bytedance.sdk.openadsdk.api.m.a("_tt_ad_sdk_", "start pl load");
            z(this.f901a, dlVar);
        } else {
            com.bytedance.sdk.openadsdk.api.m.a("_tt_ad_sdk_", "no pl");
            e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.z
    public boolean z() {
        return (com.bytedance.sdk.openadsdk.api.gc.z() || this.g == null || !this.g.isInitSuccess()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.z
    public z.dl g() {
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.api.z
    protected com.bytedance.sdk.openadsdk.dl.dl dl() {
        return this.gz;
    }

    private boolean z(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.g.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Function<SparseArray<Object>, Object> z(int i) {
        if (i == 2) {
            return com.bytedance.sdk.openadsdk.live.dl.z();
        }
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.downloadnew.dl.z(TTAppContextHolder.getContext());
        }
        if (i != 4) {
            return null;
        }
        return com.bytedance.sdk.openadsdk.api.plugin.z.z.z();
    }

    private static Initializer gc() {
        try {
            Class<?> clsLoadClass = TTAdSdk.class.getClassLoader().loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
            Bundle bundle = new Bundle();
            bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new fo.dl());
            bundle.putInt("api_sdk_version", 7105);
            return new com.bytedance.sdk.openadsdk.api.a((Function) clsLoadClass.getDeclaredMethod("getNewInstance", Bundle.class).invoke(null, bundle));
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.z(th);
            com.bytedance.sdk.openadsdk.api.m.gc("_tt_ad_sdk_", "Get direct initializer failed");
            return null;
        }
    }

    private class g implements Function<SparseArray<Object>, Object> {
        private g() {
        }

        public ValueSet z(int i, Result result) {
            com.bytedance.sdk.openadsdk.api.m.dl("bstsdk", "Load p_init: " + result.code() + ", message: " + result.message());
            if (result.isSuccess() && uy.this.dl != null) {
                if (uy.this.m && uy.this.g != null && uy.this.g.isInitSuccess()) {
                    uy uyVar = uy.this;
                    uyVar.z(uyVar.g.getManager(), result);
                }
                uy uyVar2 = uy.this;
                uyVar2.g = uyVar2.dl;
                uy uyVar3 = uy.this;
                uyVar3.z(uyVar3.g.getManager(), true);
            }
            if (!uy.this.m) {
                uy.this.g(result);
            }
            if (!result.isSuccess() || uy.this.dl == null) {
                return null;
            }
            uy.this.m();
            return null;
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
            int iIntValue = valueSetG.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetG.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 != null) {
                ValueSet valueSetG2 = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) sparseArray2).g();
                z(iIntValue, com.bykv.z.z.z.z.g.z().z(valueSetG2.intValue(-999900)).z(valueSetG2.stringValue(-999901)).z(valueSetG2.booleanValue(-999903)).z(com.bykv.z.z.z.z.dl.z((SparseArray<Object>) valueSetG2.objectValue(-999902, SparseArray.class)).g()).g());
            }
            return null;
        }
    }

    private void z(e eVar, com.bykv.z.z.z.z.dl dlVar) {
        if (this.dl == null || !this.dl.isInitSuccess()) {
            com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z(dlVar.g().sparseArray());
            dlVarZ.z(15, new g());
            try {
                if (this.dl == null) {
                    synchronized (dl.class) {
                        if (this.dl == null) {
                            Initializer initializerZ = dl.z.z(eVar);
                            this.dl = initializerZ;
                            z(initializerZ, eVar, dlVarZ);
                        }
                    }
                }
            } catch (a e) {
                com.bytedance.sdk.openadsdk.api.m.a("bstsdk", "Load p_init failed: " + e.z() + ", message: " + e.getMessage());
                m.z(e.z(), e.getMessage(), 0L);
                if (this.m) {
                    return;
                }
                com.bytedance.sdk.openadsdk.api.m.gc("bstsdk", "finishInit, pl_error: " + e.getMessage());
                g(com.bykv.z.z.z.z.g.z().z(false).z(e.z()).z(e.getMessage()).g());
            } catch (Exception e2) {
                m.z(4206, "Load p_init failed: " + e2.getMessage(), 0L);
                com.bytedance.sdk.openadsdk.api.m.a("_tt_ad_sdk_", "Load p_init failed: " + e2.getMessage());
                if (this.m) {
                    return;
                }
                com.bytedance.sdk.openadsdk.api.m.gc("bstsdk", "finishInit, error: " + e2.getMessage());
                g(com.bykv.z.z.z.z.g.z().z(false).z(4206).z(e2.getMessage()).g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Manager manager, Result result) {
        if (manager == null || !(manager instanceof com.bytedance.sdk.openadsdk.api.dl)) {
            return;
        }
        Function<SparseArray<Object>, Object> functionZ = ((com.bytedance.sdk.openadsdk.api.dl) manager).z(1);
        if (functionZ instanceof Function) {
            functionZ.apply(com.bykv.z.z.z.z.dl.z(1).z(-99999987, 16).z(-99999985, Void.class).z(17, true).z(21, result.values() == null ? null : result.values().sparseArray()).g().sparseArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ExecutorService executorService = (ExecutorService) z(ExecutorService.class, 1);
        if (executorService != null && (executorService instanceof ThreadPoolExecutor)) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            kb.g.z(threadPoolExecutor);
            com.bytedance.sdk.openadsdk.fv.z.z().z(threadPoolExecutor);
        }
        ExecutorService executorService2 = (ExecutorService) z(ExecutorService.class, 2);
        if (executorService2 != null) {
            kb.g.g((ThreadPoolExecutor) executorService2);
        }
        ExecutorService executorService3 = (ExecutorService) z(ExecutorService.class, 3);
        if (executorService3 != null) {
            kb.g.z((ScheduledExecutorService) executorService3);
        }
    }

    private <T> T z(Class<T> cls, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("action", i);
        return (T) g().getExtra(cls, bundle);
    }

    private static void z(Initializer initializer, e eVar, com.bykv.z.z.z.z.dl dlVar) throws a {
        if (initializer != null) {
            try {
                eVar.z();
                JSONObject jSONObject = new JSONObject();
                eVar.z(jSONObject, 20L);
                jSONObject.put("zeus", fo.z(TTAppContextHolder.getContext()).z());
                dlVar.z(17, com.bytedance.sdk.openadsdk.fv.z.z().g());
                dlVar.z(20, kb.g.fo());
                dlVar.z(19, kb.g.uy());
                dlVar.z(21, kb.g.wp());
                dlVar.z(22, new com.bytedance.sdk.openadsdk.ats.dl());
                initializer.init(TTAppContextHolder.getContext(), dlVar.z(9, jSONObject).g());
                if (TTAppContextHolder.getContext() != null) {
                    Zeus.hookHuaWeiVerifier((Application) TTAppContextHolder.getContext().getApplicationContext());
                }
                com.bytedance.sdk.openadsdk.api.m.g("_tt_ad_sdk_", "Initialized done");
                return;
            } catch (Exception e) {
                Zeus.unInstallPlugin("com.byted.pangle");
                throw new a(4207, "Init error: " + e.getMessage());
            }
        }
        throw new a(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, "Init error");
    }

    private void e() {
        try {
            com.bytedance.sdk.openadsdk.api.m.dl("_tt_ad_sdk_", "istl push pl start");
            if (this.e) {
                fo.z(TTAppContextHolder.getContext()).g();
            }
            com.bytedance.sdk.openadsdk.api.m.dl("_tt_ad_sdk_", "istl push pl done");
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.m.gc("_tt_ad_sdk_", "istl err: " + th.getMessage());
            com.bytedance.sdk.openadsdk.api.m.z(th);
        }
    }

    private static final class dl {
        private static final dl z = new dl();
        private volatile Initializer g;

        private dl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Initializer z(e eVar) throws a {
            if (this.g == null) {
                synchronized (this) {
                    if (this.g == null) {
                        this.g = g(eVar);
                    }
                }
            }
            return this.g;
        }

        private static Initializer g(e eVar) throws a {
            try {
                eVar.g("call_create_initializer");
                BaseDexClassLoader baseDexClassLoaderZ = fo.z(TTAppContextHolder.getContext()).z(eVar, 60000);
                if (baseDexClassLoaderZ == null) {
                    throw new a(4205, "Get initializer failed");
                }
                Class<?> clsLoadClass = baseDexClassLoaderZ.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
                eVar.g("get_init_class_cost");
                Bundle bundle = new Bundle();
                bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER, new fo.dl());
                bundle.putInt("api_sdk_version", 7105);
                eVar.g("create_bundle_cost");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getNewInstance", Bundle.class);
                eVar.g("get_init_method_cost");
                try {
                    com.bytedance.sdk.openadsdk.api.a aVar = new com.bytedance.sdk.openadsdk.api.a((Function) declaredMethod.invoke(null, bundle));
                    eVar.g("get_init_instance_cost");
                    com.bytedance.sdk.openadsdk.api.m.g("TTPluginManager", "Create initializer success");
                    return aVar;
                } catch (Throwable th) {
                    Zeus.unInstallPlugin("com.byted.pangle");
                    throw th;
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.openadsdk.api.m.a("TTPluginManager", "Create initializer failed");
                if (th2 instanceof a) {
                    throw th2;
                }
                com.bytedance.sdk.openadsdk.api.m.z(th2);
                throw new a(4206, th2.getMessage());
            }
        }
    }

    private static final class z extends z.dl {
        private z() {
        }

        @Override // com.bytedance.sdk.openadsdk.api.z.dl
        protected void z(Throwable th) {
            fo.z(th);
        }

        @Override // com.bytedance.sdk.openadsdk.api.z.dl
        protected Object z(Object obj) {
            boolean z = obj instanceof TTPluginListener;
            if (z) {
                fo.z(TTAppContextHolder.getContext()).z((TTPluginListener) obj);
            }
            if (z) {
                TTPluginListener tTPluginListener = (TTPluginListener) obj;
                return fo.z(TTAppContextHolder.getContext()).z(tTPluginListener.packageName(), tTPluginListener.config());
            }
            if (obj instanceof ILiveAdCustomConfig) {
                return com.bytedance.sdk.openadsdk.live.dl.z((ILiveAdCustomConfig) obj);
            }
            return com.bytedance.sdk.openadsdk.l.g.z(obj) ? new com.bytedance.sdk.openadsdk.l.g(obj) : obj;
        }
    }
}
