package com.anythink.core.common.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile h f6925d;
    private Thread.UncaughtExceptionHandler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f6926c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SharedPreferences f6927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f6928f = "crash_type";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f6929g = "crash_msg";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f6930h = e.f6775c;
    String a = "com.anythink";

    private h(Context context) {
        this.f6926c = context;
        this.f6927e = this.f6926c.getSharedPreferences(g.f6804t, 0);
    }

    public static h a(Context context) {
        if (f6925d == null) {
            synchronized (h.class) {
                if (f6925d == null) {
                    f6925d = new h(context);
                }
            }
        }
        return f6925d;
    }

    private String b() {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            HashMap map = new HashMap(4);
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Thread key = it.next().getKey();
                if (key.getName().startsWith("anythink")) {
                    String str = key.getName() + "-" + key.getState();
                    if (map.containsKey(str)) {
                        map.put(str, Integer.valueOf(((Integer) map.get(str)).intValue() + 1));
                    } else {
                        map.put(str, 1);
                    }
                    i2++;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(map);
                jSONObject.put("anythink_thread_count", i2);
                try {
                    ActivityManager activityManager = (ActivityManager) this.f6926c.getSystemService("activity");
                    Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                    if (processMemoryInfo.length > 0) {
                        jSONObject.put("app_memory", (processMemoryInfo[0].getTotalPss() / 1024) + "MB");
                    }
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    if (Build.VERSION.SDK_INT >= 16) {
                        jSONObject.put("sys_total_memory", (memoryInfo.totalMem / 1048576) + "MB");
                        jSONObject.put("sys_avail_memory", (memoryInfo.availMem / 1048576) + "MB");
                    }
                } catch (Throwable unused) {
                }
                return jSONObject.toString();
            } catch (Throwable th) {
                return th.getMessage();
            }
        } catch (Throwable th2) {
            return th2.getMessage();
        }
    }

    private void c() {
        Map<String, ?> all = this.f6927e.getAll();
        Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String string = next != null ? next.toString() : "";
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    com.anythink.core.common.j.c.a(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(e.f6775c));
                } catch (Exception unused) {
                }
            }
        }
        if (all.size() > 0) {
            this.f6927e.edit().clear().commit();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) throws JSONException {
        if (th == null) {
            return;
        }
        try {
            String strB = b(th);
            if (a(strB)) {
                String strB2 = b(strB);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("crash_type", URLEncoder.encode(strB2));
                jSONObject.put("crash_msg", URLEncoder.encode(b() + "\n" + strB));
                jSONObject.put(e.f6775c, n.a().r());
                SharedPreferences.Editor editorEdit = this.f6927e.edit();
                editorEdit.putString(System.currentTimeMillis() + "_crash", jSONObject.toString());
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.b == null || this.b == this || (this.b instanceof h)) {
                return;
            }
            this.b.uncaughtException(thread, th);
        } catch (Exception unused2) {
        }
    }

    public final void a() {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.f6926c).b(n.a().p());
        if (aVarB == null || aVarB.x() != 0) {
            try {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.b.h.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(h.this);
                    }
                });
                if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof h)) {
                    this.b = Thread.getDefaultUncaughtExceptionHandler();
                }
                Thread.setDefaultUncaughtExceptionHandler(this);
            } catch (Exception unused) {
            }
        }
    }

    private void a(Throwable th) throws JSONException {
        try {
            String strB = b(th);
            if (a(strB)) {
                String strB2 = b(strB);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("crash_type", URLEncoder.encode(strB2));
                jSONObject.put("crash_msg", URLEncoder.encode(b() + "\n" + strB));
                jSONObject.put(e.f6775c, n.a().r());
                SharedPreferences.Editor editorEdit = this.f6927e.edit();
                editorEdit.putString(System.currentTimeMillis() + "_crash", jSONObject.toString());
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(String str) {
        com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(this.f6926c).b(n.a().p());
        if (aVarB != null) {
            if (aVarB.x() == 0) {
                return false;
            }
            String strZ = aVarB.z();
            try {
                if (TextUtils.isEmpty(strZ)) {
                    return true;
                }
                JSONArray jSONArray = new JSONArray(strZ);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (str.contains(jSONArray.optString(i2))) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        } else if (str.contains(this.a)) {
            return true;
        }
        return false;
    }

    private static String b(Throwable th) throws Throwable {
        PrintWriter printWriter;
        StringWriter stringWriter;
        if (th == null) {
            return "";
        }
        StringWriter stringWriter2 = null;
        printWriter = null;
        PrintWriter printWriter2 = null;
        try {
            for (Throwable th2 = new Throwable(com.anythink.core.common.k.g.a(), th); th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof UnknownHostException) {
                    return "";
                }
            }
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    printWriter.close();
                    stringWriter.close();
                    String string = stringWriter.toString();
                    try {
                        stringWriter.close();
                        stringWriter.close();
                    } catch (Throwable unused) {
                    }
                    return string;
                } catch (Exception unused2) {
                    printWriter2 = printWriter;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable unused3) {
                            return "";
                        }
                    }
                    if (printWriter2 != null) {
                        stringWriter.close();
                    }
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter2 = stringWriter;
                    if (stringWriter2 != null) {
                        try {
                            stringWriter2.close();
                        } catch (Throwable unused4) {
                            throw th;
                        }
                    }
                    if (printWriter != null) {
                        stringWriter2.close();
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th4) {
                th = th4;
                printWriter = null;
            }
        } catch (Exception unused6) {
            stringWriter = null;
        } catch (Throwable th5) {
            th = th5;
            printWriter = null;
        }
    }

    static /* synthetic */ void a(h hVar) {
        Map<String, ?> all = hVar.f6927e.getAll();
        Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String string = next != null ? next.toString() : "";
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    com.anythink.core.common.j.c.a(jSONObject.optString("crash_type"), jSONObject.optString("crash_msg"), jSONObject.optString(e.f6775c));
                } catch (Exception unused) {
                }
            }
        }
        if (all.size() > 0) {
            hVar.f6927e.edit().clear().commit();
        }
    }

    private static String b(String str) {
        try {
            Matcher matcher = Pattern.compile(".*?(Exception|Error|Death)", 2).matcher(str);
            String strGroup = matcher.find() ? matcher.group(0) : "";
            try {
                return !TextUtils.isEmpty(strGroup) ? strGroup.replaceAll("Caused by:", "").replaceAll(" ", "") : strGroup;
            } catch (Exception unused) {
                return strGroup;
            }
        } catch (Exception unused2) {
            return "";
        }
    }
}
