package com.bytedance.sdk.component.panglearmor;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.utils.wp;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static e uy;
    private static String z;
    private static AtomicBoolean g = new AtomicBoolean(false);
    private static final AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f786a = "";
    private static long gc = 0;
    private static int m = 0;
    private static g e = null;
    private static volatile DisplayManager.DisplayListener gz = null;
    private static volatile boolean fo = false;

    public static void z(e eVar) {
        uy = eVar;
    }

    public static void z() {
        try {
            Context contextA = a();
            if (!gc() || dl.getAndSet(true) || contextA == null) {
                return;
            }
            if (e != null) {
                g.z((Application) contextA).g((Application) contextA);
                e = null;
            }
            if (gz != null) {
                ((DisplayManager) contextA.getSystemService("display")).unregisterDisplayListener(gz);
                fo = false;
                gz = null;
            }
        } catch (Throwable unused) {
        }
    }

    @DungeonFlag
    public static String g() {
        if (fo.g() && uy != null) {
            final Handler handlerZ = com.bytedance.sdk.component.utils.gz.z();
            final gz gzVarE = e();
            handlerZ.post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.m.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!m.dl.get()) {
                            g unused = m.e = g.z((Application) m.uy.z());
                            m.g(handlerZ);
                        }
                        gc.z(m.uy.z());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        Object objZ = m.z(1001, new Object[]{m.uy.z()});
                        if (objZ instanceof String) {
                            String unused2 = m.f786a = (String) objZ;
                        }
                    } catch (Throwable th) {
                        String unused3 = m.f786a = m.g(th);
                    }
                    if (gzVarE == null || m.g.getAndSet(true)) {
                        return;
                    }
                    JSONObject jSONObjectZ = com.bytedance.sdk.component.panglearmor.z.z.z().z(m.uy.z(), m.uy.g());
                    if (jSONObjectZ != null && jSONObjectZ.length() > 0) {
                        gzVarE.z("detailed_app_info", jSONObjectZ);
                    }
                    m.g.set(false);
                }
            });
        }
        if (TextUtils.isEmpty(f786a)) {
            String strGc = SoftDecTool.gc();
            if (!TextUtils.isEmpty(strGc)) {
                f786a = strGc;
            }
        }
        return TextUtils.isEmpty(f786a) ? "eyJzdHRzIjoxfQ==" : f786a;
    }

    @DungeonFlag
    public static Object z(int i, Object[] objArr) {
        return SoftDecTool.cn(i, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void g(Handler handler) {
        if (!fo.g() || fo || a() == null) {
            return;
        }
        fo = true;
        if (gz == null) {
            gz = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglearmor.m.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                    if (i != 0) {
                        try {
                            m.z(1003, new Object[]{Integer.valueOf(i), m.a()});
                        } catch (Throwable th) {
                            wp.z(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                    if (i != 0) {
                        try {
                            m.z(1004, new Object[]{Integer.valueOf(i), m.a()});
                        } catch (Throwable th) {
                            wp.z(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    if (i != 0) {
                        try {
                            m.z(1005, new Object[]{Integer.valueOf(i), m.a()});
                        } catch (Throwable th) {
                            wp.z(th);
                        }
                    }
                }
            };
        }
        ((DisplayManager) a().getSystemService("display")).registerDisplayListener(gz, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String g(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            f786a = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            wp.z(th2);
            f786a = "eyJzdHRzIjozfQ==";
        }
        return f786a;
    }

    @DungeonFlag
    public static void z(final MotionEvent motionEvent) {
        if (motionEvent == null || !fo.g() || a() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.bytedance.sdk.component.utils.gz.z().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.m.3
                @Override // java.lang.Runnable
                public void run() {
                    m.z(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), m.a()});
                }
            });
        }
    }

    @DungeonFlag
    public static void z(long j, int i) {
        gc = j;
        m = i;
    }

    public static String z(String str, long j, int i, boolean z2) {
        try {
            g gVar = e;
            if (gVar != null) {
                return gVar.z(str, j, i, z2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String z(String str, String str2) {
        Object objZ = z(1010, new String[]{str, str2});
        return objZ instanceof String ? (String) objZ : str2;
    }

    public static String dl() {
        if (z == null) {
            Object objZ = z(1011, new Object[0]);
            if (objZ instanceof String) {
                z = (String) objZ;
            }
        }
        String str = z;
        return str != null ? str : "";
    }

    public static Context a() {
        e eVar = uy;
        if (eVar != null) {
            return eVar.z();
        }
        return null;
    }

    public static boolean gc() {
        e eVar = uy;
        if (eVar != null) {
            return eVar.dl();
        }
        return false;
    }

    public static String m() {
        e eVar = uy;
        if (eVar != null) {
            return eVar.g();
        }
        return null;
    }

    public static gz e() {
        e eVar = uy;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public static long gz() {
        return gc;
    }

    public static int fo() {
        return m;
    }
}
