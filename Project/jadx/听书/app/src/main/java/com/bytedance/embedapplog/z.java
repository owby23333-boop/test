package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.collector.Collector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f310a = null;
    public static ConcurrentHashMap<String, String> dl = new ConcurrentHashMap<>(4);
    private static boolean e = false;
    public static boolean g = true;
    private static volatile bv gc = null;
    private static volatile a gz = null;
    private static boolean m = true;
    public static gb z;

    public static boolean gz() {
        return true;
    }

    public static void z(Context context, gz gzVar) {
        if (gc != null) {
            cb.g(new RuntimeException("Init Twice!"));
            return;
        }
        if (gzVar.lq() == null) {
            cb.g(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        ti tiVarM = ti.m();
        bv bvVar = new bv(application, gzVar);
        gc = bvVar;
        gb gbVar = new gb(application, bvVar);
        tiVarM.z(application, bvVar, gbVar, new fv(gzVar.uy()));
        z = gbVar;
        if (gc.fv()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        cb.a("Inited", null);
    }

    public static void z(boolean z2) {
        g = z2;
    }

    public static void z() {
        gb gbVar;
        if (!g || (gbVar = z) == null) {
            return;
        }
        gbVar.a();
    }

    public static void g() {
        ti.z();
    }

    public static a dl() {
        return gz;
    }

    public static g a() {
        return f310a;
    }

    public static void z(HashMap<String, Object> map) {
        gb gbVar = z;
        if (gbVar != null) {
            gbVar.z(map);
        }
    }

    public static String gc() {
        gb gbVar = z;
        if (gbVar != null) {
            return gbVar.v();
        }
        return null;
    }

    public static JSONObject m() {
        if (gc != null) {
            return gc.q();
        }
        return null;
    }

    public static String e() {
        gb gbVar = z;
        return gbVar != null ? gbVar.gz() : "";
    }

    public static <T> T z(String str, T t) {
        gb gbVar = z;
        if (gbVar != null) {
            return (T) gbVar.z(str, t);
        }
        return null;
    }

    public static void z(String str, JSONObject jSONObject) {
        ti.z(new nb(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void z(String str, JSONObject jSONObject, int i) {
        ti.z(new nb(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void z(String str, Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        cb.g(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        z(str, jSONObject);
    }

    public static void z(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        cb.g(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        z(str, jSONObject, i);
    }

    public static void g(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            cb.g("call onEventData with invalid params, return", null);
            return;
        }
        try {
            ti.z(new wn(str, jSONObject));
        } catch (Exception e2) {
            cb.dl("call onEventData get exception: ", e2);
        }
    }

    public static String fo() {
        gb gbVar = z;
        return gbVar != null ? gbVar.e() : "";
    }

    public static String uy() {
        gb gbVar = z;
        return gbVar != null ? gbVar.uy() : "";
    }

    public static String kb() {
        gb gbVar = z;
        return gbVar != null ? gbVar.kb() : "";
    }

    public static dl wp() {
        return sf.z();
    }

    public static void z(gc gcVar) {
        dh.z(gcVar);
    }

    public static gz i() {
        if (gc != null) {
            return gc.vm();
        }
        return null;
    }
}
