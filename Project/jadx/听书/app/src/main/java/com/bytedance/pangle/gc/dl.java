package com.bytedance.pangle.gc;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.fo;
import com.bytedance.sdk.openadsdk.api.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static File dl;
    private static File g;
    private static File z;

    private static void gc() {
        if (z == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + fo.dl);
            z = file;
            z(file);
        }
    }

    public static String z(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    private static String z(String... strArr) {
        gc();
        File file = z;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return z(file);
    }

    public static String z() {
        gc();
        return z.getPath();
    }

    public static String g() {
        Application appApplication = Zeus.getAppApplication();
        if (g == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + fo.g);
            }
            g = downloadDir;
        }
        return z(g);
    }

    public static String dl() {
        Application appApplication = Zeus.getAppApplication();
        if (dl == null) {
            dl = new File(appApplication.getFilesDir(), ".pangle" + fo.z);
        }
        return z(dl);
    }

    public static String a() {
        File externalFilesDir;
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = appApplication.getExternalFilesDir(".pangle" + fo.g)) == null) {
                return null;
            }
            return z(externalFilesDir);
        } catch (Exception e) {
            m.z(e);
            return null;
        }
    }

    public static String z(String str, int i) {
        gc();
        File file = z;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String z(String str) {
        return z(str);
    }

    public static String g(String str, int i) {
        return new File(z(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String dl(String str, int i) {
        return com.bytedance.pangle.util.fo.v() ? z(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.bytedance.pangle.m.g.z()) : z(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String a(String str, int i) {
        return z(str, "version-".concat(String.valueOf(i)), "lib");
    }

    public static String gc(String str, int i) {
        return new File(z(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String m(String str, int i) {
        return new File(z(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String e(String str, int i) {
        return new File(z(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String gz(String str, int i) {
        return com.bytedance.pangle.util.fo.v() ? z(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.bytedance.pangle.m.g.z()) : z(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String fo(String str, int i) {
        return z(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }

    public static boolean uy(String str, int i) {
        return new File(z() + File.separator + str + File.separator + "version-" + i).exists();
    }

    public static String z(String str, int i, String str2) {
        return new File(z(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }

    public static File[] kb(String str, int i) {
        String strZ = z(str, "version-".concat(String.valueOf(i)), "dex");
        if (TextUtils.isEmpty(strZ)) {
            return null;
        }
        return new File(strZ).listFiles(new FileFilter() { // from class: com.bytedance.pangle.gc.dl.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".dex");
            }
        });
    }

    public static String wp(String str, int i) {
        return new File(z(str, "version-".concat(String.valueOf(i)), "config"), "config.json").getPath();
    }
}
