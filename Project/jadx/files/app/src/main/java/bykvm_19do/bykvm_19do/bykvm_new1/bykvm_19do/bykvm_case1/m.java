package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.umeng.message.proguard.ad;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    private static class a {
        private final PrintWriter a;

        a(PrintWriter printWriter) {
            this.a = printWriter;
        }

        Object a() {
            return this.a;
        }

        void a(Object obj) {
            this.a.println(obj);
        }
    }

    @NonNull
    public static String a(@NonNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            if (c(th)) {
                a(th, printWriter);
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

    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder a(StackTraceElement stackTraceElement, StringBuilder sb) {
        String className = stackTraceElement.getClassName();
        sb.append("  at ");
        sb.append(className);
        sb.append(".");
        sb.append(stackTraceElement.getMethodName());
        sb.append(ad.f20405r);
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(")\n");
        return sb;
    }

    @Nullable
    public static JSONObject a(String str) {
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces != null) {
                jSONObject.put("thread_all_count", allStackTraces.size());
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    Thread key = entry.getKey();
                    String name = key.getName();
                    if (!b(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                        jSONObject2.put("thread_name", key.getName() + ad.f20405r + key.getId() + ad.f20406s);
                        StackTraceElement[] value = entry.getValue();
                        boolean z2 = true;
                        if (value != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (StackTraceElement stackTraceElement : value) {
                                jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ad.f20405r + stackTraceElement.getLineNumber() + ad.f20406s);
                            }
                            jSONObject2.put("thread_stack", jSONArray2);
                            if (jSONArray2.length() <= 0) {
                                z2 = false;
                            }
                        }
                        if (z2) {
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                jSONObject.put("thread_stacks", jSONArray);
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void a(Throwable th, a aVar, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set) {
        if (set.contains(th)) {
            aVar.a("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int iMin = Math.min(stackTrace.length, 256);
        int i2 = iMin - 1;
        int i3 = i2;
        for (int iMin2 = Math.min(stackTraceElementArr.length, 256) - 1; i3 >= 0 && iMin2 >= 0 && stackTrace[i3].equals(stackTraceElementArr[iMin2]); iMin2--) {
            i3--;
        }
        int i4 = i2 - i3;
        aVar.a(str2 + str + th);
        for (int i5 = 0; i5 <= i3; i5++) {
            aVar.a(str2 + "\tat " + stackTrace[i5]);
        }
        if (iMin < stackTrace.length) {
            aVar.a("\t... skip " + (stackTrace.length - iMin) + " lines");
        }
        if (i4 != 0) {
            aVar.a(str2 + "\t... " + i4 + " more");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, stackTrace, "Suppressed: ", str2 + "\t", set);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            a(cause, aVar, stackTrace, "Caused by: ", str2, set);
        }
    }

    private static void a(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        a aVar = new a(printWriter);
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (aVar.a()) {
            aVar.a(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (i3 > 256) {
                    aVar.a("\t... skip " + (stackTrace.length - i3) + " lines");
                    break;
                }
                aVar.a("\tat " + stackTraceElement);
                i3++;
                i2++;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, stackTrace, "Suppressed: ", "\t", setNewSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, stackTrace, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static boolean b(String str) {
        Set<String> setA = e.a();
        if (!setA.contains(str)) {
            for (String str2 : setA) {
                if (TextUtils.isEmpty(str) || !str.startsWith(str2)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean b(Throwable th) {
        if (th == null) {
            return false;
        }
        int i2 = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i2 > 20) {
                    return false;
                }
                i2++;
                th = th.getCause();
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static boolean c(Throwable th) {
        int i2 = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i2 > 20) {
                return false;
            }
            th = th.getCause();
            i2++;
        }
        return false;
    }
}
