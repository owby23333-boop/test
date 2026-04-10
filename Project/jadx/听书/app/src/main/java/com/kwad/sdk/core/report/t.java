package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class t {
    private static String aHS = IF();
    private static long aHT = 0;
    private static Context aHU;

    public static void init(Context context) {
        aHU = context;
    }

    public static String IB() {
        com.kwad.sdk.core.d.c.d("ReportIdManager", ">> updateSessionId");
        String strIF = IF();
        aHS = strIF;
        return strIF;
    }

    public static String IC() {
        return aHS;
    }

    public static long ID() {
        long jBE = bE(aHU);
        b(aHU, 1 + jBE);
        return jBE;
    }

    public static long IE() {
        return aHT;
    }

    private static String IF() {
        return UUID.randomUUID().toString();
    }

    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
        editorEdit.putLong("seq", j);
        return editorEdit.commit();
    }

    private static long bE(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }
}
