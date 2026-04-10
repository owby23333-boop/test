package com.bytedance.sdk.openadsdk.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.funny.audio.core.utils.FileUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class un {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final un f1371a = new un();
    private static int e = -1;
    private static String fo = "ext_plugin";
    private Function<SparseArray<Object>, Object> gz;
    private volatile Function<SparseArray<Object>, Object> z = null;
    private volatile Function<SparseArray<Object>, Object> g = null;
    private volatile Function<SparseArray<Object>, Object> dl = null;
    private AtomicBoolean gc = new AtomicBoolean(false);
    private AtomicBoolean m = new AtomicBoolean(false);

    private un() {
    }

    public static un z() {
        return f1371a;
    }

    public Function<SparseArray<Object>, Object> z(int i) {
        try {
            if (gk.z() && i == 10003) {
                return e();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return null;
    }

    public static int g() {
        if (e == -1) {
            e = z().m().intValue();
        }
        return e;
    }

    private Integer m() {
        Function<SparseArray<Object>, Object> functionWp = wp();
        if (functionWp != null) {
            Object objApply = functionWp.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(1004).z(Integer.class).g());
            if (objApply instanceof Integer) {
                return (Integer) objApply;
            }
        }
        return -1;
    }

    private Function<SparseArray<Object>, Object> e() {
        com.bytedance.sdk.openadsdk.core.sy.dl dlVar = (com.bytedance.sdk.openadsdk.core.sy.dl) com.bytedance.sdk.openadsdk.ats.dl.z("pitaya");
        if (dlVar == null || !dlVar.isPitayaEnvAvailable()) {
            com.bytedance.sdk.component.utils.wp.a(fo, "can use pitaya false");
            return null;
        }
        if (!a() || m().intValue() < 1100) {
            return null;
        }
        if (this.dl == null) {
            synchronized (un.class) {
                if (this.dl == null) {
                    try {
                        Function<SparseArray<Object>, Object> functionWp = wp();
                        if (functionWp != null) {
                            Object objApply = functionWp.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB).z(Function.class).g());
                            if (objApply instanceof Function) {
                                this.dl = (Function) objApply;
                            }
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.a(fo, "getBridge:" + th.getMessage());
                    }
                }
            }
        }
        return this.dl;
    }

    public static void dl() {
        if (gk.dl < 5001) {
            return;
        }
        if (zw.g().uf()) {
            Bundle bundle = new Bundle();
            Bundle bundleZ = z(uy.ls().q());
            if (bundleZ != null) {
                bundle.putBundle("com.byted.csj.ext", bundleZ);
            }
            uy.ls().z(bundle);
            return;
        }
        JSONObject jSONObjectLq = uy.ls().lq();
        if (jSONObjectLq != null) {
            jSONObjectLq.remove("com.byted.csj.ext");
        }
    }

    private static Bundle z(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(PluginConstants.KEY_APP_ID, str);
            String strGz = gz();
            if (TextUtils.isEmpty(strGz)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strGz);
            bundle.putString("sdk_version", g(gk.gc));
            return bundle;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a(fo, "error:" + th.getMessage());
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    private static String gz() {
        if (gk.dl == 5001 || gk.dl == 5002) {
            return uy();
        }
        return fo();
    }

    private static String fo() {
        return (String) uy.ls().gb().apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8).z(String.class).z(0, "com.byted.csj.ext").g());
    }

    private static String uy() {
        try {
            Function<SparseArray<Object>, Object> functionGb = uy.ls().gb();
            JSONObject jSONObjectOptJSONObject = uy.ls().lq().optJSONObject("com.byted.csj.ext");
            Object objApply = functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6).z(Boolean.class).z(0, "com.byted.csj.ext").g());
            if (!(objApply != null ? ((Boolean) objApply).booleanValue() : false)) {
                return jSONObjectOptJSONObject == null ? "0.0.0.0" : (String) jSONObjectOptJSONObject.opt(PluginConstants.KEY_PLUGIN_VERSION);
            }
            if (z().a()) {
                return kb();
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a(fo, "ignore:" + th.getMessage());
            com.bytedance.sdk.component.utils.wp.z(th);
            return "0.0.0.0";
        }
    }

    private static String kb() {
        try {
            Integer numM = z().m();
            if (numM.intValue() != -1) {
                return g(numM.intValue());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    public static String g(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
            }
        }
        String string = sb.toString();
        return (i < 100 || i >= 1000) ? string : "0." + string;
    }

    public boolean a() {
        try {
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a(fo, "pit_ext_error:" + th.getMessage());
        }
        if (gk.dl < 5001 || !zw.g().uf()) {
            return false;
        }
        if (this.gc.get()) {
            return true;
        }
        if (this.m.compareAndSet(false, true)) {
            final Function<SparseArray<Object>, Object> functionGb = uy.ls().gb();
            Object objApply = functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6).z(Boolean.class).z(0, "com.byted.csj.ext").g());
            if (objApply != null ? ((Boolean) objApply).booleanValue() : false) {
                Object objApply2 = functionGb.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(7).z(Boolean.class).z(0, "com.byted.csj.ext").g());
                if (objApply2 != null ? ((Boolean) objApply2).booleanValue() : false) {
                    this.gc.set(true);
                    this.m.set(false);
                } else {
                    com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.1
                        @Override // java.lang.Runnable
                        public void run() {
                            un.this.z(functionGb, true);
                        }
                    });
                }
            } else {
                this.m.set(false);
            }
        }
        return false;
    }

    public com.byted.z.z.z.z gc() {
        if (gk.dl >= 5001 && com.bytedance.sdk.openadsdk.core.tb.g.z(zw.g().x()) && a()) {
            return (com.byted.z.z.z.z) com.bytedance.sdk.openadsdk.ats.dl.z("alog");
        }
        return null;
    }

    private Function<SparseArray<Object>, Object> wp() {
        ClassLoader classLoader;
        try {
            if (this.gz == null && (classLoader = (ClassLoader) uy.ls().gb().apply(com.bytedance.sdk.openadsdk.ls.a.z().z(4).z(ClassLoader.class).z(0, "com.byted.csj.ext").g())) != null) {
                this.gz = (Function) classLoader.loadClass("com.byted.csj.ext_impl.ServiceManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            return this.gz;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a(fo, "getServiceManager:" + th.getMessage());
            return null;
        }
    }

    public boolean z(Function<SparseArray<Object>, Object> function, boolean z) {
        try {
            if (this.gc.get()) {
                return true;
            }
            if (!z) {
                this.m.set(true);
            }
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(5).z(Boolean.class).z(0, "com.byted.csj.ext").g());
            boolean zBooleanValue = objApply != null ? ((Boolean) objApply).booleanValue() : false;
            this.gc.set(zBooleanValue);
            this.m.set(false);
            return zBooleanValue;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.a(fo, ":" + th.getMessage());
            return false;
        }
    }
}
