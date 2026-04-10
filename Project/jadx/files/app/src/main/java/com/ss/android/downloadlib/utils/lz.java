package com.ss.android.downloadlib.utils;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class lz {
    private static Map<String, mb> mb = Collections.synchronizedMap(new HashMap());

    public interface mb {
        void mb();

        void mb(String str);
    }

    private static mb b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return mb.remove(str);
    }

    public static void mb(String[] strArr, mb mbVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        mb(strValueOf, mbVar);
        TTDelegateActivity.mb(strValueOf, strArr);
    }

    public static boolean ox(String str) {
        return com.ss.android.downloadlib.addownload.x.h().mb(com.ss.android.downloadlib.addownload.x.getContext(), str);
    }

    public static void mb(String str) {
        mb mbVarB;
        if (TextUtils.isEmpty(str) || (mbVarB = b(str)) == null) {
            return;
        }
        mbVarB.mb();
    }

    public static void mb(String str, String str2) {
        mb mbVarB;
        if (TextUtils.isEmpty(str) || (mbVarB = b(str)) == null) {
            return;
        }
        mbVarB.mb(str2);
    }

    private static void mb(String str, mb mbVar) {
        if (TextUtils.isEmpty(str) || mbVar == null) {
            return;
        }
        mb.put(str, mbVar);
    }
}
