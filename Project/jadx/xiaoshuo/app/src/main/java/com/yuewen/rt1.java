package com.yuewen;

import com.duokan.core.diagnostic.LogLevel;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class rt1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17166b = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17167a = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17168a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f17168a = iArr;
            try {
                iArr[LogLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17168a[LogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17168a[LogLevel.EVENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17168a[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17168a[LogLevel.DISASTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String c() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        for (Map.Entry<Thread, StackTraceElement[]> entry : sz3.b()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            printWriter.println(key.toString());
            for (StackTraceElement stackTraceElement : value) {
                printWriter.print("\t");
                printWriter.println(stackTraceElement.toString());
            }
        }
        printWriter.flush();
        printWriter.close();
        return stringWriter.toString();
    }

    public final void a(LogLevel logLevel, String str, String str2, Throwable th) {
        if (d(logLevel)) {
            return;
        }
        String str3 = "MI_" + str;
        int i = a.f17168a[logLevel.ordinal()];
        if (i == 1) {
            bl0.q(4, str3, str2, th, 7);
            return;
        }
        if (i == 2) {
            bl0.q(5, str3, str2, th, 7);
            return;
        }
        if (i == 3) {
            bl0.q(3, str3, str2, th, 7);
        } else if (i == 4) {
            bl0.q(6, str3, str2, th, 7);
        } else {
            if (i != 5) {
                return;
            }
            bl0.a(str2, th);
        }
    }

    public void b(boolean z) {
        this.f17167a = z;
    }

    public final boolean d(LogLevel logLevel) {
        return LogLevel.EVENT.ordinal() > logLevel.ordinal() || !this.f17167a;
    }

    public void e(LogLevel logLevel, String str, String str2) {
        a(logLevel, str, str2, null);
        a(logLevel, str, c(), null);
    }

    public void f(LogLevel logLevel, String str, String str2) {
        a(logLevel, str, str2, null);
    }

    public void g(LogLevel logLevel, String str, String str2, Object... objArr) {
        String string;
        try {
            string = String.format(str2, objArr);
        } catch (Throwable th) {
            string = th.toString();
        }
        a(logLevel, str, string, null);
    }

    public void h(LogLevel logLevel, String str, String str2, String str3) {
        a(logLevel, str, str2, null);
        a(logLevel, str, str3, null);
    }

    public void i(LogLevel logLevel, String str, String str2) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Thread threadCurrentThread = Thread.currentThread();
        StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
        printWriter.println(threadCurrentThread.toString());
        for (StackTraceElement stackTraceElement : stackTrace) {
            printWriter.print("\t");
            printWriter.println(stackTraceElement.toString());
        }
        printWriter.flush();
        printWriter.close();
        a(logLevel, str, str2, null);
        a(logLevel, str, stringWriter.toString(), null);
    }

    public void j(LogLevel logLevel, String str, String str2, Throwable th) {
        a(logLevel, str, str2, th);
    }

    public void k(File file) {
        if (file != null) {
            bl0.y("fileName:" + file.getName(), new Object[0]);
        }
    }
}
