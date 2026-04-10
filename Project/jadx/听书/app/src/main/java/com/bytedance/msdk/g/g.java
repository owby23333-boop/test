package com.bytedance.msdk.g;

import android.text.TextUtils;
import com.bytedance.msdk.gz.mc;
import com.funny.audio.core.utils.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static final String z = mc.a();
    public static boolean g = true;

    public static int z() {
        return Integer.parseInt(g().replace(FileUtils.FILE_EXTENSION_SEPARATOR, ""));
    }

    public static String g() {
        return com.bytedance.sdk.gromore.init.z.dl();
    }

    public static String dl() {
        if (TextUtils.isEmpty(g())) {
            return "";
        }
        String[] strArrSplit = g().split("\\.");
        if (strArrSplit.length < 4) {
            return "";
        }
        return strArrSplit[0] + FileUtils.FILE_EXTENSION_SEPARATOR + strArrSplit[1] + FileUtils.FILE_EXTENSION_SEPARATOR + strArrSplit[2];
    }

    public static String a() {
        return com.bytedance.sdk.gromore.init.z.a();
    }
}
