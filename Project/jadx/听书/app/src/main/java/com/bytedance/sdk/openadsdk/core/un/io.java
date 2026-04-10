package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.a.z;
import com.bytedance.sdk.openadsdk.core.iq.r;
import com.umeng.analytics.pro.an;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class io {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1377a = 300;
    public static int dl = 2;
    public static int g = 1;
    private static volatile z.InterfaceC0115z gc;
    public static int z;

    public static void z() {
        uy();
        m();
        if (com.bytedance.sdk.openadsdk.core.zw.g().lw()) {
            e();
            gc();
            fo();
            wp();
        }
    }

    public static com.bytedance.sdk.component.a.z g() {
        return (com.bytedance.sdk.component.a.z) com.bytedance.sdk.openadsdk.ats.dl.z("armor_service");
    }

    public static void dl() {
        com.bytedance.sdk.component.a.z zVarG = g();
        if (zVarG != null) {
            zVarG.initPglArmorCallApi(new z());
        }
    }

    static class z implements z.g {
        z() {
        }

        @Override // com.bytedance.sdk.component.a.z.g
        public void setCryptInitStatus(long j, boolean z) {
            com.bytedance.sdk.openadsdk.core.q.v.z().z(10001, j, Boolean.valueOf(z), (String) null);
        }

        @Override // com.bytedance.sdk.component.a.z.g
        public void reportSoftDecData(String str, JSONObject jSONObject) {
            if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            io.z(jSONObject.toString(), str);
        }
    }

    public static JSONArray a() {
        UsbAccessory[] accessoryList = ((UsbManager) com.bytedance.sdk.openadsdk.core.zw.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put("model", usbAccessory.getModel());
                        jSONObject.put("desc", usbAccessory.getDescription());
                        jSONObject.put(ContentProviderManager.PROVIDER_URI, usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void gc() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArrayA = a();
            if (jSONArrayA.length() > 0) {
                jSONObject.put("usb", jSONArrayA);
            }
            JSONObject jSONObject2 = new JSONObject();
            ClassLoader classLoader = Class.forName("com.bytedance.sdk.openadsdk.TTFileProvider").getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                Class<? super Object> superclass = classLoader.getClass().getSuperclass();
                while (true) {
                    if (superclass == null || superclass.getName().equals("java.lang.Object")) {
                        break;
                    }
                    if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        z(classLoader, superclass, jSONObject2);
                        break;
                    }
                    superclass = superclass.getSuperclass();
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            z(jSONObject.toString(), "pangle_check");
        }
    }

    private static void z(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
        Field declaredField = cls.getDeclaredField("pathList");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(classLoader);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            if (objArr != null) {
                jSONObject.put("size", objArr.length);
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : objArr) {
                    Field declaredField3 = obj2.getClass().getDeclaredField("dexFile");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 != null && !obj3.toString().startsWith("/data/app")) {
                        sb.append(obj3).append(";");
                    }
                }
                jSONObject.put("dexPathList", sb);
            }
        }
    }

    public static void z(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.io.1
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z(str2).g(str);
            }
        }, str2);
    }

    public static String m() {
        try {
            com.bytedance.sdk.component.a.z zVarG = g();
            if (!com.bytedance.sdk.openadsdk.core.uy.ls().wp()) {
                zVarG.setBlt(false);
            }
            return zVarG.getSoftChara();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return z(th);
        }
    }

    public static void z(MotionEvent motionEvent) {
        try {
            g().pglArmorCallApi2c(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public static String z(String str, long j, int i, boolean z2) {
        try {
            return g().pglArmorCallApi2ccc(str, j, i, z2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void z(long j, int i) {
        try {
            g().pglArmorCallApi2src(j, i);
        } catch (Throwable unused) {
        }
    }

    public static int z(String str) {
        int i = z;
        if (str == null || str.isEmpty()) {
            return dl;
        }
        int iIndexOf = str.indexOf("_");
        if (iIndexOf <= 0) {
            return dl;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        int iIndexOf2 = strSubstring2.indexOf("_");
        if (iIndexOf2 <= 0) {
            return dl;
        }
        String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
        String strSubstring4 = strSubstring2.substring(iIndexOf2 + 1);
        long jLongValue = Long.valueOf(strSubstring).longValue() - Long.valueOf(strSubstring3).longValue();
        try {
            com.bytedance.sdk.component.a.z zVarG = g();
            if (zVarG != null && !zVarG.signVerifyMD5withRSA(strSubstring3 + "_" + com.bytedance.sdk.openadsdk.core.tb.dl(), strSubstring4)) {
                return dl;
            }
            if (Math.abs(jLongValue) > f1377a) {
                i = g;
            }
            return i;
        } catch (Throwable unused) {
            return z;
        }
    }

    public static void e() {
        String[] strArrJh = com.bytedance.sdk.openadsdk.core.zw.g().jh();
        if (strArrJh == null || strArrJh.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArrJh) {
            try {
                Class.forName(str);
                arrayList.add(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (arrayList.size() > 0) {
            z(arrayList);
        }
    }

    public static boolean gz() {
        String strUy = com.bytedance.sdk.openadsdk.core.zw.g().uy();
        try {
            com.bytedance.sdk.component.a.z zVarG = g();
            if (zVarG != null) {
                return zVarG.detectHostLocalIp(strUy);
            }
            return false;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return false;
        }
    }

    public static String z(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.wp.z(th2);
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void z(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.io.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clz", list.toString());
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("pangle_clz_found").g(jSONObject.toString());
            }
        }, "pangle_clz_found");
    }

    public static void fo() {
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.io.3
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                com.bytedance.sdk.component.a.z zVarG = io.g();
                jSONObject.put("board", Build.BOARD + "#" + zVarG.pglArmorCallApi2getProperty("ro.product.board", "unknown"));
                jSONObject.put("model", Build.MODEL + "#" + zVarG.pglArmorCallApi2getProperty("ro.product.model", "unknown"));
                jSONObject.put(an.y, Build.VERSION.RELEASE + "#" + zVarG.pglArmorCallApi2getProperty("ro.build.version.release", "unknown"));
                jSONObject.put("vendor", Build.MANUFACTURER + "#" + zVarG.pglArmorCallApi2getProperty("ro.product.manufacturer", "unknown"));
                jSONObject.put("rom_version", Build.DISPLAY + "#" + zVarG.pglArmorCallApi2getProperty("ro.build.display.id", "unknown"));
                jSONObject.put("compiling_time", Build.TIME + "#" + (Long.parseLong(zVarG.pglArmorCallApi2getProperty("ro.build.date.utc", "-1")) * 1000));
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("pangle_build_pick").g(jSONObject.toString());
            }
        }, "pangle_build_pick");
    }

    public static void z(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.un.io.4
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("har_automatic").g(jSONObject.toString());
            }
        }, "har_automatic");
    }

    public static void g(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.sy.dl dlVar;
        if (jSONObject == null || com.bytedance.sdk.openadsdk.core.zw.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null || (dlVar = (com.bytedance.sdk.openadsdk.core.sy.dl) com.bytedance.sdk.openadsdk.ats.dl.z("pitaya")) == null || !dlVar.isPitayaInitSuccess()) {
            return;
        }
        dlVar.isPitayaEnvAvailable();
        dlVar.runTask("antispam_handhold", jSONObject, new com.bytedance.sdk.openadsdk.core.sy.gz() { // from class: com.bytedance.sdk.openadsdk.core.un.io.5
            @Override // com.bytedance.sdk.openadsdk.core.sy.gz
            protected PluginValueSet z(int i, com.bytedance.sdk.openadsdk.core.sy.fo foVar) {
                com.bytedance.sdk.openadsdk.ls.z zVarDl = foVar.dl();
                if (zVarDl == null) {
                    return null;
                }
                PluginValueSet pluginValueSetA = zVarDl.a();
                if (!zVarDl.z() || pluginValueSetA == null) {
                    return null;
                }
                JSONObject jSONObject2 = (JSONObject) pluginValueSetA.objectValue(2, JSONObject.class);
                if (jSONObject2 != null) {
                    new Object[]{"predict result ", jSONObject2};
                    try {
                        JSONArray jSONArray = jSONObject2.getJSONArray("probability");
                        com.bytedance.sdk.component.a.z zVarG = io.g();
                        if (jSONArray.length() == 1 && zVarG != null) {
                            zVarG.softDecTool2ua(jSONArray.optDouble(0), System.currentTimeMillis());
                        }
                    } catch (JSONException unused) {
                    }
                }
                return pluginValueSetA;
            }
        });
    }

    public static void z(int i, final int i2) {
        final com.bytedance.sdk.component.a.z zVarG = g();
        if (zVarG == null || zVarG.getArmorContext() == null || !com.bytedance.sdk.openadsdk.core.uy.ls().gc() || !zVarG.enableSetHARSensorCallBack(i)) {
            return;
        }
        if (gc == null) {
            gc = new z.InterfaceC0115z() { // from class: com.bytedance.sdk.openadsdk.core.un.io.6
                @Override // com.bytedance.sdk.component.a.z.InterfaceC0115z
                public void reportSensorData(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("scene", i2);
                        } catch (JSONException unused) {
                        }
                        io.g(jSONObject);
                        io.z(jSONObject);
                    }
                }
            };
            zVarG.setHARSensorCallBack(gc);
        }
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("har") { // from class: com.bytedance.sdk.openadsdk.core.un.io.7
            @Override // java.lang.Runnable
            public void run() {
                zVarG.registerHarSensors();
            }
        });
    }

    public static String uy() {
        r rVarKb = kb();
        com.bytedance.sdk.openadsdk.core.eo.z.z().z(rVarKb);
        if (rVarKb != null) {
            String string = rVarKb.toString();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public static r kb() {
        try {
            if (!com.bytedance.sdk.openadsdk.core.zw.g().nv()) {
                return null;
            }
            r rVarZ = com.bytedance.sdk.openadsdk.core.mc.z.z(com.bytedance.sdk.openadsdk.core.zw.getContext()).z();
            if (rVarZ != null) {
                return rVarZ;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void wp() {
        Context context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.mc.z.dl dlVarZ = com.bytedance.sdk.openadsdk.core.mc.z.dl.z(context);
            try {
                jSONObject.put("access_perm", com.bytedance.sdk.openadsdk.core.uf.g.z(context, com.kuaishou.weapon.p0.g.b));
                jSONObject.put("change_perm", com.bytedance.sdk.openadsdk.core.uf.g.z(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", com.bytedance.sdk.openadsdk.core.mc.z.gc.z());
                jSONObject.put("network", dlVarZ.z());
                z(jSONObject.toString(), "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static String i() {
        com.bytedance.sdk.component.a.z zVarG = g();
        return zVarG != null ? zVarG.getArchEnv() : "";
    }
}
