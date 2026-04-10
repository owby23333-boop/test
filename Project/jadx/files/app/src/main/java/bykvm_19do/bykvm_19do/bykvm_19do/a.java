package bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.mapplog.collector.Collector;
import com.bytedance.mapplog.util.TTEncryptUtils;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile j2 a = null;

    @SuppressLint({"StaticFieldLeak"})
    public static k2 b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f623c = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile d f625e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static b f627g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static e0 f624d = new e0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ConcurrentHashMap<String, String> f626f = new ConcurrentHashMap<>(4);

    public static <T> T a(String str, T t2) {
        k2 k2Var = b;
        if (k2Var != null) {
            return (T) k2Var.a(str, t2);
        }
        return null;
    }

    public static void a() {
        v1.h();
    }

    public static void a(Context context, h hVar) {
        RuntimeException runtimeException;
        if (a != null) {
            runtimeException = new RuntimeException("Init Twice!");
        } else {
            if (hVar.s() != null) {
                Application application = (Application) context.getApplicationContext();
                v1 v1VarI = v1.i();
                j2 j2Var = new j2(application, hVar);
                k2 k2Var = new k2(application, j2Var);
                v1VarI.a(application, j2Var, k2Var, new j0(hVar.o()));
                a = j2Var;
                b = k2Var;
                if (a.J()) {
                    application.registerReceiver(new Collector(), new IntentFilter());
                }
                l0.d("Inited", null);
                return;
            }
            runtimeException = new RuntimeException("need to involve setSensitiveInfoProvider!");
        }
        l0.a(runtimeException);
    }

    public static void a(c cVar) {
        f624d.a(cVar);
    }

    public static void a(e eVar) {
        s0.a(eVar);
    }

    public static void a(String str, Bundle bundle) {
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
                        l0.a(th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        a(str, jSONObject);
    }

    public static void a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            l0.a("eventName is empty", null);
            v1.a(new c0("", "2", 1));
        }
        v1.a(new y(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void a(HashMap<String, Object> map) {
        k2 k2Var = b;
        if (k2Var != null) {
            k2Var.a(map);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0031 A[EXC_TOP_SPLITTER, PHI: r1
  0x0031: PHI (r1v3 java.util.zip.GZIPOutputStream) = (r1v2 java.util.zip.GZIPOutputStream), (r1v4 java.util.zip.GZIPOutputStream) binds: [B:16:0x002f, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r1)
            r1 = 0
            boolean r2 = h()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r3 = "UTF-8"
            if (r2 == 0) goto L21
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2b
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L1e
            r2.write(r4)     // Catch: java.lang.Throwable -> L1e
            r1 = r2
            goto L28
        L1e:
            r4 = move-exception
            r1 = r2
            goto L2c
        L21:
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L2b
            r0.write(r4)     // Catch: java.lang.Throwable -> L2b
        L28:
            if (r1 == 0) goto L39
            goto L31
        L2b:
            r4 = move-exception
        L2c:
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r4)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L39
        L31:
            r1.close()     // Catch: java.io.IOException -> L35
            goto L39
        L35:
            r4 = move-exception
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r4)
        L39:
            byte[] r4 = r0.toByteArray()
            boolean r0 = h()
            if (r0 == 0) goto L48
            int r0 = r4.length
            byte[] r4 = com.bytedance.mapplog.util.TTEncryptUtils.a(r4, r0)
        L48:
            return r4
        L49:
            r4 = move-exception
            if (r1 == 0) goto L54
            r1.close()     // Catch: java.io.IOException -> L50
            goto L54
        L50:
            r0 = move-exception
            bykvm_19do.bykvm_19do.bykvm_19do.l0.a(r0)
        L54:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.a.a(java.lang.String):byte[]");
    }

    public static JSONObject b() {
        if (a != null) {
            return a.M();
        }
        return null;
    }

    public static String c() {
        if (a != null) {
            return a.L();
        }
        return null;
    }

    public static String d() {
        k2 k2Var = b;
        if (k2Var != null) {
            return k2Var.m();
        }
        return null;
    }

    public static boolean e() {
        return f623c;
    }

    @NonNull
    public static c f() {
        return f624d;
    }

    public static String g() {
        k2 k2Var = b;
        return k2Var != null ? k2Var.g() : "";
    }

    public static boolean h() {
        return true;
    }

    public static d i() {
        return f625e;
    }

    public static b j() {
        return f627g;
    }

    public static h k() {
        if (a != null) {
            return a.p();
        }
        return null;
    }

    public static int l() {
        if (a != null) {
            return a.A();
        }
        return 0;
    }

    public static String m() {
        k2 k2Var = b;
        return k2Var != null ? k2Var.j() : "";
    }

    public static boolean n() {
        return TTEncryptUtils.a();
    }
}
