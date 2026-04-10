package com.kwad.sdk.o;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class a {
    private static File aug;

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.isDirectory();
        }
        return file;
    }

    private static File ba(Context context) {
        if (aug == null) {
            aug = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return aug;
    }

    private static String t(Context context, String str) {
        return i(new File(ba(context), "apk-" + str)).getPath();
    }

    static String v(Context context, String str) {
        File file = new File(t(context, str), "dynamic.apk");
        if (file.exists()) {
            return file.getPath();
        }
        return new File(t(context, str), "dynamic_apk").getPath();
    }
}
