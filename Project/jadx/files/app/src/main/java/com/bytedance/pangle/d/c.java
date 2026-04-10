package com.bytedance.pangle.d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.g;
import com.bytedance.pangle.util.i;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private static File a;
    private static File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static File f14537c;

    private static String a(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (f14537c == null) {
            f14537c = new File(appApplication.getFilesDir(), ".pangle" + g.a);
        }
        return a(f14537c);
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + g.b);
            if (externalFilesDir != null) {
                return a(externalFilesDir);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void d() {
        if (a == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), "pangle" + g.f14583c);
            a = file;
            a(file);
        }
    }

    public static String e(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String f(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk")).getPath();
    }

    public static String g(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk", "temp")).getPath();
    }

    public static String h(String str, int i2) {
        return i.h() ? a(str, "version-".concat(String.valueOf(i2)), "apk", "temp", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i2)), "dalvik-cache");
    }

    public static String i(String str, int i2) {
        return a(str, "version-".concat(String.valueOf(i2)), "secondary-dexes");
    }

    private static String a(String... strArr) {
        d();
        File file = a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return a(file);
    }

    public static String d(String str, int i2) {
        return a(str, "version-".concat(String.valueOf(i2)), "lib");
    }

    public static String b(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk"), "base-1.apk").getPath();
    }

    public static String c(String str, int i2) {
        return i.h() ? a(str, "version-".concat(String.valueOf(i2)), "apk", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i2)), "dalvik-cache");
    }

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + g.b);
            }
            b = downloadDir;
        }
        return a(b);
    }

    public static String a(String str, int i2) {
        d();
        File file = a;
        String[] strArr = {str, "version-".concat(String.valueOf(i2))};
        for (int i3 = 0; i3 < 2; i3++) {
            String str2 = strArr[i3];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String a(String str) {
        return a(str);
    }
}
