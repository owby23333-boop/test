package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static boolean a = false;

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "KWE_N" : str;
    }

    public static String a(Throwable th) {
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "UnknownHostException";
            }
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        String string = stringWriter.toString();
        printWriter.close();
        return string;
    }

    public static void a(boolean z2) {
        a = z2;
    }

    public static boolean a(Context context, String[] strArr) {
        try {
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) == 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String b(String str) {
        try {
            e eVarA = com.yxcorp.kuaishou.addfp.c.a.a.a(str, false);
            return !TextUtils.isEmpty(eVarA.b) ? eVarA.b : (TextUtils.isEmpty(eVarA.f20611c) || !eVarA.f20611c.contains("denied")) ? TextUtils.isEmpty(eVarA.b) ? "KWE_N" : "KWE_OTHER" : "KWE_PN";
        } catch (Throwable th) {
            th.printStackTrace();
            return "KWE_PE";
        }
    }
}
