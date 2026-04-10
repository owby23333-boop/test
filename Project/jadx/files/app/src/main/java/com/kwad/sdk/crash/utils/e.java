package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private static Context Om;

    @WorkerThread
    private static boolean b(Context context, long j2) {
        if (context == null) {
            return false;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
        editorEdit.putLong("crashseq", j2);
        return editorEdit.commit();
    }

    @WorkerThread
    private static long bh(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    public static void init(Context context) {
        Om = context;
    }

    @WorkerThread
    public static long xv() {
        long jBh = bh(Om);
        b(Om, 1 + jBh);
        return jBh;
    }
}
