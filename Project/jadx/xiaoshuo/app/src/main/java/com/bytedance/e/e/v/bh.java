package com.bytedance.e.e.v;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class bh {

    public static class e {
        private final PrintWriter e;

        public e(PrintWriter printWriter) {
            this.e = printWriter;
        }

        public Object e() {
            return this.e;
        }

        public void e(Object obj) {
            this.e.println(obj);
        }
    }

    private static boolean bf(String str) {
        Set<String> setE = ga.e();
        if (setE.contains(str)) {
            return true;
        }
        for (String str2 : setE) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }

    public static String e(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            e(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static boolean bf(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static StringBuilder e(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(Consts.DOT);
        sb.append(stackTraceElement.getMethodName());
        sb.append("(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    @NonNull
    public static String e(@NonNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (d(th)) {
                e(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            return stringWriter.toString();
        } catch (Exception unused) {
            return "";
        } finally {
            printWriter.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x002a A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject e(java.lang.String r16) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.e.e.v.bh.e(java.lang.String):org.json.JSONObject");
    }

    private static void e(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        e eVar = new e(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (eVar.e()) {
            eVar.e(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (i2 > 256) {
                    eVar.e("\t... skip " + (stackTrace.length - i2) + " lines");
                    break;
                }
                eVar.e("\tat " + stackTraceElement);
                i2++;
                i++;
            }
            for (Throwable th2 : th.getSuppressed()) {
                e(th2, eVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                e(cause, eVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void e(Throwable th, e eVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            eVar.e("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int iMin = Math.min(stackTrace.length, 256);
        int i = iMin - 1;
        int i2 = i;
        for (int iMin2 = Math.min(stackTraceElementArr.length, 256) - 1; i2 >= 0 && iMin2 >= 0 && stackTrace[i2].equals(stackTraceElementArr[iMin2]); iMin2--) {
            i2--;
        }
        int i3 = i - i2;
        eVar.e(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            eVar.e(str2 + "\tat " + stackTrace[i4]);
        }
        if (iMin < stackTrace.length) {
            eVar.e("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i3 != 0) {
            eVar.e(str2 + "\t... " + i3 + " more");
        }
        for (Throwable th2 : th.getSuppressed()) {
            e(th2, eVar, stackTrace, "Suppressed: ", str2 + "\t", set);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            e(cause, eVar, stackTrace, "Caused by: ", str2, set);
        }
    }
}
