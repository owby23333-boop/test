package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ag {
    private static final String a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";
    private final String b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f16530c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f16531d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16532e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";

    private void a(JSONObject jSONObject, int i2) {
        Object objA;
        try {
            Object objA2 = Build.VERSION.SDK_INT >= 26 ? dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2)), "IActivityManagerSingleton") : dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2)), "gDefault");
            if (objA2 == null || (objA = dg.a("android.util.Singleton", objA2, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(objA, jSONObject, i2);
        } catch (Exception unused) {
        }
    }

    private boolean a(Object obj, JSONObject jSONObject, int i2) {
        StringBuilder sb;
        if (jSONObject != null) {
            try {
                boolean zIsProxyClass = Proxy.isProxyClass(obj.getClass());
                String name = obj.getClass().getName();
                int i3 = 1;
                if (!zIsProxyClass) {
                    if (i2 == 3 && !name.contains("Instrumentation")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i2);
                        String string = sb2.toString();
                        if (!zIsProxyClass) {
                            i3 = 0;
                        }
                        jSONObject.put(string, i3);
                        sb = new StringBuilder();
                        sb.append(i2);
                        sb.append("-c");
                    }
                    return zIsProxyClass;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i2);
                String string2 = sb3.toString();
                if (!zIsProxyClass) {
                    i3 = 0;
                }
                jSONObject.put(string2, i3);
                sb = new StringBuilder();
                sb.append(i2);
                sb.append("-c");
                jSONObject.put(sb.toString(), name);
                return zIsProxyClass;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void b(JSONObject jSONObject, int i2) {
        try {
            Object objA = dg.a(new String(c.a(a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
            if (objA != null) {
                a(objA, jSONObject, i2);
            }
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject, int i2) {
        Object objA;
        Object objA2;
        try {
            if (Build.VERSION.SDK_INT < 29 || (objA = dg.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (objA2 = dg.a("android.util.Singleton", objA, MonitorConstants.CONNECT_TYPE_GET, new Object[0])) == null) {
                return;
            }
            a(objA2, jSONObject, i2);
        } catch (Exception unused) {
        }
    }

    private void d(JSONObject jSONObject, int i2) {
        Object objA;
        try {
            Object objA2 = dg.a(new String(c.a(a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
            if (objA2 == null || (objA = dg.a(objA2.getClass(), objA2, "mInstrumentation")) == null) {
                return;
            }
            a(objA, jSONObject, i2);
        } catch (Exception unused) {
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            b(jSONObject, 0);
            a(jSONObject, 1);
            c(jSONObject, 2);
            d(jSONObject, 3);
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            PackageManager packageManager = context.getPackageManager();
            Object objA = dg.a(packageManager.getClass(), packageManager, "mPM");
            if (objA == null) {
                return null;
            }
            if (a(objA, jSONObject, 0)) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
