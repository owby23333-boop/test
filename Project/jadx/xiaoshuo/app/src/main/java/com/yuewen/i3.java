package com.yuewen;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i3 {
    @SuppressLint({"DefaultLocale"})
    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        return str.substring(0, iLastIndexOf) + "_" + i + str.substring(iLastIndexOf, str.length());
    }

    public abstract String b();

    public abstract String c();
}
