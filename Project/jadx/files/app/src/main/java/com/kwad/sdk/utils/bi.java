package com.kwad.sdk.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class bi {
    public static boolean ag(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            for (int i2 = 0; i2 < strArrSplit.length && i2 < strArrSplit2.length; i2++) {
                try {
                    int i3 = Integer.parseInt(strArrSplit[i2]) - Integer.parseInt(strArrSplit2[i2]);
                    if (i3 > 0) {
                        return true;
                    }
                    if (i3 < 0) {
                        return false;
                    }
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
            if (strArrSplit.length >= strArrSplit2.length) {
                return true;
            }
        }
        return false;
    }
}
