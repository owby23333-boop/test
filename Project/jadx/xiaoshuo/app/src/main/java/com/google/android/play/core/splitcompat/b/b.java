package com.google.android.play.core.splitcompat.b;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6935a;

    public b(String str) {
        int iMyUid = Process.myUid();
        int iMyPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(iMyUid);
        sb.append("]  PID: [");
        sb.append(iMyPid);
        sb.append("] ");
        String strValueOf = String.valueOf(sb.toString());
        String strValueOf2 = String.valueOf(str);
        this.f6935a = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    private int a(int i, String str, Object[] objArr) {
        if (Log.isLoggable("PlayCore", i)) {
            return Log.i("PlayCore", a(this.f6935a, str, objArr));
        }
        return 0;
    }

    public int b(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public int c(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public int d(String str, Object... objArr) {
        return a(6, str, objArr);
    }

    public int a(String str, Object... objArr) {
        return a(4, str, objArr);
    }

    public int a(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", a(this.f6935a, str, objArr), th);
        }
        return 0;
    }

    public static a a() {
        throw new AssertionError();
    }

    private static String a(String str, String str2, Object... objArr) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        String string = sb.toString();
        if (objArr == null || objArr.length <= 0) {
            return string;
        }
        try {
            return String.format(Locale.US, string, objArr);
        } catch (IllegalFormatException e) {
            String strValueOf = String.valueOf(string);
            Log.e("PlayCore", strValueOf.length() != 0 ? "Unable to format ".concat(strValueOf) : new String("Unable to format "), e);
            String strValueOf2 = String.valueOf(string);
            String strJoin = TextUtils.join(", ", objArr);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 3 + String.valueOf(strJoin).length());
            sb2.append(strValueOf2);
            sb2.append(" [");
            sb2.append(strJoin);
            sb2.append("]");
            return sb2.toString();
        }
    }
}
