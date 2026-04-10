package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes17.dex */
public class bb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9035a = "OOMChecker";

    public static boolean a(Throwable th, String str) {
        String[] strArrSplit;
        String strH = qt1.h(th);
        boolean z = (th instanceof OutOfMemoryError) || (!TextUtils.isEmpty(strH) && (strH.contains("android.database.CursorWindowAllocationException") || strH.contains("java.lang.OutOfMemoryError") || strH.contains("EGL_BAD_ALLOC")));
        if (!z && !TextUtils.isEmpty(str) && (strArrSplit = str.split(";")) != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (qt1.g()) {
                    qt1.t(f9035a, "-->generateUploadExceptionInfo(): loop flag: " + str2);
                }
                if (strH.contains(str2)) {
                    return true;
                }
            }
        }
        return z;
    }
}
