package com.kwad.sdk.crash.utils;

import android.os.Build;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    static abstract class a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        abstract Object Au();

        abstract void println(Object obj);
    }

    static class b extends a {
        private final PrintWriter asx;

        b(PrintWriter printWriter) {
            super((byte) 0);
            this.asx = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final Object Au() {
            return this.asx;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        final void println(Object obj) {
            this.asx.println(obj);
        }
    }

    private static void a(Throwable th, a aVar) {
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (aVar.Au()) {
            aVar.println(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                aVar.println("\tat " + stackTraceElement);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, "Suppressed: ", "\t", setNewSetFromMap);
                }
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + th);
            for (StackTraceElement stackTraceElement : stackTrace) {
                aVar.println(str2 + "\tat " + stackTraceElement);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                for (Throwable th2 : th.getSuppressed()) {
                    a(th2, aVar, "Suppressed: ", str2 + "\t", set);
                }
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th + "]");
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }
}
