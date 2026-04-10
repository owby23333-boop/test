package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static Context aHU;

    public static void init(Context context) {
        aHU = context;
    }

    public static long ID() {
        long jBE = bE(aHU);
        b(aHU, 1 + jBE);
        return jBE;
    }

    private static boolean b(Context context, long j) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        editorEdit.putLong("crashseq", j);
        return editorEdit.commit();
    }

    private static long bE(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }
}
