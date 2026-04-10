package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ai {
    private static final String[] b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};
    private Context a;

    public ai(Context context) {
        this.a = context;
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv("PATH");
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] strArrSplit = str.split(":");
            int length = strArrSplit.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str2 = strArrSplit[i2];
                if (!str2.endsWith("/")) {
                    str2 = str2 + '/';
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean b() {
        try {
            String strA = bg.a("ro.build.display.id");
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            if (strA.contains("flyme")) {
                return true;
            }
            if (strA.toLowerCase().contains("flyme")) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public int a() {
        boolean z2;
        try {
            String[] strArrA = a(bh.f16587z);
            int length = strArrA.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (new File(strArrA[i2], bh.f16586y).exists()) {
                    z2 = true;
                    break;
                }
                i2++;
            }
        } catch (Exception unused) {
        }
        return z2 ? 1 : 0;
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception unused) {
            return "";
        }
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public int d() {
        String strA = aa.a().a("ro.secure");
        return (strA == null || !"0".equals(strA)) ? 1 : 0;
    }

    public int e() {
        String strA = aa.a().a("ro.debuggable");
        return (strA == null || !"0".equals(strA)) ? 1 : 0;
    }

    public int f() {
        String strA = aa.a().a("ro.adb.secure");
        return (strA == null || !"0".equals(strA)) ? 1 : 0;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String strA = a(" which su ");
            if (TextUtils.isEmpty(strA) || strA.length() <= 2) {
                jSONObject.put("0", 0);
            } else {
                jSONObject.put("0", 1);
                jSONObject.put("0-p", strA);
            }
            String strA2 = a(" id ");
            if (!TextUtils.isEmpty(strA2)) {
                if (strA2.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String strA3 = a(" busybox df ");
            if (!TextUtils.isEmpty(strA3) && !strA3.contains("not found")) {
                if (strA3.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        return new File("/system/app/Superuser.apk").exists() ? 1 : 0;
    }

    public String i() {
        for (String str : b) {
            if (new File(str, "magisk").exists()) {
                return str + "magisk";
            }
        }
        return "";
    }

    public String j() {
        for (String str : b) {
            if (new File(str, bh.f16586y).exists()) {
                return str + bh.f16586y;
            }
        }
        return "";
    }

    public String k() {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }
}
