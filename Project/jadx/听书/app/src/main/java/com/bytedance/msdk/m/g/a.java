package com.bytedance.msdk.m.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.adapter.ks.BuildConfig;
import com.bytedance.msdk.api.a.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.core.ti.a implements com.bytedance.msdk.z.z.a {
    private String dl;
    private Function<SparseArray<Object>, Object> g;
    private Function<SparseArray<Object>, Object> gc;
    private com.bytedance.msdk.api.a.dl m;
    private dl z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<com.bytedance.msdk.z.z.dl> f497a = new CopyOnWriteArrayList();
    private long e = 0;
    private int gz = 0;

    @Override // com.bytedance.msdk.z.z.a
    public String dl() {
        return null;
    }

    public a() {
        dl dlVarZ = dl.z(com.bytedance.msdk.core.z.kb().ti());
        this.z = dlVarZ;
        this.g = dlVarZ.z();
    }

    @Override // com.bytedance.msdk.z.z.g
    public void z(Context context, Map<String, Object> map, com.bytedance.msdk.z.z.dl dlVar) {
        if (!this.f497a.contains(dlVar)) {
            this.f497a.add(dlVar);
        }
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        gc.z(aVarZ);
        aVarZ.z(3, map.get(PluginConstants.KEY_APP_ID));
        aVarZ.z(8550, Boolean.valueOf(com.bytedance.msdk.core.z.kb().tb()));
        aVarZ.z(8, com.bytedance.msdk.core.z.kb().fv());
        aVarZ.z(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold, map.get("app_key"));
        String str = (String) map.get(MediationConstant.EXTRA_ADN_NAME);
        this.dl = str;
        aVarZ.z(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, z(str));
        aVarZ.z(8560, g(this.dl));
        aVarZ.z(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec, map.get(MediationConstant.EXTRA_ADN_NAME));
        aVarZ.z(8410, BuildConfig.ADAPTER_VERSION);
        aVarZ.z(8411, com.bytedance.msdk.g.g.dl());
        aVarZ.z(8412, "17.2.0.71");
        aVarZ.z(8413, "9.3941.0");
        aVarZ.z(8414, com.bytedance.msdk.adapter.gdt.BuildConfig.ADAPTER_VERSION);
        aVarZ.z(8415, "2.11.0.3.32");
        aVarZ.z(8417, "4.24.0.0");
        aVarZ.z(8418, "4.3.0.38");
        aVarZ.z(8416, "16.6.57.14");
        aVarZ.z(8558, "2.11.0.3.32");
        aVarZ.z(7, Integer.valueOf(fo()));
        aVarZ.z(8425, map);
        aVarZ.z(8300, this);
        try {
            Function<SparseArray<Object>, Object> functionDl = com.bytedance.msdk.core.z.z.gc.dl(this.dl);
            if (functionDl != null) {
                this.gc = functionDl;
                functionDl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8240).z(Void.class).z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).z(8424, aVarZ.g()).g());
            } else {
                aVarZ.z(AVMDLDataLoader.KeyIsLiveLoaderEnable).z(Void.class);
                this.g.apply(aVarZ.g());
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private int fo() {
        com.bytedance.msdk.z.dl.dl dlVarG = com.bytedance.msdk.core.z.kb().g();
        if (dlVarG != null) {
            return dlVarG.uf();
        }
        return 0;
    }

    public static String z(String str) {
        str.hashCode();
        switch (str) {
            case "klevin":
                return MediationConstant.KLEVIN_ADN_CLASS_NAME;
            case "sigmob":
                return MediationConstant.SIGMOB_ADN_CLASS_NAME;
            case "xiaomi":
                return MediationConstant.XIAOMI_ADN_CLASS_NAME;
            case "ks":
                return MediationConstant.KS_ADN_CLASS_NAME;
            case "gdt":
                return MediationConstant.GDT_ADN_CLASS_NAME;
            case "admob":
                return MediationConstant.ADMOB_ADN_CLASS_NAME;
            case "baidu":
                return MediationConstant.BAIDU_ADN_CLASS_NAME;
            case "unity":
                return MediationConstant.UNITY_ADN_CLASS_NAME;
            case "mintegral":
                return MediationConstant.MINTEGRAL_ADN_CLASS_NAME;
            default:
                return null;
        }
    }

    public static String g(String str) {
        str.hashCode();
        switch (str) {
            case "sigmob":
                return "a.b.c.d.e.f.sob.SobFunction";
            case "xiaomi":
                return "a.b.c.d.e.f.xmi.XmiFunction";
            case "ks":
                return "a.b.c.d.e.f.kou.KouFunction";
            case "gdt":
                return "a.b.c.d.e.f.gng.GngFunction";
            case "admob":
                return "a.b.c.d.e.f.aob.AobFunction";
            case "baidu":
                return "a.b.c.d.e.f.bdu.BduFunction";
            case "unity":
                return "a.b.c.d.e.f.uty.UtyFunction";
            case "mintegral":
                return "a.b.c.d.e.f.mal.MalFunction";
            default:
                return null;
        }
    }

    @Override // com.bytedance.msdk.z.z.a
    public String z() {
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable).z(String.class).g());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    @Override // com.bytedance.msdk.z.z.a
    public String z(Context context, Map<String, Object> map) {
        if (this.gc != null) {
            Object objApply = this.gc.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8102).z(String.class).z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).z(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).g());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.z.z.a
    public Map<String, Object> g(Context context, Map<String, Object> map) {
        if (this.gc != null) {
            Object objApply = this.gc.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsLiveGetLoaderType).z(String.class).z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).z(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).g());
            if (objApply instanceof Map) {
                return (Map) objApply;
            }
        }
        return null;
    }

    public String gz() {
        return this.dl;
    }

    @Override // com.bytedance.msdk.z.z.a
    public String g() {
        try {
            Function<SparseArray<Object>, Object> function = this.gc;
            if (function != null) {
                Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8104).z(String.class).g());
                return objApply instanceof String ? (String) objApply : "";
            }
        } catch (Throwable th) {
            wp.z(th);
        }
        return "";
    }

    @Override // com.bytedance.msdk.z.z.a
    public void z(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8242).z(Void.class).z(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).g());
        }
    }

    @Override // com.bytedance.msdk.z.z.a
    public int z(com.bytedance.msdk.api.a.dl dlVar) {
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function != null) {
            this.m = dlVar;
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8126).z(Integer.class).g());
            if (objApply != null) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.msdk.z.z.a
    public void z(v vVar, SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> function = this.gc;
        if (function == null || vVar == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8124).z(Void.class).z(8517, sparseArray).g());
    }

    @Override // com.bytedance.msdk.z.z.a
    public void a() {
        try {
            if (com.bytedance.msdk.core.z.z.gc.dl(gz()) != null) {
                uy();
            } else {
                kb();
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private void uy() {
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", gz() + "版本号：" + g() + " , 聚合版本号：" + com.bytedance.sdk.gromore.init.z.dl());
    }

    private void kb() {
        String strDl = com.bytedance.sdk.gromore.init.z.dl();
        if (!TextUtils.isEmpty(z())) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK_SDK_Init", gz() + "版本号：" + g() + " , " + gz() + "Adapter版本号：" + z() + " , 聚合版本号：" + strDl);
        } else {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK_SDK_Init", gz() + "版本号：" + g() + " , ***" + gz() + "Adapter未接入，请检查***, 聚合版本号：" + strDl);
        }
    }

    @Override // com.bytedance.msdk.z.z.a
    public long gc() {
        return this.e;
    }

    @Override // com.bytedance.msdk.z.z.a
    public int m() {
        return this.gz;
    }

    @Override // com.bytedance.msdk.z.z.a
    public void e() {
        this.gz = 0;
        this.e = 0L;
    }

    private void wp() {
        Iterator<com.bytedance.msdk.z.z.dl> it = this.f497a.iterator();
        while (it.hasNext()) {
            it.next().z();
        }
        this.f497a.clear();
    }

    private void z(com.bytedance.msdk.api.z zVar) {
        Iterator<com.bytedance.msdk.z.z.dl> it = this.f497a.iterator();
        while (it.hasNext()) {
            it.next().z(zVar);
        }
        this.f497a.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8122) {
            this.gc = (Function) pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Function.class);
            wp();
        } else if (i == 8123) {
            SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class);
            }
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(8022, SparseArray.class);
            }
            if (sparseArray != null) {
                PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z((SparseArray<Object>) sparseArray).g();
                z(new com.bytedance.msdk.api.z(pluginValueSetG.intValue(-999900), pluginValueSetG.stringValue(-999901)));
                return null;
            }
        } else if (i == 8212) {
            if (this.m != null) {
                this.m.z(pluginValueSet.intValue(8095));
            }
        } else if (i == 8266) {
            this.gc = (Function) pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Function.class);
        } else if (i == 8270) {
            this.gz = pluginValueSet.intValue(8557);
            this.e = pluginValueSet.longValue(8556) - pluginValueSet.longValue(8555);
        }
        return null;
    }
}
