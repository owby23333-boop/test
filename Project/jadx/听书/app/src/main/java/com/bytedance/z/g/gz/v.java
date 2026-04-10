package com.bytedance.z.g.gz;

import android.text.TextUtils;
import com.funny.audio.core.utils.FileUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static String z(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            z(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder z(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(FileUtils.FILE_EXTENSION_SEPARATOR).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String z(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (dl(th)) {
                z(th, printWriter);
            } else {
                th.printStackTrace(printWriter);
            }
            String string = stringWriter.toString();
            printWriter.close();
            return string;
        } catch (Exception unused) {
            printWriter.close();
            return "";
        } catch (Throwable th2) {
            printWriter.close();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject z(java.lang.String r16) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.z.g.gz.v.z(java.lang.String):org.json.JSONObject");
    }

    private static boolean g(String str) {
        Set<String> setZ = gc.z();
        if (setZ.contains(str)) {
            return true;
        }
        for (String str2 : setZ) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            if (th instanceof OutOfMemoryError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            i++;
            try {
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static class z {
        private final PrintWriter z;

        z(PrintWriter printWriter) {
            this.z = printWriter;
        }

        Object z() {
            return this.z;
        }

        void z(Object obj) {
            this.z.println(obj);
        }
    }

    private static void z(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        z zVar = new z(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (zVar.z()) {
            zVar.z(th);
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
                    zVar.z("\t... skip " + (stackTrace.length - i2) + " lines");
                    break;
                } else {
                    zVar.z("\tat " + stackTraceElement);
                    i2++;
                    i++;
                }
            }
            for (Throwable th2 : th.getSuppressed()) {
                z(th2, zVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                z(cause, zVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void z(Throwable th, z zVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            zVar.z("\t[CIRCULAR REFERENCE:" + th + "]");
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
        zVar.z(str2 + str + th);
        for (int i4 = 0; i4 <= i2; i4++) {
            zVar.z(str2 + "\tat " + stackTrace[i4]);
        }
        if (iMin < stackTrace.length) {
            zVar.z("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i3 != 0) {
            zVar.z(str2 + "\t... " + i3 + " more");
        }
        for (Throwable th2 : th.getSuppressed()) {
            z(th2, zVar, stackTrace, "Suppressed: ", str2 + "\t", set);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            z(cause, zVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static boolean dl(Throwable th) {
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
}
