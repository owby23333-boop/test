package com.bytedance.pangle.m;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.fo;
import com.funny.audio.core.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static int g = 2;
    public static int z = 1;

    public static SharedPreferences z(Context context) {
        return com.bytedance.sdk.openadsdk.ats.a.z(context.getApplicationContext(), "plugin_oat_info", 0);
    }

    static String[] z(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        arrayList.add("--runtime-arg");
        arrayList.add("-classpath");
        arrayList.add("--runtime-arg");
        arrayList.add("&");
        arrayList.add("--instruction-set=" + z());
        if (i == z) {
            if (fo.v()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == g) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String z() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.m.z(e);
            return null;
        }
    }

    public static String z(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR));
        if (".dex".equals(strSubstring2)) {
            return strSubstring;
        }
        if (".zip".equals(strSubstring2) || ".apk".equals(strSubstring2)) {
            return strSubstring.replace(strSubstring2, ".odex");
        }
        return strSubstring + ".odex";
    }

    public static String g(String str) {
        String strSubstring = str.substring(str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR));
        return ".dex".equals(strSubstring) ? strSubstring : (".zip".equals(strSubstring) || ".apk".equals(strSubstring)) ? ".odex" : str + ".odex";
    }

    public static boolean z(String str, String str2) {
        return z.z(z(str, str2, z));
    }

    public static boolean z(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !gz.z(file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean z(String str, String... strArr) {
        for (String str2 : strArr) {
            if (!new File(str + File.separator + z(str2)).exists()) {
                return false;
            }
        }
        return true;
    }
}
