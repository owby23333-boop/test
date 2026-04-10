package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class uy {
    private static Map<String, z> z = Collections.synchronizedMap(new HashMap());

    public interface z {
        void z();

        void z(String str);
    }

    public static void z(String[] strArr, z zVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        z(strValueOf, zVar);
        TTDelegateActivity.z(strValueOf, strArr);
    }

    public static void z(String str) {
        z zVarDl;
        if (TextUtils.isEmpty(str) || (zVarDl = dl(str)) == null) {
            return;
        }
        zVarDl.z();
    }

    public static void z(String str, String str2) {
        z zVarDl;
        if (TextUtils.isEmpty(str) || (zVarDl = dl(str)) == null) {
            return;
        }
        zVarDl.z(str2);
    }

    private static void z(String str, z zVar) {
        if (TextUtils.isEmpty(str) || zVar == null) {
            return;
        }
        z.put(str, zVar);
    }

    private static z dl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return z.remove(str);
    }

    public static boolean g(String str) {
        return com.ss.android.downloadlib.addownload.wp.gc().z(com.ss.android.downloadlib.addownload.wp.getContext(), str);
    }
}
