package com.bytedance.sdk.openadsdk.core.sy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.an;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements dl, z.g, Function {
    private Function<SparseArray<Object>, Object> dl;
    private AtomicBoolean z = new AtomicBoolean(false);
    private AtomicBoolean g = new AtomicBoolean(false);

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            init((Context) sparseArray.get(1), (Function) sparseArray.get(2));
            return null;
        }
        if (iIntValue == 2) {
            return Boolean.valueOf(isPitayaEnvAvailable());
        }
        if (iIntValue == 3) {
            return Boolean.valueOf(isPitayaInitSuccess());
        }
        if (iIntValue == 4) {
            runTask((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (Function) sparseArray.get(3));
            return null;
        }
        if (iIntValue != 6) {
            return null;
        }
        queryPackage((String) sparseArray.get(1), (Function) sparseArray.get(2));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, gc gcVar) {
        com.bytedance.sdk.openadsdk.core.q.v.z().z(j, gcVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.bytedance.sdk.openadsdk.core.un.z zVarA = com.bytedance.sdk.openadsdk.core.uy.ls().a();
        if (zVarA != null) {
            zVarA.z(this);
        }
    }

    private Function<SparseArray<Object>, Object> gc() {
        Function<SparseArray<Object>, Object> functionZ = zw.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (functionZ != null && isPitayaInitSuccess()) {
            return functionZ;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void z() {
        Function<SparseArray<Object>, Object> functionGc;
        try {
            if (com.bytedance.sdk.openadsdk.core.uy.ls().gk() || (functionGc = gc()) == null) {
                return;
            }
            functionGc.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(1008).z(Void.class).z(36, 0).g());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.un.z.g
    public void g() {
        Function<SparseArray<Object>, Object> functionGc;
        try {
            if (com.bytedance.sdk.openadsdk.core.uy.ls().gk() || (functionGc = gc()) == null) {
                return;
            }
            functionGc.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(1008).z(Void.class).z(36, 1).g());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public boolean isPitayaInitSuccess() {
        return this.g.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public void runTask(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> functionZ = zw.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (functionZ == null) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8).z(Void.class).z(-99999979, com.bytedance.sdk.openadsdk.ls.gc.z().z(-6).z(false).z("predict bridge is null").z(com.bytedance.sdk.openadsdk.ls.a.z().z(5, str).g()).g()).g());
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("run_package_start", System.currentTimeMillis());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        functionZ.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(1003).z(Void.class).z(25, str).z(26, jSONObject).z(1, function).z(37, jSONObject2).g());
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public void init(Context context, final Function<SparseArray<Object>, Object> function) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (zw.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(-1).z(Void.class).g());
                return;
            }
            return;
        }
        if (isPitayaInitSuccess()) {
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(0).z(Void.class).g());
                return;
            }
            return;
        }
        try {
            if (this.z.compareAndSet(false, true)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("aid", "1371");
                jSONObject.put("channel", gk.e);
                jSONObject.put("core_api_version", gk.f1105a);
                jSONObject.put("core_plugin_version", "7.1.0.5");
                jSONObject.put("debug", false);
                jSONObject.put("update", true);
                jSONObject.put("download_concurrency", 2);
                jSONObject.put("py_concurrency", 2);
                jSONObject.put("provide_applog", true);
                jSONObject.put("sdk_session_id", com.bytedance.sdk.openadsdk.core.q.g.z);
                m();
                function.apply(com.bytedance.sdk.openadsdk.ls.a.z(com.bykv.z.z.z.z.z.z().z(21, jSONObject).z(22, context).z(38, this.dl).z(1, new gz() { // from class: com.bytedance.sdk.openadsdk.core.sy.m.1
                    @Override // com.bytedance.sdk.openadsdk.core.sy.gz
                    protected PluginValueSet z(int i, gc gcVar) {
                        m.this.g.set(gcVar.z());
                        if (!gcVar.z()) {
                            if (gcVar.g() != null) {
                                com.bytedance.sdk.component.utils.wp.a("pitaya_ext_plugin", "pit error:" + gcVar.g().toString());
                            }
                            Function function2 = function;
                            if (function2 != null) {
                                function2.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(-1).z(Void.class).g());
                            }
                        } else {
                            Function function3 = function;
                            if (function3 != null) {
                                function3.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(0).z(Void.class).g());
                            }
                            m.this.a();
                        }
                        m.this.z(System.currentTimeMillis() - jCurrentTimeMillis, gcVar);
                        return super.z(i, gcVar);
                    }
                }).z(13, com.bytedance.sdk.component.uy.e.z()).g().sparseArray()).z(1001).z(Void.class).g());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a("pitaya_ext_plugin", "pit#initPit:" + th.getMessage());
            if (function != null) {
                function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(-1).z(Void.class).g());
            }
        }
    }

    private void m() {
        if (this.dl == null) {
            this.dl = new gz() { // from class: com.bytedance.sdk.openadsdk.core.sy.m.2
                @Override // com.bytedance.sdk.openadsdk.core.sy.gz, com.bytedance.sdk.openadsdk.core.ti.a
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    com.bytedance.sdk.openadsdk.ls.z zVar = new com.bytedance.sdk.openadsdk.ls.z((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
                    try {
                        if (i == 1) {
                            JSONObject jSONObject = (JSONObject) zVar.a().objectValue(10, JSONObject.class);
                            z.z().z(jSONObject.optString(an.e), jSONObject.optString("key"), jSONObject.optString("value"));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", true);
                            return (T) com.bytedance.sdk.openadsdk.ls.a.z().z(37, jSONObject2).g();
                        }
                        if (i == 2) {
                            JSONObject jSONObject3 = (JSONObject) zVar.a().objectValue(10, JSONObject.class);
                            String strOptString = jSONObject3.optString(an.e);
                            String strOptString2 = jSONObject3.optString("key");
                            String strZ = z.z().z(strOptString, strOptString2);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(strOptString2, strZ);
                            return (T) com.bytedance.sdk.openadsdk.ls.a.z().z(37, jSONObject4).g();
                        }
                        return (T) super.applyFunction(i, pluginValueSet, cls);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                        return (T) com.bytedance.sdk.openadsdk.ls.a.z().z(37, new JSONObject()).g();
                    }
                }
            };
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public boolean isPitayaEnvAvailable() {
        if (!gk.z() || gk.dl < 5003 || Build.VERSION.SDK_INT < 28) {
            return false;
        }
        if (dl() && Build.VERSION.SDK_INT == 29) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.tb.g.g(zw.g().x());
    }

    public boolean dl() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public void queryPackage(String str, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> functionZ = zw.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB);
        if (functionZ != null) {
            com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
            zVarZ.z(1, function);
            zVarZ.z(25, str);
            functionZ.apply(com.bytedance.sdk.openadsdk.ls.a.z(zVarZ.g().sparseArray()).z(1004).z(Void.class).g());
        }
    }
}
