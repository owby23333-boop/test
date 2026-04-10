package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    private static Context Om;
    private static String ajv = xx();
    private static long ajw = 0;

    @WorkerThread
    private static boolean b(Context context, long j2) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        editorEdit.putLong("seq", j2);
        return editorEdit.commit();
    }

    @WorkerThread
    private static long bh(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    public static void init(Context context) {
        Om = context;
    }

    public static String xt() {
        com.kwad.sdk.core.d.b.d("ReportIdManager", ">> updateSessionId");
        String strXx = xx();
        ajv = strXx;
        return strXx;
    }

    public static String xu() {
        return ajv;
    }

    @WorkerThread
    public static long xv() {
        long jBh = bh(Om);
        b(Om, 1 + jBh);
        return jBh;
    }

    public static long xw() {
        return ajw;
    }

    private static String xx() {
        return UUID.randomUUID().toString();
    }
}
