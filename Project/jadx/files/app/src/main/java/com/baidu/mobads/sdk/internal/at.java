package com.baidu.mobads.sdk.internal;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.av;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class at extends av.a {
    public static final String a = "local";
    private static final int b = 4000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12866c = 23;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12867d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f12868e = Pattern.compile("(\\$\\d+)+$");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char f12869f = 9556;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final char f12870g = 9562;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final char f12871h = 9567;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final char f12872i = 9553;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f12873j = "════════════════════════════════════════════";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f12874k = "------------------------------------------";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f12875l = "╔════════════════════════════════════════════════════════════════════════════════════════";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f12876m = "╚════════════════════════════════════════════════════════════════════════════════════════";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f12877n = "╟------------------------------------------------------------------------------------";

    @Override // com.baidu.mobads.sdk.internal.av.a
    @NonNull
    String a() {
        return "local";
    }

    protected String a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Matcher matcher = f12868e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String strSubstring = className.substring(className.lastIndexOf(46) + 1);
        return (strSubstring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? strSubstring : strSubstring.substring(0, 23);
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    final String b() {
        String strB = super.b();
        if (strB != null) {
            return strB;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : a(stackTrace[5]);
    }

    protected String c() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z2 = false;
        int i2 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f12868e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (!className.equals(av.class.getName()) && !className.equals(bq.class.getName())) {
                if (z2) {
                    break;
                }
            } else {
                z2 = true;
            }
            i2++;
        }
        return "   (" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ")# " + stackTrace[i2].getMethodName();
    }

    @Override // com.baidu.mobads.sdk.internal.av.a
    protected void a(int i2, String str, String str2, Throwable th) {
        int iMin;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("当前线程：");
            sb.append(Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("调用位置：");
            sb.append(c());
            sb.append(";  ");
            sb.append("打印消息：");
            if (str2.length() > b) {
                ArrayList arrayList = new ArrayList();
                int length = str2.length();
                int i3 = 0;
                while (i3 < length) {
                    int iIndexOf = str2.indexOf(10, i3);
                    if (iIndexOf == -1) {
                        iIndexOf = length;
                    }
                    while (true) {
                        iMin = Math.min(iIndexOf, i3 + b);
                        arrayList.add(str2.substring(i3, iMin));
                        if (iMin >= iIndexOf) {
                            break;
                        } else {
                            i3 = iMin;
                        }
                    }
                    i3 = iMin + 1;
                }
                for (String str3 : (String[]) arrayList.toArray(new String[arrayList.size()])) {
                    a(i2, str, sb.toString() + str3);
                }
                return;
            }
            sb.append(str2);
            a(i2, str, sb.toString());
        } catch (Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    private static void a(int i2, String str, String str2) {
        if (i2 == 7) {
            Log.wtf(str, str2);
        } else {
            Log.println(i2, str, str2);
        }
    }
}
