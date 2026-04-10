package com.bytedance.e.e.v;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class v {
    public static File bf(@NonNull Context context) {
        return new File(d(context), "crash_history");
    }

    @SuppressLint({"SdCardPath"})
    private static String d(@NonNull Context context) {
        String path;
        try {
            if (context.getFilesDir() != null) {
                path = context.getFilesDir().getPath();
            } else {
                File dir = context.getDir("/data/data/" + context.getPackageName() + "/files/", 0);
                path = dir != null ? dir.getPath() : null;
            }
            return path != null ? path : "/sdcard/";
        } catch (Exception e) {
            e.printStackTrace();
            return "/sdcard/";
        }
    }

    public static File e(@NonNull Context context) {
        return new File(d(context), "CrashLogJava");
    }

    public static String bf() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String e() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }
}
