package com.kwad.sdk.crash.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return false;
        }
        String[] strArrZK = e.zJ().zK();
        if (strArrZK == null || strArrZK.length == 0) {
            return true;
        }
        boolean zA = false;
        for (String str : strArrZK) {
            zA = a(stackTraceElementArr, str);
            if (zA) {
                break;
            }
        }
        if (zA) {
            for (String str2 : e.zJ().zL()) {
                if (b(stackTraceElementArr, str2)) {
                    return false;
                }
            }
        }
        return zA;
    }

    private static boolean a(@NonNull StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashFilter filterTags element className=" + className + " filter tag=" + str);
                return true;
            }
        }
        return false;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, String str) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            if (!TextUtils.isEmpty(className) && className.contains(str)) {
                com.kwad.sdk.core.d.b.d("ExceptionCollector", "CrashFilter excludeTags element className=" + className + " exclude tag=" + str);
                return true;
            }
        }
        return false;
    }

    public static boolean g(@NonNull Throwable th) {
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < 5; i2++) {
            arrayList.add(th.getStackTrace());
            th = th.getCause();
            if (th == null) {
                break;
            }
        }
        return x(arrayList);
    }

    private static boolean x(@NonNull List<StackTraceElement[]> list) {
        Iterator<StackTraceElement[]> it = list.iterator();
        while (it.hasNext()) {
            if (a(it.next())) {
                return true;
            }
        }
        return false;
    }
}
