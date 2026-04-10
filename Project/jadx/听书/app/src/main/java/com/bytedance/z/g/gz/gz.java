package com.bytedance.z.g.gz;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    public static File z(Context context) {
        return new File(dl(context), "CrashLogJava");
    }

    public static File g(Context context) {
        return new File(dl(context), "crash_history");
    }

    public static String z() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String g() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    private static String dl(Context context) {
        String path;
        try {
            if (com.bytedance.sdk.openadsdk.api.plugin.g.z(context) != null) {
                path = com.bytedance.sdk.openadsdk.api.plugin.g.z(context).getPath();
            } else {
                File fileZ = com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                path = fileZ != null ? fileZ.getPath() : null;
            }
            return path != null ? path : "/sdcard/";
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return "/sdcard/";
        }
    }
}
